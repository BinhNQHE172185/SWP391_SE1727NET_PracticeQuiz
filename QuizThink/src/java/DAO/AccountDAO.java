/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Account;
import DAL.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author LEMONLORD
 */
public class AccountDAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account getAccount(String username, String password) {
        Account account = null;
        int accountId;
        String email;
        String gender;
        String avatar;
        String fullname;
        Date dob;
        Date createDate;
        Date modifyDate;
        String passwordToken;
        int roleId;
        String sql = "SELECT * FROM Account WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                accountId = rs.getInt("Account_id");
                email = rs.getString("email");
                avatar = rs.getString("avatar");
                gender = rs.getString("gender");
                fullname = rs.getString("fullname");
                dob = rs.getDate("DOB");
                createDate = rs.getDate("createdDate");
                modifyDate = rs.getDate("modifyDate");
                passwordToken = rs.getString("passwordToken");
                boolean accountStatus = rs.getBoolean("status");
                account = new Account(accountId, username, password, email, fullname, dob, gender, null, avatar, createDate, modifyDate, passwordToken, accountStatus);
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }

    public Account getUsername(String username) {
        Account account = null;
        int accountId;
        String email;
        String password;
        String gender;
        String avatar;
        String fullname;
        Date dob;
        Date createDate;
        Date modifyDate;
        String passwordToken;
        int roleId;
        String sql = "SELECT * FROM Account WHERE username = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                accountId = rs.getInt("Account_id");
                email = rs.getString("email");
                password = rs.getString("password");
                avatar = rs.getString("avatar");
                gender = rs.getString("gender");
                fullname = rs.getString("fullname");
                dob = rs.getDate("DOB");
                createDate = rs.getDate("createdDate");
                modifyDate = rs.getDate("modifyDate");
                passwordToken = rs.getString("passwordToken");
                roleId = rs.getInt("role_id");
                boolean accountStatus = rs.getBoolean("status");
                account = new Account(accountId, username, password, email, fullname, dob, gender, null, avatar, createDate, modifyDate, passwordToken, accountStatus);
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }

    public void RegisterAcc(String username, String password, String email) {
        Account account = null;
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[email]\n"
                + "           ,[createdDate]\n"
                + "           ,[role_id]\n"
                + "           ,[status])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,2\n"
                + "           ,'true')";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            LocalDateTime currentTime = LocalDateTime.now();
            Date creDate = Date.valueOf(currentTime.toLocalDate());
            ps.setDate(4, creDate);
            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean checkPass(String password) {
        if (password.length() < 8) {
            return false;
        }
        Pattern pattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[0-9]).*$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public boolean checkUsername(String username) {
        // Check if the username is at least 4 characters long and at most 20 characters long
        if (username.length() < 4 || username.length() > 20) {
            return false;
        }

        // Check if the username contains only alphanumeric characters and underscores
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]+$");
        Matcher matcher = pattern.matcher(username);
        if (!matcher.matches()) {
            return false;
        }

        return true;
    }

    public boolean UsernameExist(String username) {
        Account ac;
        ac = getUsername(username);
        if (ac == null) {
            return true;
        }
        return false;
    }

    // Create new Account which could be expert marketing sale, customer, membership
    public void createAnyAccount(String username, String password, String email, String status, String gender, String avatar, String fullname, String DOB, String address, String phonenumber, int roleId) {
        String query = "INSERT INTO [Account] ([username], [password], [email], [fullname], [DOB], [gender], [self-introduction], [avatar], [createdDate], [modifyDate], [passwordToken], [role_id], [status])\n"
                + "VALUES (?, ?, ?, ?, ?, ?, NULL, ?, ?, NULL, NULL, ?, 1);";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, fullname);
            ps.setString(5, DOB);
            ps.setString(6, gender);
            ps.setString(7, avatar);
            ps.setInt(9, roleId);

            LocalDateTime currentTime = LocalDateTime.now();
            Date createdDate = Date.valueOf(currentTime.toLocalDate());
            ps.setDate(8, createdDate);
            ps.executeUpdate(); // no result ==> no need result set
        } catch (Exception e) {
            // Handle exceptions here
        } finally {
            // Close database connections and resources in a real application
            // For simplicity, it's omitted here.
        }
    }

    // Get number of account
    public int getNumOfAccount() {
        String query = "select COUNT(*) from Account";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    //Get all account
    public List<Account> getAllAccount(int page) {
        List<Account> list = new ArrayList<>();
        Account account = null;
        int accountId;
        String username;
        String email;
        String gender;
        String avatar;
        String fullname;
        Date dob;
        Date createDate;
        Date modifyDate;
        String passwordToken;
        boolean accountStatus;
        String query = "SELECT * FROM Account\n"
                + "ORDER BY Account_id\n"
                + "OFFSET ? ROWS FETCH NEXT 15 ROWS ONLY";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (page - 1) * 15); // page 1 starts at index 0
            rs = ps.executeQuery();
            while (rs.next()) {
                accountId = rs.getInt("Account_id");
                username = rs.getString("username");
                email = rs.getString("email");
                avatar = rs.getString("avatar");
                gender = rs.getString("gender");
                fullname = rs.getString("fullname");
                dob = rs.getDate("DOB");
                createDate = rs.getDate("createdDate");
                modifyDate = rs.getDate("modifyDate");
                passwordToken = rs.getString("passwordToken");
                accountStatus = rs.getBoolean("status");
                account = new Account(accountId, username, null, email, fullname, dob, gender, null, avatar, createDate, modifyDate, passwordToken, accountStatus);
                list.add(account);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return list;
    }
    // Get  Account by ID

    public Account getAccountByID(int accountId) {
        Account account = null;
        String username;
        String email;
        String gender;
        String avatar;
        String fullname;
        Date dob;
        Date createDate;
        Date modifyDate;
        String passwordToken;
        boolean accountStatus;
        String sql = "SELECT * FROM Account WHERE Account_id = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, accountId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                username = rs.getString("username");
                email = rs.getString("email");
                avatar = rs.getString("avatar");
                gender = rs.getString("gender");
                fullname = rs.getString("fullname");
                dob = rs.getDate("DOB");
                createDate = rs.getDate("createdDate");
                modifyDate = rs.getDate("modifyDate");
                passwordToken = rs.getString("passwordToken");
                accountStatus = rs.getBoolean("status");
                account = new Account(accountId, username, null, email, fullname, dob, gender, null, avatar, createDate, modifyDate, passwordToken, accountStatus);
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }

    public void updateProfile(String fullname, String email, String dob, String gender, String introduction, String accountID) {
        String query = "update Account set fullname = ?, email = ?, DOB = ?, gender = ?, [self-introduction] = ? where Account_id =?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, fullname);
            ps.setString(2, email);
            ps.setString(3, dob);
            ps.setString(4, gender);
            ps.setString(5, introduction);
            ps.setString(6, accountID);
            rs = ps.executeQuery();
        } catch (Exception e) {

        }
    }

    public void updatePassword(String password, String accountID) {
        String query = "update Account set password = ? where Account_id =?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, accountID);
            rs = ps.executeQuery();
        } catch (Exception e) {

        }
    }
}

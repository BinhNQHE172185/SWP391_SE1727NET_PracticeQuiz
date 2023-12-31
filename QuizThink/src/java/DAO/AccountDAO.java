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
        String selfIntroduction;
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
                selfIntroduction = rs.getString("self-introduction");
                createDate = rs.getDate("createdDate");
                modifyDate = rs.getDate("modifyDate");
                passwordToken = rs.getString("passwordToken");
                boolean accountStatus = rs.getBoolean("status");
                account = new Account(accountId, username, password, email, fullname, dob, gender, selfIntroduction, avatar, createDate, modifyDate, passwordToken, accountStatus);
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }

    public int countMember() {
        int size = 0;
        String sql = "Select COUNT (*) as c from  Account";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                size = rs.getInt("c");
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return size;
    }

    public int checkRole(int accountId) {
        int role = 0;
        String sql = "Select role_id from AccountRole where Account_id = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, accountId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                role = rs.getInt("role_id");
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return role;
    }

    public List<Account> getAllCustomer() {
        List<Account> customerList = new ArrayList<>();
        String sql = "SELECT a.*\n"
                + "FROM Account a\n"
                + "INNER JOIN [Transaction] s ON a.Account_id = s.Account_id ";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int accountId = rs.getInt("Account_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String fullname = rs.getString("fullname");
                Date dob = rs.getDate("DOB");
                String gender = rs.getString("gender");
                String selfIntroduction = rs.getString("self-introduction");
                String avatar = rs.getString("avatar");
                Date createDate = rs.getDate("createdDate");
                Date modifyDate = rs.getDate("modifyDate");
                String passwordToken = rs.getString("passwordToken");
                boolean accountStatus = rs.getBoolean("status");

                Account customer = new Account(accountId, username, password, email, fullname, dob, gender, selfIntroduction, avatar, createDate, modifyDate, passwordToken, accountStatus);

                customerList.add(customer);
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return customerList;
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
        String selfIntroduction;
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
                selfIntroduction = rs.getString("self-introduction");
                createDate = rs.getDate("createdDate");
                modifyDate = rs.getDate("modifyDate");
                passwordToken = rs.getString("passwordToken");
                boolean accountStatus = rs.getBoolean("status");
                account = new Account(accountId, username, password, email, fullname, dob, gender, selfIntroduction, avatar, createDate, modifyDate, passwordToken, accountStatus);
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }

    public void RegisterAcc(String username, String password, String email) {
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[email]\n"
                + "           ,[createdDate]\n"
                + "           ,[status])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,'True')";
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

    public void setRole(int accountID, int Role) {
        String sql = "INSERT INTO [dbo].[AccountRole]\n"
                + "           ([Account_id]\n"
                + "           ,[role_id])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, accountID);
            ps.setInt(2, Role);
            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Account checkEmail(String email) {
        Account acc = null;
        int accountId;
        String username;
        String password;
        String gender;
        String avatar;
        String fullname;
        Date dob;
        Date createDate;
        Date modifyDate;
        String passwordToken;
        String selfIntroduction;
        String sql = "select * \n"
                + "from Account\n"
                + "where email='" + email + "'";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                accountId = rs.getInt("Account_id");
                username = rs.getString("username");
                password = rs.getString("password");
                avatar = rs.getString("avatar");
                gender = rs.getString("gender");
                fullname = rs.getString("fullname");
                dob = rs.getDate("DOB");
                selfIntroduction = rs.getString("self-introduction");
                createDate = rs.getDate("createdDate");
                modifyDate = rs.getDate("modifyDate");
                passwordToken = rs.getString("passwordToken");
                boolean accountStatus = rs.getBoolean("status");
                acc = new Account(accountId, username, password, email, fullname, dob, gender, selfIntroduction, avatar, createDate, modifyDate, passwordToken, accountStatus);
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acc;
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
        String query = "INSERT INTO [Account] ([username], [password], [email], [fullname], [DOB], [gender], [self-introduction], [avatar], [createdDate], [modifyDate], [passwordToken], [status])\n"
                + "VALUES (?, ?, ?, ?, ?, ?, NULL, ?, ?, NULL, NULL, 1);"
                + "DECLARE @NewAccountId INT;\n"
                + "SET @NewAccountId = SCOPE_IDENTITY();\n"
                + "DECLARE @RoleId INT;\n"
                + "SET @RoleId = ?;\n"
                + "\n"
                + "INSERT INTO [AccountRole] (\n"
                + "    [Account_id],\n"
                + "    [role_id]\n"
                + ") VALUES (\n"
                + "    @NewAccountId, -- Sử dụng Account_id của tài khoản mới\n"
                + "    @RoleId -- Sử dụng role_id của vai trò bạn muốn gán\n"
                + ");\n"
                + "\n"
                + "select * from AccountRole";

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

            LocalDateTime currentTime = LocalDateTime.now();
            Date createdDate = Date.valueOf(currentTime.toLocalDate());
            ps.setDate(8, createdDate);
            ps.setInt(9, roleId);
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

    // Get number of account
    public int getNumOfAccountByRole(String roleID) {
        String query = "select COUNT(*) from Account where Account_id in (select Account_id from AccountRole where role_id = ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, roleID);
            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<Account> getStudentList(int subjectId) {
        List<Account> list = new ArrayList<>();
        int accountId;
        String name;
        String gender;
        String email;
        Date Dob;
        Date enroll;
        boolean status;
        String query = "select * from SubjectStatus s, Account a \n"
                + "where s.Subject_id = ? and s.Account_id = a.Account_id and a.status = 1";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (subjectId)); // page 1 starts at index 0
            rs = ps.executeQuery();
            while (rs.next()) {
                accountId = rs.getInt("Account_id");
                name = rs.getString("fullname");
                gender = rs.getString("gender");
                email = rs.getString("email");
                Dob = rs.getDate("DOB");
                enroll = rs.getDate("createdDate");
                list.add(new Account(accountId, email, name, Dob, gender, enroll));
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return list;
    }

    public List<Account> getStudentListByNameAsc(int subjectId) {
        List<Account> list = new ArrayList<>();
        int accountId;
        String name;
        String gender;
        String email;
        Date Dob;
        Date enroll;
        boolean status;
        String query = "select * from SubjectStatus s, Account a \n"
                + "where s.Subject_id = ? and s.Account_id = a.Account_id and a.status = 1 ORDER BY a.fullname asc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (subjectId)); // page 1 starts at index 0
            rs = ps.executeQuery();
            while (rs.next()) {
                accountId = rs.getInt("Account_id");
                name = rs.getString("fullname");
                gender = rs.getString("gender");
                email = rs.getString("email");
                Dob = rs.getDate("DOB");
                enroll = rs.getDate("createdDate");
                list.add(new Account(accountId, email, name, Dob, gender, enroll));
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return list;
    }

    public List<Account> getStudentListByNameDesc(int subjectId) {
        List<Account> list = new ArrayList<>();
        int accountId;
        String name;
        String gender;
        String email;
        Date Dob;
        Date enroll;
        boolean status;
        String query = "select * from SubjectStatus s, Account a \n"
                + "where s.Subject_id = ? and s.Account_id = a.Account_id and a.status = 1 ORDER BY a.fullname desc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (subjectId)); // page 1 starts at index 0
            rs = ps.executeQuery();
            while (rs.next()) {
                accountId = rs.getInt("Account_id");
                name = rs.getString("fullname");
                gender = rs.getString("gender");
                email = rs.getString("email");
                Dob = rs.getDate("DOB");
                enroll = rs.getDate("createdDate");
                list.add(new Account(accountId, email, name, Dob, gender, enroll));
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return list;
    }

    //Get all account
    public List<Account> getAllAccount(int page) {
        List<Account> list = new ArrayList<>();
        String query = "SELECT * FROM Account\n"
                + "ORDER BY Account_id\n"
                + "OFFSET ? ROWS FETCH NEXT 15 ROWS ONLY";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (page - 1) * 15); // page 1 starts at index 0
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getDate(11),
                        rs.getString(12),
                        rs.getBoolean(13)
                ));

            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return list;
    }

    //Get all account by role
    public List<Account> getAllAccountByRole(int page, String roleId) {
        List<Account> list = new ArrayList<>();
        String query = "select * from Account where Account_id in (select Account_id from AccountRole where role_id = ?)\n"
                + "ORDER BY Account_id\n"
                + "OFFSET ? ROWS FETCH NEXT 15 ROWS ONLY";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(2, (page - 1) * 15); // page 1 starts at index 0
            ps.setString(1, roleId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getDate(11),
                        rs.getString(12),
                        rs.getBoolean(13)
                ));

            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return list;
    }

    public List<Account> getAllStudentByRole() {
        List<Account> list = new ArrayList<>();
        String query = "select * from Account where Account_id in (select Account_id from AccountRole where role_id = 1)\n";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getDate(11),
                        rs.getString(12),
                        rs.getBoolean(13)
                ));

            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return list;
    }
    // Get  Account by ID

    public Account getAccountByID(int accountID) {
        String query = "SELECT * FROM Account WHERE Account_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getDate(11),
                        rs.getString(12),
                        rs.getBoolean(13)
                );
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }

    //Add AccountRole data for new account
    public void insertAccountRole(String role_id) {
        String query = "INSERT INTO [AccountRole] ([account_id], [role_id])\n"
                + "VALUES (?, ?);";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, role_id);
            ps.executeUpdate(); // no result ==> no need result set
        } catch (Exception e) {
            // Handle exceptions here
        } finally {
            // Close database connections and resources in a real application
            // For simplicity, it's omitted here.
        }
    }

    public void BanAccount(int accountID) {
        String query = "UPDATE [Account] SET [Status] = 0 where [account_id] = ? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void UnbanAccount(int accountID) {
        String query = "UPDATE [Account] SET [Status] = 1 where [account_id] = ? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    // Edit User 
    public void editUser(int accountID, String username, String password, String email, String status, String gender, String avatar, String fullname, String DOB) {
        String query = "UPDATE [Account]\n"
                + "SET [username] = ?,\n"
                + "    [password] = ?,\n"
                + "    [email] = ?,\n"
                + "    [fullname] = ?,\n"
                + "    [DOB] = ?,\n"
                + "    [gender] = ?,\n"
                + "    [avatar] = ?,\n"
                + "    [modifyDate] = ?\n"
                + "WHERE [account_id] = ?";

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
            LocalDateTime currentTime = LocalDateTime.now();
            Date modifyDate = Date.valueOf(currentTime.toLocalDate());
            ps.setDate(8, modifyDate);
            ps.setInt(9, accountID);
            ps.executeUpdate(); // no result ==> no need result set
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

//    // Get  Account by ID
//    public Account getAccountByID(String Account_ID) {
//        String query = "select * from Account where account_id = ?";
//        try {
//            conn = new DBContext().getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setString(1, Account_ID);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                return new Account(
//                        rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getString(5),
//                        rs.getDate(6),
//                        rs.getString(7),
//                        rs.getString(8),
//                        rs.getString(9),
//                        rs.getDate(10),
//                        rs.getDate(11),
//                        rs.getString(12),
//                        rs.getInt(13),
//                        rs.getBoolean(14)
//                );
//            }
//        } catch (Exception e) {
//        }
//        return null;
//    }
    public void updateProfile(String fullname, String email, String dob, String gender, String avatar, String introduction, int accountID) {
        String query = "update Account set fullname = ?, email = ?, DOB = ?, gender = ?, avatar = ?, [self-introduction] = ? where Account_id =?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, fullname);
            ps.setString(2, email);
            ps.setString(3, dob);
            ps.setString(4, gender);
            ps.setString(5, avatar);
            ps.setString(6, introduction);
            ps.setInt(7, accountID);
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

    // Search account by fullname
    public List<Account> searchAccountByName(String txtSearch) {
        List<Account> list = new ArrayList<>();
        String query = "select * from Account where fullname like ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getDate(11),
                        rs.getString(12),
                        rs.getBoolean(13)
                ));

            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return list;
    }
//    public void Expert getExpertByID(){
//        String query = "SELECT * FROM Expert WHERE Account_id = ?";
//        try {
//            conn = new DBContext().getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setInt(1, accountID);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                return new Account(
//                        rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getString(5),
//                        rs.getDate(6),
//                        rs.getString(7),
//                        rs.getString(8),
//                        rs.getString(9),
//                        rs.getDate(10),
//                        rs.getDate(11),
//                        rs.getString(12),
//                        rs.getBoolean(13)
//                );
//            }
//        } catch (Exception e) {
//            //e.printStackTrace();
//        }
//        return null;
//    }

    public List<Account> searchCustomerByName(String name) {
        List<Account> customerList = new ArrayList<>();
        String sql = "SELECT * FROM Account a "
                + "INNER JOIN AccountRole ar ON a.Account_id = ar.Account_id "
                + "INNER JOIN Role r ON ar.role_id = r.role_id "
                + "WHERE r.role_name = 'customer' "
                + "AND a.fullname LIKE ?";

        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + name + "%"); // Search for name containing the given input

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // Retrieve account information from the result set and create Account objects
                // (similar to what you did in your existing getAllCustomer method)
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return customerList;
    }

    public int addAccount(
            String username,
            String password,
            String email,
            String fullname,
            String dob,
            String gender,
            String selfIntroduction,
            String avatar,
            boolean status
    ) {
        String sql = "INSERT INTO Account (username, password, email, fullname, DOB, gender, [self-introduction], avatar, createdDate, modifyDate, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, fullname);
            ps.setString(5, dob);
            ps.setString(6, gender);
            ps.setString(7, selfIntroduction);
            ps.setString(8, avatar);
            LocalDateTime currentTime = LocalDateTime.now();
            Date modifyDate = Date.valueOf(currentTime.toLocalDate());
            ps.setDate(9, modifyDate);
            ps.setDate(10, modifyDate);
            ps.setBoolean(11, status);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            // Handle or log the exception
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        // Create an instance of AccountDAO
        AccountDAO accountDAO = new AccountDAO();

        // Provide the name you want to search for
        String nameToSearch = "John"; // Replace with the desired name

        // Call the searchCustomerByName method to get a list of matching customers
        List<Account> matchingCustomers = accountDAO.searchCustomerByName(nameToSearch);

        // Iterate through the matching customers and print their details
        for (Account customer : matchingCustomers) {
            System.out.println("Customer ID: " + customer.getAccountId());
            System.out.println("Username: " + customer.getUsername());
            System.out.println("Full Name: " + customer.getFullname());
            // Add more properties as needed
            System.out.println();
        }
    }

}

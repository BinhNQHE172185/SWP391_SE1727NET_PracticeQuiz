/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAL.DBContext;
import Model.Expert;
import Model.Marketer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class ExpertDAO extends DBContext {

    PreparedStatement ps;
    ResultSet rs;

    public int getNumOfExpert() {
        String query = "select COUNT(*) from Subject";
        try {
            ps = getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    public Expert getExpert(String username, String password) {
        int expertId;
        String email;
        String name;
        String selfIntroduction;
        String avatar;
        boolean status;
        Expert ex = null;
        String sql = "SELECT * FROM Expert WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                expertId = rs.getInt("Expert_id");
                username = rs.getString("username");
                password = rs.getString("password");
                email = rs.getString("email");
                name = rs.getString("name");
                selfIntroduction = rs.getString("self-introduction");
                avatar = rs.getString("avatar");
                status = rs.getBoolean("status");
                ex = new Expert(expertId, username, password, email, name, selfIntroduction, avatar, status);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            Logger.getLogger(ExpertDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return ex;
    }

    public Expert checkMail(String email) {
        Expert ex = null;
        int expertId;
        String name;
        String username;
        String password;
        String selfIntroduction;
        String avatar;
        boolean status;
        String sql = "SELECT * FROM Expert WHERE email = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                expertId = rs.getInt("Expert_id");
                username = rs.getString("username");
                password = rs.getString("password");
                email = rs.getString("email");
                name = rs.getString("name");
                selfIntroduction = rs.getString("self-introduction");
                avatar = rs.getString("avatar");
                status = rs.getBoolean("status");
                ex = new Expert(expertId, username, password, email, name, selfIntroduction, avatar, status);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            Logger.getLogger(ExpertDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return ex;
    }

    public void updatePassword(String password, String expertId) {
        String query = "update Expert set password = ? where Expert_id =?";
        try {
            Connection conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, expertId);
            rs = ps.executeQuery();
        } catch (Exception e) {

        }
    }

    public void updateProfile(String name, String email, String avatar, String desc, int expertID) {
        try {
            String query = "  update Expert\n"
                    + "  set email = ?,\n"
                    + "  [name] = ?,\n"
                    + "  avatar = ?,\n"
                    + "  [self-introduction] = ?\n"
                    + "  where Expert_id = ?";
            Connection conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, avatar);
            ps.setString(4, desc);
            ps.setInt(5, expertID);
            rs = ps.executeQuery();
        } catch (Exception e) {
            Logger.getLogger(ExpertDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Expert getExpertBySubjectID(int subjectId) {
        int expertId;
        String username;
        String password;
        String email;
        String name;
        String selfIntroduction;
        String avatar;
        boolean status;
        Expert ex = null;

        String sql = "SELECT E.* FROM Expert AS E "
                + "INNER JOIN Subject AS S ON E.Expert_id = S.Expert_id "
                + "WHERE S.Subject_id = ?";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, subjectId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                expertId = rs.getInt("Expert_id");
                username = rs.getString("username");
                password = rs.getString("password");
                email = rs.getString("email");
                name = rs.getString("name");
                selfIntroduction = rs.getString("self-introduction");
                avatar = rs.getString("avatar");
                status = rs.getBoolean("status");

                ex = new Expert(expertId, username, password, email, name, selfIntroduction, avatar, status);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            Logger.getLogger(ExpertDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return ex;
    }

    public Expert getExpertByID(int expertID) {
        int expertId;
        String username;
        String password;
        String email;
        String name;
        String selfIntroduction;
        String avatar;
        boolean status;
        Expert ex = null;
        String sql = "select * from Expert where Expert_id = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, expertID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                expertId = rs.getInt("Expert_id");
                username = rs.getString("username");
                password = rs.getString("password");
                email = rs.getString("email");
                name = rs.getString("name");
                selfIntroduction = rs.getString("self-introduction");
                avatar = rs.getString("avatar");
                status = rs.getBoolean("status");
                ex = new Expert(expertId, username, password, email, name, selfIntroduction, avatar, status);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            Logger.getLogger(ExpertDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return ex;
    }
    public Expert getExpertByUsername(String username) {
        int expertId;
        String password;
        String email;
        String name;
        String selfIntroduction;
        String avatar;
        boolean status;
        Expert ex = null;
        String sql = "select * from Expert where username = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                expertId = rs.getInt("Expert_id");
                username = rs.getString("username");
                password = rs.getString("password");
                email = rs.getString("email");
                name = rs.getString("name");
                selfIntroduction = rs.getString("self-introduction");
                avatar = rs.getString("avatar");
                status = rs.getBoolean("status");
                ex = new Expert(expertId, username, password, email, name, selfIntroduction, avatar, status);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            Logger.getLogger(ExpertDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return ex;
    }
    public Expert getExpertByEmail(String email) {
        int expertId;
        String password;
        String username;
        String name;
        String selfIntroduction;
        String avatar;
        boolean status;
        Expert ex = null;
        String sql = "select * from Expert where username = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                expertId = rs.getInt("Expert_id");
                username = rs.getString("username");
                password = rs.getString("password");
                email = rs.getString("email");
                name = rs.getString("name");
                selfIntroduction = rs.getString("self-introduction");
                avatar = rs.getString("avatar");
                status = rs.getBoolean("status");
                ex = new Expert(expertId, username, password, email, name, selfIntroduction, avatar, status);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            Logger.getLogger(ExpertDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return ex;
    }

    public void RegisterExpert(String username, String password, String email) {
        String sql = "INSERT INTO [dbo].[Expert]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[email]\n"
                + "           ,[status])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,'True')";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ExpertDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean UsernameExist(String username) {
        Expert ac;
        ac = getExpertByUsername(username);
        if (ac == null) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ExpertDAO dao = new ExpertDAO();
        Expert ex = dao.getExpertByID(37);
        System.out.println(ex.getName());
    }
}

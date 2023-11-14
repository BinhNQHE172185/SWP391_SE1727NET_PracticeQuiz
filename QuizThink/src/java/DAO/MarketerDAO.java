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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MarketerDAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Marketer getMarketerBySlider(int sliderId) {
        int marketerId;
        String username;
        String password;
        String email;
        String name;
        String selfIntroduction;
        String avatar;
        boolean status;
        Marketer marketer = null;

        String sql = "SELECT M.* FROM Marketer AS M "
                + "INNER JOIN Slider AS S ON M.Marketer_id = S.Marketer_id "
                + "WHERE S.Slider_id = ?";

        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, sliderId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                marketerId = rs.getInt("Marketer_id");
                username = rs.getString("username");
                password = rs.getString("password");
                email = rs.getString("email");
                name = rs.getString("name");
                selfIntroduction = rs.getString("self-introduction");
                avatar = rs.getString("avatar");
                status = rs.getBoolean("status");

                marketer = new Marketer(marketerId, username, password, email, name, selfIntroduction, avatar, status);
            }

            rs.close();
            ps.close();
            connection.close(); // Don't forget to close the connection.

        } catch (Exception e) {
            Logger.getLogger(MarketerDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return marketer;
    }

    public Marketer getMarketer(String username, String password) {
        Marketer mk = null;
        int marketerId;
        String email;
        String name;
        String avatar;
        String selfIntroduction;
        boolean status;
        String sql = "SELECT * FROM Marketer where username = ? and password = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                marketerId = rs.getInt("Marketer_id");
                username = rs.getString("username");
                password = rs.getString("password");
                email = rs.getString("email");
                name = rs.getString("name");
                selfIntroduction = rs.getString("self-introduction");
                avatar = rs.getString("avatar");
                status = rs.getBoolean("status");
                mk = new Marketer(marketerId, username, password, email, name, selfIntroduction, avatar, status);
            }
        } catch (Exception ex) {
            Logger.getLogger(MarketerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mk;
    }

    public Marketer getMarketerProfile(int marketerId) {
        Marketer mk = null;
        String sql = "SELECT * FROM Marketer WHERE Marketer_id = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, marketerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String name = rs.getString("name");
                String selfIntroduction = rs.getString("self-introduction");
                String avatar = rs.getString("avatar");
                boolean status = rs.getBoolean("status");
                mk = new Marketer(marketerId, username, password, email, name, selfIntroduction, avatar, status);
            }
        } catch (Exception ex) {
            Logger.getLogger(MarketerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mk;
    }

    public void updateMarketerProfile(String name, String email, String avatar, String selfIntroduction,int marketerId ) {
        try {
            String query = "UPDATE Marketer\n"
                    + "SET email = ?,\n"
                    + "    name = ?,\n"
                    + "    avatar = ?,\n"
                    + "    [self-introduction] = ?\n"
                    + "WHERE Marketer_id = ?;";
            Connection conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, name);
            ps.setString(3, avatar);
            ps.setString(4, selfIntroduction);
            ps.setInt(5, marketerId);
            rs = ps.executeQuery();
        } catch (Exception e) {
            Logger.getLogger(ExpertDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public Marketer checkMail(String email) {
        Marketer mk = null;
        int marketerId;
        String username;
        String password;
        String name;
        String avatar;
        String selfIntroduction;
        boolean status;
        String sql = "SELECT * FROM Marketer where email = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                marketerId = rs.getInt("Marketer_id");
                username = rs.getString("username");
                password = rs.getString("password");
                email = rs.getString("email");
                name = rs.getString("name");
                selfIntroduction = rs.getString("self-introduction");
                avatar = rs.getString("avatar");
                status = rs.getBoolean("status");
                mk = new Marketer(marketerId, username, password, email, name, selfIntroduction, avatar, status);
            }
        } catch (Exception ex) {
            Logger.getLogger(MarketerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return mk;
    }
    public void updatePassword(String password, String MarketerId) {
        String query = "update Marketer set password = ? where Marketer_id =?";
        try {
            Connection conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, MarketerId);
            rs = ps.executeQuery();
        } catch (Exception e) {

        }
    }
    
    //Get all account
    public List<Marketer> getAllMarketer(int page) {
        List<Marketer> list = new ArrayList<>();
            String query = "SELECT * FROM Marketer\n" +
                    "ORDER BY Marketer_id"
                + "OFFSET ? ROWS FETCH NEXT 15 ROWS ONLY";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (page - 1) * 15); // page 1 starts at index 0
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Marketer(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getBoolean(8)
                ));

            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return list;
    }
}

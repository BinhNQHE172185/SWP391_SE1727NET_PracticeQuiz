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
}

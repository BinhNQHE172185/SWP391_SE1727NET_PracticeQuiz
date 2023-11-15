/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAL.DBContext;
import Model.Membership;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QUYBINH
 */
public class MembershipDAO extends DBContext {

    public List<Membership> getMembership() {
        List<Membership> list = new ArrayList<>();
        String sql = "SELECT * FROM Membership";
        int membershipId;
        float price;
        float discount;
        String desc;
        String title;
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                membershipId = rs.getInt("Membership_id");
                price = rs.getFloat("price");
                discount = rs.getFloat("discount");
                desc = rs.getString("description");
                title = rs.getString("title");
                Membership mem = new Membership(membershipId, price, discount, desc, title);
                list.add(mem);
            }
        } catch (Exception ex) {
            Logger.getLogger(MembershipDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Membership getMembershipByID(int id) {
        Membership mem = null;
        String sql = "SELECT * FROM Membership where Membership_id = ?";
        int membershipId;
        float price;
        float discount;
        String desc;
        String title;
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                membershipId = rs.getInt("Membership_id");
                price = rs.getFloat("price");
                discount = rs.getFloat("discount");
                desc = rs.getString("description");
                title = rs.getString("title");
                mem = new Membership(membershipId, price, discount, desc, title);
            }
        } catch (Exception ex) {
            Logger.getLogger(MembershipDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mem;
    }

    public void addMembership(float price, String desc, String title) {
        String sql = "INSERT INTO [dbo].[Membership]\n"
                + "           ([price]\n"
                + "           ,[description]\n"
                + "           ,[title])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";  // Removed an extra parameter placeholder

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setFloat(1, price);
            ps.setString(2, desc);
            ps.setString(3, title);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(MembershipDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EditMembership(int id, float price, float discount, String desc, String title) {
        String sql = "UPDATE [dbo].[Membership]\n"
                + "   SET [price] = ?\n"
                + "      ,[discount] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[title] = ?\n"
                + " WHERE Membership_id = ?";  // Removed an extra parameter placeholder

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setFloat(1, price);
            ps.setFloat(2, discount);
            ps.setString(3, desc);
            ps.setString(4, title);
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(MembershipDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DeteleMembership(int id) {
        String sql = "DELETE FROM [dbo].[Membership]\n"
                + "      WHERE Membership_id = ?";  // Removed an extra parameter placeholder

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(MembershipDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        MembershipDAO md = new MembershipDAO();
        List<Membership> mem = md.getMembership();
        for (Membership m : mem) {
            System.out.println(m.getPrice() + "" + m.getDescription());
        }
    }
}

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
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                membershipId = rs.getInt("Membership_id");
                price = rs.getFloat("price");
                discount = rs.getFloat("discount");
                desc = rs.getString("description");
                Membership mem = new Membership(membershipId, price, discount, desc);
                list.add(mem);
            }
        } catch (Exception ex) {
            Logger.getLogger(MembershipDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void main(String[] args){
        MembershipDAO md = new MembershipDAO();
        List<Membership> mem = md.getMembership();
        for(Membership m : mem){
            System.out.println(m.getPrice() + "" +m.getDescription());
        }
    }
}

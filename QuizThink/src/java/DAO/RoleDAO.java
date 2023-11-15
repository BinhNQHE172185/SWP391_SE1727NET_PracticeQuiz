/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAL.DBContext;
import Model.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class RoleDAO extends DBContext{
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Role> getAllRole() {
        List<Role> list = new ArrayList<>();
        String query = "SELECT * FROM Role";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add( new Role(
                        rs.getInt(1),
                        rs.getString(2)
                ));
                
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return list;
    }
    
    public int getRoleByAccountID( String account_id){
        String query = "SELECT role_id FROM AccountRole where Account_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, account_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }
        return 0;
    }
    
    public static void main(String[] args) {
        try {
            
            RoleDAO dao = new RoleDAO();
            System.out.println();
            List<Role> list = dao.getAllRole();
            for (Role role : list) {
                System.out.println(role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

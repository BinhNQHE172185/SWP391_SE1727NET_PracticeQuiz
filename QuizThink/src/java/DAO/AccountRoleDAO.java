/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAL.DBContext;
import Model.AccountRole;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author admin
 */
public class AccountRoleDAO extends DBContext {
    private PreparedStatement ps;
    private ResultSet rs;
    
    public AccountRole getRoleByAccID(int accID){
        try{
            String query = " select * from AccountRole where Account_id =?";
            PreparedStatement ps = getConnection().prepareStatement(query);
            ps.setInt(1, accID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return new AccountRole(
                        rs.getInt("AccountRole_id"),
                        rs.getInt("Account_id"),
                        rs.getInt("role_id"));
            }
        }catch(Exception e){
            
        }
        return null;
    }
}
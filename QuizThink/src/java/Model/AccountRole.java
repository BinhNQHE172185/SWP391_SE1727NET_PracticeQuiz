/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author kimdi
 */
public class AccountRole {
    private int accountRoleId;
    private int accountId;
    private int roleId;
    
    public AccountRole() {
    }
    
    public AccountRole(int accountRoleId, int accountId, int roleId) {
        this.accountRoleId = accountRoleId;
        this.accountId = accountId;
        this.roleId = roleId;
    }
    
    public int getAccountRoleId() {
        return accountRoleId;
    }
    
    public void setAccountRoleId(int accountRoleId) {
        this.accountRoleId = accountRoleId;
    }
    
    public int getAccountId() {
        return accountId;
    }
    
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    
    public int getRoleId() {
        return roleId;
    }
    
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}

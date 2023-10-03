/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author LEMONLORD
 */
public class Account {

    private int accountId;
    private String username;
    private String password;
    private String email;
    private String fullname;
    private Date dob;
    private String gender;
    private String selfIntroduction;
    private String avatar;
    private Date createdDate;
    private Date modifyDate;
    private String passwordToken;
    private boolean status;

    public Account(int accountId, String username, String password, String email, String fullname, Date dob, String gender, String selfIntroduction, String avatar, Date createdDate, Date modifyDate, String passwordToken, boolean status) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.dob = dob;
        this.gender = gender;
        this.selfIntroduction = selfIntroduction;
        this.avatar = avatar;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
        this.passwordToken = passwordToken;
        this.status = status;
    }

    public Account() {
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getPasswordToken() {
        return passwordToken;
    }

    public void setPasswordToken(String passwordToken) {
        this.passwordToken = passwordToken;
    }
    
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" + "accountId=" + accountId + ", username=" + username + ", password=" + password + ", email=" + email + ", fullname=" + fullname + ", dob=" + dob + ", gender=" + gender + ", status=" + status + '}';
    }
      
}

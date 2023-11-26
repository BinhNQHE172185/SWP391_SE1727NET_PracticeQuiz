/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
public class Marketer {
    private int marketerID;
    private String username;
    private String password;
    private String email;
    private String name;
    private String selfIntroduction;
    private String avatar;
    private boolean status;

    public Marketer() {
    }

    public Marketer(int marketerID, String username, String password, String email, String name, String selfIntroduction, String avatar, boolean status) {
        this.marketerID = marketerID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.selfIntroduction = selfIntroduction;
        this.avatar = avatar;
        this.status = status;
    }

    public int getMarketerID() {
        return marketerID;
    }

    public void setMarketerID(int marketerID) {
        this.marketerID = marketerID;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}

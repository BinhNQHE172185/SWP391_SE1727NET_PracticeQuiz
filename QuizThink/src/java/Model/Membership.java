/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
public class Membership {
    private int membershipID;
    private float price;
    private float discount;
    private String description;
    private String title;
    
    public Membership() {
    }

    public Membership(int membershipID, float price, float discount, String description) {
        this.membershipID = membershipID;
        this.price = price;
        this.discount = discount;
        this.description = description;
    }

    public Membership(int membershipID, float price, float discount, String description, String title) {
        this.membershipID = membershipID;
        this.price = price;
        this.discount = discount;
        this.description = description;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public int getMembershipID() {
        return membershipID;
    }

    public void setMembershipID(int membershipID) {
        this.membershipID = membershipID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class Transaction {
    private int transactionID;
    private int accountID;
    private int memnershipID;
    private Date transactionDate;
    private String fullname;
    private String email;
    private String paymentMethod;
    private String nameOnCard;
    private String creditNumber;
    private Date expirationDate;
    private String cvv;
    private float totalMoney;

    public Transaction() {
    }

    public Transaction(int transactionID, int accountID, int memnershipID, Date transactionDate, String fullname, String email, String paymentMethod, String nameOnCard, String creditNumber, Date expirationDate, String cvv, float totalMoney) {
        this.transactionID = transactionID;
        this.accountID = accountID;
        this.memnershipID = memnershipID;
        this.transactionDate = transactionDate;
        this.fullname = fullname;
        this.email = email;
        this.paymentMethod = paymentMethod;
        this.nameOnCard = nameOnCard;
        this.creditNumber = creditNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.totalMoney = totalMoney;
    }

    public Transaction(int accountID, int memnershipID, Date transactionDate, String fullname, String email, String paymentMethod, String nameOnCard, String creditNumber, Date expirationDate, String cvv, float totalMoney) {
        this.accountID = accountID;
        this.memnershipID = memnershipID;
        this.transactionDate = transactionDate;
        this.fullname = fullname;
        this.email = email;
        this.paymentMethod = paymentMethod;
        this.nameOnCard = nameOnCard;
        this.creditNumber = creditNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.totalMoney = totalMoney;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getMemnershipID() {
        return memnershipID;
    }

    public void setMemnershipID(int memnershipID) {
        this.memnershipID = memnershipID;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(String creditNumber) {
        this.creditNumber = creditNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }
    
}

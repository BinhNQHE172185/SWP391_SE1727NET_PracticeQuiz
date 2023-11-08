/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author QUYBINH
 */
public class Transaction {
    private int TransactionId;
    private int AccountId;
    private int MemebershipId;
    private Date TransactionDate;
    private String fullName;
    private String email;
    private String PaymentMethod;
    private String NameOnCard;
    private String cardCredit;
    private Date ExpireDate;
    private String CVV;
    private Float totalMoney;

    public Transaction() {
    }

    public Transaction(int TransactionId, int AccountId, int MemebershipId, Date TransactionDate, String fullName, String email, String PaymentMethod, String NameOnCard, String cardCredit, Date ExpireDate, String CVV, Float totalMoney) {
        this.TransactionId = TransactionId;
        this.AccountId = AccountId;
        this.MemebershipId = MemebershipId;
        this.TransactionDate = TransactionDate;
        this.fullName = fullName;
        this.email = email;
        this.PaymentMethod = PaymentMethod;
        this.NameOnCard = NameOnCard;
        this.cardCredit = cardCredit;
        this.ExpireDate = ExpireDate;
        this.CVV = CVV;
        this.totalMoney = totalMoney;
    }

    public int getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(int TransactionId) {
        this.TransactionId = TransactionId;
    }

    public int getAccountId() {
        return AccountId;
    }

    public void setAccountId(int AccountId) {
        this.AccountId = AccountId;
    }

    public int getMemebershipId() {
        return MemebershipId;
    }

    public void setMemebershipId(int MemebershipId) {
        this.MemebershipId = MemebershipId;
    }

    public Date getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(Date TransactionDate) {
        this.TransactionDate = TransactionDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

    public String getNameOnCard() {
        return NameOnCard;
    }

    public void setNameOnCard(String NameOnCard) {
        this.NameOnCard = NameOnCard;
    }

    public String getCardCredit() {
        return cardCredit;
    }

    public void setCardCredit(String cardCredit) {
        this.cardCredit = cardCredit;
    }

    public Date getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(Date ExpireDate) {
        this.ExpireDate = ExpireDate;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public Float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Float totalMoney) {
        this.totalMoney = totalMoney;
    }

    
    
}

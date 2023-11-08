/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAL.DBContext;
import Model.Transaction;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QUYBINH
 */
public class TransactionDAO extends DBContext {

    public List<Transaction> getTransaction() {
        List<Transaction> tran = new ArrayList<>();
        String sql = "Select * from [dbo].[Transaction]";
        int TransactionId;
        int AccountId;
        int MemebershipId;
        Date TransactionDate;
        String fullName;
        String email;
        String PaymentMethod;
        String NameOnCard;
        String cardCredit;
        Date ExpireDate;
        String CVV;
        Float totalMoney;
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               TransactionId = rs.getInt("Transaction_id");
               AccountId = rs.getInt("Account_id");
               MemebershipId = rs.getInt("Membership_id");
               TransactionDate = rs.getDate("Transaction_date");
               fullName = rs.getString("Fullname");
               email = rs.getString("Email");
               PaymentMethod = rs.getString("Payment_method");
               NameOnCard = rs.getString("Name_on_card");
               cardCredit = rs.getString("Card_credit_number");
               CVV = rs.getString("CVV");
               ExpireDate = rs.getDate("Expiration");
               totalMoney = rs.getFloat("Total_money");
               tran.add(new Transaction(TransactionId, AccountId, MemebershipId, TransactionDate, fullName, email, PaymentMethod, NameOnCard, cardCredit, ExpireDate, CVV, totalMoney));
            }
        } catch (Exception ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tran;
    }
    
    public static void main(String args[]){
        TransactionDAO td = new TransactionDAO();
        List<Transaction> t = td.getTransaction();
        for(Transaction o : t){
            System.out.println(o.getPaymentMethod());
        }
    }
}

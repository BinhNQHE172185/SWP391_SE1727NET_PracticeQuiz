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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author admin
 */
public class TransactionDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;
    private static final Pattern CVV_PATTERN = Pattern.compile("^[0-9]{3,4}$");

    public boolean isValidFullName(String fullName) {
        // Define a regular expression pattern for a full name with multiple surnames
        String regex = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)+$";

        // Compile the regular expression pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(fullName);

        // Check if the input matches the pattern
        return matcher.matches();
    }

    public boolean isValidCardName(String fullName) {
        // Define a regular expression pattern for a full name with multiple surnames
        String regex = "^[A-Z][A-Za-z]*(\\s[A-Z][A-Za-z]*)+$";

        // Compile the regular expression pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(fullName);

        // Check if the input matches the pattern
        return matcher.matches();
    }

    public boolean isValidCreditCard(String number) {
        int[] digits = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            digits[i] = Character.getNumericValue(number.charAt(i));
        }

        for (int i = digits.length - 2; i >= 0; i -= 2) {
            int doubleDigit = digits[i] * 2;
            if (doubleDigit > 9) {
                doubleDigit -= 9;
            }
            digits[i] = doubleDigit;
        }

        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }

        return (sum % 10) == 0;
    }

    public boolean isValid(String cvv) {
        if (cvv == null) {
            return false;
        }
        return CVV_PATTERN.matcher(cvv).matches();
    }

    public void addTransaction(int accID, int memID, Date tranDate, String fullname, String email, String payMethod, String nameOnCard, String creditNumber, Date expiration, String cvv, float totalMoney) {
        try {
            String query = " insert into [Transaction]\n"
                    + "(Account_id, Membership_id, Transaction_date, Fullname, Email, Payment_method, Name_on_card, Card_credit_number, Expiration, CVV, Total_money)\n"
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, accID);
            ps.setInt(2, memID);
            ps.setDate(3, tranDate);
            ps.setString(4, fullname);
            ps.setString(5, email);
            ps.setString(6, payMethod);
            ps.setString(7, nameOnCard);
            ps.setString(8, creditNumber);
            ps.setDate(9, expiration);
            ps.setString(10, cvv);
            ps.setFloat(11, totalMoney);
            ps.executeQuery();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
    }

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
            while (rs.next()) {
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
    public void updateAccountRole(int roleID, int accID){
        try {
            String query = "update AccountRole set role_id = ? where Account_id = ?";
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, roleID);
            ps.setInt(2, accID);          
            ps.executeQuery();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String name = "BUI NGOC DUNG";
        String cardNumber = "1234567890123452";
        String cvv = "321";
        TransactionDAO dao = new TransactionDAO();
        boolean isName = dao.isValidCardName(name);
        System.out.println(isName);
        boolean isCvv = dao.isValid(cvv);
        System.out.println(isCvv);
    }
}

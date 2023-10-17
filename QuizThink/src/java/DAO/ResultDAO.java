/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAL.DBContext;
import Model.Result;
import Model.Subject;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ResultDAO extends DBContext {
    
    private PreparedStatement ps;
    private ResultSet rs;
    
    public List<Result> getResultByAccountID(String questionID, String accountID) {
        List<Result> list = new ArrayList<>();
        try {
            String query = "select * from Result where Question_id = ? and Account_id = ? order by takenDate desc";
            ps = getConnection().prepareStatement(query);
            ps.setString(1, questionID);
            ps.setString(2, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int Result_id = rs.getInt("Result_id");
                int Question_id = rs.getInt("Question_id");
                int Account_id = rs.getInt("Account_id");
                String selectedChoice = rs.getString("selectedChoice");
                Date takenDate = rs.getDate("takenDate");
                Time takenDuration = rs.getTime("takenDuration");
                Time duration = rs.getTime("duration");
                float mark = rs.getFloat("mark");
                int quizCount = rs.getInt("quiz_count");
                list.add(new Result(Result_id, Question_id, Account_id, selectedChoice, takenDate, takenDuration, duration, mark, quizCount));
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }
    
    public Result getResultByID(String id) {
        try {
            String query = " select * from Result where Result_id = ?";
            ps = getConnection().prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                return new Result(
                        rs.getInt("Result_id"),
                        rs.getInt("Question_id"),
                        rs.getInt("Account_id"),
                        rs.getString("selectedChoice"),
                        rs.getDate("takenDate"),
                        rs.getTime("takenDuration"),
                        rs.getTime("duration"),
                        rs.getFloat("mark"),
                        rs.getInt("quiz_count"));
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        ResultDAO dao = new ResultDAO();
//        List<Result> list = dao.getResultByAccountID("2", "2");
//        for(Result rs: list){
//            System.out.println(rs.getMark());
//        }
        Result rs = dao.getResultByID("5");
        System.out.println(rs.getMark());
        
    }
}

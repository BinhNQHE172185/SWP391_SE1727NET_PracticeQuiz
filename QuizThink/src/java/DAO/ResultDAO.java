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
    
    public List<Result> getResultByAccountID(String questionId, String accountId ){
        List<Result> listResult = new ArrayList<>();
        try {
            String query = "  select * from Result  where Question_id = ? and Account_id = ? order by takenDate desc";
            ps = getConnection().prepareStatement(query);
            ps.setString(1, questionId);
            ps.setString(2, accountId);           
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
                listResult.add(new Result(Result_id, Question_id, Account_id, selectedChoice, takenDate, takenDuration, duration, mark));
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return listResult;
    }
    
    public static void main(String[] args) {
        ResultDAO dao = new ResultDAO();
        List<Result> list = dao.getResultByAccountID("2", "2");
        for(Result rs: list){
            System.out.println(rs.getMark());
        }
    }
}

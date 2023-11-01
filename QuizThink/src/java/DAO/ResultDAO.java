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
import java.sql.Statement;
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

    public List<Result> getResultByAccountID(int questionID, int accountID) {
        List<Result> list = new ArrayList<>();
        try {
            String query = "select * from Result where Question_id = ? and Account_id = ? order by takenDate desc";
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, questionID);
            ps.setInt(2, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int Result_id = rs.getInt("Result_id");
                int Question_id = questionID;
                int Account_id = accountID;
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

    public List<Result> getResultByAccount(int accountID) {
        List<Result> list = new ArrayList<>();
        try {
            String query = "select * from Result where Account_id = ? order by takenDate desc";
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, accountID);
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

    public Result getResultByID(int id) {
        try {
            String query = " select * from Result where Result_id = ?";
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Result(
                        id,
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

    public int addResult(Result result) {
        int resultId = 0;

        try {
            String query = "INSERT INTO Result (Question_id, Account_id, selectedChoice, takenDate, takenDuration, duration, mark, quiz_count) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            ps = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, result.getQuestionId());
            ps.setInt(2, result.getAccountId());
            ps.setString(3, result.getSelectedChoice());
            ps.setDate(4, result.getTakenDate());
            ps.setTime(5, result.getTakenDuration());
            ps.setTime(6, result.getDuration());
            ps.setFloat(7, result.getMark());
            ps.setInt(8, result.getQuizCount());

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                // Retrieve the generated result ID
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    resultId = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }

        return resultId;
    }

    public Result getHighestMarkResultByQuestionIdAndAccountId(int questionId, int accountId) {
        Result highestMarkResult = null;
        try {
            String query = "SELECT TOP 1 * FROM Result WHERE Question_id = ? AND Account_id = ? ORDER BY mark DESC";
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, questionId);
            ps.setInt(2, accountId);
            rs = ps.executeQuery();

            if (rs.next()) {
                int resultId = rs.getInt("Result_id");
                String selectedChoice = rs.getString("selectedChoice");
                Date takenDate = rs.getDate("takenDate");
                Time takenDuration = rs.getTime("takenDuration");
                Time duration = rs.getTime("duration");
                float mark = rs.getFloat("mark");
                int quizCount = rs.getInt("quiz_count");

                highestMarkResult = new Result(resultId, questionId, accountId, selectedChoice, takenDate, takenDuration, duration, mark, quizCount);
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return highestMarkResult;
    }

    public static void main(String[] args) {
        ResultDAO resultDAO = new ResultDAO();
        int questionId = 37;
        int accountId = 1;

        // Call the getHighestMarkResultByQuestionIdAndAccountId method
        Result highestMarkResult = resultDAO.getHighestMarkResultByQuestionIdAndAccountId(questionId, accountId);

        // Print the retrieved result information
        if (highestMarkResult != null) {
            System.out.println("Result ID: " + highestMarkResult.getResultId());
            System.out.println("Question ID: " + highestMarkResult.getQuestionId());
            System.out.println("Account ID: " + highestMarkResult.getAccountId());
            System.out.println("Selected Choice: " + highestMarkResult.getSelectedChoice());
            System.out.println("Taken Date: " + highestMarkResult.getTakenDate());
            System.out.println("Taken Duration: " + highestMarkResult.getTakenDuration());
            System.out.println("Duration: " + highestMarkResult.getDuration());
            System.out.println("Mark: " + highestMarkResult.getMark());
            System.out.println("Quiz Count: " + highestMarkResult.getQuizCount());
        } else {
            System.out.println("Result not found for Question ID: " + questionId + " and Account ID: " + accountId);
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAL.DBContext;
import Model.QuestionStatus;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kimdi
 */
public class QuestionStatusDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public int addQuestionStatus(QuestionStatus questionStatus) {
        int questionStatusId = 0;
        try {
            String query = "INSERT INTO QuestionStatus (Subject_id, Question_id, Account_id, status, createdDate, modifyDate) VALUES (?, ?, ?, ?, ?, ?)";
            ps = getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, questionStatus.getSubjectId());
            ps.setInt(2, questionStatus.getQuestionId());
            ps.setInt(3, questionStatus.getAccountId());
            ps.setBoolean(4, questionStatus.isStatus());
            ps.setObject(5, questionStatus.getCreatedDate());
            ps.setObject(6, questionStatus.getModifyDate());
            ps.executeUpdate();

            // Retrieve the generated QuestionStatus_id
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                questionStatusId = rs.getInt(1);
                questionStatus.setQuestionStatusId(questionStatusId);
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return questionStatusId;
    }

    public QuestionStatus getQuestionStatusByQuestionIdAndAccountId(int questionId, int accountId) {
        QuestionStatus questionStatus = null;
        try {
            String query = "SELECT * FROM QuestionStatus WHERE Question_id = ? AND Account_id = ?";
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, questionId);
            ps.setInt(2, accountId);
            rs = ps.executeQuery();

            if (rs.next()) {
                questionStatus = new QuestionStatus();
                questionStatus.setQuestionStatusId(rs.getInt("QuestionStatus_id"));
                questionStatus.setSubjectId(rs.getInt("Subject_id"));
                questionStatus.setQuestionId(rs.getInt("Question_id"));
                questionStatus.setAccountId(rs.getInt("Account_id"));
                questionStatus.setStatus(rs.getBoolean("status"));
                questionStatus.setCreatedDate(rs.getDate("createdDate"));
                questionStatus.setModifyDate(rs.getDate("modifyDate"));
                questionStatus.setPassDate(rs.getDate("passDate"));
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return questionStatus;
    }

    public List<QuestionStatus> getQuestionStatusListBySubjectIdAndUserId(int subjectId, int accountId) {
        List<QuestionStatus> questionStatusList = new ArrayList<>();
        try {
            String query = "SELECT * FROM QuestionStatus WHERE Subject_id = ? AND Account_id = ?";
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, subjectId);
            ps.setInt(2, accountId);
            rs = ps.executeQuery();

            while (rs.next()) {
                QuestionStatus questionStatus = new QuestionStatus();
                questionStatus.setQuestionStatusId(rs.getInt("QuestionStatus_id"));
                questionStatus.setSubjectId(rs.getInt("Subject_id"));
                questionStatus.setQuestionId(rs.getInt("Question_id"));
                questionStatus.setAccountId(rs.getInt("Account_id"));
                questionStatus.setStatus(rs.getBoolean("status"));
                questionStatus.setCreatedDate(rs.getDate("createdDate"));
                questionStatus.setModifyDate(rs.getDate("modifyDate"));
                questionStatus.setPassDate(rs.getDate("passDate"));

                questionStatusList.add(questionStatus);
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return questionStatusList;
    }

    public boolean updateQuestionStatusToTrue(int questionStatusId) {
        boolean success = false;
        try {
            String query = "UPDATE QuestionStatus SET status = 1, passDate = GETDATE() WHERE QuestionStatus_id = ?";
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, questionStatusId);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                success = true;
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return success;
    }

    public static void main(String[] args) {
        QuestionStatusDAO questionStatusDAO = new QuestionStatusDAO();
        int questionStatusId = 8;

        // Call the updateQuestionStatusToTrue method
        boolean updated = questionStatusDAO.updateQuestionStatusToTrue(questionStatusId);

        // Print the result of the update
        if (updated) {
            System.out.println("Question status with ID " + questionStatusId + " updated successfully.");
        } else {
            System.out.println("Failed to update question status with ID " + questionStatusId + ".");
        }
    }
}

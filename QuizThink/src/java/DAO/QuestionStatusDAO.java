/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAL.DBContext;
import Model.QuestionStatus;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}

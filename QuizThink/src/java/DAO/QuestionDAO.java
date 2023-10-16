/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAL.DBContext;
import Model.Question;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kimdi
 */
public class QuestionDAO extends DBContext {

    public Question getQuestionById(int questionId) {
        String sql = "SELECT * FROM Question WHERE Question_id = ?";
        Question question = null;

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, questionId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int subjectId = resultSet.getInt("Subject_id");
                int expertId = resultSet.getInt("Expert_id");
                String title = resultSet.getString("title");
                String imageURL = resultSet.getString("imageURL");
                int quizCount = resultSet.getInt("quiz_count");
                String description = resultSet.getString("description");
                float requirement = resultSet.getFloat("requirement");
                Date createdDate = resultSet.getDate("createdDate");
                Date modifyDate = resultSet.getDate("modifyDate");
                boolean status = resultSet.getBoolean("status");
                Time duration = resultSet.getTime("duration");

                question = new Question(questionId, subjectId, expertId, title, imageURL, quizCount, description, requirement, createdDate, modifyDate, status, duration);
            }
            resultSet.close();
            statement.close();
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }
        return question;
    }

    public List<Question> getQuestionsBySubjectId(int subjectId) {
        String sql = "SELECT * FROM Question WHERE Subject_id = ?";
        List<Question> questions = new ArrayList<>();

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, subjectId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int questionId = resultSet.getInt("Question_id");
                int expertId = resultSet.getInt("Expert_id");
                String title = resultSet.getString("title");
                String imageURL = resultSet.getString("imageURL");
                int quizCount = resultSet.getInt("quiz_count");
                String description = resultSet.getString("description");
                float requirement = resultSet.getFloat("requirement");
                Date createdDate = resultSet.getDate("createdDate");
                Date modifyDate = resultSet.getDate("modifyDate");
                boolean status = resultSet.getBoolean("status");
                Time duration = resultSet.getTime("duration");

                Question question = new Question(questionId, subjectId, expertId, title, imageURL, quizCount, description, requirement, createdDate, modifyDate, status, duration);

                questions.add(question);
            }
            resultSet.close();
            statement.close();
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }
        return questions;
    }

    public List<Question> getQuestionsBySubjectId(int subjectId, int offSet, int noOfRecords) {
        String sql = "SELECT * FROM Question WHERE Subject_id = ? ORDER BY Question_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<Question> questions = new ArrayList<>();

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, subjectId);
            statement.setInt(2, offSet);
            statement.setInt(3, noOfRecords);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int questionId = resultSet.getInt("Question_id");
                int expertId = resultSet.getInt("Expert_id");
                String title = resultSet.getString("title");
                String imageURL = resultSet.getString("imageURL");
                int quizCount = resultSet.getInt("quiz_count");
                String description = resultSet.getString("description");
                float requirement = resultSet.getFloat("requirement");
                Date createdDate = resultSet.getDate("createdDate");
                Date modifyDate = resultSet.getDate("modifyDate");
                boolean status = resultSet.getBoolean("status");
                Time duration = resultSet.getTime("duration");

                Question question = new Question(questionId, subjectId, expertId, title, imageURL, quizCount, description, requirement, createdDate, modifyDate, status, duration);

                questions.add(question);
            }
            resultSet.close();
            statement.close();
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }
        return questions;
    }

    public int getNumberOfRecordsBySubjectId(int subjectId) {
        String sql = "SELECT COUNT(*) AS count FROM Question WHERE Subject_id = ?";
        int count = 0;

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, subjectId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }

            resultSet.close();
            statement.close();
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }

        return count;
    }

    public static void main(String[] args) {
        // Assuming you have an instance of your DAO class
        QuestionDAO yourDAO = new QuestionDAO();

        // Assuming you have a subjectId to test
        int subjectId = 1;

        // Call the method to get the number of records for the subject
        List<Question> questions = yourDAO.getQuestionsBySubjectId(subjectId,3,1);

        // Print the result
        for (Question question : questions) {
            System.out.println(question.getQuestionId());
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAL.DBContext;
import Model.Quiz;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kimdi
 */
public class QuizDAO extends DBContext {

    public List<Quiz> getQuizzesByQuestionId(int questionId) {
        String sql = "SELECT * FROM Quiz WHERE Question_id = ?";
        List<Quiz> quizzes = new ArrayList<>();

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, questionId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int quizId = resultSet.getInt("Quiz_id");
                Integer type = resultSet.getInt("type");
                String content = resultSet.getString("content");
                String description = resultSet.getString("description");

                Quiz quiz = new Quiz(quizId, questionId, type, content, description);

                quizzes.add(quiz);
            }
            resultSet.close();
            statement.close();
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }
        return quizzes;
    }

    public List<Quiz> getQuizzesByQuestionId(int questionId, int offSet, int noOfRecords) {
        String sql = "SELECT * FROM Quiz WHERE Question_id = ? ORDER BY Quiz_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<Quiz> quizzes = new ArrayList<>();

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, questionId);
            statement.setInt(2, offSet);
            statement.setInt(3, noOfRecords);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int quizId = resultSet.getInt("Quiz_id");
                Integer type = resultSet.getInt("type");
                String content = resultSet.getString("content");
                String description = resultSet.getString("description");

                Quiz quiz = new Quiz(quizId, questionId, type, content, description);

                quizzes.add(quiz);
            }
            resultSet.close();
            statement.close();
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }
        return quizzes;
    }

    public int getNumberOfRecordsByQuestionId(int questionId) {
        String sql = "SELECT COUNT(*) AS count FROM Quiz WHERE Question_id = ?";
        int count = 0;

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, questionId);
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

    public List<Quiz> searchQuizzesByQuestionId(int questionId, String searchQuery, int offSet, int noOfRecords) {
        String sql = "SELECT * FROM Quiz WHERE Question_id = ? AND [content] LIKE ? ORDER BY Quiz_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<Quiz> quizzes = new ArrayList<>();

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, questionId);
            statement.setString(2, "%" + searchQuery + "%");
            statement.setInt(3, offSet);
            statement.setInt(4, noOfRecords);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int quizId = resultSet.getInt("Quiz_id");
                Integer type = resultSet.getInt("type");
                String content = resultSet.getString("content");
                String description = resultSet.getString("description");

                Quiz quiz = new Quiz(quizId, questionId, type, content, description);

                quizzes.add(quiz);
            }
            resultSet.close();
            statement.close();
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }
        return quizzes;
    }

    public int getNumberOfRecordsByQuestionIdAndSearch(int questionId, String searchQuery) {
        String sql = "SELECT COUNT(*) AS count FROM Quiz WHERE Question_id = ? AND [content] LIKE ?";
        int count = 0;

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, questionId);
            statement.setString(2, "%" + searchQuery + "%");
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
        QuizDAO yourDAO = new QuizDAO();

        // Assuming you have a subjectId to test
        int questionId = 1;

        // Call the method to get the number of records for the subject
        List<Quiz> quizs = yourDAO.searchQuizzesByQuestionId(questionId,"quo", 0, 5);

        // Print the result
        for (Quiz quiz : quizs) {
            System.out.println(quiz.getContent());
        }
    }
}

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
    
    public int getNumOfQuiz() {
        String query = "select COUNT(*) from Quiz";
        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }
}

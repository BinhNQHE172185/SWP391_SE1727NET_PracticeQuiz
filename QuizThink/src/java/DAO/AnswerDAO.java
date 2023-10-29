package DAO;

import DAL.DBContext;
import Model.Answer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author kimdi
 */
public class AnswerDAO extends DBContext {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<Answer> getAnswersByQuizId(int quizId) {
        String sql = "SELECT * FROM Answer WHERE Quiz_id = ?";
        List<Answer> answers = new ArrayList<>();

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, quizId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int answerId = resultSet.getInt("Answer_id");
                boolean isCorrect = resultSet.getBoolean("isCorrect");
                String content = resultSet.getString("content");

                Answer answer = new Answer(answerId, quizId, isCorrect, content);

                answers.add(answer);
            }
            resultSet.close();
            statement.close();
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }
        return answers;
    }

    public List<Answer> getCorrectAnswersByQuizId(int quizId) {
        String sql = "SELECT * FROM Answer WHERE Quiz_id = ? AND isCorrect = ?";
        List<Answer> answers = new ArrayList<>();

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, quizId);
            statement.setBoolean(2, true);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int answerId = resultSet.getInt("Answer_id");
                boolean isCorrect = resultSet.getBoolean("isCorrect");
                String content = resultSet.getString("content");

                Answer answer = new Answer(answerId, quizId, isCorrect, content);

                answers.add(answer);
            }
            resultSet.close();
            statement.close();
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }
        return answers;
    }
    
    // Add Answer temp
    public void addAnswer(int quiz_id, String isCorrect, String content){ 
        String query = "INSERT INTO Answer (Quiz_id, isCorrect, content)\n" +
                        "VALUES\n" +
                        "    (?, ?, ?)";
         try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            
            ps.setInt(1, quiz_id);
            ps.setString(2, isCorrect);
            ps.setString(3, content);
            ps.executeUpdate(); 
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    //Remove Answer
    public void removeAnswer(String answer_id){ 
        String query ="delete from Answer \n" +
                        "where answer_id = ?";
         try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            
            ps.setString(1, answer_id);
            ps.executeUpdate(); 
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
            
    // Edit answer
    public void editAnswer(String answer_id, String isCorrect, String content){ 
        String query = "UPDATE [Answer]\n" +
                        "SET [isCorrect] = ?,\n" +
                        "    [content] = ?\n" +
                        "WHERE [Answer_id] = ?;";
         try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            if(isCorrect.equals("correct")){
                ps.setString(1, "1");
            }else{
                ps.setString(1, "0");
            }
            ps.setString(2, content);
            ps.setString(3, answer_id);
            ps.executeUpdate(); // no result ==> no need result set
            
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // Assuming you have a QuizDAO instance called quizDAO
        AnswerDAO answerDAO = new AnswerDAO();

        // Assuming you have a quizId to test
        int quizId = 123; // Replace with your actual quiz ID

        // Call the getCorrectAnswersByQuizId method
        List<Answer> correctAnswers = answerDAO.getCorrectAnswersByQuizId(quizId);

        // Print the retrieved correct answers
        for (Answer answer : correctAnswers) {
            System.out.println("Answer ID: " + answer.getAnswerId());
            System.out.println("Quiz ID: " + answer.getQuizId());
            System.out.println("Is Correct: " + answer.isCorrect());
            System.out.println("Content: " + answer.getContent());
            System.out.println("---------------------------");
        }
    }
}

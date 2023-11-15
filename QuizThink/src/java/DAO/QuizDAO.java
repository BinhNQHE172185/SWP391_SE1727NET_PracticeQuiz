/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAL.DBContext;
import Model.Quiz;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kimdi
 */
public class QuizDAO extends DBContext {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
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
    
    public boolean removeQuiz(String quizId) {
        String query = "DELETE from Answer where Quiz_id = ?\n" +
                        "DELETE from Quiz where Quiz_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, quizId);
            ps.setString(2, quizId);
            ps.executeUpdate(); 
            return true;
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    
    // Add quiz temp
    public void addQuiz(String question_id, String type, String content, String description, String[] isCorrectList, String[] contents){ 
        String query = "INSERT INTO Quiz (Question_id, type, content, description)\n" +
                        "VALUES\n" +
                        "    (?, ?, ?, ?)";
         try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, question_id);
            ps.setString(2, type);
            ps.setString(3, content);
            if(description.equals("null")){
                ps.setNull(4, java.sql.Types.NVARCHAR);
            }else{
               ps.setString(4, description); 
            }
             System.out.println("hello");
            ps.execute();
            
           
                rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    int quizId = rs.getInt(1); // Lấy giá trị quiz_id vừa được tạo
                    // Tạo DAO cho bảng Answer và sử dụng quizId
                    AnswerDAO answerDAO = new AnswerDAO();
                    System.out.println("Giá trị tự động tạo (ID): " + quizId);
                    for (int i = 0; i < contents.length; i++) {
                        if(isCorrectList[i].equals("correct")){
                            answerDAO.addAnswer(quizId, "1", contents[i]);
                        }else{
                            answerDAO.addAnswer(quizId, "0", contents[i]);
                        }
                    }
                }
            
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    // Get  Quiz by ID
    public Quiz getQuizByID(String quiz_id) {
        String query = "SELECT * FROM Quiz WHERE Quiz_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, quiz_id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Quiz(
                        rs.getInt(1), // Quiz_id
                        rs.getInt(2), // question_id
                        rs.getInt(3), // Type
                        rs.getString(4),//Content
                        rs.getString(5) //Description
                );
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }
    
    // Edit quiz
    public void editQuiz(String quiz_id, String type, String content, String description, String[] isCorrectList, String[] contents){ 
        String query = "UPDATE [Quiz]\n" +
                        "SET [type] = ?,\n" +
                        "    [content] = ?,\n" +
                        "    [description] = ?\n" +
                        "WHERE [quiz_id] = ?;";
         try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, type);
            ps.setString(2, content);
            if(description.equals("null")){
                ps.setNull(3, java.sql.Types.NVARCHAR);
            }else{
               ps.setString(3, description); 
            }
            ps.setString(4, quiz_id);
            ps.executeUpdate(); // no result ==> no need result set
            
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
}

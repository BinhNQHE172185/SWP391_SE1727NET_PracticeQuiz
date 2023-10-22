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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public List<Question> searchQuestionsBySubjectId(int subjectId, String searchQuery, int offSet, int noOfRecords) {
        String sql = "SELECT * FROM Question WHERE Subject_id = ? AND title LIKE ? ORDER BY Question_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<Question> questions = new ArrayList<>();

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, subjectId);
            statement.setString(2, "%" + searchQuery + "%");
            statement.setInt(3, offSet);
            statement.setInt(4, noOfRecords);
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

    public int getNumberOfRecordsBySubjectIdAndSearch(int subjectId, String searchQuery) {
        String sql = "SELECT COUNT(*) AS count FROM Question WHERE Subject_id = ? AND title LIKE ?";
        int count = 0;

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, subjectId);
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

    public int getNumberOfRecordBySubjectIDAndExpertID(int ExpertID, int SubjectID){
        String sql = "SELECT \n"
                + "  COUNT(*) as count\n"
                + "FROM \n"
                + "  Expert e\n"
                + "  JOIN Question q ON q.Expert_id = e.Expert_id\n"
                + "  JOIN Subject s ON q.Subject_id = s.Subject_id\n"
                + "WHERE \n"
                + "  (e.Expert_id = ?) and (s.Subject_id=?) ";
        int count = 0;
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, ExpertID);
            statement.setInt(2, SubjectID);
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

    public void addQuestion(int SubjectID, int ExpertID, int requirement, String title, String image, String decs, Time time) {
        LocalDateTime currentTime = LocalDateTime.now();
        Date creDate = Date.valueOf(currentTime.toLocalDate());
        String sql = "INSERT INTO [dbo].[Question]\n"
                + "           ([Subject_id]\n"
                + "           ,[Expert_id]\n"
                + "           ,[title]\n"
                + "           ,[imageURL]\n"
                + "           ,[requirement]\n"
                + "           ,[description]\n"
                + "           ,[createdDate]\n"
                + "           ,[status]\n"
                + "           ,[duration])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,'True'\n"
                + "           ,?)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, SubjectID);
            ps.setInt(2, ExpertID);
            ps.setString(3, title);
            ps.setString(4, image);
            ps.setInt(5, requirement);
            ps.setString(6, decs);
            ps.setDate(7, creDate);
            ps.setTime(8, time);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        // Assuming you have an instance of your DAO class
        QuestionDAO yourDAO = new QuestionDAO();

        // Assuming you have a subjectId to test
        int subjectId = 1;

        // Call the method to get the number of records for the subject
        List<Question> questions = yourDAO.searchQuestionsBySubjectId(subjectId, "gex", 0, 5);

        // Print the result
        for (Question question : questions) {
            System.out.println(question.getQuestionId());
        }
    }
}

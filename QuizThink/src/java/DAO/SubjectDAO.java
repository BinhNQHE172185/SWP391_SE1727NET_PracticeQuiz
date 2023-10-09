/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAL.DBContext;
import Model.Subject;
import Model.SubjectStatus;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.*;

/**
 *
 * @author kimdi
 */
public class SubjectDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    private List<Subject> list;
    private List<SubjectStatus> listss;

    public List<Subject> getAllSubjects() {
        List<Subject> listSubject = new ArrayList<>();
        try {
            String query = "SELECT * FROM Subject";
            ps = getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int subjectId = rs.getInt("Subject_id");
                int expertId = rs.getInt("Expert_id");
                int subjectDimensionId = rs.getInt("SubjectDimension_id");
                String title = rs.getString("title");
                String imageURL = rs.getString("imageURL");
                int questionCount = rs.getInt("question_count");
                int rate = rs.getInt("Rate");
                int rateCount = rs.getInt("Rate_count");
                int level = rs.getInt("level");
                float requirement = rs.getFloat("requirement");
                String description = rs.getString("description");
                Date createdDate = rs.getDate("createdDate");
                Date modifyDate = rs.getDate("modifyDate");
                boolean status = rs.getBoolean("status");
                Time duration = rs.getTime("duration");

                listSubject.add(new Subject(subjectId, expertId, subjectDimensionId, title, imageURL, questionCount, rate, rateCount, level, requirement, description, createdDate, modifyDate, status, duration));
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return listSubject;
    }

    public Subject getSubjectById(int subjectId) {
        String sql = "SELECT * FROM Subject WHERE subject_Id = ?";
        Subject subject = null;

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, subjectId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int expertId = resultSet.getInt("Expert_id");
                int subjectDimensionId = resultSet.getInt("SubjectDimension_id");
                String title = resultSet.getString("title");
                String imageURL = resultSet.getString("imageURL");
                int questionCount = resultSet.getInt("question_count");
                int rate = resultSet.getInt("rate");
                int rateCount = resultSet.getInt("rate_count");
                int level = resultSet.getInt("level");
                float requirement = resultSet.getFloat("requirement");
                String description = resultSet.getString("description");
                Date createdDate = resultSet.getDate("createdDate");
                Date modifyDate = resultSet.getDate("modifyDate");
                boolean status = resultSet.getBoolean("status");
                Time duration = resultSet.getTime("duration");

                subject = new Subject(subjectId, expertId, subjectDimensionId, title, imageURL, questionCount, rate, rateCount, level, requirement, description, createdDate, modifyDate, status, duration);
            }
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }

        return subject;
    }

    public List<Subject> getRegistedSubject(int accountID) {
        List<Subject> listSubject = new ArrayList<>();
        try {
            String query = "  select * from Subject, SubjectStatus where (Subject.Subject_id = SubjectStatus.Subject_id) and Account_id = ?";
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int subjectId = rs.getInt("Subject_id");
                int expertId = rs.getInt("Expert_id");
                int subjectDimensionId = rs.getInt("SubjectDimension_id");
                String title = rs.getString("title");
                String imageURL = rs.getString("imageURL");
                int questionCount = rs.getInt("question_count");
                int rate = rs.getInt("Rate");
                int rateCount = rs.getInt("Rate_count");
                int level = rs.getInt("level");
                float requirement = rs.getFloat("requirement");
                String description = rs.getString("description");
                Date createdDate = rs.getDate("createdDate");
                Date modifyDate = rs.getDate("modifyDate");
                boolean status = rs.getBoolean("status");
                Time duration = rs.getTime("duration");

                listSubject.add(new Subject(subjectId, expertId, subjectDimensionId, title, imageURL, questionCount, rate, rateCount, level, requirement, description, createdDate, modifyDate, status, duration));
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return listSubject;
    }

    public List<Subject> getSubjectByName(String titl) {
        List<Subject> listSubject = new ArrayList<>();
        try {
            String query = "SELECT * FROM Subject WHERE title like ?";
            ps = getConnection().prepareStatement(query);
            ps.setString(1, titl);
            rs = ps.executeQuery();
            while (rs.next()) {
                int subjectId = rs.getInt("Subject_id");
                int expertId = rs.getInt("Expert_id");
                int subjectDimensionId = rs.getInt("SubjectDimension_id");
                String title = rs.getString("title");
                String imageURL = rs.getString("imageURL");
                int questionCount = rs.getInt("question_count");
                int rate = rs.getInt("Rate");
                int rateCount = rs.getInt("Rate_count");
                int level = rs.getInt("level");
                float requirement = rs.getFloat("requirement");
                String description = rs.getString("description");
                Date createdDate = rs.getDate("createdDate");
                Date modifyDate = rs.getDate("modifyDate");
                boolean status = rs.getBoolean("status");
                Time duration = rs.getTime("duration");

                listSubject.add(new Subject(subjectId, expertId, subjectDimensionId, title, imageURL, questionCount, rate, rateCount, level, requirement, description, createdDate, modifyDate, status, duration));
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return listSubject;
    }

    public List<Subject> getRegistedSubjectByName(int id, String titl) {
        List<Subject> listSubject = new ArrayList<>();
        try {
            String query = "select * from Subject, SubjectStatus where (Subject.Subject_id = SubjectStatus.Subject_id) and Account_id = ? and title like ?";
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, "%" + titl + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                int subjectId = rs.getInt("Subject_id");
                int expertId = rs.getInt("Expert_id");
                int subjectDimensionId = rs.getInt("SubjectDimension_id");
                String title = rs.getString("title");
                String imageURL = rs.getString("imageURL");
                int questionCount = rs.getInt("question_count");
                int rate = rs.getInt("Rate");
                int rateCount = rs.getInt("Rate_count");
                int level = rs.getInt("level");
                float requirement = rs.getFloat("requirement");
                String description = rs.getString("description");
                Date createdDate = rs.getDate("createdDate");
                Date modifyDate = rs.getDate("modifyDate");
                boolean status = rs.getBoolean("status");
                Time duration = rs.getTime("duration");

                listSubject.add(new Subject(subjectId, expertId, subjectDimensionId, title, imageURL, questionCount, rate, rateCount, level, requirement, description, createdDate, modifyDate, status, duration));
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return listSubject;
    }

    public void cancelRegistedSubject(int accID, int subjectID) {

        String query = "  delete from SubjectStatus where Account_id = ? and Subject_id = ? ";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, accID);
            ps.setInt(2, subjectID);
            rs = ps.executeQuery();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public int getNumOfSubject() {
        String query = "select COUNT(*) from Subject";
        try {
            ps = ps = getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        SubjectDAO dao = new SubjectDAO();
        List<Subject> list = dao.getRegistedSubjectByName(2, "a");
        for (Subject s : list) {
            System.out.println(s.getTitle());
        }
    }
}

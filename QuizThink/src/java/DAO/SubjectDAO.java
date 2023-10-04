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
    
    public List<Subject> getAllSubjects(){
        try{
            String query = "SELECT * FROM Subject";
            ps = getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Subject subject= new Subject(rs.getInt("subjectId"),
                        rs.getInt("expertId"),
                        rs.getInt("subjectDimensionId"),
                        rs.getString("title"),
                        rs.getString("imageURL"),
                        rs.getInt("questionCount"),
                        rs.getInt("rate"),
                        rs.getInt("rateCount"),
                        rs.getInt("level"),
                        rs.getFloat("requirement"),
                        rs.getString("description"),
                        rs.getDate("createdDate"),
                        rs.getDate("modifyDate"),
                        rs.getBoolean("status"),
                        rs.getTime("duration"));
                list.add(subject);
            }
        }catch(Exception e){
            
        }
        return list;
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
    
    public List<SubjectStatus> getRegistedSubject(int accountID) {
        try {
            String query = "Select * from SubjectStatus where account_id = ?";
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while(rs.next()){
                SubjectStatus subjectStatus= new SubjectStatus
                        (rs.getInt("subjectStatusID"),
                        rs.getInt("subjectId"),
                        rs.getInt("accountId"),
                        rs.getBoolean("status"),
                        rs.getDate("createdDate"),
                        rs.getDate("modifyDate"),
                        rs.getDate("passDate"));
                listss.add(subjectStatus);
            }
        } catch (Exception e) {

        }
        return null;
    }
}

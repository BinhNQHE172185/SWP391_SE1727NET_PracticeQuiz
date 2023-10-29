/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAL.DBContext;
import Model.SubjectStatus;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kimdi
 */
public class SubjectStatusDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public int getSubjectStatusId(int subjectId, int accountId) {
        int subjectStatusId = -1;
        try {
            String query = "SELECT SubjectStatus_id FROM SubjectStatus WHERE Subject_id = ? AND Account_id = ?";
            PreparedStatement ps = getConnection().prepareStatement(query);
            ps.setInt(1, subjectId);
            ps.setInt(2, accountId);
            ResultSet rs = ps.executeQuery();

            // Check if a record exists and retrieve the SubjectStatus_id
            if (rs.next()) {
                subjectStatusId = rs.getInt("SubjectStatus_id");
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return subjectStatusId;
    }

    public int addSubjectStatus(SubjectStatus subjectStatus) {
        int subjectStatusId = 0;
        try {
            String query = "INSERT INTO SubjectStatus (Subject_id, Account_id, status, createdDate, modifyDate) VALUES (?, ?, ?, ?, ?)";
            ps = getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, subjectStatus.getSubjectId());
            ps.setInt(2, subjectStatus.getAccountId());
            ps.setBoolean(3, subjectStatus.isStatus());
            ps.setObject(4, subjectStatus.getCreatedDate());
            ps.setObject(5, subjectStatus.getModifyDate());
            ps.executeUpdate();

            // Retrieve the generated SubjectStatus_id
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                subjectStatusId = rs.getInt(1);
                subjectStatus.setSubjectStatusId(subjectStatusId);
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return subjectStatusId;
    }

    public List<SubjectStatus> getStudentListExpert(int subjectId) {
        List<SubjectStatus> ss = new ArrayList<>();
        int ssId;
        boolean status;
        Date createdDate;
        int AccountId;
        String sql = "select * from SubjectStatus s, Account a \n"
                + "where s.Subject_id = ? and s.Account_id = a.Account_id";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, subjectId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ssId = rs.getInt("SubjectStatus_id");
                status = rs.getBoolean("status");
                createdDate = rs.getDate("createdDate");
                AccountId = rs.getInt("Account_id");
                ss.add(new SubjectStatus(ssId, subjectId, AccountId, status, createdDate));
            }
            ps.close();
            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(SubjectStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ss;
    }
}

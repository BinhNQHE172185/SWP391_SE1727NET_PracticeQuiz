/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAL.DBContext;
import Model.SubjectDimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class SubjectDimensionDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public List<SubjectDimension> getAllSubjectDimension() {
        List<SubjectDimension> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM SubjectDimension";
            ps = getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int subjectDimensionId = rs.getInt("SubjectDimension_id");
                int ParentSD_id = rs.getInt("ParentSD_id");
                String title = rs.getString("title");
                String imageURL = rs.getString("imageURL");
                String description = rs.getString("description");

                list.add(new SubjectDimension(subjectDimensionId, ParentSD_id, title, imageURL, description));
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public SubjectDimension getSubjectDimensionByID(int id) {
        String query = "select * from SubjectDimension where SubjectDimension_id = ?";
        SubjectDimension subjectDimension = null;
        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int subjectDimensionId = resultSet.getInt("SubjectDimension_id");
                int ParentSD_id = resultSet.getInt("ParentSD_id");
                String title = resultSet.getString("title");
                String imageURL = resultSet.getString("imageURL");
                String description = resultSet.getString("description");

                subjectDimension = new SubjectDimension(subjectDimensionId, ParentSD_id, title, imageURL, description);
            }
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }
        return subjectDimension;
    }

    public SubjectDimension getParentSubjectDimension(int parentSDId) {
        String query = "SELECT * FROM SubjectDimension WHERE SubjectDimension_id = (SELECT ParentSD_id FROM SubjectDimension WHERE SubjectDimension_id = ?)";
        SubjectDimension parentSubjectDimension = null;

        try (
                 PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setInt(1, parentSDId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int subjectDimensionId = resultSet.getInt("SubjectDimension_id");
                parentSDId = resultSet.getInt("ParentSD_id");
                String title = resultSet.getString("title");
                String imageURL = resultSet.getString("imageURL");
                String description = resultSet.getString("description");

                parentSubjectDimension = new SubjectDimension(subjectDimensionId, parentSDId, title, imageURL, description);
            }
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }
        return parentSubjectDimension;
    }

}

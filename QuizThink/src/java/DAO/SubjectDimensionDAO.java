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
import java.sql.Statement;
import java.sql.Types;
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
    public SubjectDimension getSubjectDimensionBySubject(int id) {
    String query = "SELECT SubjectDimension.* " +
                   "FROM Subject " +
                   "INNER JOIN SubjectDimension ON Subject.SubjectDimension_id = SubjectDimension.SubjectDimension_id " +
                   "WHERE Subject.Subject_id = ?";
    SubjectDimension subjectDimension = null;

    try {
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int subjectDimensionId = resultSet.getInt("SubjectDimension_id");
            int parentSDId = resultSet.getInt("ParentSD_id");
            String title = resultSet.getString("title");
            String imageURL = resultSet.getString("imageURL");
            String description = resultSet.getString("description");

            subjectDimension = new SubjectDimension(subjectDimensionId, parentSDId, title, imageURL, description);
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

    public List<SubjectDimension> getAllParentSubjectDimensions(int offSet, int noOfRecords) {
        List<SubjectDimension> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM SubjectDimension WHERE ParentSD_id IS NULL ORDER BY SubjectDimension_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1, offSet);
            statement.setInt(2, noOfRecords);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int subjectDimensionId = resultSet.getInt("SubjectDimension_id");
                int parentSDId = resultSet.getInt("ParentSD_id");
                String title = resultSet.getString("title");
                String imageURL = resultSet.getString("imageURL");
                String description = resultSet.getString("description");

                list.add(new SubjectDimension(subjectDimensionId, parentSDId, title, imageURL, description));
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public List<SubjectDimension> getAllParentSubjectDimensionsAsc(int offSet, int noOfRecords) {
        List<SubjectDimension> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM SubjectDimension WHERE ParentSD_id IS NULL ORDER BY title ASC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1, offSet);
            statement.setInt(2, noOfRecords);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int subjectDimensionId = resultSet.getInt("SubjectDimension_id");
                int parentSDId = resultSet.getInt("ParentSD_id");
                String title = resultSet.getString("title");
                String imageURL = resultSet.getString("imageURL");
                String description = resultSet.getString("description");

                list.add(new SubjectDimension(subjectDimensionId, parentSDId, title, imageURL, description));
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public List<SubjectDimension> getAllParentSubjectDimensionsDesc(int offSet, int noOfRecords) {
        List<SubjectDimension> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM SubjectDimension WHERE ParentSD_id IS NULL ORDER BY title DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1, offSet);
            statement.setInt(2, noOfRecords);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int subjectDimensionId = resultSet.getInt("SubjectDimension_id");
                int parentSDId = resultSet.getInt("ParentSD_id");
                String title = resultSet.getString("title");
                String imageURL = resultSet.getString("imageURL");
                String description = resultSet.getString("description");

                list.add(new SubjectDimension(subjectDimensionId, parentSDId, title, imageURL, description));
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public List<SubjectDimension> getChildSubjectDimensions(int parentId, int offSet, int noOfRecords) {
        List<SubjectDimension> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM SubjectDimension WHERE ParentSD_id = ? ORDER BY SubjectDimension_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1, parentId);
            statement.setInt(2, offSet);
            statement.setInt(3, noOfRecords);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int subjectDimensionId = resultSet.getInt("SubjectDimension_id");
                int parentSDId = resultSet.getInt("ParentSD_id");
                String title = resultSet.getString("title");
                String imageURL = resultSet.getString("imageURL");
                String description = resultSet.getString("description");

                list.add(new SubjectDimension(subjectDimensionId, parentSDId, title, imageURL, description));
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public List<SubjectDimension> getAllChildSubjectDimensions(int parentId) {
        List<SubjectDimension> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM SubjectDimension WHERE ParentSD_id = ?";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1, parentId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int subjectDimensionId = resultSet.getInt("SubjectDimension_id");
                int parentSDId = resultSet.getInt("ParentSD_id");
                String title = resultSet.getString("title");
                String imageURL = resultSet.getString("imageURL");
                String description = resultSet.getString("description");

                list.add(new SubjectDimension(subjectDimensionId, parentSDId, title, imageURL, description));
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public List<SubjectDimension> getChildSubjectDimensionsAsc(int parentId, int offSet, int noOfRecords) {
        List<SubjectDimension> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM SubjectDimension WHERE ParentSD_id = ? ORDER BY title ASC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1, parentId);
            statement.setInt(2, offSet);
            statement.setInt(3, noOfRecords);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int subjectDimensionId = resultSet.getInt("SubjectDimension_id");
                int parentSDId = resultSet.getInt("ParentSD_id");
                String title = resultSet.getString("title");
                String imageURL = resultSet.getString("imageURL");
                String description = resultSet.getString("description");

                list.add(new SubjectDimension(subjectDimensionId, parentSDId, title, imageURL, description));
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public List<SubjectDimension> getChildSubjectDimensionsDesc(int parentId, int offSet, int noOfRecords) {
        List<SubjectDimension> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM SubjectDimension WHERE ParentSD_id = ? ORDER BY title DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1, parentId);
            statement.setInt(2, offSet);
            statement.setInt(3, noOfRecords);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int subjectDimensionId = resultSet.getInt("SubjectDimension_id");
                int parentSDId = resultSet.getInt("ParentSD_id");
                String title = resultSet.getString("title");
                String imageURL = resultSet.getString("imageURL");
                String description = resultSet.getString("description");

                list.add(new SubjectDimension(subjectDimensionId, parentSDId, title, imageURL, description));
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public int getNumberOfRecordsParentSD() {
        String query = "SELECT COUNT(*) AS count FROM SubjectDimension WHERE ParentSD_id IS NULL";
        int count = 0;

        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }

        return count;
    }

    public int getNumberOfRecordsChildSD(int parentId) {
        String query = "SELECT COUNT(*) AS count FROM SubjectDimension WHERE ParentSD_id = ?";
        int count = 0;

        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1, parentId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }

        return count;
    }

    public List<SubjectDimension> searchSubjectDimensionsByTitle(String title, int offSet, int noOfRecords) {
        List<SubjectDimension> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM SubjectDimension WHERE title LIKE ? ORDER BY SubjectDimension_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setString(1, "%" + title + "%");
            statement.setInt(2, offSet);
            statement.setInt(3, noOfRecords);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int subjectDimensionId = resultSet.getInt("SubjectDimension_id");
                int parentSDId = resultSet.getInt("ParentSD_id");
                String dimensionTitle = resultSet.getString("title");
                String imageURL = resultSet.getString("imageURL");
                String description = resultSet.getString("description");

                list.add(new SubjectDimension(subjectDimensionId, parentSDId, dimensionTitle, imageURL, description));
            }

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }

        return list;
    }

    public int getNumberOfRecordsByTitle(String title) {
        String query = "SELECT COUNT(*) AS count FROM SubjectDimension WHERE title LIKE ?";
        int count = 0;

        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setString(1, "%" + title + "%");
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }

        return count;
    }

    public boolean addSubjectDimension(SubjectDimension subjectDimension) {
        try {
            String query = "INSERT INTO SubjectDimension (ParentSD_id, title, imageURL, description) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            Integer parentSDId = subjectDimension.getParentSDId();
            if (parentSDId != null) {
                statement.setInt(1, parentSDId);
            } else {
                statement.setNull(1, Types.INTEGER);
            }

            statement.setString(2, subjectDimension.getTitle());
            statement.setString(3, subjectDimension.getImageURL());
            statement.setString(4, subjectDimension.getDescription());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                subjectDimension.setSubjectDimensionId(generatedId);
            }

            generatedKeys.close();
            statement.close();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateSubjectDimension(SubjectDimension subjectDimension) {
        try {
            String query = "UPDATE SubjectDimension SET ParentSD_id = ?, title = ?, imageURL = ?, description = ? WHERE SubjectDimension_id = ?";
            PreparedStatement statement = getConnection().prepareStatement(query);
            Integer parentSDId = subjectDimension.getParentSDId();
            if (parentSDId != null) {
                statement.setInt(1, parentSDId);
            } else {
                statement.setNull(1, Types.INTEGER);
            }
            statement.setString(2, subjectDimension.getTitle());
            statement.setString(3, subjectDimension.getImageURL());
            statement.setString(4, subjectDimension.getDescription());
            statement.setInt(5, subjectDimension.getSubjectDimensionId());
            int rowsAffected = statement.executeUpdate();

            statement.close();

            return rowsAffected > 0;
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteSubjectDimension(int subjectDimensionId) {
        try {
            String query = "DELETE FROM SubjectDimension WHERE SubjectDimension_id = ?";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1, subjectDimensionId);
            int rowsAffected = statement.executeUpdate();

            statement.close();

            return rowsAffected > 0;
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAL.DBContext;
import Model.RegisteredSubject;
import Model.Subject;
import Model.SubjectStatus;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDateTime;
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
                float requirement = rs.getFloat("requirement");
                String description = rs.getString("description");
                Date createdDate = rs.getDate("createdDate");
                Date modifyDate = rs.getDate("modifyDate");
                boolean status = rs.getBoolean("status");

                listSubject.add(new Subject(subjectId, expertId, subjectDimensionId, title, imageURL, requirement, description, createdDate, modifyDate, status));
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return listSubject;
    }

    public int getNumberOfRecordsBySubjectTitle(String searchQuery) {
        String sql = "SELECT COUNT(*) AS count FROM Subject WHERE title LIKE ?";
        int count = 0;

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, "%" + searchQuery + "%");
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

    public List<Subject> getRecentSubject() {
        List<Subject> listSubject = new ArrayList<>();
        try {
            String query = "SELECT *\n"
                    + "FROM Subject\n"
                    + "ORDER BY createdDate DESC;";
            ps = getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int subjectId = rs.getInt("Subject_id");
                int expertId = rs.getInt("Expert_id");
                int subjectDimensionId = rs.getInt("SubjectDimension_id");
                String title = rs.getString("title");
                String imageURL = rs.getString("imageURL");
                float requirement = rs.getFloat("requirement");
                String description = rs.getString("description");
                Date createdDate = rs.getDate("createdDate");
                Date modifyDate = rs.getDate("modifyDate");
                boolean status = rs.getBoolean("status");

                listSubject.add(new Subject(subjectId, expertId, subjectDimensionId, title, imageURL, requirement, description, createdDate, modifyDate, status));
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
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                subjectId = rs.getInt("Subject_id");
                int expertId = rs.getInt("Expert_id");
                int subjectDimensionId = rs.getInt("SubjectDimension_id");
                String title = rs.getString("title");
                String imageURL = rs.getString("imageURL");
                float requirement = rs.getFloat("requirement");
                String description = rs.getString("description");
                Date createdDate = rs.getDate("createdDate");
                Date modifyDate = rs.getDate("modifyDate");
                boolean status = rs.getBoolean("status");

                subject = new Subject(subjectId, expertId, subjectDimensionId, title, imageURL, requirement, description, createdDate, modifyDate, status);
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
                float requirement = rs.getFloat("requirement");
                String description = rs.getString("description");
                Date createdDate = rs.getDate("createdDate");
                Date modifyDate = rs.getDate("modifyDate");
                boolean status = rs.getBoolean("status");

                listSubject.add(new Subject(subjectId, expertId, subjectDimensionId, title, imageURL, requirement, description, createdDate, modifyDate, status));
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
                float requirement = rs.getFloat("requirement");
                String description = rs.getString("description");
                Date createdDate = rs.getDate("createdDate");
                Date modifyDate = rs.getDate("modifyDate");
                boolean status = rs.getBoolean("status");

                listSubject.add(new Subject(subjectId, expertId, subjectDimensionId, title, imageURL, requirement, description, createdDate, modifyDate, status));
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
                float requirement = rs.getFloat("requirement");
                String description = rs.getString("description");
                Date createdDate = rs.getDate("createdDate");
                Date modifyDate = rs.getDate("modifyDate");
                boolean status = rs.getBoolean("status");

                listSubject.add(new Subject(subjectId, expertId, subjectDimensionId, title, imageURL, requirement, description, createdDate, modifyDate, status));
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

    public void ApproveSubject(String subjectId) {
        String query = "UPDATE [Subject]\n"
                + "SET [status] = 1\n"
                + "WHERE [Subject_id] = ?;";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, subjectId);
            ps.executeUpdate(); // no result ==> no need result set
        } catch (Exception e) {
            // Handle exceptions here
        }
    }

    public void denySubjects(String subjectId) {
        String query = "UPDATE [Subject]\n"
                + "SET [status] = 0\n"
                + "WHERE [Subject_id] = ?;";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, subjectId);
            ps.executeUpdate(); // no result ==> no need result set
        } catch (Exception e) {
            // Handle exceptions here
        }
    }

    public List<Subject> getNotApproveSubjects() {
        List<Subject> list = new ArrayList<>();
        try {
            String query = "select * from Subject where status IS NULL";
            ps = getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int subjectId = rs.getInt("Subject_id");
                int expertId = rs.getInt("Expert_id");
                int subjectDimensionId = rs.getInt("SubjectDimension_id");
                String title = rs.getString("title");
                String imageURL = rs.getString("imageURL");
                float requirement = rs.getFloat("requirement");
                String description = rs.getString("description");
                Date createdDate = rs.getDate("createdDate");
                Date modifyDate = rs.getDate("modifyDate");
                boolean status = rs.getBoolean("status");

                list.add(new Subject(subjectId, expertId, subjectDimensionId, title, imageURL, requirement, description, createdDate, modifyDate, status));
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
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

    public List<Subject> getAllSubjects(int offSet, int noOfRecords) {
        List<Subject> listSubject = new ArrayList<>();
        try {
            // Use a SQL query with OFFSET and FETCH NEXT clauses to implement pagination
            String query = "SELECT * FROM Subject ORDER BY Subject_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, offSet);
            ps.setInt(2, noOfRecords);
            rs = ps.executeQuery();

            while (rs.next()) {
                int subjectId = rs.getInt("Subject_id");
                int expertId = rs.getInt("Expert_id");
                int subjectDimensionId = rs.getInt("SubjectDimension_id");
                String title = rs.getString("title");
                String imageURL = rs.getString("imageURL");
                float requirement = rs.getFloat("requirement");
                String description = rs.getString("description");
                Date createdDate = rs.getDate("createdDate");
                Date modifyDate = rs.getDate("modifyDate");
                boolean status = rs.getBoolean("status");

                listSubject.add(new Subject(subjectId, expertId, subjectDimensionId, title, imageURL, requirement, description, createdDate, modifyDate, status));
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return listSubject;
    }

    public List<Subject> getSubjectsBySubjectDimensionId(int subjectDimensionId, int offSet, int noOfRecords) {
        List<Subject> listSubject = new ArrayList<>();
        try {
            // Use a SQL query with OFFSET and FETCH NEXT clauses to implement pagination
            String query = "SELECT * FROM Subject WHERE SubjectDimension_id = ? ORDER BY Subject_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            PreparedStatement ps = getConnection().prepareStatement(query);
            ps.setInt(1, subjectDimensionId);
            ps.setInt(2, offSet);
            ps.setInt(3, noOfRecords);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int subjectId = rs.getInt("Subject_id");
                int expertId = rs.getInt("Expert_id");
                String title = rs.getString("title");
                String imageURL = rs.getString("imageURL");
                float requirement = rs.getFloat("requirement");
                String description = rs.getString("description");
                Date createdDate = rs.getDate("createdDate");
                Date modifyDate = rs.getDate("modifyDate");
                boolean status = rs.getBoolean("status");

                listSubject.add(new Subject(subjectId, expertId, subjectDimensionId, title, imageURL, requirement, description, createdDate, modifyDate, status));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return listSubject;
    }

    public List<Subject> searchSubjects(String keyword, int offSet, int noOfRecords) {
        List<Subject> searchResults = new ArrayList<>();
        try {
            // Use a SQL query to search for subjects by keyword
            String query = "SELECT * FROM Subject WHERE title LIKE ? "
                    + "ORDER BY Subject_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            ps = getConnection().prepareStatement(query);
            // Set the keyword with wildcards for a broad search
            ps.setString(1, "%" + keyword + "%");
            ps.setInt(2, offSet);
            ps.setInt(3, noOfRecords);
            rs = ps.executeQuery();

            while (rs.next()) {
                int subjectId = rs.getInt("Subject_id");
                int expertId = rs.getInt("Expert_id");
                int subjectDimensionId = rs.getInt("SubjectDimension_id");
                String title = rs.getString("title");
                String imageURL = rs.getString("imageURL");
                float requirement = rs.getFloat("requirement");
                String description = rs.getString("description");
                Date createdDate = rs.getDate("createdDate");
                Date modifyDate = rs.getDate("modifyDate");
                boolean status = rs.getBoolean("status");

                searchResults.add(new Subject(subjectId, expertId, subjectDimensionId, title, imageURL, requirement, description, createdDate, modifyDate, status));
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return searchResults;
    }

    public int getNumberOfRecords() {
        String sql = "SELECT COUNT(*) AS count FROM Subject";
        int count = 0;

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
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
    public int getNumberOfRecordsBySubjectDimensionId(int subjectDimensionId) {
    String sql = "SELECT COUNT(*) AS count FROM Subject WHERE SubjectDimension_id = ?";
    int count = 0;

    try {
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, subjectDimensionId);
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

    public void addExpertSubject(int expertID, int subjectDimensionID, String title, String imageURL, String description, Date createdDate, Date modifyDate) {
        try {
            String query = "  insert into Subject(Expert_id, SubjectDimension_id, title, imageURL, [description], createdDate, modifyDate, [status])\n"
                    + "  values (?, ?, ?, ?, ?, ?, ?, NULL)";
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, expertID);
            ps.setInt(2, subjectDimensionID);
            ps.setString(3, title);
            ps.setString(4, imageURL);
            ps.setString(5, description);
            ps.setDate(6, createdDate);
            ps.setDate(7, modifyDate);
            ps.executeQuery();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateExpertSubject(String title, String imageURL, float requirement, String description, Date modifyDate, int subjectID) {

        String query = "UPDATE Subject \n"
                + "SET title = ?, \n"
                + "    imageURL = ?,\n"
                + "    requirement = ?,\n"
                + "    [description] = ?,\n"
                + "    modifyDate = ?\n"
                + "WHERE Subject_id = ?;";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, imageURL);
            ps.setFloat(3, requirement);
            ps.setString(4, description);
            ps.setDate(5, modifyDate);
            ps.setInt(6, subjectID);
            rs = ps.executeQuery();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Subject> searchSubjectByExpert(int id, String titl) {
        List<Subject> listSubject = new ArrayList<>();
        try {
            String query = "select * from Subject where Expert_id = ? and title like ? and status = 1";
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
                float requirement = rs.getFloat("requirement");
                String description = rs.getString("description");
                Date createdDate = rs.getDate("createdDate");
                Date modifyDate = rs.getDate("modifyDate");
                boolean status = rs.getBoolean("status");

                listSubject.add(new Subject(subjectId, expertId, subjectDimensionId, title, imageURL, requirement, description, createdDate, modifyDate, status));
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return listSubject;
    }

    public List<Subject> getSubjectByExpert(int expertID) {
        List<Subject> listSubject = new ArrayList<>();
        try {
            String query = " select * from Subject where Expert_id = ?";
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, expertID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int subjectId = rs.getInt("Subject_id");
                int expertId = rs.getInt("Expert_id");
                int subjectDimensionId = rs.getInt("SubjectDimension_id");
                String title = rs.getString("title");
                String imageURL = rs.getString("imageURL");
                float requirement = rs.getFloat("requirement");
                String description = rs.getString("description");
                Date createdDate = rs.getDate("createdDate");
                Date modifyDate = rs.getDate("modifyDate");
                boolean status = rs.getBoolean("status");

                listSubject.add(new Subject(subjectId, expertId, subjectDimensionId, title, imageURL, requirement, description, createdDate, modifyDate, status));
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return listSubject;
    }

    public void deleteExpertSubject(int expertID, int subjectID) {

        String query = "update Subject set status = 0 where Expert_id = ? and Subject_id = ? ";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, expertID);
            ps.setInt(2, subjectID);
            rs = ps.executeQuery();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public int getNumberOfRecordByExpertID(int ExpertID) {
        String sql = "select count(*) as count from Subject, Expert where (Subject.Expert_id = Expert.Expert_id)and Expert.Expert_id = ? AND (Subject.status IS NULL OR Subject.status != 'False')";
        int count = 0;
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, ExpertID);
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

    public int getNumberOfRecordByExpertIDandStatus(int ExpertID, boolean status) {
        int count = 0;
        String s = "";
        if (!status) {
            s = "NULL";
        }

        try {
            if (!status) {
                String sql = "select count(*) as count from Subject, Expert where (Subject.Expert_id = Expert.Expert_id)and Expert.Expert_id = ? AND (Subject.status is NULL)";
                PreparedStatement statement = getConnection().prepareStatement(sql);
                statement.setInt(1, ExpertID);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    count = resultSet.getInt("count");
                }
                resultSet.close();
                statement.close();
            } else {
                String sql = "select count(*) as count from Subject, Expert where (Subject.Expert_id = Expert.Expert_id)and Expert.Expert_id = ? AND (Subject.status = ?)";
                PreparedStatement statement = getConnection().prepareStatement(sql);
                statement.setInt(1, ExpertID);
                statement.setBoolean(2, status);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    count = resultSet.getInt("count");
                }
                resultSet.close();
                statement.close();
            }

        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }

        return count;
    }

    public List<Subject> getSubjectByExpertPaging(int expertID, int offSet, int noOfRecords) {
        List<Subject> listSubject = new ArrayList<>();
        try {
            String query = "SELECT * FROM Subject WHERE Expert_id = ? AND (status IS NULL OR status != 'False') ORDER BY Subject_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, expertID);
            ps.setInt(2, offSet);
            ps.setInt(3, noOfRecords);
            rs = ps.executeQuery();
            while (rs.next()) {
                int subjectId = rs.getInt("Subject_id");
                int expertId = rs.getInt("Expert_id");
                int subjectDimensionId = rs.getInt("SubjectDimension_id");
                String title = rs.getString("title");
                String imageURL = rs.getString("imageURL");
                float requirement = rs.getFloat("requirement");
                String description = rs.getString("description");
                Date createdDate = rs.getDate("createdDate");
                Date modifyDate = rs.getDate("modifyDate");
                boolean status = rs.getBoolean("status");

                listSubject.add(new Subject(subjectId, expertId, subjectDimensionId, title, imageURL, requirement, description, createdDate, modifyDate, status));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return listSubject;
    }

    public List<Subject> getSubjectByExpertPagingByStatus(int expertID, int offSet, int noOfRecords, Boolean status) {
        List<Subject> listSubject = new ArrayList<>();
        if (!status) {
            String s = "NULL";
        }
        try {

            if (!status) {
                String query = "SELECT * FROM Subject WHERE status is NULL AND Expert_id = ? ORDER BY Subject_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                ps = getConnection().prepareStatement(query);
                ps.setInt(1, expertID);
                ps.setInt(2, offSet);
                ps.setInt(3, noOfRecords);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int subjectId = rs.getInt("Subject_id");
                    int expertId = rs.getInt("Expert_id");
                    int subjectDimensionId = rs.getInt("SubjectDimension_id");
                    String title = rs.getString("title");
                    String imageURL = rs.getString("imageURL");
                    float requirement = rs.getFloat("requirement");
                    String description = rs.getString("description");
                    Date createdDate = rs.getDate("createdDate");
                    Date modifyDate = rs.getDate("modifyDate");
                    listSubject.add(new Subject(subjectId, expertId, subjectDimensionId, title, imageURL, requirement, description, createdDate, modifyDate, status));
                }
            } else {
                String query = "SELECT * FROM Subject WHERE status = ? AND Expert_id = ? ORDER BY Subject_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                ps = getConnection().prepareStatement(query);
                ps.setBoolean(1, status);
                ps.setInt(2, expertID);
                ps.setInt(3, offSet);
                ps.setInt(4, noOfRecords);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int subjectId = rs.getInt("Subject_id");
                    int expertId = rs.getInt("Expert_id");
                    int subjectDimensionId = rs.getInt("SubjectDimension_id");
                    String title = rs.getString("title");
                    String imageURL = rs.getString("imageURL");
                    float requirement = rs.getFloat("requirement");
                    String description = rs.getString("description");
                    Date createdDate = rs.getDate("createdDate");
                    Date modifyDate = rs.getDate("modifyDate");
                    listSubject.add(new Subject(subjectId, expertId, subjectDimensionId, title, imageURL, requirement, description, createdDate, modifyDate, status));
                }
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return listSubject;
    }

    public List<RegisteredSubject> getRegisteredSubject(int id) {
        List<RegisteredSubject> listSubject = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "  s.Subject_id,\n"
                    + "  ss.Account_id,\n"
                    + "  s.title AS subjectTitle,\n"
                    + "  s.imageURL AS subjectImage, \n"
                    + "  s.description AS subjectDescription,\n"
                    + "  e.username AS expertUsername,\n"
                    + "  e.avatar AS expertImage,\n"
                    + "  sd.title AS subjectDimensionTitle,\n"
                    + "  COUNT(q.Question_id) AS questionCount\n"
                    + "FROM SubjectStatus ss\n"
                    + "INNER JOIN Subject s ON ss.Subject_id = s.Subject_id\n"
                    + "INNER JOIN Expert e ON s.Expert_id = e.Expert_id  \n"
                    + "INNER JOIN SubjectDimension sd ON s.SubjectDimension_id = sd.SubjectDimension_id\n"
                    + "LEFT JOIN Question q ON s.Subject_id = q.Subject_id\n"
                    + "WHERE ss.Account_id = ?\n"
                    + "GROUP BY\n"
                    + "  s.Subject_id,\n"
                    + "  ss.Account_id,\n"
                    + "  s.title,\n"
                    + "  s.imageURL,\n"
                    + "  s.description,\n"
                    + "  e.username,\n"
                    + "  sd.title,\n"
                    + "  e.avatar";
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int subjectID = rs.getInt(1);
                int accountID = rs.getInt(2);
                String subjectTitle = rs.getString(3);
                String image = rs.getString(4);
                String desc = rs.getString(5);
                String expert = rs.getString(6);
                String avatar = rs.getString(7);
                String dimension = rs.getString(8);
                int count = rs.getInt(9);

                listSubject.add(new RegisteredSubject(subjectID, accountID, subjectTitle, image, desc, expert, avatar, dimension, count));
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return listSubject;
    }

    public List<RegisteredSubject> searchRegisteredSubject(int id, String search) {
        List<RegisteredSubject> listSubject = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "  s.Subject_id,\n"
                    + "  ss.Account_id,\n"
                    + "  s.title AS subjectTitle,\n"
                    + "  s.imageURL AS subjectImage, \n"
                    + "  s.description AS subjectDescription,\n"
                    + "  e.username AS expertUsername,\n"
                    + "  e.avatar AS expertImage,\n"
                    + "  sd.title AS subjectDimensionTitle,\n"
                    + "  COUNT(q.Question_id) AS questionCount\n"
                    + "FROM SubjectStatus ss\n"
                    + "INNER JOIN Subject s ON ss.Subject_id = s.Subject_id\n"
                    + "INNER JOIN Expert e ON s.Expert_id = e.Expert_id  \n"
                    + "INNER JOIN SubjectDimension sd ON s.SubjectDimension_id = sd.SubjectDimension_id\n"
                    + "LEFT JOIN Question q ON s.Subject_id = q.Subject_id\n"
                    + "WHERE ss.Account_id = ? and s.title like ?\n"
                    + "GROUP BY\n"
                    + "  s.Subject_id,\n"
                    + "  ss.Account_id,\n"
                    + "  s.title,\n"
                    + "  s.imageURL,\n"
                    + "  s.description,\n"
                    + "  e.username,\n"
                    + "  sd.title,\n"
                    + "  e.avatar";
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, "%" + search + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                int subjectID = rs.getInt(1);
                int accountID = rs.getInt(2);
                String subjectTitle = rs.getString(3);
                String image = rs.getString(4);
                String desc = rs.getString(5);
                String expert = rs.getString(6);
                String avatar = rs.getString(7);
                String dimension = rs.getString(8);
                int count = rs.getInt(9);

                listSubject.add(new RegisteredSubject(subjectID, accountID, subjectTitle, image, desc, expert, avatar, dimension, count));
            }
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return listSubject;
    }
}

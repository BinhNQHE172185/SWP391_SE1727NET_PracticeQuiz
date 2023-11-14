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
                list.add(new Subject(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getFloat(10),
                        rs.getString(11),
                        rs.getDate(12),
                        rs.getDate(13),
                        rs.getBoolean(14),
                        rs.getTime(15)
                ));

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

                searchResults.add(new Subject(subjectId, expertId, subjectDimensionId, title, imageURL, questionCount, rate, rateCount, level, requirement, description, createdDate, modifyDate, status, duration));
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

    public static void main(String[] args) {
        // Create an instance of the class that contains the getRecentSubject function
        SubjectDAO dao = new SubjectDAO(); // Replace YourClassName with the actual name of your class

        // Call the getRecentSubject function to retrieve the list of recent subjects
        List<Subject> recentSubjects = dao.getRecentSubject(); // Replace YourClassName with the actual name of your class

        // Check if any subjects were retrieved
        if (recentSubjects.isEmpty()) {
            System.out.println("No recent subjects found.");
        } else {
            // Iterate through the list of recent subjects and print their details
            for (Subject subject : recentSubjects) {
                System.out.println("Subject ID: " + subject.getSubjectId());
                System.out.println("Title: " + subject.getTitle());
                System.out.println("Description: " + subject.getDescription());
                System.out.println("Created Date: " + subject.getCreatedDate());
                System.out.println("--------------------------------------------------------");
            }
        }
    }

    public void addExpertSubject(int expertID, int subjectDimensionID, String title, String imageURL, String description, Date createdDate, Date modifyDate, boolean status) {
        try {
            String query = "  insert into Subject(Expert_id, SubjectDimension_id, title, imageURL, [description], createdDate, modifyDate, [status])\n"
                    + "  values (?, ?, ?, ?, ?, ?, ?, ?)";
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, expertID);
            ps.setInt(2, subjectDimensionID);
            ps.setString(3, title);
            ps.setString(4, imageURL);
            ps.setString(5, description);
            ps.setDate(6, createdDate);
            ps.setDate(7, modifyDate);
            ps.setBoolean(8, status);
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
            String query = "select * from Subject where Expert_id = ? and title like ?";
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
        String sql = "select count(*) as count from Subject, Expert \n"
                + "where (Subject.Expert_id = Expert.Expert_id)and Expert.Expert_id = ? and Subject.status = 1";
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

    public List<Subject> getSubjectByExpertPaging(int expertID, int offSet, int noOfRecords) {
        List<Subject> listSubject = new ArrayList<>();
        try {
            String query = "SELECT * FROM Subject WHERE status = 1 AND Expert_id = ? ORDER BY Subject_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
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
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return listSubject;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAL.DBContext;
import Model.Subject;
import Model.SubjectDimension;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class SubjectDimensionDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;
    
    public List<SubjectDimension> getAllSubjectDimension(){
        List<SubjectDimension> list = new ArrayList<>();
        try{
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
        }catch (Exception e) {
            System.err.println("An error occurred while executing the query: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAL.DBContext;
import Model.Slider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SliderDAO extends DBContext {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Slider> listSliders() {
        String sql = "SELECT * FROM Slider";
        List<Slider> sliders = new ArrayList<>();

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int sliderId = resultSet.getInt("Slider_id");
                String imageURL = resultSet.getString("imageURL");
                String linkURL = resultSet.getString("linkURL");
                String description = resultSet.getString("description");
                String title = resultSet.getString("Title");
                String name = resultSet.getString("Name");
                // Retrieve other fields as needed

                Slider slider = new Slider();
                slider.setSliderId(sliderId);
                slider.setImageURL(imageURL);
                slider.setLinkURL(linkURL);
                slider.setDescription(description);
                slider.setTitle(title);
                slider.setName(name);
                
                // Set other fields

                sliders.add(slider);
            }
            resultSet.close();
            statement.close();
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }
        return sliders;
    }
    public void addSlider(String title, String name, String imageURL, String description) {
    String sql = "INSERT INTO Slider (Title, Name, imageURL, description, createdDate, modifyDate, status) " +
                 "VALUES (?, ?, ?, ?, GETDATE(), GETDATE(), 1)";

    try {
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setString(1, title);
        statement.setString(2, name);
        statement.setString(3, imageURL);
        statement.setString(4, description);
    } catch (Exception ex) {
        System.err.println("An error occurred while adding a slider: " + ex.getMessage());
        ex.printStackTrace();
    }
}


    public static void main(String[] args) {
        SliderDAO sliderDAO = new SliderDAO();

        List<Slider> sliders = sliderDAO.listSliders();

        for (Slider slider : sliders) {
            System.out.println("Slider ID: " + slider.getSliderId());
            System.out.println("Image URL: " + slider.getImageURL());
            System.out.println("Link URL: " + slider.getLinkURL());
            System.out.println("Description: " + slider.getDescription());
            System.out.println("Name: "+slider.getName());
            System.out.println("Title: "+slider.getTitle());
            System.out.println("---------------------------");
        }
    }
}


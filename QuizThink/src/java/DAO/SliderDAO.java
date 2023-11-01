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

    public Slider getSliderById(int sliderId) {
        String sql = "SELECT * FROM Slider WHERE Slider_id = ?";
        Slider slider = null;

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, sliderId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String imageURL = resultSet.getString("imageURL");
                String linkURL = resultSet.getString("linkURL");
                String description = resultSet.getString("description");
                String title = resultSet.getString("Title");
                String name = resultSet.getString("Name");
                // Retrieve other fields as needed

                slider = new Slider();
                slider.setSliderId(sliderId);
                slider.setImageURL(imageURL);
                slider.setLinkURL(linkURL);
                slider.setDescription(description);
                slider.setTitle(title);
                slider.setName(name);
                // Set other fields
            }

            resultSet.close();
            statement.close();
        } catch (Exception ex) {
            System.err.println("An error occurred while executing the query: " + ex.getMessage());
            ex.printStackTrace();
        }
        return slider;
    }

    public void addSlider( String imageURL, String linkURL, String description, boolean status, int marketerId, String title, String name) {
        String sql = "INSERT INTO Slider ( imageURL, linkURL, description, createdDate, modifyDate, status, Marketer_id, Title, Name)"
                + "VALUES (?,?,?,GETDATE(),GETDATE(),?,?,?,?);";

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);

            
            statement.setString(1, imageURL);
            statement.setString(2, linkURL);
            statement.setString(3, description);
            statement.setBoolean(4, status);
            statement.setInt(5, marketerId);
            statement.setString(6, title);
            statement.setString(7, name);
            statement.executeUpdate();
        } catch (Exception ex) {
            System.err.println("An error occurred while adding a slider: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void deleteSlider(int sliderId) {
        String sql = "Delete from Slider where Slider_id=?  ";
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);

            statement.setInt(1, sliderId);

            statement.executeUpdate();
        } catch (Exception ex) {
            System.err.println("An error occurred while delete a slider: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void updateSlider(String title, String name, String imageURL, String description, int sliderId) {
        String sql = "UPDATE Slider\n"
                + "SET\n"
                + "    [Title] = ?,\n"
                + "    [Name] = ?,\n"
                + "    [imageURL] = ?,\n"
                + "    [description] = ?,\n"
                + "    [modifyDate] = GETDATE()\n"
                + "WHERE\n"
                + "    [Slider_id] = ?;";

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);

            statement.setString(1, title);
            statement.setString(2, name);
            statement.setString(3, imageURL);
            statement.setString(4, description);
            statement.setInt(5, sliderId);
            statement.executeUpdate();
        } catch (Exception ex) {
            System.err.println("An error occurred while adding a slider: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SliderDAO sliderDAO = new SliderDAO();

        List<Slider> sliders = sliderDAO.listSliders();
        Slider slider = sliderDAO.getSliderById(1);

        System.out.println(slider.getDescription());
    }
}

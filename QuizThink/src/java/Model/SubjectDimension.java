/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 *
 * @author kimdi
 */
import java.util.Date;

public class SubjectDimension {
    private int subjectDimensionId;
    private Integer parentSDId;
    private String title;
    private String imageURL;
    private String description;

    public SubjectDimension() {
    }

    public SubjectDimension(int subjectDimensionId, Integer parentSDId, String title, String imageURL, String description) {
        this.subjectDimensionId = subjectDimensionId;
        this.parentSDId = parentSDId;
        this.title = title;
        this.imageURL = imageURL;
        this.description = description;
    }

    public int getSubjectDimensionId() {
        return subjectDimensionId;
    }

    public void setSubjectDimensionId(int subjectDimensionId) {
        this.subjectDimensionId = subjectDimensionId;
    }

    public Integer getParentSDId() {
        return parentSDId;
    }

    public void setParentSDId(Integer parentSDId) {
        this.parentSDId = parentSDId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}

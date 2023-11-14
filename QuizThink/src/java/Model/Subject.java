/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author kimdi
 */
import java.sql.Time;
import java.util.Date;

public class Subject {
    private int subjectId;
    private int expertId;
    private int subjectDimensionId;
    private String title;
    private String imageURL;
    private float requirement;
    private String description;
    private Date createdDate;
    private Date modifyDate;
    private boolean status;

    public Subject() {
    }

    public Subject(int subjectId, int expertId, int subjectDimensionId, String title, String imageURL, float requirement, String description, Date createdDate, Date modifyDate, boolean status) {
        this.subjectId = subjectId;
        this.expertId = expertId;
        this.subjectDimensionId = subjectDimensionId;
        this.title = title;
        this.imageURL = imageURL;
        this.requirement = requirement;
        this.description = description;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
        this.status = status;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getExpertId() {
        return expertId;
    }

    public void setExpertId(int expertId) {
        this.expertId = expertId;
    }

    public int getSubjectDimensionId() {
        return subjectDimensionId;
    }

    public void setSubjectDimensionId(int subjectDimensionId) {
        this.subjectDimensionId = subjectDimensionId;
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


    public float getRequirement() {
        return requirement;
    }

    public void setRequirement(float requirement) {
        this.requirement = requirement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;

    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

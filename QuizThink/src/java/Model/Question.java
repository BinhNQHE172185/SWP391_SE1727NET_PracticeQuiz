/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author kimdi
 */
public class Question {

    private int questionId;
    private int subjectId;
    private int expertId;
    private String title;
    private String imageURL;
    private String description;
    private float requirement;
    private Date createdDate;
    private Date modifyDate;
    private boolean status;
    private Time duration;

    public Question() {
    }

    public Question(int questionId, int subjectId, int expertId, String title, String imageURL, String description, float requirement, Date createdDate, Date modifyDate, boolean status, Time duration) {
        this.questionId = questionId;
        this.subjectId = subjectId;
        this.expertId = expertId;
        this.title = title;
        this.imageURL = imageURL;
        this.description = description;
        this.requirement = requirement;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
        this.status = status;
        this.duration = duration;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
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

    public float getRequirement() {
        return requirement;
    }

    public void setRequirement(float requirement) {
        this.requirement = requirement;
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

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

}

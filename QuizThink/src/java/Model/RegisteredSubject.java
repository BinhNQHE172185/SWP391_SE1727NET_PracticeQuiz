/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
public class RegisteredSubject {
    private int subjectId;
    private int accountId;
    private String subjectTitle;
    private String image;
    private String description;
    private String expert;
    private String expertAvatar;
    private String subjectDimension;
    private int questionCount;

    public RegisteredSubject() {
    }

    public RegisteredSubject(int subjectId, int accountId, String subjectTitle, String image, String description, String expert, String expertAvatar, String subjectDimension, int questionCount) {
        this.subjectId = subjectId;
        this.accountId = accountId;
        this.subjectTitle = subjectTitle;
        this.image = image;
        this.description = description;
        this.expert = expert;
        this.expertAvatar = expertAvatar;
        this.subjectDimension = subjectDimension;
        this.questionCount = questionCount;
    }  

    public String getExpertAvatar() {
        return expertAvatar;
    }

    public void setExpertAvatar(String expertAvatar) {
        this.expertAvatar = expertAvatar;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpert() {
        return expert;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }

    public String getSubjectDimension() {
        return subjectDimension;
    }

    public void setSubjectDimension(String subjectDimension) {
        this.subjectDimension = subjectDimension;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    
    
}

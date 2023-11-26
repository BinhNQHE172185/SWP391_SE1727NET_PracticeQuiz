/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author kimdi
 */
public class QuestionStatus {
    private int questionStatusId;
    private int subjectId;
    private int questionId;
    private int accountId;
    private boolean status;
    private Date createdDate;
    private Date modifyDate;
    private Date passDate;

    public QuestionStatus() {
    }

    public QuestionStatus(int questionStatusId, int subjectId, int questionId, int accountId, boolean status, Date createdDate, Date modifyDate, Date passDate) {
        this.questionStatusId = questionStatusId;
        this.subjectId = subjectId;
        this.questionId = questionId;
        this.accountId = accountId;
        this.status = status;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
        this.passDate = passDate;
    }
     public QuestionStatus(int subjectId, int questionId, int accountId, boolean status, Date createdDate, Date modifyDate) {
        this.subjectId = subjectId;
        this.questionId = questionId;
        this.accountId = accountId;
        this.status = status;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
    }

    public int getQuestionStatusId() {
        return questionStatusId;
    }

    public void setQuestionStatusId(int questionStatusId) {
        this.questionStatusId = questionStatusId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public Date getPassDate() {
        return passDate;
    }

    public void setPassDate(Date passDate) {
        this.passDate = passDate;
    }
}

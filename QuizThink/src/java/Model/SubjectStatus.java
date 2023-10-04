/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class SubjectStatus {
    private int subjectStatusId;
    private int subjectId;
    private int accountId;
    private boolean status;
    private Date createdDate;
    private Date modifyDate;
    private Date passDate;

    public SubjectStatus() {
    }

    public SubjectStatus(int subjectStatusId, int subjectId, int accountId, boolean status, Date createdDate, Date modifyDate, Date passDate) {
        this.subjectStatusId = subjectStatusId;
        this.subjectId = subjectId;
        this.accountId = accountId;
        this.status = status;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
        this.passDate = passDate;
    }

    public int getSubjectStatusId() {
        return subjectStatusId;
    }

    public void setSubjectStatusId(int subjectStatusId) {
        this.subjectStatusId = subjectStatusId;
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

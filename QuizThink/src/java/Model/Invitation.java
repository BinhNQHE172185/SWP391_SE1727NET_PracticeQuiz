/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author admin
 */
public class Invitation {
    private int invitationID;
    private int accountID;
    private int subjectID;
    private String description;
    private Date createdDate;
    private Date modifyDate;
    private boolean status;
    private Time duration;

    public Invitation() {
    }

    public Invitation(int invitationID, int accountID, int subjectID, String description, Date createdDate, Date modifyDate, boolean status, Time duration) {
        this.invitationID = invitationID;
        this.accountID = accountID;
        this.subjectID = subjectID;
        this.description = description;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
        this.status = status;
        this.duration = duration;
    }

    public int getInvitationID() {
        return invitationID;
    }

    public void setInvitationID(int invitationID) {
        this.invitationID = invitationID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
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

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }
    
}

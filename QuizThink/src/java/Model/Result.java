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
public class Result {
    private int resultId;
    private int questionId;
    private int accountId;
    private String selectedChoice;
    private Date takenDate;
    private Time takenDuration;
    private Time duration;
    private float mark;

    public Result() {
        // Default constructor
    }

    public Result(int resultId, int questionId, int accountId, String selectedChoice, Date takenDate, Time takenDuration, Time duration, float mark) {
        this.resultId = resultId;
        this.questionId = questionId;
        this.accountId = accountId;
        this.selectedChoice = selectedChoice;
        this.takenDate = takenDate;
        this.takenDuration = takenDuration;
        this.duration = duration;
        this.mark = mark;
    }    

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
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

    public String getSelectedChoice() {
        return selectedChoice;
    }

    public void setSelectedChoice(String selectedChoice) {
        this.selectedChoice = selectedChoice;
    }

    public Date getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(Date takenDate) {
        this.takenDate = takenDate;
    }

    public Time getTakenDuration() {
        return takenDuration;
    }

    public void setTakenDuration(Time takenDuration) {
        this.takenDuration = takenDuration;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }
}

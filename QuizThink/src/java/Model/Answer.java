/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author kimdi
 */
public class Answer {

    private int answerId;
    private int quizId;
    private boolean isCorrect;
    private String content;

    public Answer() {
    }

    public Answer(int answerId, int quizId, boolean isCorrect, String content) {
        this.answerId = answerId;
        this.quizId = quizId;
        this.isCorrect = isCorrect;
        this.content = content;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
    
    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public boolean isIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

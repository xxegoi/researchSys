package com.example.demo.pojo;

import java.util.Date;

public class Result {
    private int resultId;
    private String resultUser;
    private Answer resultAnswer;
    private Date resultTime;
    private Question resultQuestion;

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public String getResultUser() {
        return resultUser;
    }

    public void setResultUser(String resultUser) {
        this.resultUser = resultUser;
    }

    public Answer getResultAnswer() {
        return resultAnswer;
    }

    public void setResultAnswer(Answer resultAnswer) {
        this.resultAnswer = resultAnswer;
    }

    public Date getResultTime() {
        return resultTime;
    }

    public void setResultTime(Date resultTime) {
        this.resultTime = resultTime;
    }

    public Question getResultQuestion() {
        return resultQuestion;
    }

    public void setResultQuestion(Question resultQuestion) {
        this.resultQuestion = resultQuestion;
    }
}

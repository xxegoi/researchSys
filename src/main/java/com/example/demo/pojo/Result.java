package com.example.demo.pojo;

import java.util.Date;

public class Result extends basePOJO{
    private int resultId;
    private String resultUser;
    private String resultAnswer;
    private Date resultTime;
    private Question resultQuestion;
    private Research resultResearch;

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

    public Research getResultResearch() {
        return resultResearch;
    }

    public void setResultResearch(Research resultResearch) {
        this.resultResearch = resultResearch;
    }

    public String getResultAnswer() {
        return resultAnswer;
    }

    public void setResultAnswer(String resultAnswer) {
        this.resultAnswer = resultAnswer;
    }
}

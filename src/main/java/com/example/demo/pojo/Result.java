package com.example.demo.pojo;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class Result extends basePOJO{

    private int resultId;
    private String resultUser;
    @NotEmpty(message = "答案不能为空")
    private String resultAnswer;
    private Date resultTime;
    private int resultQuestion;
    private int resultResearch;

    public int getResultQuestion() {
        return resultQuestion;
    }

    public void setResultQuestion(int resultQuestion) {
        this.resultQuestion = resultQuestion;
    }

    public int getResultResearch() {
        return resultResearch;
    }

    public void setResultResearch(int resultResearch) {
        this.resultResearch = resultResearch;
    }

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

    public String getResultAnswer() {
        return resultAnswer;
    }

    public void setResultAnswer(String resultAnswer) {
        this.resultAnswer = resultAnswer;
    }
}

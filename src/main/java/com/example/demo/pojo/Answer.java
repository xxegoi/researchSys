package com.example.demo.pojo;

public class Answer {
    //答案id
    private int answerId;
    //答案内容
    private String answerTitle;
    //排序
    private int ansIndex;
    //所属问题Id
    private int ansQuestionId;

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswerTitle() {
        return answerTitle;
    }

    public void setAnswerTitle(String answerTitle) {
        this.answerTitle = answerTitle;
    }

    public int getAnsIndex() {
        return ansIndex;
    }

    public void setAnsIndex(int ansIndex) {
        this.ansIndex = ansIndex;
    }

    public int getAnsQuestionId() {
        return ansQuestionId;
    }

    public void setAnsQuestionId(int ansQuestionId) {
        this.ansQuestionId = ansQuestionId;
    }
}

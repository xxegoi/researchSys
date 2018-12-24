package com.example.demo.pojo;

import java.util.List;

public class Question {
    //问题Id
    private int questionId;
    //问题类型
    private QuestionType questionType;
    //问题描述
    private String questionDescribe;
    //所属调查Id
    private int questionResearchId;
    //答案
    private List<Answer> answerList;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public String getQuestionDescribe() {
        return questionDescribe;
    }

    public void setQuestionDescribe(String questionDescribe) {
        this.questionDescribe = questionDescribe;
    }

    public int getQuestionResearchId() {
        return questionResearchId;
    }

    public void setQuestionResearchId(int questionResearchId) {
        this.questionResearchId = questionResearchId;
    }
}

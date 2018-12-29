package com.example.demo.viewmodel;

import com.example.demo.pojo.Question;
import com.example.demo.pojo.Result;

public class QuestionResultViewModel {
    private Question question;
    private Result result;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}

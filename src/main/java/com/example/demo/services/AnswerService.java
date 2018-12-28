package com.example.demo.services;

import com.example.demo.pojo.Answer;

import java.util.List;

public interface AnswerService {

    List<Answer> GetList(int questionId);

    int insert(Answer answer);

    int update(Answer answer);

    int delete(int Id);

    int deleteByQuestionId(int questionId);

    int insertList(List<Answer> answers);
}

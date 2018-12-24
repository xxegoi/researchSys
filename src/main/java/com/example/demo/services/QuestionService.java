package com.example.demo.services;

import com.example.demo.pojo.Question;

import java.util.List;

public interface QuestionService {

    Question GetQuestionById(int id);

    List<Question> GetQuestionByResearchId(int resId);

    int insert(Question question);

    int update(Question question);

    int delete(int Id);
}

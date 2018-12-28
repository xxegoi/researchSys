package com.example.demo.services;

import com.example.demo.pojo.Question;

import java.util.List;

public interface QuestionService {

    Question GetQuestionById(int id);

    List<Question> GetQuestionByResearchId(int resId);

    int insert(Question question) throws Exception;

    int update(Question question) throws Exception;

    int delete(int Id);

    int insertQuestionList(List<Question> questions) throws Exception;

    int deleteByResearchId(int researchId);

}

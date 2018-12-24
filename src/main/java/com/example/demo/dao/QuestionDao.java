package com.example.demo.dao;

import com.example.demo.pojo.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao {

    Question getQuestionById(int Id);

    List<Question> getQuestionListByResearchId(int resId);

    int insert(Question question);

    int update(Question question);

    int delete(int questionId);
}

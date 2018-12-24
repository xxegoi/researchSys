package com.example.demo.dao;

import com.example.demo.pojo.Answer;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerDao {
    Answer getAnswerById(int id);

    List<Answer> getList(int questionId);

    int insert(Answer answer);

    int delete(int id);

    int update(Answer answer);
}

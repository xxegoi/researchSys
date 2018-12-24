package com.example.demo.services.Impl;

import com.example.demo.dao.QuestionDao;
import com.example.demo.pojo.Question;
import com.example.demo.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionDao questionDao=null;

    @Override
    public Question GetQuestionById(int id) {
        return questionDao.getQuestionById(id);
    }

    @Override
    public List<Question> GetQuestionByResearchId(int resId) {
        return questionDao.getQuestionListByResearchId(resId);
    }

    @Override
    public int insert(Question question) {
        return questionDao.insert(question);
    }

    @Override
    public int update(Question question) {
        return questionDao.update(question);
    }

    @Override
    public int delete(int Id) {
        return questionDao.delete(Id);
    }
}

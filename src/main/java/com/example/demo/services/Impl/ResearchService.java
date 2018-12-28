package com.example.demo.services.Impl;

<<<<<<< HEAD:src/main/java/com/example/demo/services/Impl/AnswerServiceImpl.java
import com.example.demo.dao.AnswerDao;
import com.example.demo.pojo.Answer;
import com.example.demo.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerDao answerDao=null;

    @Override
    public List<Answer> GetList(int questionId) {
        return answerDao.getList(questionId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public int insert(Answer answer) {
        return answerDao.insert(answer);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public int update(Answer answer) {
        return answerDao.update(answer);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public int delete(int Id) {
        return answerDao.delete(Id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public int deleteByQuestionId(int questionId) {
        return answerDao.deleteByQuestionId(questionId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    public int insertList(List<Answer> answers) {
        return answerDao.insertList(answers);
    }

=======
public class ResearchService {
>>>>>>> parent of c074f7b... Test OK:src/main/java/com/example/demo/services/Impl/ResearchService.java
}

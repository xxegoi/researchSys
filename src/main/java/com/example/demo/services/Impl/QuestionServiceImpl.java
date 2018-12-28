package com.example.demo.services.Impl;

import com.example.demo.dao.QuestionDao;
import com.example.demo.pojo.Answer;
import com.example.demo.pojo.Question;
import com.example.demo.pojo.QuestionType;
import com.example.demo.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionDao questionDao=null;

    @Autowired
    AnswerServiceImpl answerService=null;

    @Override
    public Question GetQuestionById(int id) {

        return questionDao.getQuestionById(id);
    }

    @Override
    public List<Question> GetQuestionByResearchId(int resId) {
        return questionDao.getQuestionListByResearchId(resId);
    }

    @Override
    //启用事务，隔离级别为：读写提交，传播级别：Required
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public int insert(Question question) throws Exception {

        if(question.getQuestionType()!= QuestionType.Fill&&question.getAnswerList().size()==0){
            throw new Exception("可选答案至少需要2个或以上");
        }

        int i=questionDao.insert(question);

        if(question.getQuestionType()!=QuestionType.Fill){

            for (Answer answer :question.getAnswerList()){
                answer.setAnsQuestionId(question.getQuestionId());
                i+=answerService.insert(answer);
            }

        }

        return i;
    }

    @Override
    //启用事务，隔离级别为：读写提交，传播级别：Required
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public int update(Question question) throws Exception {

        if(question.getQuestionType()!=QuestionType.Fill&&question.getAnswerList().size()==0){
            throw new Exception("可选答案至少需要2个或以上");
        }

        int i= questionDao.update(question);

        i+=answerService.deleteByQuestionId(question.getQuestionId());

        for (Answer answer:question.getAnswerList()){
            i+=answerService.insert(answer);
        }

        return i;
    }

    @Override
    //启用事务，隔离级别为：读写提交，传播级别：Required
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public int delete(int Id) {
        int i= questionDao.delete(Id);

        i+=answerService.deleteByQuestionId(Id);

        return i;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public int insertQuestionList(List<Question> questions) throws Exception {
        int i=0;

        for (Question question:questions){

            if(question.getQuestionType()!= QuestionType.Fill&&question.getAnswerList().size()==0){
                throw new Exception(String.format("题目【%d】可选答案至少需要2个或以上",questions.indexOf(question)));
            }

            i=questionDao.insert(question);

            if(question.getQuestionType()!=QuestionType.Fill){

                for (Answer answer :question.getAnswerList()){
                    answer.setAnsQuestionId(question.getQuestionId());
                }

                i+=answerService.insertList(question.getAnswerList());
            }


        }


        return i;
    }

    @Override
    public int deleteByResearchId(int researchId) {
        List<Question> questions=questionDao.getQuestionListByResearchId(researchId);

        int i=0;
        for(Question question:questions){

            i+=answerService.deleteByQuestionId(question.getQuestionId());
            i+=questionDao.delete(question.getQuestionId());

        }
        return i;
    }

}

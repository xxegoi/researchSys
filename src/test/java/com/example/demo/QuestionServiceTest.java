package com.example.demo;

import com.example.demo.pojo.Answer;
import com.example.demo.pojo.Question;
import com.example.demo.pojo.QuestionType;
import com.example.demo.services.QuestionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class QuestionServiceTest extends DemoApplicationTests {

    @Autowired
    QuestionService questionService;

    @Test
    public void testInsertList(){

        String questionTitleTemplate="Test Question ";
        String answerTitleTemplate="Test Answer ";

        List<Question> questions=new ArrayList<>();

        for(int i=0;i<10;i++){

            Question question=new Question();
            question.setQuestionDescribe(questionTitleTemplate+i);
            question.setQuestionResearchId(8);
            QuestionType type=null;

            if(i%3==1){
                type=QuestionType.Fill;
            }
            else if(i%4==1){
                type=QuestionType.Multiple;
            }else{
                type=QuestionType.Choose;
            }

            question.setQuestionType(type);

            if(type!=QuestionType.Fill){

                List<Answer> answers=new ArrayList<>();

                for(int j=0;j<4;j++){
                    Answer answer=new Answer();
                    answer.setAnsIndex(j+1);
                    answer.setAnswerTitle(answerTitleTemplate+(j+1));
                    answers.add(answer);
                }

                question.setAnswerList(answers);
            }

            questions.add(question);

        }

        try {
            questionService.insertQuestionList(questions);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testInsert(){

        String questionTitleTemplate="Test Question ";
        String answerTitleTemplate="Test Answer ";

        List<Question> questions=new ArrayList<Question>();

        for(int i=0;i<10;i++){

            Question question=new Question();
            question.setQuestionDescribe(questionTitleTemplate+i);
            question.setQuestionResearchId(8);
            QuestionType type=null;

            if(i%3==1){
                type=QuestionType.Fill;
            }
            else if(i%4==1){
                type=QuestionType.Multiple;
            }else{
                type=QuestionType.Choose;
            }

            question.setQuestionType(type);

            if(type!=QuestionType.Fill){

                List<Answer> answers=new ArrayList<Answer>();

                for(int j=0;j<4;j++){
                    Answer answer=new Answer();
                    answer.setAnsIndex(j+1);
                    answer.setAnswerTitle(answerTitleTemplate+(j+1));
                    answers.add(answer);
                }

                question.setAnswerList(answers);
            }

            try {
                questionService.insert(question);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }



    }

    @Test
    public void delete(){
        questionService.deleteByResearchId(8);
    }
}

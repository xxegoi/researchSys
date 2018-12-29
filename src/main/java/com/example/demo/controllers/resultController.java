package com.example.demo.controllers;

import com.example.demo.common.FailResult;
import com.example.demo.common.ReturnResult;
import com.example.demo.common.SucessResult;
import com.example.demo.pojo.Question;
import com.example.demo.services.Impl.QuestionServiceImpl;
import com.example.demo.services.Impl.ResultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Result")
public class resultController {

    @Autowired
    SucessResult sucessResult;
    @Autowired
    FailResult failResult;

    @Autowired
    ResultServiceImpl resultService=null;

    @Autowired
    QuestionServiceImpl questionService=null;

    @RequestMapping("/answer")
    public ReturnResult getQuestionList(int researchId){
        Boolean flag=false;

        try{

            List<Question> questions= questionService.GetQuestionByResearchId(researchId);
            flag=true;
            sucessResult.setData(questions);

        }
        catch (Exception e){
            failResult.setMessage(e.getMessage());
        }

        return flag?sucessResult:failResult;
    }


}

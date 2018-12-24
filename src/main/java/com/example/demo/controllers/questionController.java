package com.example.demo.controllers;

import com.example.demo.common.FailResult;
import com.example.demo.common.ReturnResult;
import com.example.demo.common.SucessResult;
import com.example.demo.pojo.Question;
import com.example.demo.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class questionController {
    @Autowired
    QuestionService questionService=null;
    @Autowired
    SucessResult sucessResult=null;
    @Autowired
    FailResult failResult=null;

    @RequestMapping("/get")
    public ReturnResult getQuestionById(int id){
        Boolean flag=false;
        try{
            Question question= questionService.GetQuestionById(id);
            sucessResult.setData(question);
            flag=true;
        }
        catch (Exception e){
            failResult.setMessage(e.getMessage());
        }
        finally {
            if(!flag&&failResult.getMessage()==null){
                failResult.setMessage("未知错误");
            }

            return flag?sucessResult:failResult;
        }
    }

    @RequestMapping("/getList")
    public ReturnResult getQuestionListByResearchId(int resId){
        Boolean flag=false;
        try{
            List<Question> questionList=questionService.GetQuestionByResearchId(resId);
            flag=true;
        }
        catch (Exception e){
            failResult.setMessage(e.getMessage());
        }
        finally {
            if(!flag&&failResult.getMessage()==null){
                failResult.setMessage("未知错误");
            }
            return flag?sucessResult:failResult;
        }
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ReturnResult insert(@RequestBody Question question){
        Boolean flag=false;
        try{
            int i = questionService.insert(question);
            if(i>0){
                sucessResult.setData(i);
                flag=true;
            }
        }
        catch (Exception e){
            failResult.setMessage(e.getMessage());
        }
        finally {
            if(!flag&&failResult.getMessage()==null){
                failResult.setMessage("未知错误");
            }
            return flag?sucessResult:failResult;
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ReturnResult update(Question question){
        Boolean flag=false;
        try{
            int i=questionService.update(question);
            if(i>0){
                sucessResult.setData(i);
                flag=true;
            }
        }
        catch (Exception e){
            failResult.setMessage(e.getMessage());
        }
        finally {
            if(!flag&&failResult.getMessage()==null){
                failResult.setMessage("未知错误");
            }
            return flag?sucessResult:failResult;
        }
    }

    @RequestMapping("/delete")
    public ReturnResult delete(int Id){
        Boolean flag=false;
        try{
            int i=questionService.delete(Id);
            if(i>0){
                sucessResult.setData(i);
                flag=true;
            }
        }
        catch (Exception e){
            failResult.setMessage(e.getMessage());
        }finally {
            if(!flag&&failResult.getMessage()==null){
                failResult.setMessage("未知错误");
            }
            return flag?sucessResult:failResult;
        }
    }
}

package com.example.demo.controllers;

import com.example.demo.common.FailResult;
import com.example.demo.common.ReturnResult;
import com.example.demo.common.SucessResult;
import com.example.demo.pojo.Research;
import com.example.demo.services.Impl.ResearchServiceImpl;
import com.example.demo.viewmodel.ResearchQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/Research")
@RestController
public class researchController {

    @Autowired
    SucessResult sucessResult=null;
    @Autowired
    FailResult failResult=null;

    @Autowired
    ResearchServiceImpl researchService=null;

    @RequestMapping("/getList")
    public ReturnResult getList(@RequestBody(required = false)ResearchQueryModel model){
        Boolean flag=false;

        try {
            if(model.getTitle()==null||model.getTitle().length()==0){
                List<Research> researchList=researchService.getList(model.getPageModel());
                flag=true;
                sucessResult.setData(researchList);
            }else{
                List<Research> researchList=researchService.getResearchByTitle(model.getTitle(),model.getPageModel());
                flag=true;
                sucessResult.setData(researchList);
            }
        }
        catch (Exception e){
            failResult.setMessage(e.getMessage());
        }
        finally {
            return flag?sucessResult:failResult;
        }

    }

    @RequestMapping("/addResearch")
    public ReturnResult add(@RequestBody Research research){
        Boolean flag=false;

        try{
            int i= researchService.insert(research);
            flag=true;
            sucessResult.setData(i);
        }catch(Exception e){
            failResult.setMessage(e.getMessage());
        }
        finally {
            return flag?sucessResult:failResult;
        }
    }

    @RequestMapping("/updateResearch")
    public ReturnResult update(@RequestBody Research research){
        Boolean flag=false;

        try{
            int i= researchService.update(research);
            flag=true;
            sucessResult.setData(i);
        }
        catch (Exception e){
            failResult.setMessage(e.getMessage());
        }

        return flag?sucessResult:failResult;
    }

    @RequestMapping("/deleteResearch")
    public ReturnResult delete(int researchId){

        Boolean flag=false;

        try {
            int i=researchService.delete(researchId);
            sucessResult.setData(i);
            flag=true;
        }
        catch (Exception e){
            failResult.setMessage(e.getMessage());
        }

        return flag?sucessResult:failResult;
    }

}

package com.example.demo.services.Impl;

import com.example.demo.common.Page;
import com.example.demo.dao.ResearchDao;
import com.example.demo.pojo.Research;
import com.example.demo.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResearchService implements com.example.demo.services.ResearchService {

    @Autowired
    QuestionService questionService=null;

    @Autowired
    ResearchDao researchDao=null;

    @Override
    public Research getResearchById(int Id) throws Exception {
        Research result=this.researchDao.GetResearchById(Id);
        if(result==null){
            throw new Exception("记录不存在");
        }
        return result;
    }

    @Override
    public List<Research> getResearchByTitle(String title, Page page) {

        if(page==null){
            page=new Page(1,20);
        }

        List<Research> researchList=this.researchDao.GetResearchByTitle(title,page.getRowBounds());

        return researchList;
    }

    @Override
    public int insert(Research research) throws Exception {

        if(research==null){
            throw new Exception("不能插入空记录");
        }

        if(research.getResearchTitle()==null||research.getResearchTitle().toString().length()==0){
            throw new Exception("调查标题不能为空");
        }

        if(research.getResearchStart()==null||research.getResearchEnd()==null){
            throw new Exception("调查开始和结束时间不能为空");
        }

        if(research.getResearchStart().getTime()>research.getResearchEnd().getTime()){
            throw new Exception("调查结束时间不能早于开始时间");
        }

        return this.researchDao.insert(research);
    }

    @Override
    public int update(Research research) throws Exception {

        if(research.getResearchTitle()==null||research.getResearchTitle().length()==0){
            throw new Exception("标题不能为空");
        }

        if(research.getResearchStart().getTime()>research.getResearchEnd().getTime()){
            throw new Exception("结束时间不能早于开始时间");
        }

        return this.researchDao.update(research);
    }

    @Override
    public int delete(int Id) {
        return this.researchDao.delete(Id);
    }

}

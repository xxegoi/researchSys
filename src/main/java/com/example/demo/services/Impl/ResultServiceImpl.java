package com.example.demo.services.Impl;

import com.example.demo.dao.ResultDao;
import com.example.demo.pojo.Result;
import com.example.demo.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    ResultDao resultDao=null;

    @Override
    public Result GetResult(String user, int questionId, int researchId) {
        return resultDao.GetResult(user,questionId,researchId);
    }

    @Override
    public int insert(Result result) {
        return resultDao.insert(result);
    }

    @Override
    public int update(Result result) {
        return resultDao.update(result);
    }

    @Override
    public int delete(int Id) {
        return resultDao.delete(Id);
    }

    @Override
    public List<Result> getAllByResearchIdAndUser(String user, int researchId) {
        return resultDao.getAllByResearchIdAndUser(user,researchId);
    }
}

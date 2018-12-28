package com.example.demo.services;

import com.example.demo.pojo.Result;

import java.util.List;

public interface ResultService {

    Result GetResult(String user, int questionId,int researchId);

    int insert(Result result);

    int update(Result result);

    int delete(int Id);

    List<Result> getAllByResearchIdAndUser(String user, int researchId);
}

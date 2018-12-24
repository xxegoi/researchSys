package com.example.demo.dao;

import com.example.demo.pojo.Result;
import org.springframework.stereotype.Repository;


@Repository
public interface ResultDao {

    Result GetResult(String user,int questionId);

    int insert(Result result);

    int update(Result result);

    int delete(int Id);
}

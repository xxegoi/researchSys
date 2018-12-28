package com.example.demo.dao;

import com.example.demo.pojo.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ResultDao {

    Result GetResult(@Param("user") String user,@Param("questionId") int questionId,@Param("researchId") int researchId);

    List<Result> getAllByResearchIdAndUser(String user,int researchId);

    int insert(Result result);

    int update(Result result);

    int delete(int Id);
}

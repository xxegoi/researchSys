package com.example.demo.dao;

import com.example.demo.pojo.Research;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResearchDao {
    Research GetResearchById(int Id);

    List<Research> GetResearchList(RowBounds rowBounds);

    int insert(Research research);

    int update(Research research);

    int delete(int Id);
}

package com.example.demo.services;

import com.example.demo.common.Page;
import com.example.demo.pojo.Question;
import com.example.demo.pojo.Research;

import java.util.List;

public interface ResearchService {

    Research getResearchById(int Id) throws Exception;

    List<Research> getResearchByTitle(String title,Page page);

    int insert(Research research) throws Exception;

    int update(Research research) throws Exception;

    int delete(int Id);

    List<Research> getList(Page page);

}

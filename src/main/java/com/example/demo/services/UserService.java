package com.example.demo.services;

import com.example.demo.common.Page;
import com.example.demo.pojo.User;

import java.util.List;

public interface UserService  {

    User getUser(int id) throws Exception;

    List<User> getList(Page page);

    int insert(User user) throws Exception;

    int delete(int userId) throws Exception;

    int update(User user) throws Exception;

}

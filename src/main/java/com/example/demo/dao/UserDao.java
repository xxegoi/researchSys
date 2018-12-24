package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    User getUserById(int id);

    List<User> getAll(RowBounds rowBounds);

    int insert(User user);

    int delete(int userId);

    int update(User user);

    User getUserByName(String userName);

}

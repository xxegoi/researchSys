package com.example.demo.services.Impl;

import com.example.demo.common.Page;
import com.example.demo.dao.UserDao;
import com.example.demo.pojo.User;
import com.example.demo.services.UserService;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao=null;

    @Override
    public User getUser(int id) throws Exception {

        User u= userDao.getUserById(id);
        if(u==null){
            throw new Exception("用户不存在");
        }

        return u;
    }

    @Override
    public List<User> getList(Page page) {
        //Mybatis分页类
        RowBounds rowBounds=null;

        if(page==null){
            rowBounds=new RowBounds(0,20);
        }else {
            rowBounds=new RowBounds((page.getPage()-1)*page.getSize(),page.getSize());
        }

        return userDao.getAll(rowBounds);
    }

    @Override
    public int insert(User user) throws Exception {

        User u=userDao.getUserByName(user.getUserName());
        if(u!=null){
            throw new Exception("此用户已存在");
        }

        return userDao.insert(user);
    }

    @Override
    public int delete(int userId) throws Exception {

        User u=userDao.getUserById(userId);


        if(u==null){
            throw new SqlSessionException("此用户不存在");
        }

        if(u.getUserName().equals("admin")||userId==1){
            throw new Exception("不能删除系统管理员");
        }

        int i= userDao.delete(userId);

        return i;
    }

    @Override
    public int update(User user) throws Exception {

        User u=userDao.getUserById(user.getUserId());

        if(u==null){
            throw new Exception("此用户不存在");
        }

        return userDao.update(user);
    }


}

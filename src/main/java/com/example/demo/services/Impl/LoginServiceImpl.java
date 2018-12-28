package com.example.demo.services.Impl;

import com.example.demo.dao.UserDao;
import com.example.demo.pojo.User;
import com.example.demo.services.LoginService;
import com.example.demo.viewmodel.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserDao userDao=null;

    @Override
    public Boolean Login(LoginUser loginUser) throws Exception {

        User user=userDao.getUserByName(loginUser.getUserName());

        if(user==null){
            throw new Exception("用户不存在");
        }

        if(user.getUserPassword().equals(loginUser.getPassWord())){
            return true;
        }
        else {
            throw new Exception("密码错误");
        }

    }
}

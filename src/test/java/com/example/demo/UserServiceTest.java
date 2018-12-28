package com.example.demo;

import com.example.demo.common.Page;
import com.example.demo.pojo.User;
import com.example.demo.services.Impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceTest extends DemoApplicationTests {

    @Autowired
    UserServiceImpl userService;

    @Test
    public void testInsertUser(){

        User user=new User();
        user.setUserName("sai");
        user.setUserPassword("admin@123");

        try {
            Assert.assertSame("Insert Not OK",1,userService.insert(user));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testSelectUser(){
        List<User> list= userService.getList(new Page(1,20));
        for (User user:list){
            System.out.println(user.getUserName());
        }
    }


}

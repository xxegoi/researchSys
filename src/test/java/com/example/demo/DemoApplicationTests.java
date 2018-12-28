package com.example.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DemoApplicationTests {

    @Before
    public void init(){
        System.out.println("----------测试开始----------");
    }




    @After
    public void after(){
        System.out.println("----------测试结束----------");
    }

}


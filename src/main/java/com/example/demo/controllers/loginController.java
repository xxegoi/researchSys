package com.example.demo.controllers;

import com.example.demo.common.FailResult;
import com.example.demo.common.ReturnResult;
import com.example.demo.common.SucessResult;
import com.example.demo.common.ValidatorUnit;
import com.example.demo.services.Impl.LoginServiceImpl;
import com.example.demo.viewmodel.LoginUser;
import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
public class loginController {

    @Autowired
    LoginServiceImpl loginService=null;
    @Autowired
    FailResult failResult=null;
    @Autowired
    SucessResult sucessResult=null;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ReturnResult Login(@RequestBody LoginUser loginUser){
        Boolean flag=false;

        List<String> messages= ValidatorUnit.validate(loginUser);

        if(messages!=null){

            failResult.setMessage(messages);
            return failResult;
        }

        try {
            flag= loginService.Login(loginUser);

            String sercetKey="dclyResearchSys";

            byte[] apiKey= DatatypeConverter.parseBase64Binary(sercetKey);

            Key key=Keys.hmacShaKeyFor(apiKey);

            JwtBuilder jwtBuilder= Jwts.builder();
            jwtBuilder.setSubject(loginUser.getUserName());

            SimpleDateFormat sdf=new  SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

            Date now=new Date();
            //过期时间从当前时间往后推30分钟
            jwtBuilder.setExpiration(new Date(now.getTime()+60*1000*30));
            //转换为jws
            String jws= jwtBuilder.signWith(key).compact();



        } catch (Exception e) {
            failResult.setMessage(e.getMessage());
        }


        return flag?sucessResult:failResult;

    }




}


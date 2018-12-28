package com.example.demo.controllers;

import com.example.demo.common.FailResult;
import com.example.demo.common.ReturnResult;
import com.example.demo.common.SucessResult;
import com.example.demo.common.ValidatorUnit;
import com.example.demo.services.Impl.LoginServiceImpl;
import com.example.demo.viewmodel.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;

import java.util.List;
import java.util.Set;

import static com.example.demo.common.ValidatorUnit.validate;

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
        } catch (Exception e) {
            failResult.setMessage(e.getMessage());
        }


        return flag?sucessResult:failResult;

    }

}


package com.example.demo.services;

import com.example.demo.viewmodel.LoginUser;

public interface LoginService {
    Boolean Login(LoginUser loginUser) throws Exception;
}

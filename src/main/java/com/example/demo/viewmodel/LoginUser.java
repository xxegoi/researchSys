package com.example.demo.viewmodel;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class LoginUser {

    @NotEmpty(message = "用户名不能为空")
    @Pattern(regexp = "[\\w\\d]+",message = "用户名只能包含字母和数字")
    private String userName;

    @NotNull(message = "密码不能为空")
    @Length(min = 6,max = 12,message = "密码长度在6到12位")
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) throws Exception {

        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) throws Exception {

        this.passWord = passWord;
    }
}

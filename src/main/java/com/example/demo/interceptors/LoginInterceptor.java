package com.example.demo.interceptors;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception {


       Enumeration<String> keys= request.getHeaderNames();

       while (keys!=null&&keys.hasMoreElements()){
           String k=keys.nextElement();

           System.out.println(k+"="+request.getHeader(k));
       }


        return true;
    }
}

package com.example.demo.config;

import com.example.demo.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class interceptorsConfig implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor filter=null;


    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(filter).addPathPatterns("/**");
    }
}

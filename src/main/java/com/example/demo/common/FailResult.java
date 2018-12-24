package com.example.demo.common;

import org.springframework.stereotype.Component;

@Component
public class FailResult extends ReturnResult {
    public FailResult(){
        this.setStatus("fail");
    }
}

package com.example.demo.common;

import org.springframework.stereotype.Component;

@Component
public class SucessResult extends ReturnResult {
    public SucessResult(){
        this.setStatus("sucess");
    }
}

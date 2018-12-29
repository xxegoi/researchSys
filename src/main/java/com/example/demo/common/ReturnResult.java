package com.example.demo.common;


import java.util.List;

public abstract class ReturnResult {
    private String status;
    private String message;
    private Object data;
    private String code;//

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessage(List<String> messages){

        String str="";
        for (String message :messages){
            str+=message+"; ";
        }
        this.message=str;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

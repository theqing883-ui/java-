package com.itheima.controller;

public class Result {
    public Integer code;
    private Object date;
    private String message;

    public Result(Integer code, Object date) {
        this.code = code;
        this.date = date;
    }

    public Result(Integer code, Object date, String message) {
        this.date = date;
        this.message = message;
        this.code = code;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

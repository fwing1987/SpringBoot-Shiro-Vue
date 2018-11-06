package com.example.springboot.dto;

public class Result {
    public int code;
    public String message;
    public Object body;

    public Result(){
        code = 20000;
    }
    public Result(int code){
        this.code = code;
    }

}

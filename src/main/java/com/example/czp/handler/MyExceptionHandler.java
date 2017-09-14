package com.example.czp.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
@ControllerAdvice
public class MyExceptionHandler {
    //处理所有Exctption类异常（其实就是所有的异常，因为其他的异常是继承Exception的）
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handle(HttpServletRequest request , Exception e){
        return "服务器繁忙，请稍后再试";
    }
}

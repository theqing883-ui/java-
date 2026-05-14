package com.itheima.controller;

import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException e) {
        System.out.println("捕捉到系统异常"+e.getMessage());
        return new Result(e.getCode(),null,e.getMessage());
    }
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException e) {
        System.out.println("捕捉到业务异常 "+e.getMessage());
        return new Result(e.getCode(),null,e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception e) {
        System.out.println("捕捉到未知异常 " + e.getMessage());
        return new Result(Code.UNKNOW_EXP, null, "出现异常");
    }

}

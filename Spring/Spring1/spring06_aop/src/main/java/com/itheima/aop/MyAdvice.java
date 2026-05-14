package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyAdvice {
    @Pointcut("execution(* com.itheima.dao.BookDao.*())")
    public void pt() {
    }

    @Around("pt()")
    public Object method(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        System.out.println(signature.getDeclaringTypeName() + "." + signature.getName());
        Long times1 = System.currentTimeMillis();
        System.out.println("开始时间 " + times1);
        Object obj = pjp.proceed();
        Long times2 = System.currentTimeMillis();
        System.out.println("结束时间 " + times2);
        System.out.println("用时 " + (times2 - times1) + " 毫秒");
        return obj;
    }
}

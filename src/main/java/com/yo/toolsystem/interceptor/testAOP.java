package com.yo.toolsystem.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Yoy on 2017/5/4.
 */

public class testAOP {

    @Pointcut("execution(public  *  com.yo.toolsystem.controller.*.*(..))")
    public void login(){
    }

    @Before("execution(public  *  com.yo.toolsystem.controller.*.*(..))")
    public void doLogin(){
        System.out.print("session-->");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

    }

}

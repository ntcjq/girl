package com.example.girl.aspect;


import org.aopalliance.intercept.Joinpoint;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.hibernate.mapping.Join;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Component
@Aspect
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.girl.controller.GirlController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void logBefore(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes=  (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest)requestAttributes.getRequest();
        logger.info("url={}",request.getRequestURL());
        logger.info("method={}",request.getMethod());
        logger.info("ip={}",request.getRemoteAddr());
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("agrs={}",joinPoint.getArgs());


    }

    @After("log()")
    public void logAfter(){
        logger.info("after log");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void logAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}

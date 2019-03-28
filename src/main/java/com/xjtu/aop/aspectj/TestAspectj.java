package com.xjtu.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @auther coraljiao
 * @date 2019/3/28 14:23
 * @description
 */
@Component
@Aspect
public class TestAspectj {
    @Pointcut("execution(* com.xjtu.aop..*.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(){
        System.out.println("aop--before");
    }
}

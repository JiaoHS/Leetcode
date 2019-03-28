package com.xjtu.aop;

import com.xjtu.aop.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @auther coraljiao
 * @date 2019/3/28 14:06
 * @description
 */
public class AopTest {
    public static void main(String[] args){
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        annotationConfigApplicationContext.getBean(TestService.class).query();
        //System.out.println(annotationConfigApplicationContext.getBean(TestService.class).getClass().getName());
    }
}

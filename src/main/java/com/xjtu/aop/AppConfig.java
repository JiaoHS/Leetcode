package com.xjtu.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @auther coraljiao
 * @date 2019/3/28 14:08
 * @description
 */
@Configuration
@ComponentScan("com.xjtu.aop")
@EnableAspectJAutoProxy
public class AppConfig {

}

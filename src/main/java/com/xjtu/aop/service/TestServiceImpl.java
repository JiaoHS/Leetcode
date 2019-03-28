package com.xjtu.aop.service;

import org.springframework.stereotype.Component;

/**
 * @auther coraljiao
 * @date 2019/3/28 14:07
 * @description
 */
@Component
public class TestServiceImpl implements TestService {
    @Override
    public void query() {
        System.out.println("test aop");
    }
}

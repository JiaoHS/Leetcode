package com.xjtu.qiuzhao.daili.jingtaitaili;

/**
 * @auther coraljiao
 * @date 2019/9/6 14:57
 * @description
 */
public class CarProxy extends Car {
    @Override
    public void move() {
        System.out.println("日志开始记录....");
        super.move();
        System.out.println("日志结束记录....");
    }
}

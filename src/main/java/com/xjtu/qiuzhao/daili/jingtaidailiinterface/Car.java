package com.xjtu.qiuzhao.daili.jingtaidailiinterface;

/**
 * @auther coraljiao
 * @date 2019/9/6 15:01
 * @description
 */
public class Car implements Moveable {
    @Override
    public void move() {
        System.out.println("汽车行驶中....");
    }
}

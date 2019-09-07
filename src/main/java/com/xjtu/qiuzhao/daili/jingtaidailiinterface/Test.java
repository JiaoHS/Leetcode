package com.xjtu.qiuzhao.daili.jingtaidailiinterface;

/**
 * @auther coraljiao
 * @date 2019/9/6 15:02
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Moveable car = new CarProxy();
        car.move();
    }
}

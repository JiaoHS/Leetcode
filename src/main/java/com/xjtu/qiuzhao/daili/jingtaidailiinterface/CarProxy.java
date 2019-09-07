package com.xjtu.qiuzhao.daili.jingtaidailiinterface;

/**
 * @auther coraljiao
 * @date 2019/9/6 15:01
 * @description
 */
public class CarProxy implements Moveable {
    private Moveable move;

    @Override
    public void move() {
        if (move == null) {
            move = new Car();
        }
        System.out.println("开始记录日志：");
        move.move();
        System.out.println("记录日志结束！");
    }
}

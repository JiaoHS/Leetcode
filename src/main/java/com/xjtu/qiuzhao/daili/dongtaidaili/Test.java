package com.xjtu.qiuzhao.daili.dongtaidaili;

import java.lang.reflect.Proxy;

/**
 * @auther coraljiao
 * @date 2019/9/6 15:08
 * @description
 */
public class Test {
    public static void main(String[] args){
        Moveable move =  (Moveable) Proxy.newProxyInstance(Car.class.getClassLoader(), Car.class.getInterfaces(), new LogHandler(new Car()));
        System.out.println("代理对象:"+move.getClass().getName());
        System.out.println("执行方法:"+move.move());
    }
}

package com.xjtu.qiuzhao.guanchazhemoshi;

/**
 * @auther coraljiao
 * @date 2019/9/6 15:56
 * @description
 */
public class Test {
    public static void main(String[] args) {
        //创建主题(被观察者)
        MagazineSubject magazine = new MagazineSubject();
        //创建三个不同的观察者
        CustomerObserver a = new CustomerObserver("A");
        CustomerObserver b = new CustomerObserver("B");
        CustomerObserver c = new CustomerObserver("C");
        //将观察者注册到主题中
//        magazine.addObserver(a);
//        magazine.addObserver(b);
//        magazine.addObserver(c);

        //更新主题的数据，当数据更新后，会自动通知所有已注册的观察者
        magazine.publish();
    }
}

package com.xjtu.ssmidea.domain;

import java.util.ArrayList;
import java.util.List;

public class demo2 {
    public static final int Const1 = 10;

    public static void main(String[] args) {
        demo();

        new Person("ddd");
        Son s = new Son("gou");
        if (s != null) {

        }
        for (int i = 0; i < 100; i++) {

        }
        for (int i = 100; i > 0; i--) {

        }

        demo3();

    }

    public static void demo3() {
        List<String> list=new ArrayList<>();
        for (String s1 : list) {
            String hhh = "zhangsan";
            String name= hhh;
           int age=24;
            new StringBuilder().append("name: ").append(name).append(" age ").append(age).toString();
            System.out.println("name:" + name + "age" + age);
        }
    }

    private static void demo() {

    }

    /**
     * kjh
     */
    private int age;

    /**
     * hhh
     */
    private String Name;


}

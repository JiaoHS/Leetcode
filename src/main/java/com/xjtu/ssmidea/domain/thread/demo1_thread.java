package com.xjtu.ssmidea.domain.thread;

public class demo1_thread {
    public static void main(String[] args) throws InterruptedException {

        Singlon s1 = Singlon.GetSinglon();
        Singlon s2 = Singlon.GetSinglon();
        System.out.println(s1 == s2);
        //demo();

        //demo2();


//        demo1 demo = new demo1();
//        demo.start();
//
//        runable d2 = new runable();
//        //d2.run();
//        new Thread(d2).start();//将runnable作为参数传给Thred
//
//
//        for (int i = 0; i < 200; i++) {
//            System.out.println("我是主线程");
//        }
    }

    public static void demo2() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            Thread.sleep(1000);
            System.out.println(i + "秒");
        }
    }

    public static void demo() {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println(this.getName());
                for (int i = 0; i < 2; i++) {
                    System.out.println("我是继承thread线程");
                }
            }
        };

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 20; i++) {
                    System.out.println("我是实现runnable线程");
                }
            }
        });
        t2.setDaemon(true);
        t1.start();
        t2.start();
    }


}

class demo1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("我是新县城");
        }
    }
}

class runable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("runbable");
        }
    }
}


class Singlon {
    private void Singlon() {

    }

    public static Singlon s;

    public static Singlon GetSinglon() {
        return s;
    }
}

class Singlon2 {
    private void Singlon2() {

    }

    public static Singlon s;

    public static Singlon GetSinglon() {
        if (s == null) {
            s = new Singlon();
        }
        return s;
    }
}

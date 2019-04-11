package com.xjtu.ssmidea.jianzhioffer;

import java.util.HashMap;

/**
 * @auther coraljiao
 * @date 2019/4/10 10:22
 * @description
 */
public class day06 {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n1;  //构造一个带环的链表,去除此句表示不带环

        System.out.println(hasLoop(n1));
        System.out.println(hasLoop2(n1));
        System.out.println(hasLoop3(n1));
    }

    public static boolean hasLoop(Node n) {
        //定义两个指针tmp1,tmp2
        Node tmp1 = n;
        Node tmp2 = n.next;

        while (tmp2 != null) {
            tmp1 = tmp1.next;  //每次迭代时，指针1走一步，指针2走两步
            tmp2 = tmp2.next.next;
            if (tmp2 == null) return false;//不存在环时，退出
            int d1 = tmp1.val;
            int d2 = tmp2.val;
            if (d1 == d2) return true;//当两个指针重逢时，说明存在环，否则不存在。

        }
        return true; //如果tmp2为null，说明元素只有一个，也可以说明是存在环
    }

    //方法2：将每次走过的节点保存到hash表中，如果节点在hash表中，则表示存在环
    public static boolean hasLoop2(Node n) {
        Node temp1 = n;
        HashMap<Node, Node> ns = new HashMap<Node, Node>();
        while (n != null) {
            if (ns.get(temp1) != null) return true;
            else ns.put(temp1, temp1);
            temp1 = temp1.next;
            if (temp1 == null) return false;
        }
        return true;
    }

    public static boolean hasLoop3(Node n) {
        Node temp = n;
        HashMap<Node, Node> hashMap = new HashMap<>();
        while (n != null) {
            if (hashMap.get(temp) != null) return true;
            else {
                hashMap.put(temp, temp);
            }
            temp = temp.next;
            if (temp == null) return false;
        }
        return true;
    }
}

//饿汉式
class Sington1 {
    private final static Sington1 SINGTON_1 = new Sington1();

    private Sington1() {
    }

    public Sington1 getSington1() {
        return SINGTON_1;
    }
}

//懒汉式
class Sington2 {
    private static Sington2 SINGTON_2;

    private Sington2() {
    }

    public Sington2 getSington2() {
        if (SINGTON_2 == null) {
            SINGTON_2 = new Sington2();
        }
        return SINGTON_2;
    }
}

//改进1
class Sington3 {
    private static Sington3 sington3;

    private Sington3() {
    }

    public static Sington3 getSington3() {
        if (sington3 == null) {
            synchronized (Sington3.class) {
                sington3 = new Sington3();
            }
        }
        return sington3;
    }
}

//改进2
class Sington4 {
    private static volatile Sington4 sington4;

    private Sington4() {
    }

    public static Sington4 getSington4() {
        if (sington4 == null) {
            synchronized (Sington4.class) {
                if (sington4 == null) {
                    sington4 = new Sington4();
                }
            }
        }
        return sington4;
    }
}

//静态内部类
class Singlton5 {
    private Singlton5() {
    }

    private static class SingtonINstance {
        private final static Singlton5 SINGTON_I_NSTANCE = new Singlton5();
    }

    public Singlton5 getSington5() {
        return SingtonINstance.SINGTON_I_NSTANCE;
    }
}

enum Sington6 {
    INSTANC;
}

package com.xjtu.ssmidea.algorithm;

import sun.awt.Mutex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @auther coraljiao
 * @date 2019/3/26 10:38
 * @description
 */
public class day012 {
    private static CyclicBarrier barrier = new CyclicBarrier(31);
    private static int a = 0;
    private static Mutex mutex = new Mutex();

    //IntBuffer buffer=new IntBuffer(4);

    public static void main(String[] args) throws Exception {
        //test();

    }

    public static void test() throws InterruptedException, BrokenBarrierException {
        //说明:我们启用30个线程，每个线程对i自加10000次，同步正常的话，最终结果应为300000；
        //未加锁前
        for (int i = 0; i < 30; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increment1();//没有同步措施的a++；
                    }
                    try {
                        barrier.await();//等30个线程累加完毕
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
        barrier.await();
        System.out.println("加锁前，a=" + a);
        //加锁后
        barrier.reset();//重置CyclicBarrier
        a = 0;
        for (int i = 0; i < 30; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increment2();//a++采用Mutex进行同步处理
                    }
                    try {
                        barrier.await();//等30个线程累加完毕
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        barrier.await();
        System.out.println("加锁后，a=" + a);
    }

    public static void increment1() {
        a++;
    }

    /**
     * 63      * 使用自定义的Mutex进行同步处理的a++
     * 64
     */
    public static void increment2() {
        mutex.lock();
        a++;
        mutex.unlock();
    }

    //数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
    public int MoreThanHalfNum_Solution(int[] array) {
        int len = array.length;
        if (len < 1) {
            return 0;
        }
        int count = 0;
        Arrays.sort(array);
        int num = array[len / 2];
        for (int i = 0; i < len; i++) {
            if (num == array[i])
                count++;
        }
        if (count <= (len / 2)) {
            num = 0;
        }
        return num;
    }
    //输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        if(input.length < k || k == 0)
            return list;

        for (int i = 0; i < k; i++)
            list.add(input[i]);

        for (int i = k; i < input.length; i++) {
            int j = this.getMax(list);
            int temp = (Integer) list.get(j);
            if (input[i] < temp)
                list.set(j, input[i]);
        }
        return list;
    }
    public int getMax(ArrayList<Integer> list) {
        int max = list.get(0);
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                j = i;
            }
        }
        return j;
    }
}

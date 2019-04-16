package com.xjtu.ssmidea.jianzhioffer;

/**
 * @auther coraljiao
 * @date 2019/4/16 19:00
 * @description
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spirit on 2017/1/23.
 * //给定一定的金额，一定的人数，保证每个人都能随机获得一定的金额。
 * //比如100元的红包，10个人抢，每人分得一些金额。约束条件为，最佳手气金额不能超过最大金额的90%。
 */
public class day09 {
    //红包最小值
    private static final float MINVALUE = 0.01F;
    //红包最大值
    private static float MAXVALUE = 0.01F;

    /**
     * 这里为了避免某一个红包占用大量资金，我们需要设定非最后一个红包的最大金额，我们把他设置为红包金额平均值的N倍；
     */
    private static final float TIMES = 2.1F;

    /**
     * 判断红包是否合情理
     *
     * @param money
     * @param count
     * @return
     */
    public boolean isRight(float money, int count) {
        float avg = money / count;

        if (avg < MINVALUE) {
            return false;
        } else if (avg > MAXVALUE) {
            return false;
        }
        return true;
    }

    /**
     * 分红包核心算法
     *
     * @param money
     * @param minS
     * @param maxS
     * @param count
     * @return
     */
    public float randomRedPacket(float money, float minS, float maxS, int count) {
        //当人数剩余一个时，把当前剩余全部返回
        if (count == 1) {
            return money;
        }
        //如果当前最小红包等于最大红包，之间返回当前红包
        if (minS == maxS) {
            return minS;
        }
        float max = maxS > money ? money : maxS;
        //随机产生一个红包
        float one = (float) (Math.random() * (max - minS) + minS);
        float balance = money - one;
        //判断此次分配后，后续是否合理
        if (isRight(balance, count - 1)) {
            return one;
        } else {
            //重新分配
            float avg = balance / (count - 1);
            //如果本次红包过大，导致下次不够分，走这一条
            if (avg < MINVALUE) {
                return randomRedPacket(money, minS, one, count);
            } else {
                return randomRedPacket(money, one, maxS, count);
            }
        }
    }

    /**
     * 分红包
     *
     * @param money
     * @param count
     * @return
     */
    public List<Float> spiltRedPackets(float money, int count) {
        MAXVALUE = money * 0.9F;
        //首先判断红包是否合情理
        if (!isRight(money, count)) {
            return null;
        }

        List<Float> list = new ArrayList<Float>();
        //TIMES这里为了避免某一个红包占用大量资金，我们需要设定非最后一个红包的最大金额，我们把他设置为红包金额平均值的N倍
        float max = money / count * TIMES;
        max = max > money ? money : max;
        for (int i = 0; i < count; i++) {
            float value = randomRedPacket(money, MINVALUE, max, count - i);
            list.add(value);
            money -= value;
        }
        return list;
    }

    public static void main(String[] args) {
        day09 red = new day09();
        float money = 100F;
        int count = 10;
        MAXVALUE = money * 0.9F;
//        for (int i = 0; i < 100; i++) {
//            List<Float> temp = red.spiltRedPackets(money, count);
//            for (int j = 0; j < temp.size(); j++) {
//                if (temp.get(j) > MAXVALUE) {
//                    System.out.println(temp.get(j) + ":" + j);
//                }
//            }
//            System.out.println(i);
//        }
        System.out.println(red.spiltRedPackets(money, count));
    }
}

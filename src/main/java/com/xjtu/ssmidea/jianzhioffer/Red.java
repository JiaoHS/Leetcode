package com.xjtu.ssmidea.jianzhioffer;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: spring
 * @description:
 * @author: seven
 * @create: 2019/04/16 19:20
 **/
public class Red {

    public static boolean isRight(float money, int count, float minS, float maxS) {
        float avg = money / count;
        if (avg < minS || avg > maxS) {
            return false;
        }
        return true;
    }

    public static float randomRedPacket(float money, float minS, float maxS, int count) {
        if (count == 1) {
            return money;
        }
        if (minS == maxS) {
            return minS;
        }
        float max = maxS > money ? money : maxS;
        float one = (float) (Math.random() * (max - minS) + minS);
        float balance = money - one;
        if (isRight(balance, count - 1, minS, maxS)) {
            return one;
        } else {
            float avg = balance / (count - 1);
            if (avg < minS) {
                return randomRedPacket(money, minS, one, count);
            } else {
                return randomRedPacket(money, one, maxS, count);
            }
        }
    }

    public static List<Float> spiltRedPackets(float money, int count) {
        float minS = 0.01F;
        float maxS = money * 0.9F;
        if (!isRight(money, count, minS, maxS)) {
            return null;
        }
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        List<Float> list = new ArrayList<>();
        while (count != 0) {
            float value = randomRedPacket(money, minS, maxS, count);
            value = Float.valueOf(decimalFormat.format(value));
            list.add(value);
            money -= value;
            count--;
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(spiltRedPackets(100, 10));

//        day09 red = new day09();
//        float money = 5F;
//        int count = 3;
//        for (int i = 0; i < 10000; i++) {
//            List<Float> temp = red.spiltRedPackets(money, count);
//            for (int j = 0; j < temp.size(); j++) {
//                if (temp.get(j) > 90) {
//                    System.out.println(temp.get(j) + ":" + j);
//                }
//            }
//            //System.out.println(i);
//        }
    }
}

package com.xjtu.ssmidea.jianzhioffer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

/**
 * @program: spring
 * @description:
 * @author: seven
 * @create: 2019/04/16 18:49
 **/
public class HongBao {
    public static void main(String[] args) {
        ArrayList<Double> random = random(100, 10);
        for (Double aDouble : random) {
            System.out.println(aDouble);
        }
    }

    public static ArrayList<Double> random(double sum, int count) {
        ArrayList<Double> arrayList = new ArrayList<>();
        Random random = new Random();
        double max = sum;
        while (count != 1) {
            double tmp = new BigDecimal(random.nextDouble() * sum).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (tmp > max * 0.9) {
                continue;
            }
            if (sum - tmp <= 0) {
                continue;
            }
            if (tmp <= 0.000006) {
                continue;
            }
            arrayList.add(tmp);
            sum -= tmp;
            count--;
        }
        arrayList.add(new BigDecimal(sum).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        return arrayList;
    }
}

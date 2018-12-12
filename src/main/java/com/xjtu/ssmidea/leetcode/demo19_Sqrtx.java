package com.xjtu.ssmidea.leetcode;

public class demo19_Sqrtx {
    public static void main(String[] args) {
        int demo = 8;
        int res = mySqrt(demo);
        System.out.println(res);
    }

    private static int mySqrt(int demo) {

        return (int) Math.floor(Math.sqrt(demo));
    }
}

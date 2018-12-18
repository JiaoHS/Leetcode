package com.xjtu.ssmidea.leetcode;

public class demo37_ValidPerfectSquare {
    public static void main(String[] args) {
        int num = 7;
        boolean square = isPerfectSquare2(num);
        System.out.println(square);
    }

    private static boolean isPerfectSquare2(int num) {
        if (num == 0 || num == 1) return true;
        int left = 0, right = num / 2;
        while (left <= right) {
            long mid = (left + right) / 2;
            long val = mid * mid;
            if (val == num) return true;
            if (val > num) right = (int) mid - 1;
            if (val < num) left = (int) mid + 1;
        }
        return false;
    }

    public static boolean isPerfectSquare(int num) {
        //不使用sqrt情况下，有恒等式：
        //1+3+5+…+(2*n-1) = n^2
        for (int i = 1; num > 0; i += 2) {
            num -= i;
        }
        return num == 0;
    }
}

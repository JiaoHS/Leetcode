package com.xjtu.ssmidea.leetcode2;

/**
 * @auther coraljiao
 * @date 2018/12/27 14:14
 * @description 阵列产品除自我
 * 给定n个整数的数组n其中n> 1，返回一个数组输出，使得output [i]等于除nums [i]之外的所有nums元素的乘积
 * 思路：先循环求左边的乘积和，再循环乘以右边的乘积和
 */
public class demo02_ProductofArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = productExceptSelf3(nums);
        for (int re : res) {
            System.out.println(res);
        }
    }

    private static int[] productExceptSelf3(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }

    private static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = sum(nums);
        }
        return nums;
    }

    private static int sum(int[] nums) {
        int sum = 0;
        int temp = 0;
        System.out.println(Integer.parseInt("a"));
        for (int i = 0; i < nums.length; i++) {
            if (temp == 0) {

            }
        }
        return sum;
    }
}

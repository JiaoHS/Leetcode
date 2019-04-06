package com.xjtu.ssmidea.jianzhioffer;

/**
 * @auther coraljiao
 * @date 2019/4/2 19:54
 * @description
 */
public class day03 {
    public static void main(String[] args) {
        int[] nums = {8, 1, 4, 7, 5};
        sort001(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    private static void sort001(int[] nums) {
        sort002(nums, 0, nums.length - 1);
    }

    private static void sort002(int[] nums, int left, int right) {
        if (left > right) return;
        int i = left, j = right;
        int temp = nums[left];
        while (i < j) {
            while (i < j && nums[j] >= temp) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= temp) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = temp;
        sort002(nums, left, i - 1);
        sort002(nums, i + 1, right);
    }

}

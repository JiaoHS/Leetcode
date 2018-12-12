package com.xjtu.ssmidea.leetcode;

import java.util.Arrays;

public class demo24_ReversePairs {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 1};
        int res = reversePairs(nums);
        System.out.println(res);
    }

    //给定一个数组nums，如果i <j且nums [i]> 2 * nums [j]，我们称（i，j）为一个重要的反向对。
    //您需要返回给定数组中重要反向对的数量
    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    private static int mergeSort(int[] nums, int s, int e){
        if(s>=e) return 0;
        int mid = s + (e-s)/2;
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e);
        for(int i = s, j = mid+1; i<=mid; i++){
            while(j<=e && nums[i]/2.0 > nums[j]) j++;
            cnt += j-(mid+1);
        }
        Arrays.sort(nums, s, e+1);
        return cnt;
    }
}

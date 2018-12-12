package com.xjtu.ssmidea.leetcode;

public class demo15_MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //System.out.println(maxSubArray(nums));
        //System.out.println(maxSubArry2(nums));
        //System.out.println(maxSubArray3(nums));
        System.out.println(maxSubArray4(nums));
    }

    private static int maxSubArray4(int[] nums) {
        int curMax = nums[0];
        int globalMax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            globalMax = Math.max(globalMax, curMax);
        }
        return globalMax;
    }

    private static int maxSubArray3(int[] nums) {
        int maxNum = nums[0];
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num += nums[i];
            if (num < nums[i]) {
                num = nums[i];
            }
            maxNum = Math.max(num, maxNum);
        }
        return maxNum;
    }

    private static int maxSubArry2(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            //累加值和当前的比大小，取大的赋值给变量maxnum
            sum += nums[i];
            if (sum <= nums[i]) {
                sum = nums[i];
            }
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    private static int maxSubArray(int[] nums) {
        if (nums.length > 0 && nums.length == 1) return nums[0];
        int maxSoFar = nums[0];//总体目前
        int maxEndingHere = nums[0];//当前
        for (int i = 1; i < nums.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}

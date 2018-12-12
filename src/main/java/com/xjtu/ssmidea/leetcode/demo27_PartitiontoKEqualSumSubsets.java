package com.xjtu.ssmidea.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class demo27_PartitiontoKEqualSumSubsets {
    public static void main(String[] args) {
        int[] nums = {4, 4, 6, 2, 3, 8, 10, 2, 10, 7};
        int k = 4;
        boolean flag = canPartitionKSubsets2(nums, k);
        System.out.println(flag);
    }

    private static boolean canPartitionKSubsets2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return false;
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0 || sum < k) return false;
        sum = sum / k;//每个组的和  总数除以 组数
        return possible(nums, sum, new int[k], nums.length - 1);
    }

    private static boolean possible(int[] nums, int sum, int[] p, int idx) {
        if (idx == -1) {
            // for (int s : p) System.out.print(s + " ");
            //System.out.println();
            for (int s : p) if (s != sum) return false;//如果k个组合中的某一个不等于每个组的和 就false  不停的更新k个组合的数组
            return true;
        }

        int num = nums[idx];//排序后最大的数
        //大小等于4的数组里每个位置相加等于sum的时候
        for (int i = 0; i < p.length; i++) {
            if (p[i] + num <= sum) {//最大的数
                p[i] += num;
                if (possible(nums, sum, p, idx - 1)){
                    return true;
                }
                p[i] -= num;
            }
        }
        return false;
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        if (k < 1 || k > 16 || nums.length > 16 || nums.length < 0) return false;
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 10000 || nums[i] < 0) return false;
            sum += nums[i];
            list.add(nums[i]);
        }
        Collections.sort(list);
        //1 2 2 3 3 4 5
        int groupsum = sum / k;//每个组的总和
        int count = 0;
        for (int j = list.size() - 1; j >= 0; j--) {
            if (list.get(j) > groupsum) {
                return false;
            } else if (list.get(j) == groupsum) {
                list.remove(j);
                count++;
            } else {
                for (int z = 0; z < list.size(); z++) {
                    if (list.get(j) + list.get(z) == groupsum) {
                        count++;
                        list.remove(j);
                        list.remove(z);
                        j--;
                        break;
                    }
                }
            }
        }
        return count == k;
    }
}

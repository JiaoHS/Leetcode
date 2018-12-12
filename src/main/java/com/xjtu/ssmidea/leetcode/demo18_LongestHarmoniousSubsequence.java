package com.xjtu.ssmidea.leetcode;

import java.util.Arrays;
import java.util.TreeMap;

public class demo18_LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        int[] nums = {0,3,0,0,1,1,1,3,1,3,2,3,2,3,-1,0,2,1,0,0,0,1,3,3,-3,3,3,1,3};
        //int res = findLHS(nums);
        int res = findLHS2(nums);
        System.out.println(res);
    }

    private static int findLHS2(int[] nums) {
        int len = 0;
        int max = 0;
        Arrays.sort(nums);
        int i = 0, j = 0;
        while(i < nums.length && j < nums.length){
            if(nums[j] - nums[i] == 1){
                j++;
                max = Math.max(max, j - i);
            }else if(nums[j] == nums[i]){
                j++;
            }else{
                i++;
            }
        }
        return max;
//        Map<Integer,Integer> map = new HashMap<>();
//
//        int res = 0;
//
//        for(int i = 0; i < nums.length; i++){
//            if(map.containsKey(nums[i])){
//
//                map.put(nums[i],map.get(nums[i])+1);
//            }
//            else
//                map.put(nums[i],1);
//        }
//
//        for (int key : map.keySet()) {
//            if (map.containsKey(key + 1))
//                res = Math.max(res, map.get(key) + map.get(key + 1));
//        }
//        return res;
    }

    private static int findLHS(int[] nums) {
        int temp = 0, res = 0, res1 = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        if (map.size() == 1 || map.size() == 0) {
            return 0;
        }
        temp=map.firstKey();
        for (Integer index : map.keySet()) {
            if (Math.abs(index - temp) == 1) {
                res = map.get(index) + map.get(temp);
            }
            temp = index;
            res1 = Math.max(res, res1);
        }
        return res1;
    }
}

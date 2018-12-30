package com.xjtu.ssmidea.leetcode2;


import java.util.HashMap;
import java.util.Map;

/**
 * @auther coraljiao
 * @date 2018/12/30 18:44
 * @description
 */
//给定一个整数数组，返回两个数字的索引，使它们相加到特定目标。 您可以假设每个输入只有一个解决方案，并且您可能不会两次使用相同的元素。
public class demo08_TwoSum {
    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        int  target = 9;
        int[] res=twoSum2(nums,target);
        for (int re : res) {
            System.out.println(re);
        }
    }

    private static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static int[] twoSum(int[] nums, int target) {
        int temp1=0;
        int temp2=0;
        int size=2;
        int[] index=new int[size];
        for(int i=0 ;i<nums.length;i++){
            temp1=nums[i];
            temp2=target-temp1;
            if(temp2>temp1){
                //右侧循环
                for(int j=i ;j<nums.length-i;j++){
                    if(nums[j]==temp2){
                        index[0]=j;
                    }
                }
            }else{
                //左侧循环
                for(int k=0 ;k<i;k++){
                    if(nums[k]==temp2){
                        index[1]=i;
                    }
                }
            }
        }
        return index;
    }
}

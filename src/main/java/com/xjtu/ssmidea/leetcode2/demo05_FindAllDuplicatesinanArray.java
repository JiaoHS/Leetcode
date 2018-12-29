package com.xjtu.ssmidea.leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther coraljiao
 * @date 2018/12/28 20:10
 * @description
 */
public class demo05_FindAllDuplicatesinanArray {
    public static void main(String[] args){
        int[] nums={4,3,2,7,8,2,3,1};
        List<Integer> list = findDuplicates4(nums);
        System.out.println(list.get(0));

    }

    private static List<Integer> findDuplicates4(int[] nums) {
        List<Integer>  result = new ArrayList();
        if(nums == null || nums.length == 0) {
            return result;
        }

        int[] count  = new int[nums.length+1];

        for(int i = 0; i< nums.length; i++) {
            if(count[nums[i]] == 1) {
                result.add(nums[i]);
            } else {
                count[nums[i]]++;
            }
        }
        return result;
    }

    private static List<Integer> findDuplicates3(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++)
        {
            int k = nums[i] > 0 ? nums[i] : -nums[i];
            if(nums[k - 1] > 0)
                nums[k - 1] = -nums[k - 1];
            else
            {
                ret.add(nums[i] > 0 ? nums[i] : -nums[i]);
            }
        }

        return ret;
    }

    private static List<Integer> findDuplicates2(int[] nums) {
        //4,3,2,7,8,2,3,1
        List<Integer> res = new ArrayList<>();
        int value=0;
        for(int i=0;i<nums.length;i++){
            value=Math.abs(nums[i])-1;
            if(nums[value]<0){
                res.add(value+1);
            }else{
                nums[value] = nums[value]*-1;
            }
        }
        return res;
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (Integer key : map.keySet()) {
            if(map.get(key)==2){
                list.add(key);
            }
        }
        return list;
    }
}

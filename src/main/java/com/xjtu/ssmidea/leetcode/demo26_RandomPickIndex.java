package com.xjtu.ssmidea.leetcode;

import java.util.Random;

public class demo26_RandomPickIndex {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        Solution solution = new Solution(nums);
        int res = solution.pick(3);
        System.out.println(res);
    }
}

class Solution {
    int[] nums;
    Random rnd;
//    Map<Integer, List<Integer>> map = new HashMap<>();
//    private static Random random = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
//        for (int i = 0; i < nums.length; i++) {
//            List<Integer> list = new ArrayList<>();
//            if (map.containsKey(nums[i])) {
//                list = map.get(nums[i]);
//                list.add(i);
//            } else {
//                list.add(i);
//            }
//            map.put(nums[i], list);
//        }
    }

    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (rnd.nextInt(++count) == 0)
                result = i;
        }

        return result;
//        if (map.containsKey(target)) {
//            List<Integer> list = map.get(target);
//            if (list.size() == 1) {
//                return list.get(0);
//            } else {
//                int max = list.get(list.size() - 1);
//                int min = list.get(0);
//                return random.nextInt(max) % (max - min + 1) + min;
//            }
//
//        } else {
//            return -1;
//        }
    }
}


//class Solution {
//    int[] arr;
//    public Solution(int[] nums) {
//        arr = new int[nums.length];
//        for(int i=0; i<nums.length; i++)
//            arr[i] = nums[i];
//    }
//
//    public int pick(int target) {
//        ArrayList<Integer> list = new ArrayList<>();
//        // put all target indexes in a list then get random index from the list
//        for(int i=0; i<arr.length; i++){
//            if(arr[i] == target)
//                list.add(i);
//        }
//
//        if(list.size() == 0)
//            return -1;
//        else{
//            // Math.random() returns 0.0-1.0
//            int random = (int) (Math.random() * list.size());
//            return list.get(random);
//        }
//    }
//}


//class Solution {
//
//    private int[] nums;
//    private Random random;
//
//    public Solution(int[] nums) {
//        this.nums = nums;
//        random = new Random();
//    }
//
//    public int pick(int target) {
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        for(int i =0;i<nums.length;i++)
//        {
//            if(nums[i] == target)
//                list.add(i);
//        }
//        int index =random.nextInt(list.size());
//        return list.get(index);
//    }
//}

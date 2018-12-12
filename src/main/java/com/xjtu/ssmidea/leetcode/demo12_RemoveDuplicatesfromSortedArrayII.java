package com.xjtu.ssmidea.leetcode;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demo12_RemoveDuplicatesfromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int res = removeDuplicates(nums);
        System.out.println(res);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static int removeDuplicates(int[] nums) {
        //demo1();
        //demo2();


        List<Integer> list = getIntNum(nums);

        return list.size();
    }

    public static void demo2() {
        //        iter
//        int i = 0;
//        for (int n : nums) {
//            if (i < 2 || n > nums[i - 2]) {
//                nums[i] = n;
//                i++;
//            }
//        }
//
//        return i;
    }

    public static void demo1() {
        File file2 = new File("F:\\data.txt");
        long l = file2.length();
        boolean b = file2.exists();
        System.out.println(l);
        System.out.println(b);
        try {
            FileInputStream file = new FileInputStream("F:\\data.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Integer> getIntNum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (map != null && map.size() > 0 && map.containsKey(nums[i]) && map.get(nums[i]) >= 2) {
                delete(i, nums);
                i--;
                continue;
            }
            list.add(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return list;
    }

    public static int[] delete2(int index, int array[]) {
        //数组的删除其实就是覆盖前一位
        int[] arrNew = new int[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            if (i < index) {
                arrNew[i] = array[i];
            } else {
                arrNew[i] = array[i + 1];
            }
        }
        return arrNew;
    }

    public static int[] delete(int index, int array[]) {
        //数组的删除其实就是覆盖前一位
        int[] arrNew = new int[array.length - 1];
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        System.arraycopy(array, 0, arrNew, 0, arrNew.length);
        return arrNew;
    }
}

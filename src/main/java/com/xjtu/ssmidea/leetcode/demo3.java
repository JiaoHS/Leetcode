package com.xjtu.ssmidea.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class demo3 {
    /*
        * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

    Each letter in the magazine string can only be used once in your ransom note.

    Note:
    You may assume that both strings contain only lowercase letters.
    canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
    *
    * */
    public static void main(String[] args) {
//        boolean flag = canConstruct("aac", "aab");
//        System.out.println(flag);

        //test();
    }

    /**
     * 二分查找，找到该值在数组中的下标，否则为-1
     */
    public static int binarySerach(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    //查找第一个与key相等的元素
    // 查找第一个相等的元素
    static int findFirstEqual(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < array.length && array[left] == key) {
            return left;
        }
        return -1;
    }
    //查找最后一个与key相等的元素
    // 查找最后一个相等的元素
    static int findLastEqual(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] <= key) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        if (right >= 0 && array[right] == key) {
            return right;
        }

        return -1;
    }
    //查找最后一个等于或者小于key的元素
    // 查找最后一个等于或者小于key的元素
    static int findLastEqualSmaller(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return right;
    }
    //查找最后一个小于key的元素
    static int findLastSmaller(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return right;
    }
    // 查找第一个等于或者大于key的元素
    static int findFirstEqualLarger(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
    // 查找第一个大于key的元素
    static int findFirstLarger(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void test() {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        //用户输入10个整数
        System.out.println("请输入10个整数：");
        for (int i = 0; i < 10; i++) {
            list.add(scan.nextInt());
        }
        scan.close();

        //逆序排序
        Collections.sort(list, Collections.reverseOrder());

        //输出排序结果
        System.out.println(list);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        boolean flag = true;
        for (int i = 0; i < magazine.length(); i++) {
            map[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            map[ransomNote.charAt(i) - 'a']--;
            if (map[ransomNote.charAt(i) - 'a'] < 0) {
                //ans = ransomNote.charAt(i);
                flag = false;
            }
        }
        return flag;
    }
}

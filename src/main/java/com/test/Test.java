package com.test;

import com.xjtu.ssmidea.jianzhioffer.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther coraljiao
 * @date 2020/4/3 14:11
 * @description
 */
public class Test {
    public static void main(String[] args) {
        int[] num = {4, 1, 2, 6, 9, 10};
        quickSort(num);
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }

    //一个二维数组，每一列和每一行都是有序的，判断给定值在不在二维数组内
    public boolean find(int[][] array, int target) {
        int rows = array.length, cols = array[0].length;
        int i = rows - 1, j = 0;
        while (i >= 0 && j < cols) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }

    //手写快排
    public static void quickSort(int[] array) {
        quickSort1(array, 0, array.length - 1);
    }

    private static void quickSort1(int[] array, int left, int right) {
        if (left > right) return;
        int i = left, j = right;
        int temp = array[left];
        while (i != j) {
            while (i < j && temp <= array[j]) {
                j--;
            }
            array[i] = array[j];
            while (i < j && array[i] <= temp) {
                i++;
            }
            array[j] = array[i];
        }
        array[i] = temp;
        quickSort1(array, left, i - 1);
        quickSort1(array, i + 1, right);
    }

    //给三个int，分别是年，月，日，返回值是这一年的第几天
    //（1）若某个年份能被4整除但不能被100整除，则是闰年。
    //（2）若某个年份能被400整除，则也是闰年。
    public static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static int whichDay(int year, int month, int day) {
//        int res = 0;
//        for (int i = 1; i < month; i++) {
//            res += days[i - 1];
//        }
//        if (month >= 2 && runnian(year)) {
//            res++;
//        }
//        return res + day;

        //int day = 0;
        for (int i = 1; i < month; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    day = day + 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    day = day + 30;
                    break;
                case 2:
                    if (((year % 4 == 0) & (year % 100 != 0)) | (year % 400 == 0))
                        day += 29;
                    else day += 28;
            }
        }
        return day + day;
    }

    private static boolean runnian(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }

    //从二叉树的右边看得到的序列java
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> lilst = new ArrayList<>();
        rightView(root, lilst, 0);
        return lilst;
    }

    private void rightView(TreeNode root, List<Integer> lilst, int i) {
        if (root == null) return;
        if (i == lilst.size()) {
            lilst.add(root.val);
        }
        rightView(root.right, lilst, i + 1);
        rightView(root.left, lilst, i + 1);
    }
}

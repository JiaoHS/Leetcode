package com.xjtu.ssmidea.algorithm;

/**
 * @auther coraljiao
 * @date 2019/3/4 10:15
 * @description 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class 二维数组查找 {
    public static void main(String[] args) {
        int num=4;

//        int[][] arr = {{1,2,3,4}, {5,6,7,8}};
//        boolean b = find(arr, 3);
//        System.out.println(b);
    }

    private static boolean find(int[][] arr, int target) {
        int len = arr.length - 1;
        int i = 0;
        while ((len >= 0) && (i < arr[0].length)) {
            if (arr[len][i] > target) {
                len--;
            } else if (arr[len][i] < target) {
                i++;
            } else {
                System.out.println(i);
                return true;
            }
        }
        return false;
    }
}

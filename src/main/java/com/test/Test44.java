package com.test;

import java.util.ArrayList;

/**
 * @auther coraljiao
 * @date 2020/4/4 10:45
 * @description
 */
public class Test44 {
    public static void main(String[] args) {
        int[] num1 = {10, 6, 8, 17, 1};
//        int[] num2 = {2, 4, 6, 9};
//        int[] merge = merge(num1, num2);
//        for (int i = 0; i < merge.length; i++) {
//            System.out.println(merge[i]);
//        }

        insertSort(num1);
        for (int i = 0; i < num1.length; i++) {
            System.out.println(num1[i]);
        }
    }

    public static int[] merge(int[] num1, int[] num2) {
        int[] num3 = new int[num1.length + num2.length];

        int i = 0, j = 0, k = 0;
        while (i < num1.length && j < num2.length) {
            if (num1[i] < num2[j]) {
                num3[k++] = num1[i++];
            } else {
                num3[k++] = num2[j++];
            }
        }
        while (i < num1.length) {
            num3[k++] = num1[i++];
        }

        while (j < num2.length) {
            num3[k++] = num2[j++];
        }
        return num3;
    }

    public static void insertSort(int[] num1) {
        for (int i = 1; i < num1.length; i++) {
            int temp = num1[i];
            int leftindex = i - 1;
            while (leftindex >= 0 && num1[leftindex] > temp) {
                num1[leftindex + 1] = num1[leftindex];
                leftindex--;
            }
            num1[leftindex + 1] = temp;
        }
    }
    //ababaaabccd 存在文本文件
    // 算法  快排优化  对比  联盟开发部 平台性质 业务项目 纯后端 java 聚屏 大屏 网盟的一部分
}

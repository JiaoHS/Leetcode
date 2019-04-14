package com.xjtu.ssmidea.jianzhioffer;

/**
 * @auther coraljiao
 * @date 2019/4/12 21:10
 * @description
 */
public class day08 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 2, 9};
        sort01(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void sort081(int[] arr) {
        sort082(arr, 0, arr.length - 1);
    }

    private static void sort082(int[] arr, int left, int right) {
        if (left > right) return;
        int i = left, j = arr.length - 1;
        int temp = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= temp) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] <= temp) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = temp;
        sort082(arr, left, i - 1);
        sort082(arr, i + 1, right);
    }

    //快排
    public static void sort01(int[] arrs) {
        sort02(arrs, 0, arrs.length - 1);
    }

    private static void sort02(int[] arrs, int left, int right) {
        if (left > right) return;
        int i = left, j = arrs.length - 1;
        int temp = arrs[i];
        while (i < j) {
            while (i < j && arrs[j] >= temp) {
                j--;
            }
            arrs[i] = arrs[j];
            while (i < j && arrs[i] <= temp) {
                i++;
            }
            arrs[j] = arrs[i];
        }
        arrs[i] = temp;
        sort02(arrs, left, i - 1);
        sort02(arrs, i + 1, right);
    }
}

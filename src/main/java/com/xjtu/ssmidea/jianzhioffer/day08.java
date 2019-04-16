package com.xjtu.ssmidea.jianzhioffer;

/**
 * @auther coraljiao
 * @date 2019/4/12 21:10
 * @description
 */
public class day08 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 2, 9};
        sort053(arr);
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

    //
    //归并排序
    private static void sort053(int[] arrs) {
        int[] temp = new int[arrs.length];
        sort054(arrs, 0, arrs.length - 1, temp);
    }

    private static void sort054(int[] arrs, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort054(arrs, left, mid, temp);
            sort054(arrs, mid + 1, right, temp);
            merge052(arrs, left, mid, right, temp);
        }
    }

    private static void merge052(int[] arrs, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arrs[i] < arrs[j]) {
                temp[t++] = arrs[i++];
            } else {
                temp[t++] = arrs[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arrs[i++];
        }
        while (j <= right) {
            temp[t++] = arrs[j++];
        }
        t = 0;
        while (left <= right) {
            arrs[left++] = temp[t++];
        }
    }

    //给定一定的金额，一定的人数，保证每个人都能随机获得一定的金额。
    //比如100元的红包，10个人抢，每人分得一些金额。约束条件为，最佳手气金额不能超过最大金额的90%。


}

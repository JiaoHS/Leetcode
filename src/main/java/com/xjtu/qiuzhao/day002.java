package com.xjtu.qiuzhao;

/**
 * @auther coraljiao
 * @date 2019/9/6 10:30
 * @description
 */
public class day002 {
    public static void main(String[] args) {
        int[] arr = {3, 1,  6, 9};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

//        int[][] arrs = {{1, 3}, {4, 6}, {2, 9}};
//        int target = 4;
//        boolean b = isContain(arrs, target);
    }

    private static boolean isContain(int[][] arrs, int target) {
        if (arrs.length == 0 | arrs[0].length == 0) return false;
        int rows = arrs.length - 1;
        int cols = arrs[0].length - 1;

        return false;
    }
    //判断一个有序二维数组是否包含某一个整数
    //剑指offer的思路.就是比较矩阵的右上角的数与target的大小，如果target比这个矩阵右上角的数大，由于矩阵的右上角元素A是A所在行的最大的值，所以target肯定不在A所在的行了，所以这时候就应该就在除去第一行的剩下的行中去找这个target;如果target比矩阵右上角的数A小，那么由于A所在的列中A是最小的，那么target就在除去最右边的列的其它的列；
    //如果相等，返回true


    //堆排序
    private static void duiSort02(int[] arr) {
        //构建 大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustDui(arr, i, arr.length);
        }
        //调整堆结构  交换堆顶和堆底元素
        for (int j = arr.length - 1; j > 0; j--) {
            swapDui(arr, 0, j);
            adjustDui(arr, 0, j);

        }
    }

    private static void swapDui(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void adjustDui(int[] arr, int left, int right) {
        int temp = arr[left];
        for (int k = 2 * left + 1; k < right; k = 2 * k + 1) {
            if (k + 1 < right && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[left] = arr[k];
                left = k;
            } else {
                break;
            }
        }
        arr[left] = temp;
    }

    //归并排序
    private static void guiBingSort(int[] arr) {
        int[] temp = new int[arr.length];
        suiBingSort02(arr, 0, arr.length - 1, temp);
    }

    private static void suiBingSort02(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            suiBingSort02(arr, left, mid, temp);
            suiBingSort02(arr, mid + 1, right, temp);
            mergeSuiBIngSort02(arr, left, mid, right, temp);
        }
    }

    private static void mergeSuiBIngSort02(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    //冒泡
    private static void maopaoSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    //快排
    private static void quickSort(int[] arr) {
        quickSort01(arr, 0, arr.length - 1);
    }

    private static void quickSort01(int[] arr, int left, int right) {
        if (left > right) return;
        int i = left, j = right;
        int temp = arr[i];
        while (i != j) {
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
        quickSort01(arr, left, i - 1);
        quickSort01(arr, i + 1, right);
    }


}

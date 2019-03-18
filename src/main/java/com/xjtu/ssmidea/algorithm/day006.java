package com.xjtu.ssmidea.algorithm;

import java.util.Scanner;
import java.util.Arrays;

public class day006 {
    public static void main(String[] args) {
        //test();
        int[] arr = {2, 5, 7, 1, 9};
        sort4(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void test() {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        if (m == 0) {
            System.out.println(0);
            return;
        }
        int[] len = new int[n];
        s = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            len[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(len);
        double l = 0;
        double r = len[n - 1];
        double res = 0.00;
        double mid = 0.00;
        while (r - l >= 1e-3) {
            mid = (l + r) / 2;
            if (check(n, m, len, mid)) {
                res = mid;
                l = mid;
            } else {
                r = mid;
            }
        }
        System.out.println(String.format("%.2f", res));
    }

    public static boolean check(int n, int m, int[] len, double x) {
        int num = 0;
        for (int i = 0; i < n; i++) {
            num += (int) len[i] / x;
        }
        if (num >= m) {
            return true;
        }
        return false;
    }

    //快排
    public static void sort1(int[] arr, int low, int high) {
        if (low > high) return;
        int i = low, j = high;
        int temp = arr[low];
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
        sort1(arr, low, i - 1);//i的左边比较
        sort1(arr, i + 1, high);//i的右边比较
    }

    //归并排序
    public static void sort2(int[] arr) {
        //首先初始化一个数组，存放比较的数
        int[] temp = new int[arr.length];
        sort3(arr, 0, arr.length - 1, temp);
    }

    private static void sort3(int[] arr, int left, int high, int[] temp) {
        if (left < high) {
            int mid = (left + high) / 2;
            sort3(arr, left, mid, temp);
            sort3(arr, mid + 1, high, temp);
            merge3(arr, left, mid, high, temp);
        }
    }

    private static void merge3(int[] arr, int left, int mid, int high, int[] temp) {
        //定义指针
        int i = left, j = mid + 1;
        int t = 0;
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //剩余的
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= high) {
            temp[t++] = arr[j++];
        }
        t = 0;
        //交换数组
        while (left <= high) {
            arr[left++] = temp[t++];
        }
    }

    //堆排序
    public static void sort4(int[] arr) {
        //建堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, 0, arr.length);
        }
        //交换、调整堆
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjust(arr, 0, i);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void adjust(int[] arr, int left, int right) {
        int first = arr[left];
        for (int i = 2 * left + 1; i < right; i = i * 2 + 1) {
            if (i + 1 < right && arr[i] < arr[i + 1]) {
                i++;
            }
            //交换
            if (arr[i]>first){
                arr[left]=arr[i];
                left=i;
            }else {
                break;
            }
        }
        arr[left]=first;
    }
}

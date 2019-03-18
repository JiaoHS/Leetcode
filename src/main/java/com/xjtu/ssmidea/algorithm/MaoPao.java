package com.xjtu.ssmidea.algorithm;

/**
 * @program: hello
 * @description:
 * @author: seven
 * @create: 2019/03/09 10:41
 **/
public class MaoPao {
    public static void main(String[] args) {
        int[] a = {2, 1, 4, 3, 5};
//        maopao(a);
//        quickSort(a);
//        mergeSort(a, 0, a.length-1);
//        insertSort(a);
        selectSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
    public static void maopao(int[] a) {
        for (int i = a.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }

    public static void quickSort(int[] a){
        partition(a, 0, a.length-1);

    }

    public static void partition(int[] a, int low, int high){
        if (low >= high) {
            return;
        }
        int begin = a[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (i < j && a[j] >= begin) {
                j--;
            }
            a[i++] = a[j];
            while (i < j && a[i] <= begin) {
                i++;
            }
            a[j--] = a[i];
        }
        a[i] = begin;
        partition(a, low, i-1);
        partition(a, i+1, high);
    }

    public static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high)/2;
            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);
            merge(a, low, mid+1, high);
        }
    }
    public static void merge(int[] a, int low, int mid, int high){
        int[] left = new int[mid-low];
        int[] right = new int[high - mid + 1];
        for (int i = 0; i < a.length; i++) {
            if (i < mid) {
                left[i] = a[i];
            }else if (i <= high) {
                right[i-mid] = a[i];
            }
        }
        int i = 0;
        int j = 0;
        int k = low;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                a[k] = left[i];
                i++;
                k++;
            }else {
                a[k] =right[j];
                j++;
                k++;
            }
        }
        while (i < left.length) {
            a[k++] = left[i++];
        }
        while (j < right.length) {
            a[k++] = right[j++];
        }
    }

    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int tmp = a[i];
            int j;
            for (j = i; j > 0 && a[j-1] > tmp; j--) {
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }

    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int mIndex = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[mIndex]) {
                    mIndex = j;
                }
            }
            int tmp = a[i];
            a[i] = a[mIndex];
            a[mIndex] = tmp;
        }
    }


}

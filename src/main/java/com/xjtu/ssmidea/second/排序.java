package com.xjtu.ssmidea.second;

/**
 * @auther coraljiao
 * @date 2019/3/12 09:45
 * @description
 */
public class 排序 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 1};
        //sort1(arr, 0, arr.length - 1);

        sort2(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
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
        sort1(arr, low, i - 1);
        sort1(arr, i + 1, high);
    }
    //冒泡
    public static void sort2(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }
    //
}

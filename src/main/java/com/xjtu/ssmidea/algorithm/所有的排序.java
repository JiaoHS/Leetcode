package com.xjtu.ssmidea.algorithm;

/**
 * @auther coraljiao
 * @date 2019/3/9 15:59
 * @description
 * 内排序有可以分为以下几类：
 *
 * 　　(1)、插入排序：直接插入排序、二分法插入排序、希尔排序。
 *
 * 　　(2)、选择排序：简单选择排序、堆排序。
 *
 * 　　(3)、交换排序：冒泡排序、快速排序。
 *
 * 　　(4)、归并排序
 *
 * 　　(5)、基数排序
 */
public class 所有的排序 {
    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        int[] sort1 = sort2(a);
        for (int i = 0; i < sort1.length; i++) {
            System.out.println(sort1[i]);
        }
    }

    //直接插入排序 稳定的排序
    //文件初态不同时，直接插入排序所耗费的时间有很大差异。若文件初态为正序，则每个待插入的记录只需要比较一次就能够找到合适的位置插入，故算法的时间复杂度为O(n)，这时最好的情况。若初态为反序，则第i个待插入记录需要比较i+1次才能找到合适位置插入，故时间复杂度为O(n2)，这时最坏的情况。
    public static int[] sort1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //待插入元素
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                //将大于temp的往后移动一位
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
        return arr;
    }

    //二分法插入排序，基本思想：二分法插入排序的思想和直接插入一样，只是找合适的插入位置的方式不同，这里是按二分法找到合适的位置，可以减少比较的次数。
    public static int[] sort2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int left = 0;
            int right = i - 1;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (temp < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            ////将前面全部大于当前待插入记录的记录后移
            for (int j = i - 1; j >= left; j--) {
                arr[j + 1] = arr[j];
            }
            //将待插入记录回填到正确位置.
            arr[left] = temp;
        }
        return arr;
    }

    //希尔排序 是不稳定的
    public static int[] sort3(int[] arr) {
        int d = arr.length;
        while (true) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < arr.length; i = i + d) {
                    int temp = arr[i];
                    int j;
                    for (j = i - d; j >= 0 && arr[j] > temp; j = j - d) {
                        arr[j + d] = arr[j];
                    }
                    arr[j + d] = temp;
                }
            }
            if (d == 1) {
                break;
            }
        }
        return arr;
    }
    //选择排序
    public static int[] sort4(int[] arr){
        for (int i = 0; i < arr.length; i++) {

        }
        return arr;
    }
}

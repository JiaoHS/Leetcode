package com.xjtu.ssmidea.algorithm;

/**
 * @auther coraljiao
 * @date 2019/3/9 15:59
 * @description 内排序有可以分为以下几类：
 * <p>
 * 　　(1)、插入排序：直接插入排序、二分法插入排序、希尔排序。
 * <p>
 * 　　(2)、选择排序：简单选择排序、堆排序。
 * <p>
 * 　　(3)、交换排序：冒泡排序、快速排序。
 * <p>
 * 　　(4)、归并排序
 * <p>
 * 　　(5)、基数排序
 */
public class 所有的排序 {
    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        int[] sort1 = maoPaoSort(a);
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
    public static int[] sort4(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int n = i;//最下数的索引
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {//找出最小数
                    min = arr[j];
                    n = j;
                }
            }
            //将当前比较的数和最小数替换
            arr[n] = arr[i];
            arr[i] = min;
        }
        return arr;
    }

    //堆排序
    public static int[] duiSort(int[] arr) {
        for (int i = 0; i < arr.length/2-1; i++) {
            //建堆
            buildHeap(arr,i,arr.length-i-1);
            //交换堆顶和最后一个元素
            swap(arr,0,arr.length-1-i);
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp=arr[i];
        arr[i]=arr[i1];
        arr[i]=temp;
    }
    //对data数组从0到lastIndex建大顶堆
    private static void buildHeap(int[] array, int i, int length) {
        //从lastIndex处节点（最后一个节点）的父节点开始
        int temp=array[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            // 让k先指向子节点中最大的节点
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;
            }

            // 如果发现子节点更大，则进行值的交换
            if (array[k] > temp) {
                swap(array, i, k);
                // 下面就是非常关键的一步了
                // 如果子节点更换了，那么，以子节点为根的子树会不会受到影响呢？
                // 所以，循环对子节点所在的树继续进行判断
                i = k;
                // 如果不用交换，那么，就直接终止循环了
            } else {
                break;
            }
        }
    }

    //冒泡排序
    public static int[] maoPaoSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;

    }
    //快速排序选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分
    public static int[] quickSort(int[] arr){
        int start = 0;
        int end = arr.length-1;

        return arr;
    }
}

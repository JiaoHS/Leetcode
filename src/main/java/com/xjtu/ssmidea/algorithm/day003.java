package com.xjtu.ssmidea.algorithm;

/**
 * @auther coraljiao
 * @date 2019/3/15 09:56
 * @description
 */
public class day003 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 1, 9};
        //sort01(arr, 0, arr.length - 1);
        sort02(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //快排
    public static void sort01(int[] arr, int low, int high) {
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
        sort01(arr, low, i - 1);
        sort01(arr, i + 1, high);
    }

    //堆排序//堆排序是一种选择排序，整体主要由构建初始堆+交换堆顶元素和末尾元素并重建堆两部分组成。
    public static void sort02(int[] arr) {
        //构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        //调整堆结构和交换堆顶末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);//重新对堆进行调整
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void adjustHeap(int[] arr, int i, int length) {
        int first = arr[i];//取出当前元素
        //从i结点的左子结点开始，也就是2i+1处开始
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            //如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > first) {
                //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        //将first值放到最终的位置
        arr[i] = first;
    }

    public static void sort3(int[] array) {
        //调整大顶堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap2(array, i, array.length);
        }
        //重新调整结构和交换元素
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            adjustHeap2(array, 0, i);
        }
    }

    private static void adjustHeap2(int[] array, int i, int length) {
        int first = array[i];//获取当前元素
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;
            }
            if (array[k] > first) {
                array[i] = array[k];
                i = k;
            } else {
                break;
            }
        }
        array[i] = first;
    }

    //归并排序
    public static void sort4(int[] arr) {
        int[] temp = new int[arr.length];
        sort5(arr, 0, arr.length-1, temp);
    }

    private static void sort5(int[] arr, int i, int length, int[] temp) {
        if (i < length) {
            int mid = (i + length) / 2;
            sort5(arr, i, mid, temp);
            sort5(arr, mid + 1, length, temp);
            merge2(arr, i, mid, length, temp);
        }
    }

    private static void merge2(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1;//左右指针
        int t = 0;//临时指针
        //循环比较左右的大小并插入新的数组
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //还有剩余，则将左边剩余全部插入的数组中
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        //将temp数组全部移到原数组
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}

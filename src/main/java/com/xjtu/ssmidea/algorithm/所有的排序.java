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
 *
 *
 * 一、稳定性:
 *
 * 　   稳定：冒泡排序、插入排序、归并排序和基数排序
 *
 * 　　不稳定：选择排序、快速排序、希尔排序、堆排序
 *
 * 二、平均时间复杂度
 *
 * 　　O(n^2):直接插入排序，简单选择排序，冒泡排序。
 *
 * 　　在数据规模较小时（9W内），直接插入排序，简单选择排序差不多。当数据较大时，冒泡排序算法的时间代价最高。性能为O(n^2)的算法基本上是相邻元素进行比较，基本上都是稳定的。
 *
 * 　　O(nlogn):快速排序，归并排序，希尔排序，堆排序。
 *
 * 　　其中，快排是最好的， 其次是归并和希尔，堆排序在数据量很大时效果明显。
 *
 * 三、排序算法的选择
 *
 * 　　1.数据规模较小
 *
 *   　　（1）待排序列基本序的情况下，可以选择直接插入排序；
 *
 *   　　（2）对稳定性不作要求宜用简单选择排序，对稳定性有要求宜用插入或冒泡
 *
 * 　　2.数据规模不是很大
 *
 * 　　（1）完全可以用内存空间，序列杂乱无序，对稳定性没有要求，快速排序，此时要付出log（N）的额外空间。
 *
 * 　　（2）序列本身可能有序，对稳定性有要求，空间允许下，宜用归并排序
 *
 * 　　3.数据规模很大
 *
 *    　　（1）对稳定性有求，则可考虑归并排序。
 *
 *     　　（2）对稳定性没要求，宜用堆排序
 *
 * 　　4.序列初始基本有序（正序），宜用直接插入，冒泡
 */
public class 所有的排序 {
    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 12};
//        int[] sort1 = maoPaoSort(a);

        if (a.length > 0)   //查看数组是否为空
        {
            guiBingSort(a, 0, a.length - 1);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
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
        for (int i = 0; i < arr.length / 2 - 1; i++) {
            //建堆
            buildHeap(arr, i, arr.length - i - 1);
            //交换堆顶和最后一个元素
            swap(arr, 0, arr.length - 1 - i);
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i] = temp;
    }

    //对data数组从0到lastIndex建大顶堆
    private static void buildHeap(int[] array, int i, int length) {
        //从lastIndex处节点（最后一个节点）的父节点开始
        int temp = array[i];
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
    public static int[] maoPaoSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;

    }
    //快速排序选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分

    private static void quickSort(int[] numbers, int low, int high) {
        if (low < high) {
            int middle = getMiddle(numbers, low, high); //将numbers数组进行一分为二
            quickSort(numbers, low, middle - 1);   //对低字段表进行递归排序
            quickSort(numbers, middle + 1, high); //对高字段表进行递归排序
        }
    }

    private static int getMiddle(int[] numbers, int low, int high) {
        int temp = numbers[low]; //数组的第一个作为中轴
        while (low < high) {
            while (low < high && numbers[high] >= temp)//从右向左找第一个
            //小于等于基准值得index
            {
                high--;
            }
            numbers[low] = numbers[high];//比中轴小的记录移到低端
            while (low < high && numbers[low] <= temp)//从左向右找第一个
//大于等于基准值的index
            {
                low++;
            }
            numbers[high] = numbers[low]; //比中轴大的记录移到高端
        }
        numbers[low] = temp; //中轴记录到尾
        return low; // 返回中轴的位置
    }

    //归并排序
    public static void guiBingSort(int[] arr, int low, int high) {
        if (low < high) {
            int middlw = (low + high) / 2;
            guiBingSort(arr, low, middlw);
            guiBingSort(arr, middlw + 1, high);
            merge(arr, low, middlw, high);
        }

    }

    private static void merge(int[] arr, int low, int middlw, int high) {
        int[] tempArr = new int[arr.length];
        int mid = middlw + 1;//右边的起始位置
        int temp = low;
        int third = low;
        while (low <= middlw && mid <= high) {
            //从两个数组中选取较小的数放入中间数组
            if (arr[low] <= arr[mid]) {
                tempArr[third++] = arr[low++];
            } else {
                tempArr[third++] = arr[mid++];
            }
        }
        //将剩余的部分放入中间数组
        while (low <= middlw) {
            tempArr[third++] = arr[low++];

        }
        while (mid <= high) {
            tempArr[third++] = arr[mid++];
        }
        //将中间数组复制回原数组
        while (temp <= high) {
            arr[temp] = tempArr[temp++];
        }
    }
}

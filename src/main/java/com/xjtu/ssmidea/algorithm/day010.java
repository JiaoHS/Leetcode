package com.xjtu.ssmidea.algorithm;

import java.util.Arrays;
import java.util.List;

/**
 * @auther coraljiao
 * @date 2019/3/22 22:08
 * @description
 */
public class day010 {
    //死锁
    public static void main(String[] args) {
        //sisuo();
        int[] nums = {1, 3, 2, 7, 4};
        sort2(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    //归并排序
    private static void sort2(int[] nums) {
        int[] temp = new int[nums.length];
        sort3(nums, 0, nums.length - 1, temp);
    }

    private static void sort3(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort3(nums, left, mid, temp);
            sort3(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
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

    //堆排序
    private static void sort1(int[] nums) {
        //构建堆结构
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjust(nums, i, nums.length - 1);
        }
        //交换并调整结构
        for (int j = nums.length - 1; j > 0; j--) {
            adjust(nums, 0, j);
            jiahuan(nums, 0, j);

        }
    }

    private static void jiahuan(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void adjust(int[] nums, int left, int right) {
        int first = nums[left];
        for (int k = left * 2 + 1; k < right; k = k * 2 + 1) {
            if (k + 1 < right && nums[k] < nums[k + 1]) {
                k++;
            }
            if (nums[k] > first) {
                nums[left] = nums[k];
                left = k;
            } else {
                break;
            }
        }
        nums[left] = first;
    }


    public static void sisuo() {
        final List<Integer> list1 = Arrays.asList(1, 2, 3);
        final List<Integer> list2 = Arrays.asList(4, 5, 6);
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (list1) {
                    for (Integer i : list1) {
                        System.out.println(i);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (list2) {
                        for (Integer i : list2) {
                            System.out.println(i);
                        }
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (list2) {
                    for (Integer i : list2) {
                        System.out.println(i);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (list1) {
                        for (Integer i : list1) {
                            System.out.println(i);
                        }
                    }
                }
            }
        }).start();
    }
}

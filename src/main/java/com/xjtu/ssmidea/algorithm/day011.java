package com.xjtu.ssmidea.algorithm;

/**
 * @auther coraljiao
 * @date 2019/3/25 10:11
 * @description
 */
public class day011 {
    public static void main(String[] args) {
        int[] nums = {2, 5, 7, 1, 9};
        sort6(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    //堆排序
    private static void sort6(int[] nums) {
        //构建堆结构
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjust(nums, i, nums.length);
        }
        //调整结构并交换
        for (int j = nums.length - 1; j > 0; j--) {
            swapa(nums, 0, j);
            adjust(nums, 0, j);
        }
    }

    private static void swapa(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void adjust(int[] nums, int left, int right) {
        int first = nums[left];
        for (int k = 2 * left + 1; k < right; k = k * 2 + 1) {
            //先跟兄弟节点比较
            if (k+1< right && nums[k] < nums[k + 1]) {
                k++;
            }
            //跟父节点比较并交换
            if (nums[k] > first) {
                nums[left] =nums[k];
                left=k;
            } else {
                break;
            }
        }
        nums[left]=first;
    }

    //归并排序
    private static void sort4(int[] arr) {
        //建一个临时的数组
//        int[] temp = new int[nums.length];
//        sort5(nums, 0, nums.length - 1, temp);
        int[] temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort5(arr, 0, arr.length - 1, temp);
    }

    private static void sort5(int[] arr, int left, int right, int[] temp) {
//        if (left < right) {
//            int mid = (left + right) / 2;
//            sort5(nums, left, mid, temp);
//            sort5(nums, mid + 1, right, temp);
//            merge(nums, left, mid, right, temp);
//        }
        if (left < right) {
            int mid = (left + right) / 2;
            sort5(arr, left, mid, temp);//左边归并排序，使得左子序列有序
            sort5(arr, mid + 1, right, temp);//右边归并排序，使得右子序列有序
            merge(arr, left, mid, right, temp);//将两个有序子数组合并操作
        }
    }

    //合并
    private static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1;
        int t = 0;//定义一个临时的指针

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }

        //剩余的元素
        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        while (j <= right) {
            temp[t++] = nums[j++];
        }
        t = 0;
        while (left <= right) {
            nums[left++] = temp[t++];
        }
    }

    //快排
    private static void sort2(int[] nums) {
        sort3(nums, 0, nums.length - 1);
    }

    private static void sort3(int[] nums, int left, int right) {
        if (left > right) return;
        int i = left, j = right;
        int temp = nums[left];
        while (i < j) {
            while (i < j && nums[j] >= temp) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= temp) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = temp;
        sort3(nums, left, i - 1);
        sort3(nums, i + 1, right);
    }


}

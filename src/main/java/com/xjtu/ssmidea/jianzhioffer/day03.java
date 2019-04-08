package com.xjtu.ssmidea.jianzhioffer;

/**
 * @auther coraljiao
 * @date 2019/4/2 19:54
 * @description
 */
public class day03 {
    public static void main(String[] args) {
        int[] nums = {8, 1, 4, 7, 5};
        sort006(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    //归并排序
    private static void sort006(int[] nums) {
        int[] temp = new int[nums.length];
        sort007(nums, 0, nums.length - 1, temp);
    }

    private static void sort007(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort007(nums, left, mid, temp);
            sort007(nums, mid + 1, right, temp);
            merge007(nums, left, mid, right, temp);
        }
    }

    private static void merge007(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if ( nums[i] < nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }
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

    //堆排序
    private static void sort005(int[] nums) {
        //构建堆
        for (int i = nums.length / 2 - 1; i > 0; i--) {
            adjust005(nums, i, nums.length - 1);
        }
        //调整
        for (int j = nums.length - 1; j > 0; j--) {
            adjust005(nums, 0, j);
            swap005(nums, 0, j);
        }
    }

    private static void swap005(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void adjust005(int[] nums, int left, int right) {
        int temp = nums[left];
        for (int k = 2 * left + 1; k < right; k = 2 * k + 1) {
            //先跟兄弟节点比较
            if (k + 1 < right && nums[k] < nums[k + 1]) {
                k++;
            }
            //跟父节点交换
            if (nums[k] > temp) {
                nums[left] = nums[k];
                left = k;
            } else {
                break;
            }
        }
        nums[left] = temp;
    }

    private static void adjust(int[] nums, int left, int right) {

    }

    //快排
    private static void sort003(int[] nums) {
        sort004(nums, 0, nums.length - 1);
    }

    private static void sort004(int[] nums, int left, int right) {
        if (left > right) return;
        int i = left, j = nums.length - 1;
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
        sort004(nums, left, i - 1);
        sort004(nums, i + 1, right);
    }

    //快排
    private static void sort001(int[] nums) {
        sort002(nums, 0, nums.length - 1);
    }

    private static void sort002(int[] nums, int left, int right) {
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
        sort002(nums, left, i - 1);
        sort002(nums, i + 1, right);
    }

    //输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
    //使用一个大小为K的最大堆，然后堆里面最大的数是堆顶，然后每次比较堆顶的数和数组中的数，如果堆顶的数比数组中的数A大，那么就把堆顶的数弹出来，把数组中的数A进堆，这样子到最后堆里面的堆顶始终是比外面的数小，而堆里的其他数是小于堆顶的数（最大堆的性质），所以堆中的数就是最小的k个数

}

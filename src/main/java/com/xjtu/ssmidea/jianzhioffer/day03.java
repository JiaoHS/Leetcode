package com.xjtu.ssmidea.jianzhioffer;

/**
 * @auther coraljiao
 * @date 2019/4/2 19:54
 * @description
 */
public class day03 {
    public static void main(String[] args) {
        int[] nums = {8, 1, 4, 7, 5};
        sort001(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

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

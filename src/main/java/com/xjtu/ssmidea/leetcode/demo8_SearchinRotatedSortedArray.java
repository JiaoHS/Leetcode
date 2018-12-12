package com.xjtu.ssmidea.leetcode;

public class demo8_SearchinRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int i = search(nums, 0);
        System.out.println(i);
    }

    //二分查找
    public static int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while(lo <= hi) {
            int mid = (lo + hi) / 2;

            if(nums[mid] == target) return mid;

            if(nums[lo] <= nums[mid]) {
                if(nums[lo] <= target && target <= nums[mid]){
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if(nums[mid] <= target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int Seache2(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        if (low > high) return -1;

        int  i = binarysearch(nums,low,high,target);
        return i;
    }
    public static int binarysearch(int array[], int low, int high, int target)
    {
        if (low > high) return -1;

        int mid = (low + high)/2;
        if (array[mid]> target)
            return    binarysearch(array, low, mid -1, target);
        if (array[mid]< target)
            return    binarysearch(array, mid+1, high, target);

        //if (midValue == target)
        return mid;
    }
}

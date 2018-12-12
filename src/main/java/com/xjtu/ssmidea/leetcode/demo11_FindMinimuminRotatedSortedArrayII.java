package com.xjtu.ssmidea.leetcode;

public class demo11_FindMinimuminRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] num = {0,1};
        int min = findMin2(num);
        System.out.println(min);
    }

    public static int findMin(int[] nums) {
//        int low=0;
//        int high=nums.length-1;
//        while (low<high){
//            int mid=(low+high)/2;
//            if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]){//中间的比左边的大 也比右边大
//                return nums[mid-1];
//            }else if(nums[mid]<nums[mid-1]&&nums[mid]<nums[mid+1]){//中间比左边 右边都小
//                return nums[mid];
//            } else { //中间比左边大 右边小
//
//            }
//        }
//        for (int i = 0; i < 1; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                int temp = 0;
//                if (nums[i] >= nums[j]) {
//                    temp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = temp;
//                }
//            }
//        }
        int first=nums[0];
        for (int j = 0; j < nums.length; j++) {
            int temp = 0;
            if (first >= nums[j]) {
                temp = first;
                first = nums[j];
                nums[j] = temp;
            }
        }
        return nums[0];
    }

    public static int findMin2(int[] nums) {
        int lo = 0, hi = nums.length - 1, mid = (hi + lo) / 2;
        while (lo < hi) {
            mid =  (hi + lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                hi--;
            }
        }
        return nums[lo];
    }
}

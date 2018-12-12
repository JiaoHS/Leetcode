package com.xjtu.ssmidea.leetcode;

public class demo16_NumberofSubarrayswithBoundedMaximum {
    public static void main(String[] args) {
        int[] A = {2, 1, 4, 3};
        int L = 2, R = 3;
        //System.out.println(numSubarrayBoundedMax(A, L, R));
        System.out.println(numSubarrayBoundedMax2(A, L, R));
    }

    private static int numSubarrayBoundedMax2(int[] A, int L, int R) {
        int start = -1, end = -1, res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > R) {
                start = end = i;
                continue;
            }
            //假如a[i]大于l,则当前的所有都符合条件
            //如果数组有效，则所有子数组的最大值结束也是有效的
            if (A[i] >= L) {
                end = i;
            }
            res += end - start;
        }
        return res;
    }

    private static int numSubarrayBoundedMax(int[] a, int l, int r) {
        int j = 0, res = 0, count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > l && a[i] < j) {
                count += l - j + 1;
                res += l - j + 1;
            } else if (a[i] < l) {
                res += count;
            } else {
                j = i + 1;
                count = 0;
            }
        }
        return res;
    }
}

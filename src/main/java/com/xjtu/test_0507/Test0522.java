package com.xjtu.test_0507;

import java.util.ArrayList;

/**
 * @auther coraljiao
 * @date 2021/5/22 16:10
 * @description
 */
public class Test0522 {
    //2、给定一个包含m x n个元素的矩阵(m行, n列)，请按照顺时针螺旋顺序，返回矩阵中的所有元素。
    //    输入:
    //        [
    //         [ 1, 2, 3 ],
    //         [ 4, 5, 6 ],
    //         [ 7, 8, 9 ]
    //        ]
    //    输出: [1,2,3,6,9,8,7,4,5]

    public static void main(String[] args) {
        int[][] arr=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> list=printMat(arr);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public static ArrayList printMat(int[][] arr) {
        ArrayList<Integer> list = new ArrayList();
        if (arr == null || arr.length == 0) {
            return list;
        }

        int up = 0;
        int down = arr.length - 1;
        int left = 0;
        int right = arr[0].length - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                list.add(arr[up][i]);
            }
            if (++up > down) {
                break;
            }
            for (int i = up; i <= down; i++) {
                list.add(arr[i][right]);
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                list.add(arr[down][i]);
            }
            if (--down < up) {
                break;
            }
            for (int i = down; i >= up; i--) {
                list.add(arr[i][left]);
            }
            if (++left > right) {
                break;
            }


        }
        return list;
    }
}

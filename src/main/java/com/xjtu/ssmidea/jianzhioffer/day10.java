package com.xjtu.ssmidea.jianzhioffer;

import static com.xjtu.ssmidea.algorithm.day005.sort01;

/**
 * @auther coraljiao
 * @date 2019/4/19 19:10
 * @description
 */
public class day10 {
    public static void main(String[] args){
        int[] arr={1,8,6,2};
        sort(arr);
    }
    //快排
    private static void sort(int[] arr) {
        sort01(arr,0,arr.length-1);
    }
}

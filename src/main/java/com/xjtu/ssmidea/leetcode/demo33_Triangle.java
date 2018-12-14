package com.xjtu.ssmidea.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo33_Triangle {
    public static void main(String[] args) {
        //List<List<Integer>> triangle = {{2}, {3, 4}, {6, 7}};
        List<List<Integer>> triangle = new ArrayList<>();
        int[][] nums = {{-1}, {2, 3}, {1, -1, -3}};
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                list.add(nums[i][j]);
            }

            triangle.add(list);
        }
        int res = minimumTotal4(triangle);
        System.out.println(res);
    }

    private static int minimumTotal4(List<List<Integer>> triangle) {
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int self = triangle.get(i).get(j);         //获取第（i+1）行（j+1）个数字
                int res = Math.min(triangle.get(i+1).get(j)+self,   triangle.get(i+1).get(j+1)+self);    //得到这一行与下一行相邻数的和的最小值
                triangle.get(i).set(j,res);         //更新第（i+1）行第（j+1）个数字
            }
        }
        return triangle.get(0).get(0);  //返回第一行第一个数字，也就是最小值
    }

    private static int minimumTotal3(List<List<Integer>> triangle) {
        int len = triangle.size();
        if(len==0) return 0;
        int[] map = new int[len];
        Arrays.fill(map, Integer.MAX_VALUE);
        map[0]=triangle.get(0).get(0);
        for(int i=1; i<len;i++){
            List<Integer> list = triangle.get(i);
            for(int j=i; j>0;j--){
                map[j] = list.get(j)+Math.min(map[j], map[j-1]);
            }
            map[0]+=list.get(0);
        }
        int res = Integer.MAX_VALUE;
        for (int i=0;i<len;i++) res = Math.min(res, map[i]);
        return res;
    }

    private static int minimumTotal2(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int sum = 0;
        for (int i = 0; i < triangle.size(); i++) {
            if (i == 0) {
                sum += triangle.get(0).get(0);
            } else {
                List<Integer> list = triangle.get(i);
                int temp = list.get(0);
                for (int j = 1; j < list.size(); j++) {
                    if (list.get(j) <= temp) {
                        temp = list.get(j);
                    }
                }
                sum += temp;
            }
        }
        return sum;
    }
}

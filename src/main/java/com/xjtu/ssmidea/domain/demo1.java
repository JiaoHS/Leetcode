package com.xjtu.ssmidea.domain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo1 {

    public static void combine(int[] a, int n) {

        if(null == a || a.length == 0 || n <= 0 || n > a.length)
            return;

        Arrays.sort(a);
        int[] b = new int[n];//辅助空间，保存待输出组合数
        getCombination(a, n , 0, b, 0);
    }

    private static void getCombination(int[] a, int n, int begin, int[] b, int index) {
        List<Integer> list=new ArrayList<>();
        if(n == 0){//如果够n个数了，输出b数组
            for(int i = 0; i < index; i++){
                //System.out.print(b[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < a.length; i++){

            if(index == 0 || a[i] >= b[index-1]){
                b[index] = a[i];
                getCombination(a, n-1, i+1, b, index+1);
            }
        }

    }

    public static void main(String[] args){

        int[] a = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int n = 3;
        combine(a,n);

    }

}

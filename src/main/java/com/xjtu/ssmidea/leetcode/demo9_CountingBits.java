package com.xjtu.ssmidea.leetcode;

import java.util.*;

public class demo9_CountingBits {
    public static void main(String[] args) {
//        int i = 5;

//        int[] nums = countBits2(i);
//        System.out.println(nums);

        Collection col=new ArrayList();
        col.add(100);
        col.add("HH");
        col.add(true);
        System.out.println(col);
//        Object[] ob=col.toArray();
//        for (int i=0;i<col.size();i++){
//            System.out.println(((ArrayList) col).get(i));
//        }
        Iterator it = col.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        List list=new ArrayList();
        list.add("a");
        list.add("a");
        list.add("c");
        list.add("d");

//        Iterator its=list.iterator();
//        while(its.hasNext()){
//            if(it.next().toString().equals("c")){
//                list.add("E");
//            }
//        }
        ListIterator listIt=list.listIterator();
        while(listIt.hasNext()){
            if(listIt.next().toString().equals("c")){
                listIt.add("E");
            }
        }

//
//        for(int i=0;i<list.size();i++){
//            if(list.get(i)=="a"){
//                list.add("E");
//            }
//        }
        System.out.println(list);
    }
    //i >> 1基本上意味着“砍掉最后一位数”。如果最后一位为0，则i＆1返回0，如果为1，则返回1
    public static int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++){
            f[i] = f[i >> 1] + (i & 1);
        }
        return f;
//        int[] nums = {0, 1, 5,8};
//        String s="";
//        for (int i = 0; i <= num; i++) {
//            s = Integer.toBinaryString(nums[i]);
//
//        }
//        return nums;
    }
    public static int[] countBits2(int num) {
        int [] dp = new int[num+1];
        dp[0] = 0;
        if(num == 0) return dp;
        dp[1] = 1;
        int x = 1;
        int last_x = x;
        for(int i = 2; i<=num; i++){
            if(x+1 == i){dp[i] = 1; last_x = x;x = 2*x+1; continue;}
            dp[i] = dp[i - (last_x+1)]+1;
        }
        return dp;
    }
}

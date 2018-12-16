package com.xjtu.ssmidea.leetcode;

import java.util.ArrayList;
import java.util.List;

public class demo36_LetterCasePermutation {
    public static void main(String[] args) {
        String s = "a1b2";
        List<String> list = letterCasePermutation(s);
        System.out.println(list);

    }

    public static List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        if(S == null){
            return res;
        }
        char[] srr = S.toCharArray();
        dfs(srr, 0, res);
        return res;
//        List<String> list = new ArrayList<>();
//        if (S.length() < 1 || S.length() > 12) return list;
//        char[] arr = S.toCharArray();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < S.length(); i++) {
//            int index = S.indexOf(i);//当前的索引
//            if(i==0){
//                list.add()
//            }
//            if ((int) S.charAt(i) >= 0 && (int) arr[i] <= 9) {//整数
//                list.add(S.substring(i, i + 1) + S.charAt(i) + S.substring(i + 1));
//            } else {
//                int index = S.indexOf(i);
//                list.add(S.substring(index) + (S.charAt(i) + "").toUpperCase() + S.substring(index));
//            }
//        }
//        return list;
    }

    private static void dfs(char[] srr, int index, List<String> res) {
        if(index == srr.length){   //base case
            res.add(new String(srr));
            return;
        }
        if(Character.isDigit(srr[index])){   //if we meet a number, go deeper, do nothing in current level!
            dfs(srr, index + 1, res);
        }else{    //if we meet a char, then we have two options : uppercase or do nothing.
            srr[index] = Character.toUpperCase(srr[index]);
            dfs(srr, index + 1, res);
            srr[index] = Character.toLowerCase(srr[index]);   //backTracking!
            dfs(srr, index + 1, res);
        }
    }
}

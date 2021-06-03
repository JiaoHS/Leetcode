package com.xjtu.qiuzhao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @auther coraljiao
 * @date 2020/3/3 12:27
 * @description
 */
public class day010 {
    public static void main(String[] args){
//        ArrayList<String> abc = Permutation("abc");
//        System.out.println("ok");

        Collection collection = new ArrayList();
        collection.add(4);
        collection.add(2);
        collection.add(8);
        Collection collection2 = new ArrayList();
        collection2.add(2);
        collection2.add("abc");
        collection2.add('a');
        // 在调用者中  留下交集的部分
        boolean flag = collection.retainAll(collection2);
        System.out.println(flag);// 如果因为取交集删除元素了  true  没有删除元素   false
        System.out.println(collection);
    }

    public static ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return (ArrayList)res;
    }

    public static void PermutationHelper(char[] cs, int i, List<String> list) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
        } else {
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);
                PermutationHelper(cs, i+1, list);
                swap(cs, i, j);
            }
        }
    }

    public static void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}

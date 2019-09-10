package com.xjtu.qiuzhao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @program: spring
 * @description:
 * @author: seven
 * @create: 2019/03/20 19:26
 **/
public class SnakeTest {
    public static void main(String[] args) {
        //蛇形字符串：
        //1、连续字符对  字符对 由一个大写和小写字母组成   包含的字符对必须是连续的字母 按照字母顺序排序
        //2、从输入中寻找蛇形字符串  每次寻找最长的蛇形字符串 使用过的字符串不能重复使用
        //3、得到的字符串 先
        Scanner sc = new Scanner(System.in);
        String array = sc.nextLine();
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            int[] A = new int[26];
            int[] a = new int[26];
            for (int i = 0; i < array.length(); i++) {
                if (97 <= array.charAt(i) && array.charAt(i) <= 122) {
                    a[array.charAt(i) - 'a'] = 1;
                } else if (65 <= array.charAt(i) && array.charAt(i) <= 90) {
                    A[array.charAt(i) - 'A'] = 1;
                }
            }

            StringBuilder sb = new StringBuilder();
            String s = "";
            for (int i = 0; i < 26; i++) {
                if (A[i] == 1 && a[i] == 1) {
                    sb.append((char) (i + 'A'));
                    sb.append((char) (i + 'a'));
                } else {
                    //将当前最大的字符对保存到s变量
                    if (sb.length() > s.length()) {
                        s = sb.toString();
                    } else if (sb.length() > 0) {
                        sb = new StringBuilder();
                    }
                }
            }
            //将剩余的字符串保存到array里头
            if (s.length() > 0) {
                for (int i = 0; i < s.length(); i++) {
                    if (array.indexOf(s.charAt(i)) != -1) {
                        int index = array.indexOf(s.charAt(i));
                        String tmp1 = array.substring(0, array.indexOf(s.charAt(i)));
                        String tmp2 = array.substring(array.indexOf(s.charAt(i)) + 1, array.length());
                        array = tmp1 + tmp2;
                    }
                }
                list.add(s);
            } else {
                break;
            }
        }
        //list比较器  首先按照字典顺序 相同的情况下 长度长的排在前面
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.startsWith(o2)) {
                    return -1;
                }
                if (o2.startsWith(o1)) {
                    return 1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        } else {
            System.out.println("Not Found");
        }

    }
}

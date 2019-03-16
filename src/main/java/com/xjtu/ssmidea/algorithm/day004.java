package com.xjtu.ssmidea.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @auther coraljiao
 * @date 2019/3/16 10:13
 * @description
 */
public class day004 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String temp;
        List<String> list=new ArrayList<>();
        for(int i = 0; i < n; i++){
            temp = sc.next();
            //处理字符串的函数
            list.add(doMatch(temp));
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static String fun(String str) {
        String reg = "(\\w)\\1{2}";
        Pattern pt = Pattern.compile(reg);
        Matcher match = pt.matcher(str);
        String group;


        String reg2 = "(\\w)\\1(\\w)\\2";
        Pattern pt2 = Pattern.compile(reg2);
        Matcher match2 = pt2.matcher(str);
        String group2;
        if (match.find()) {
            group = match.group();
            str = str.replace(group, group.substring(0, 2));
        }else if(match2.find()){
            group2 = match2.group();
            str = str.replace(group2, group2.substring(0, 3));
        }

        return str;
    }
    public static String doMatch(String str){
        str = match1(str);
        str = match2(str);
        return str;
    }

    public static String match1(String str){
        String reg = "(\\w)\\1{2}";
        Pattern pt = Pattern.compile(reg);
        Matcher match = pt.matcher(str);
        String group;
        while (match.find()) {
            group = match.group();
            str = str.replace(group, group.substring(0, 2));
        }
        return str;
    }

    public static String match2(String str){
        String reg = "(\\w)\\1(\\w)\\2";
        Pattern pt = Pattern.compile(reg);
        Matcher match = pt.matcher(str);
        String group;
        while (match.find()) {
            group = match.group();
            str = str.replace(group, group.substring(0, 3));
        }
        return str;
    }
}


//        int[] map = new int[26];
//        //helllo
//        for (int i = 0; i < temp.length(); i++) {
//            map[temp.charAt(i) - 'a']++;
//        }
//        return "aaa";
//    public static String match2(String str){
//        String reg = "(\\w)\\1(\\w)\\2";
//        Pattern pt = Pattern.compile(reg);
//        Matcher match = pt.matcher(str);
//        String group;
//        while (match.find()) {
//            group = match.group();
//            str = str.replace(group, group.substring(0, 3));
//        }
//        return str;
//    }

//    public static String match1(String str){
//        String reg = "(\\w)\\1{2}";
//        Pattern pt = Pattern.compile(reg);
//        Matcher match = pt.matcher(str);
//        String group;
//        while (match.find()) {
//            group = match.group();
//            str = str.replace(group, group.substring(0, 2));
//        }
//        return str;
//    }

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int retail = 1024 - n;
//        int mod = 0;
//        int res = 0;
//
//        mod = retail % 64;
//        retail = retail / 64;
//        res += retail;
//
//
//        if (mod > 0){
//            retail = mod / 16;
//            mod = mod % 16;
//            res += retail;
//        }
//
//        if (mod > 0){
//            retail = mod / 4;
//            mod = mod % 4;
//            res += retail;
//        }
//        if (mod > 0) {
//            res += mod;
//        }
//
//        System.out.println(res);
//    }
//}

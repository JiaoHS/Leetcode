//package com.xjtu.ssmidea.algorithm;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Scanner;
//
///**
// * @program: spring
// * @description:
// * @author: seven
// * @create: 2019/03/20 19:26
// **/
//public class SnakeTest {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String array = sc.nextLine();
//        ArrayList<String> list = new ArrayList<>();
//        while (true) {
//            //定义两个长度为26的数组存字符串包含的大写和小写字符
//            int[] A = new int[26];
//            int[] a = new int[26];
//            for (int i = 0; i < array.length(); i++) {
//                if ( 97 <= array.charAt(i) && array.charAt(i) <= 122) {
//                    a[array.charAt(i)-'a'] = 1;
//                }else if (65 <= array.charAt(i) && array.charAt(i) <= 90){
//                    A[array.charAt(i)-'A'] = 1;
//                }
//            }
//
//            StringBuilder sb = new StringBuilder();
//            String s = "";
//            for (int i = 0; i < 26; i++) {
//                if (A[i] == 1 && a[i] == 1) {
//                    sb.append((char)(i+'A'));
//                    sb.append((char)(i+'a'));
//                }else {
//                    if (sb.length() > s.length()) {
//                        s = sb.toString();
//                    }else if (sb.length() > 0){
//                        sb = new StringBuilder();
//                    }
//                }
//            }
//            if (s.length() > 0) {
//                for (int i = 0; i < s.length(); i++) {
//                    if (array.indexOf(s.charAt(i)) != -1) {
//                        int index = array.indexOf(s.charAt(i));
//                        String tmp1 = array.substring(0, array.indexOf(s.charAt(i)));
//                        String tmp2 = array.substring(array.indexOf(s.charAt(i))+1, array.length());
//                        array = tmp1 + tmp2;
//                    }
//                }
//                list.add(s);
//            }else {
//                break;
//            }
//        }
//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if (o1.startsWith(o2)) {
//                    return -1;
//                }
//                if (o2.startsWith(o1)){
//                    return 1;
//                }
//                else {
//                    return o1.compareTo(o2);
//                }
//            }
//        });
//        if (list.size() > 0) {
//            for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i));
//            }
//        }else {
//            System.out.println("Not Found");
//        }
//
//    }
//}

package com.xjtu.qiuzhao;

import java.util.*;

/**
 * @auther coraljiao
 * @date 2019/9/8 16:01
 * @description
 */
public class 华为笔试题 {
    public static void main(String[] args) {

        int[] array = {2, 3, 4, 4, 5, 5, 6, 6, 7, 8};
        System.out.println(onlyOne(array));

        //华为笔试题1：输入一个字符串，表示100以内的加减法，计算结果  实例 输入：“12+3-5+3-5+3-5+3-5” ，输出：4
        //computeRes2();
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.next();
//        System.out.println(computeRes3(s));

//        List<String> results = findPythonString(s);
//        if (results.size() == 0) {
//            System.out.println("Not Found");
//        } else {
//            for (String result : results) {
//                System.out.println(result);
//            }
//        }
    }

    //笔试题2：寻找蛇形字符串 使用hashmap分别存储大写字符和小写字符
    private static List<String> findPythonString(String s) {
        HashMap<Character, Integer> lowMap = new HashMap<>();
        HashMap<Character, Integer> bigMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch <= 'z' && ch >= 'a') {
                lowMap.put(ch, lowMap.getOrDefault(ch, 0) + 1);
            } else if (ch <= 'Z' && ch >= 'A') {
                bigMap.put(ch, bigMap.getOrDefault(ch, 0) + 1);
            }
        }
        List<String> list = new ArrayList<>();
        while (!bigMap.isEmpty()) {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                if (bigMap.containsKey(ch) && lowMap.containsKey(Character.toLowerCase(ch))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(ch);
                    sb.append(Character.toLowerCase(ch));
                    bigMap.put(ch, bigMap.get(ch) - 1);
                    lowMap.put(Character.toLowerCase(ch), lowMap.get(Character.toLowerCase(ch)) - 1);
                    if (bigMap.get(ch) == 0) bigMap.remove(ch);
                    if (lowMap.get(Character.toLowerCase(ch)) == 0) lowMap.remove(Character.toLowerCase(ch));
                    goAhead(sb, lowMap, bigMap);
                    list.add(sb.toString());
                    break;
                } else if (bigMap.containsKey(ch)) {
                    bigMap.remove(ch);
                } else if (lowMap.containsKey(Character.toLowerCase(ch))) {
                    lowMap.remove(Character.toLowerCase(ch));
                }

            }
        }
        return list;
    }

    private static void goAhead(StringBuilder sb
            , HashMap<Character, Integer> lowMap
            , HashMap<Character, Integer> bigMap) {
        char slowCh = (char) (sb.charAt(sb.length() - 1) + 1);
        char bigCh = Character.toUpperCase(slowCh);
        if (bigMap.containsKey(bigCh) && lowMap.containsKey(slowCh)) {
            sb.append(bigCh);
            sb.append(slowCh);
            bigMap.put(bigCh, bigMap.get(bigCh) - 1);
            lowMap.put(slowCh, lowMap.get(slowCh) - 1);
            if (bigMap.get(bigCh) == 0) bigMap.remove(bigCh);
            if (lowMap.get(slowCh) == 0) lowMap.remove(slowCh);
            goAhead(sb, lowMap, bigMap);
        } else if (bigMap.containsKey(bigCh)) {
            bigMap.remove(bigCh);
        } else if (lowMap.containsKey(slowCh)) {
            lowMap.remove(slowCh);
        }
    }

    private static int computeRes(String s) {
        String[] splits = s.split("\\+|-");
        boolean[] flag = new boolean[splits.length - 1];
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+') {
                flag[k++] = true;
            } else if (s.charAt(i) == '-') {
                flag[k++] = false;
            }
        }
        int result = Integer.valueOf(splits[0]);

        for (int i = 1; i < splits.length; i++) {
            if (flag[i - 1] == true) {
                result += Integer.valueOf(splits[i]);
            } else {
                result -= Integer.valueOf(splits[i]);
            }
        }
        return result;
    }

    private static void computeRes2() {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        char[] cs = scanner.nextLine().toCharArray();
        boolean flag = true;
        int sum = 0;
        for (int i = 0; i < cs.length; i++) {
            if (isDig(cs[i])) {
                stack.push(cs[i] - '0');
            } else {
                int temp = 0;
                int index = 1;
                while (!stack.isEmpty()) {
                    temp += stack.pop() * index;
                    index *= 10;
                }
                if (flag) {
                    sum += temp;
                } else {
                    sum -= temp;
                }
                if (cs[i] == '-') {
                    flag = false;
                } else {
                    flag = true;
                }
            }
        }
        //最后一个数
        int temp = 0;
        int index = 1;
        while (!stack.isEmpty()) {
            temp += stack.pop() * index;
            index *= 10;
        }
        if (flag) {
            sum += temp;
        } else {
            sum -= temp;
        }
        System.out.println(sum);
    }

    private static boolean isDig(char c) {
        if (c - '0' >= 0 && c - '0' <= 9) {
            return true;
        } else {
            return false;
        }
    }

    //字符串计算和
    private static int computeRes3(String s) {
        String[] strings = s.split("\\+|-");
        boolean[] booleans = new boolean[strings.length - 1];//存符号
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+') {
                booleans[k++] = true;
            } else if (s.charAt(i) == '-') {
                booleans[k++] = false;
            }
        }
        int temp = Integer.valueOf(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            if (booleans[i - 1]) {
                temp += Integer.valueOf(strings[i]);
            } else {
                temp -= Integer.valueOf(strings[i]);
            }
        }

        return temp;
    }

    //有序数组 原地去重
    private static int onlyOne(int[] array) {
        if (array == null && array.length == 0) {
            return 0;
        }
        /**size:用来统计数组中没有重复的元素个数*/
        int size = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != array[size]) {
                /**修改数组中的值*/
                array[++size] = array[i];
            }
        }
        /**返回没有重复的个数*/
        return size + 1;
    }

    private static int onlyOne2(int[] array) {
        //2, 3, 4, 4, 5, 5, 6, 6, 7, 8
        if (array == null || array.length == 0) return 0;
        int size = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != array[size]) {
                array[++size] = array[i];
            }
        }
        return size + 1;
    }
}

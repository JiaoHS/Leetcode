package com.xjtu.ssmidea.leetcode;

import java.util.Calendar;

public class demo7_最长的公共字符前缀 {
    public static void main(String[] args) {
//        String[] strs = {"flower", "flo", "flight"};
//        String s = longestCommonPrefix(strs);
//        System.out.println(s);

        String dateTime = "2016-12-31 12:30:45 123";
        Calendar calendar = Calendar.getInstance();
        //calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").parse(dateTime));
        System.out.println("日期[2016-12-31 12:30:45 123]对应毫秒：" + calendar.getTimeInMillis());
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}

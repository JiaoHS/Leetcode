package com.xjtu.ssmidea.leetcode2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @auther coraljiao
 * @date 2018/12/19 10:31
 * @description
 */
public class demo01_openthelock {
    public static void main(String[] args){

    }
    public int openLock2(String[] deadends, String target) {
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        begin.add("0000");
        end.add(target);
        int level = 0;
        while(!begin.isEmpty() && !end.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for(String s : begin) {
                if(end.contains(s)) return level;
                if(deads.contains(s)) continue;
                deads.add(s);
                StringBuilder sb = new StringBuilder(s);
                for(int i = 0; i < 4; i ++) {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if(!deads.contains(s1))
                        temp.add(s1);
                    if(!deads.contains(s2))
                        temp.add(s2);
                }
            }
            level ++;
            begin = end;
            end = temp;
        }

        return -1;
    }
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<String>();
        for (String d : deadends)
            deadSet.add(d);
        Set<String> qs = new HashSet<String>();
        Set<String> qt = new HashSet<String>();
        if (deadSet.add("0000"))
            qs.add("0000");
        if (deadSet.add(target))
            qt.add(target);
        int step = 0;
        while (!qs.isEmpty() && !qt.isEmpty()) {
            Set<String> tmp = new HashSet<String>();
            for (String cur : qs) {
                char[] cs = cur.toCharArray();
                for (int i = 0; i < 4; i++) {
                    char tc = cs[i];

                    cs[i] = (char)((tc-'0'+1)%10+'0');
                    String next = new String(cs);
                    if (qt.contains(next))
                        return step+1;
                    if (deadSet.add(next))
                        tmp.add(next);

                    cs[i] = (char)((tc-'0'+9)%10+'0');
                    next = new String(cs);
                    if (qt.contains(next))
                        return step+1;
                    if (deadSet.add(next))
                        tmp.add(next);

                    cs[i] = tc;
                }
            }
            qs = qt;
            qt = tmp;
            step++;
        }
        return -1;
    }
}

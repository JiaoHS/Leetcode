package com.xjtu.ssmidea.leetcode;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class demo2 {
    public static void main(String[] args) {
        String s = "afgd";
        String t = "agadf";
        //char c = findTheDifference(s, t);
        //System.out.println(c);
        System.out.println(s.indexOf(1));
        System.out.println(s.indexOf("f"));
        System.out.println(s.charAt(3));
        System.out.println(s.indexOf(1,2));
    }

    public static char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Map<Character, Integer> dic1 = GetDic(s);
        Map<Character, Integer> dic2 = GetDic(t);
        char c = ' ';

        for (Map.Entry<Character, Integer> entry : dic2.entrySet()) {
            if (!(dic1.containsKey(entry.getKey()) && (dic1.get(entry.getKey()) == entry.getValue()))) {
                c = entry.getKey();
            }
        }
        return c;
    }

    public static Map<Character, Integer> GetDic(String s) {
        char[] tt = s.toCharArray();
        int s1;
        Map<Character, Integer> dic = new Hashtable<>();
        for (int i = 0; i < tt.length; i++) {
            s1 = 0;
            if (dic.containsKey(tt[i])) {
                s1 = dic.get(tt[i]);
            }
            s1 = s1 + 1;
            dic.put(tt[i], s1);
        }
        return dic;
    }

    public static char KuaiSu(String s, String t) {
        int[] map = new int[26];

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        char ans = '*';
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i) - 'a']--;
            if (map[t.charAt(i) - 'a'] < 0) {
                ans = t.charAt(i);
            }
        }
        return ans;
    }

}

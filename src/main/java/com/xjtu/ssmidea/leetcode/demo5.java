package com.xjtu.ssmidea.leetcode;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
//Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1
public class demo5 {
    public static void main(String[] args) {
        String s = "leetcode";
        int index = firstUniqCharKuaisu(s);
        System.out.println(index);
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> mapL = new LinkedHashMap<>();
        Integer flag = -1;
        Integer iger;
        Character c = ' ';
        for (int i = 0; i < s.length(); i++) {
            iger = 0;
            c = s.charAt(i);
            if (mapL.containsKey(c)) {
                iger = mapL.get(c);
                iger++;
            } else {
                iger++;
            }
            mapL.put(s.charAt(i), iger);
        }
        for (Map.Entry<Character, Integer> entry : mapL.entrySet()) {
            if (entry.getValue() == 1) {
                flag = s.indexOf(entry.getKey());
                break;
            }
        }
        return flag;
    }

    public static int firstUniqCharKuaisu(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr, 0);
        for(int i=0; i< s.length(); i++)
            arr[s.charAt(i) - 'a']++;
        for(int i=0; i< s.length(); i++){
            if(arr[s.charAt(i) - 'a'] == 1){
                //   System.out.println("Value at " + i + " is zero");
                return i;
            }
        }
        return -1;
    }
}

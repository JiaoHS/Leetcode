package com.xjtu.ssmidea.leetcode;

import java.util.HashMap;

public class demo20_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "dvdf";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }

    public static int lengthOfLongestSubstring(String s) {

        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;






//        if (s.equals(" ") || s == " " || s == null || s.length() == 1) return 1;
//        char[] nums = s.toCharArray();
//        int res = 0;
//        int sum = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//
//                res = map.size() > res ? map.size() : res;
//                map = new HashMap<>();
//                i--;
//            } else {
//                map.put(nums[i], 1);
//            }
//
//            sum = map.size() > res ? map.size() : res;
//        }
//        return sum;
    }
}

package com.xjtu.ssmidea.leetcode;

public class demo17_ValidAnagram {
    public static void main(String[] args) {
        String s = "rat", t = "car";
        //boolean b = isAnagram(s, t);
        boolean b = isAnagram2(s, t);
        System.out.println(b);
    }

    private static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] charsa = new int[26];
        int[] charsb = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charsa[s.charAt(i) - 'a']++;
            charsb[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < charsa.length; i++) {
            if (charsb[i] != 0) {
                return false;
            }
        }
        return false;
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] charsa = new int[26];
        int[] charsb = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charsa[s.charAt(i) - 'a']++;
            charsb[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < charsa.length; i++) {
            if (charsb[i] != charsa[i]) {
                return false;
            }
        }
        return true;
    }
}

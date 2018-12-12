package com.xjtu.ssmidea.leetcode;

public class demo3 {
    /*
        * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

    Each letter in the magazine string can only be used once in your ransom note.

    Note:
    You may assume that both strings contain only lowercase letters.
    canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
    *
    * */
    public static void main(String[] args) {
        boolean flag = canConstruct("aac", "aab");
        System.out.println(flag);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        boolean flag = true;
        for (int i = 0; i < magazine.length(); i++) {
            map[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            map[ransomNote.charAt(i) - 'a']--;
            if (map[ransomNote.charAt(i) - 'a'] < 0) {
                //ans = ransomNote.charAt(i);
                flag = false;
            }
        }
        return flag;
    }
}

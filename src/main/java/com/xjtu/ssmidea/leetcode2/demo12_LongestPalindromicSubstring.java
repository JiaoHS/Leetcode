package com.xjtu.ssmidea.leetcode2;

/**
 * @auther coraljiao
 * @date 2019/1/17 10:23
 * @description 最长回文字符串
 * 给定一个字符串s，找出s中最长的回文子字符串。您可以假设s的最大长度是1000。
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 *
 *
 * 首先说下什么是回文串，就是正读反读都一样的字符串，比如 "bob", "level", "noon" 等等。那么最长回文子串就是在一个字符串中的那个最长的回文子串
 */

public class demo12_LongestPalindromicSubstring {
    public static void main(String[] args) {

    }
    private int lo, maxLen;
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }
    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }


    public String longestPalindrome2(String s) {
        String sub = new String();
        int maxLen = 0;
        for(int i = 0;i + 1 < s.length();i++){
            int len = maxLen/2;
            while(i - len >= 0 && i+1+len < s.length()){
                if(!isValid(s,i-len,i+1+len)) break;
                if(len * 2 + 1 > maxLen) {
                    sub = s.substring(i-len,i+2+len);
                    maxLen = sub.length();
                }
                len++;
            }
        }
        for(int i = 0;i< s.length();i++){
            int len = maxLen/2;
            while(i-len >=0 && i+len < s.length()){
                if(!isValid(s,i-len,i+len))break;
                if(len * 2 + 1 > maxLen) {
                    sub = s.substring(i-len,i+len + 1);
                    maxLen = sub.length();
                }
                len++;
            }
        }
        return sub;
    }
    private boolean isValid(String s, int start, int end){
        if(s == null || s.length() == 0) return true;
        for(int i = start, j = end;i< j;i++,j--){
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}

package com.xjtu.ssmidea.leetcode2;

import java.util.Arrays;

/**
 * @auther coraljiao
 * @date 2018/12/29 21:11
 * @description
 */
//给定一个字符串s，找到s中最长的回文子序列的长度。您可以假设s的最大长度为1000
public class demo06_LongestPalindromicSubsequence {
    public static void main(String[] args){
        String s="bbbab";
        int res=longestPalindromeSubseq3(s);
        System.out.println(res);
    }

    private static int longestPalindromeSubseq3(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int[] dp = new int[s.length()];
        char[] ch = s.toCharArray();
        Arrays.fill(dp, 1);
        for(int i = 1; i < ch.length; i++) {
            int cur = 0;
            for(int j = i-1; j >= 0; j--) {
                int temp = dp[j];
                if(ch[i] == ch[j]) {
                    dp[j] = cur + 2;
                }
                cur = Math.max(cur, temp);
            }
        }

        int max = 0;
        for(int i : dp)
            max = Math.max(i, max);

        return max;
    }

    private static int longestPalindromeSubseq2(String s) {
        if(s==null || s.length()==0)return 0;
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i=n-1;i>=0;i--){
            dp[i][i]=1;
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j))
                    dp[i][j]=dp[i+1][j-1]+2;
                else
                    dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }

    private static int longestPalindromeSubseq1(String s) {
        final int n = s.length();
        int result = 0;
        int[] pre = new int[n];
        int[] cur = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    cur[j] = 1;
                } else if (i == j - 1) {
                    cur[j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        cur[j] = 2 + pre[j - 1];
                    } else {
                        cur[j] = Math.max(cur[j - 1], pre[j]);
                    }
                }
                result = Math.max(result, cur[j]);
            }
            int[] temp = pre;
            pre = cur;
            cur = temp;
        }
        return result;
    }

    public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}

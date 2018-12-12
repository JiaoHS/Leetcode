package com.xjtu.ssmidea.leetcode;

import java.util.ArrayList;
import java.util.List;

public class demo29_RepeatedSubstringPattern {
    public static void main(String[] args) {
        String s = "ababab";//acbacb   abaaba  ababab
        boolean res = repeatedSubstringPattern2(s);
        System.out.println(res);
    }

    private static boolean repeatedSubstringPattern5(String str) {
        //该程序首先复制原始str并使其延长两倍。让我们说给定的str =“abab”。我们将有s =“abab abab”（我在中间放置一个空白区域以便清楚）。然后我们通过删除第一个和最后一个字符得到s的子字符串，即“a（bab aba）b”（括号内的字符串是我们得到的子字符串）。如果重复原始str，我们可以从我们刚刚获得的子字符串构造它。这是因为我们可以从第一个模式（“bab”）获得str的一部分，并从第二个模式（“aba”）获得另一部分。这只有当str由其重复的子串组成时才有效，否则我们无法从s得到str。 我希望这有帮助。
        String s = str + str;
        return s.substring(1, s.length() - 1).contains(str);
    }

    private static boolean repeatedSubstringPattern4(String s) {
        int n = s.length(), k = s.length()/2;
        while(k>0) {
            if (n%k == 0) {
                String pre = s.substring(0, k);
                boolean res = true;
                for (int i=k;i<n;i+=k) {
                    String cur = s.substring(i, i+k);
                    if (!pre.equals(cur)) {
                        res = false;
                        break;
                    }
                }
                if (res) { return true; }
            }
            k--;
        }
        return false;
    }

    private static boolean repeatedSubstringPattern3(String str) {
        int l = str.length();
        for(int i=l/2;i>=1;i--) {
            if(l%i==0) {
                int m = l/i;
                String subS = str.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<m;j++) {
                    sb.append(subS);
                }
                if(sb.toString().equals(str)) return true;
            }
        }
        return false;
    }

    private static boolean repeatedSubstringPattern2(String s) {
        if(s == null || s.length() == 0) return true;

        int n = s.length();
        for(int len = 1; len <= n/2; len++){ // s must repeat at least twice
            if(n % len != 0) continue;

            String pattern = s.substring(0, len); // pattern string
            int i = len; // start index of 2nd pattern
            int j = i + len; // end index of 2nd pattern + 1
            while(j <= s.length()){
                String substr = s.substring(i, j);
                if(!pattern.equals(substr)) break;
                i += len;
                j += len;
            }
            if(j == s.length() + len) return true;
        }

        return false;
    }

    public static boolean repeatedSubstringPattern(String s) {
        if (s == null || s == "" || s.length() == 0 || s.length() > 10000) return false;
        List<Character> list = new ArrayList<>();
        list.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {

        }


//        List<Character> list = new ArrayList<>();
//        List<Character> list2 = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (i < s.length() / 2) {
//                list.add(s.charAt(i));
//            } else {
//                list2.add(s.charAt(i));
//            }
//        }
//        if(list.size()!=list2.size()) return false;
//        for (int k = 0; k < list.size(); k++) {
//            if (list.get(k) != list2.get(k)) {
//                return false;
//            }
//        }

        return true;
//        int[] arr = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            arr[s.charAt(i) - 'a']++;
//        }
//        int first = arr[0];
//        for (int j = 1; j < arr.length; j++) {
//            if (arr[j] != 0 && first != arr[j]) {
//                return false;
//            }
//        }
//        return true;
    }
}

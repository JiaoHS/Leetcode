package com.xjtu.ssmidea.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class demo21 {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }

    public static String slution(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            count[c - 'a']++;
        }
        boolean[] visited = new boolean[26];
        for (char c : arr) {
            count[c - 'a']--;//访问一次--
            if (visited[c - 'a']) {//如果已访问就删除
                continue;
            }
            //当前元素和站内元素比较：如果在原字符串中，a后面还有b则应该把b移除，则把a放在c的后面,res="ca"；有c时同理，res="a";
            //如果在原字符串中，a后面没有b和c，则只能把a放在bc后面，res="bca"
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static String slution2(String s){
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        boolean[] visited = new boolean[26];

        for (int j = 0; j < s.length(); j++) {
            count[s.charAt(j) - 'a']--;
            if(visited[s.charAt(j)-'a']){
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > s.charAt(j) && count[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static String removeDuplicateLetters(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            Character c = new Character(s.charAt(i));
            if(dq.contains(c)){
                dq.removeFirstOccurrence(c);
            }
            dq.offer(c);
        }
        StringBuffer sb = new StringBuffer();
        for(Character c : dq){
            sb.append(c);
        }
        return sb.toString();
    }

    String removeDuplicateLetters2(String str){
        int[] count = new int[26];
        for(int i=0; i<str.length(); i++)
            count[str.charAt(i)-'a']++;//统计每个字符出现次数

        int pos = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) < str.charAt(pos))
                pos = i;
            if(--count[str.charAt(i)-'a'] == 0)
                break;//当一个字符计数到0时，表示该字符必须出现
        }

        return str.length()==0 ? "":str.charAt(pos) + removeDuplicateLetters2(str.substring(pos + 1).replaceAll("" + str.charAt(pos), ""));
    }


}

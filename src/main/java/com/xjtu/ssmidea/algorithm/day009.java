package com.xjtu.ssmidea.algorithm;

import java.util.*;

/**
 * @auther coraljiao
 * @date 2019/3/20 20:11
 * @description
 */
public class day009 {
    public static void main(String[] args) {
        //test();

        //test2();
//        int[] nums = {1,1,2};
//        System.out.println(removeDuplicates(nums));
        String a="ab";
        String b="a"+"b";
        System.out.println(a==b);
    }

    public static void test2() {
        HashMap<Character, Character> mappings= new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        String s="()";
        System.out.println(isValid2(s));
    }

    private static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c=='(' || c=='[' || c=='{') {
                stack.push(c);
            } else {
                if (stack.empty()) return false;
                if (c==')' && stack.pop()!='(') return false;
                if (c==']' && stack.pop()!='[') return false;
                if (c=='}' && stack.pop()!='{') return false;
            }
        }
        return stack.empty();
    }
    public static int removeDuplicates(int[] nums) {
        if (nums==null||nums.length<0) return 0;
        int temp=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j]==nums[j+1]){
                    continue;
                }else {
                    temp++;
                }
            }
        }
        return temp;
    }

    public static boolean isValid(String s,HashMap<Character,Character> mappings) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mappings.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void test() {
        Scanner sc = new Scanner(System.in);
        String array = sc.nextLine();
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            int[] A = new int[26];
            int[] a = new int[26];
            for (int i = 0; i < array.length(); i++) {
                if (92 <= array.charAt(i) && array.charAt(i) <= 122) {
                    a[array.charAt(i) - 'a'] = 1;
                } else {
                    A[array.charAt(i) - 'A'] = 1;
                }
            }
            StringBuilder sb = new StringBuilder();
            String s = "";
            for (int i = 0; i < 26; i++) {
                if (A[i] == 1 && a[i] == 1) {
                    sb.append((char) (i + 'A'));
                    sb.append((char) (i + 'a'));
                } else {
                    if (sb.length() > s.length()) {
                        s = sb.toString();
                    } else if (sb.length() > 0) {
                        sb = new StringBuilder();
                    }
                }
            }
            if (s.length() > 0) {
                for (int i = 0; i < s.length(); i++) {
                    if (array.indexOf(s.charAt(i)) != -1) {
                        int index = array.indexOf(s.charAt(i));
                        String tmp1 = array.substring(0, array.indexOf(s.charAt(i)));
                        String tmp2 = array.substring(array.indexOf(s.charAt(i)) + 1, array.length());
                        array = tmp1 + tmp2;
                    }
                }
                list.add(s);
            } else {
                break;
            }
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.startsWith(o2)) {
                    return -1;
                }
                if (o2.startsWith(o1)) {
                    return 1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        } else {
            System.out.println("Not Found");
        }
    }
}

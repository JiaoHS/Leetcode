package com.xjtu.ssmidea.leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther coraljiao
 * @date 2018/12/27 15:27
 * @description
 * ()   1
 * ()()  (())  2
 * "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"  5
 */
public class demo03_GenerateParentheses {
    public static void main(String[] args){
        int index=3;
        System.out.println(generateParenthesis(index));

    }
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    //这里的想法是只添加'（'和'）'，我们知道这将保证我们的解决方案（而不是添加太多关闭）。一旦我们添加一个'（'我们将丢弃它并尝试一个'）'，它只能关闭一个有效的'（'。这些步骤中的每一个都是递归调用的
    public static void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
}

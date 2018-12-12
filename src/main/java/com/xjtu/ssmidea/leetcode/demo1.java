package com.xjtu.ssmidea.leetcode;

import java.util.ArrayList;
import java.util.List;

public class demo1 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();   //获取开始时间
        //1123  0111
        String str = getHint("1122", "2211");
        long endTime = System.nanoTime(); //获取结束时间
        System.out.println(str);
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String getHint(String secret, String guess) {
        char[] secretArr = secret.toCharArray();
        char[] guessArr = guess.toCharArray();
        List<Character> listA = new ArrayList();
        List<Character> listB = new ArrayList();
        int[] nums = new int[10];
        for (int i = 0; i < secretArr.length; i++) {
            int A = Character.getNumericValue(secret.charAt(i));
            int B = Character.getNumericValue(guess.charAt(i));
            if (secretArr[i] == guessArr[i]) {
                listA.add('A');
            } else {
                if (nums[A] < 0) {
                    listB.add('B');
                    //如果在i处s和g不相等，并且s在已经出现过在g中的其他位置，cows++
                }
                if (nums[B] > 0) {
                    listB.add('B');
                    //如果在i处s和g不相等，并且g已经出现过在s中的其他位置，cows++
                }
                nums[A]++;
                nums[B]--;
            }
        }
        return listA.size() + "A" + listB.size() + "B";
    }
}
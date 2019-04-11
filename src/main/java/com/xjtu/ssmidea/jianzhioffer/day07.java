package com.xjtu.ssmidea.jianzhioffer;

/**
 * @auther coraljiao
 * @date 2019/4/10 13:31
 * @description
 */
public class day07 {
    public static void main(String[] args) {
        test("acgacd");
    }

    //在一个字符串中找到第一个只出现一次的字符。如输入acbacd，则输出b
    public static void test(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        char[] arr = str.toCharArray();

        int[] temp = new int[256];
        for (i = 0; i < 256; i++) {
            temp[i] = 0;
        }

        char[] hashKey = arr;
        for (i = 0; i < hashKey.length; i++) {
            int tmp = hashKey[i];
            temp[tmp]++;
        }

        for (i = 0; i < hashKey.length; i++) {
            if (temp[hashKey[i]] == 1) {
                System.out.println(hashKey[i]);
                return;
            }
        }
    }
}

package com.xjtu.ssmidea.algorithm;

import java.util.ArrayList;

/**
 * @auther coraljiao
 * @date 2019/3/5 10:28
 * @description
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class 调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 5, 6, 7};
        reOrderArray(array);
        System.out.println("ok");
    }

    public static void reOrderArray(int[] array) {
        ArrayList<Integer> odd = new ArrayList();
        ArrayList<Integer> even = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                odd.add(array[i]);
            } else {
                even.add(array[i]);
            }
        }
        for (int i = 0; i < odd.size(); i++) {
            array[i] = odd.get(i);
        }
        for (int i = 0; i < even.size(); i++) {
            array[odd.size() + i] = even.get(i);
        }
    }
}

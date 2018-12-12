package com.xjtu.ssmidea.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo10_24Game {
    static boolean res = false;
    static final double eps = 0.001;
    //You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24
    /*
    * 我们每进行一次操作，当集合中数字个数大于等于2时，我们都是取出其中两个进行一次操作并将操作得到的结果放入集合，将两个操作数丢弃，然后对更新后的集合进行检验；而当最后集合中只剩下1个数时，我们只需比较它是否与24相等，若与24相等则返回成功且不需再遍历；若与24不相等则需要继续遍历剩下的可能情况直到找到成功示例，或遍历完而未找到返回失败为止。
    * */
    public static void main(String[] args) {
        int[] i = {4, 1, 8, 7};
        boolean b = judgePoint24(i);
        System.out.println(b);
    }

    public static boolean judgePoint24(int[] nums) {
        List<Double> arr = new ArrayList<>();
        for (int n : nums) arr.add((double) n);
        helper(arr);
        return res;
//        ArrayList arr = new ArrayList<Double>();
//        for (int i : nums) arr.add((double) i);
//        return solve(arr);
    }

    private static boolean solve(ArrayList<Double> nums) {
        if (nums.size() == 0) return false;
        if (nums.size() == 1) return Math.abs(nums.get(0) - 24) < 0.001;//绝对值
        //取两张牌
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                //不能取等，相减=0
                if (i != j) {
                    ArrayList<Double> nums2 = new ArrayList<Double>();
                    for (int k = 0; k < nums.size(); k++)
                        if (k != i && k != j) {
                            nums2.add(nums.get(k));
                        }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i) continue;
                        if (k == 0) nums2.add(nums.get(i) + nums.get(j));
                        if (k == 1) nums2.add(nums.get(i) * nums.get(j));
                        if (k == 2) nums2.add(nums.get(i) - nums.get(j));
                        if (k == 3) {
                            if (nums.get(j) != 0) {
                                nums2.add(nums.get(i) / nums.get(j));
                            } else {
                                continue;
                            }
                        }
                        if (solve(nums2)) return true;
                        nums2.remove(nums2.size() - 1);
                    }
                }
            }
        }

        return true;
    }

    private static void helper(List<Double> arr) {
        if (res) return;
        if (arr.size() == 1) {
            if (Math.abs(arr.get(0) - 24.0) < eps)
                res = true;
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < i; j++) {
                List<Double> next = new ArrayList<>();
                Double p1 = arr.get(i), p2 = arr.get(j);
                next.addAll(Arrays.asList(p1 + p2, p1 - p2, p2 - p1, p1 * p2));
                if (Math.abs(p2) > eps) next.add(p1 / p2);
                if (Math.abs(p1) > eps) next.add(p2 / p1);

                arr.remove(i);
                arr.remove(j);
                for (Double n : next) {
                    arr.add(n);
                    helper(arr);
                    arr.remove(arr.size() - 1);
                }
                arr.add(j, p2);
                arr.add(i, p1);
            }
        }
    }
}

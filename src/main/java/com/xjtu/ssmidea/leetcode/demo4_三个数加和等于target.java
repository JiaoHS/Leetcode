package com.xjtu.ssmidea.leetcode;

import java.util.*;

//Given an integer array A, and an integer target, return the number of tuples i, j, k  such that i < j < k and A[i] + A[j] + A[k] == target.
//三个数加和=target  https://leetcode.com/problems/3sum-with-multiplicity/
public class demo4_三个数加和等于target {
    static List<String> arrList = new ArrayList<>();

    public static void main(String[] args) {

//        int i=0;
//        Integer ii=Integer.valueOf(i);
//        String s=ii.toString();
//        System.out.println(s);
//        i=ii.intValue();
//        String str="111";
//        int t=Integer.parseInt(str);
        //String[] arr = new String[]{"1", "1", "2", "2", "3", "3", "4", "4", "5", "5"};
        int[] A = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int temp = ThreeNum(A, 8);
        System.out.println(temp);
//        String[] array = new String[]{
//                "1","2","3","4"
//        };
        //listAll(Arrays.asList(arr), "");
    }

    public static int threeSumMulti(int[] num, int target) {
        Integer result = 0;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    private static void listAll(List asList, String string) {
        // TODO Auto-generated method stub
        if (asList.isEmpty()) {
            System.out.println(string);
            arrList.add(string);
        }
        for (int i = 0; i < 3; i++) {
            List temp = new LinkedList(asList);
            listAll(temp, string + temp.remove(i));
        }
    }

    private static void listAllInt(List<Integer> asList, String string) {
        // TODO Auto-generated method stub
        if (asList.isEmpty()) {
            System.out.println(string);
        }
        for (int i = 0; i < asList.size(); i++) {
            List temp = new LinkedList(asList);
            listAll(temp, string + temp.remove(i));
        }
    }

    private static int  ThreeNum(int[] A, int target){
        if (A == null || A.length < 3) return 0;
        Arrays.sort(A);
        long res = 0;
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < A.length; ++i) {
            map.put(A[i], map.getOrDefault(A[i], 0l) + 1l);
        }
        System.out.println(map.get(A[0]));

        for (int i = 0; i < A.length; ++i) {
            if (i > 0 && A[i] == A[i - 1]) continue;
            int j = i + 1, k = A.length - 1;

            while (j < k) {
                if (A[i] + A[j] + A[k] < target) {
                    j++;
                }
                else if (A[i] + A[j] + A[k] > target) {
                    k--;
                }
                else {
                    if (A[i] == A[j] && A[j] == A[k]) {
                        res += (map.get(A[i])) * (map.get(A[i]) - 1) * (map.get(A[i]) - 2) / 6 % 1000000007;
                    }
                    else if (A[i] == A[j]) {
                        res += (map.get(A[i])) * (map.get(A[i]) - 1) / 2 * (map.get(A[k])) % 1000000007;
                    }
                    else if (A[j] == A[k]) {
                        res += (map.get(A[i])) * (map.get(A[j])) * (map.get(A[j]) - 1) / 2 % 1000000007;
                    }
                    else {
                        res += map.get(A[i]) * map.get(A[j]) * map.get(A[k]) % 1000000007;
                    }
                    while (j + 1 < A.length && A[j] == A[j + 1]) j++;
                    while (k > j && A[k] == A[k - 1]) k--;
                    j++;
                    k--;
                }
            }
        }
        return (int) res % 1000000007;
    }

    public int threeSumMulti2(int[] A, int target) {
        long[] c = new long[101];
        for (int a : A) c[a]++;
        long res = 0;
        for (int i = 0; i <= 100; i++)
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k > 100 || k < 0) continue;
                if (i == j && j == k)
                    res += c[i] * (c[i] - 1) * (c[i] - 2) / 6;
                else if (i == j && j != k)
                    res += c[i] * (c[i] - 1) / 2 * c[k];
                else if (j < k)
                    res += c[i] * c[j] * c[k];
            }
        return (int)(res % (1e9 + 7));
    }
}

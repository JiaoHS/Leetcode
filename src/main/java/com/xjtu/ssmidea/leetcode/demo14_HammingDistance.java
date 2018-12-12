package com.xjtu.ssmidea.leetcode;

public class demo14_HammingDistance {
    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        int res = hammingDistance(x, y);
        System.out.println(res);
    }
//按位异或运算符(^)是二元运算符，要化为二进制才能进行计算，在两个操作数中，如果两个相应的位相同，则运算结果为0，否则1
    public static int hammingDistance(int x, int y) {
        int count = 0;
        while(x!= 0 || y!= 0) {
            int bit1 = x&1;
            int bit2 = y&1;

            if((bit1 ^ bit2) == 1) {
                count++;
            }
            x >>= 1;
            y >>= 1;
        }
        return count;


//        int xor = x ^ y, count = 0;
//        for (int i=0;i<32;i++) count += (xor >> i) & 1;
//        return count;

//        int num = 0;
//        int count = 0;
//        Map<Integer, Character> map = new HashMap<>();
//        Map<Integer, Character> map2 = new HashMap<>();
//        String x1 = Integer.toBinaryString(x);
//        String y1 = Integer.toBinaryString(y);
//        num = x1.length() > y1.length() ? x1.length() : y1.length();
//        for (int i = num; i >= 1; i--) {
//            map.put(i, x1.length() >= i ? x1.charAt(i - 1) : '0');
//            map2.put(i, y1.length() >= i ? y1.charAt(i - 1) : '0');
//        }
//        for (int i = 0; i < num; i++) {
//            if (map.get(i) == map2.get(i)) {
//                continue;
//            } else {
//                count++;
//            }
//        }
//        return count;
    }
}

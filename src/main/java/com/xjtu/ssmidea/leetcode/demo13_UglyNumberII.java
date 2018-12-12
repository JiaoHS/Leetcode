package com.xjtu.ssmidea.leetcode;

public class demo13_UglyNumberII {
    public static void main(String[] args) {
        int n = 10;
        int res = nthUglyNumber(n);
        System.out.println(res);
    }

    public static int nthUglyNumber(int n) {

        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];

//        if (n == 1) return 1;
//        int num = 0;
//        for (int i = 1; i < Integer.MAX_VALUE; i++) {
//            if (i == 1) {
//                num++;
//            } else if (isUgly(i)) {
//                num++;
//                if (num == n || num > 1690) {
//                    num = i;
//                    break;
//                }
//            }
//        }
//        return num;


//        int[] ugly=new int[n];
//        ugly[0]=1;
//        int i2=0, i3=0, i5=0;
//        for(int i=1; i<n; i++){
//            int factor2=2*ugly[i2],
//                    factor3=3*ugly[i3],
//                    factor5=5*ugly[i5];
//
//            int min=Math.min(factor2, Math.min(factor3, factor5));
//            ugly[i]=min;
//            if(factor2==min){
//                i2++;
//            }
//            if(factor3==min){
//                i3++;
//            }
//            if(factor5==min){
//                i5++;
//            }
//
//        }
//        return ugly[n-1];
    }

    public static boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        int rem2 = num % 2;
        int rem3 = num % 3;
        int rem5 = num % 5;
        while (rem2 == 0 || rem3 == 0 || rem5 == 0) {
            if (rem2 == 0) {
                num = num / 2;
            } else if (rem3 == 0) {
                num = num / 3;
            } else {
                num = num / 5;
            }
            rem2 = num % 2;
            rem3 = num % 3;
            rem5 = num % 5;
        }
        return num == 1;
    }
}

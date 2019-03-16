package com.xjtu.ssmidea.algorithm;

import java.util.Scanner;
import java.util.Arrays;
public class day006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        if (m == 0) {
            System.out.println(0);
            return;
        }
        int[] len = new int[n];
        s = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            len[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(len);
        double l = 0;
        double r = len[n-1];
        double res = 0.00;
        double mid = 0.00;
        while (r-l >= 1e-3){
            mid = (l+r)/2;
            if (check(n, m, len, mid)) {
                res = mid;
                l = mid;
            }else {
                r = mid;
            }
        }
        System.out.println(String.format("%.2f", res));
    }

    public static boolean check(int n, int m, int[] len, double x) {
        int num = 0;
        for (int i = 0; i < n; i++) {
            num += (int)len[i]/x;
        }
        if (num >= m){
            return true;
        }
        return false;
    }
}

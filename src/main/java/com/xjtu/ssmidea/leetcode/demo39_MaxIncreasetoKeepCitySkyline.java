package com.xjtu.ssmidea.leetcode;

public class demo39_MaxIncreasetoKeepCitySkyline {
    public static void main(String[] args) {
        int[][] grid = {};
        int res = maxIncreaseKeepingSkyline(grid);
        System.out.println(res);

    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] col = new int[n], row = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                res += Math.min(row[i], col[j]) - grid[i][j];
        return res;
//        int[][] grid2 = grid;
//        if (grid == null || 50 < grid.length || grid[0].length <= 1) return 0;
//        for (int i = 0; i < grid.length; i++) {
//            //找出横排的最大值 left or right
//            for (int j = 0; j < grid.length; j++) {
//                if (grid[i][j] > 100 || grid[i][j] < 0) return 0;
//                //找出竖排的最大值 top or bottom
//            }
//        }
//        return 0;
    }
}

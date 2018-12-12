package com.xjtu.ssmidea.leetcode;

import java.util.Arrays;
import java.util.Comparator;
//先按照y排序，然后取y值与x比较
public class demo28_MinimumNumberofArrowstoBurstBalloons {
    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int res = findMinArrowShots3(points);
        System.out.println(res);
    }

    private static int findMinArrowShots3(int[][] points) {
        if(points.length == 0)
            return 0;
        //sort by the end point,
        // Why ? Because we dont want the
        Arrays.sort(points, (a,b) ->(a[1]-b[1]));
        int prev = points[0][1];
        int arrowCount  = 1;
        for(int i =1; i<points.length; i++){
            if(points[i][0]<= prev){
                continue; //overlap
            }
            arrowCount ++;
            prev = points[i][1];
        }
        return arrowCount;
    }

    private static int findMinArrowShots2(int[][] points) {
        int count = 0;
        Arrays.sort(points, new Comparator<int[]>() {//比较器

            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int arrow = Integer.MIN_VALUE;
//{{1,6}, {2,8}, {7,12},{10,16}};
        for (int i = 0; i < points.length; i++) {

            if (arrow != Integer.MIN_VALUE && points[i][0] <= arrow) continue;

            arrow = points[i][1];
            count++;


        }
        return count;
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        //{{1,6}, {2,8}, {7,12},{10,16}};
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {//y和x比较大小
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];//更换当前的y
        }
        return arrowCnt;
    }
}

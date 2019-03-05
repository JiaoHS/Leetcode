package com.xjtu.ssmidea.algorithm;

import java.util.ArrayList;

/**
 * @auther coraljiao
 * @date 2019/3/5 11:18
 * @description
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * 按照顺时针打印矩阵，这里的话我用了一个变量count,来记录遍历的数目，当count如果小于等于二维矩阵的数目的话，说明没有遍历完成，直到count达到二维数组的数目。
 *
 * 代码中的left,right,bottom,top解读。left代表最左的一层，top代表最顶的一层，bottom代表最低的一层，right代表最右的一层，举个例子，比如最顶的层top，每当遍历完最上面的一层，那么就top++，比如最底层bottom每当遍历完最低一层就bottom--，这样下去肯定会出现top和bottom相遇的情况，也就是全部都遍历完了
 */
public class 顺时针打印矩阵 {
    public static void main(String[] args){
    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> resultList = new ArrayList<>();
        int cols = matrix[0].length;
        int rows = matrix.length;
        int left=0,top=0,bottom=rows-1,right=cols-1;
        int count = 0;//计数，count如果达到数组的全部个数，那么结束。
        while(count < cols*rows)
        {
            for(int i=left;i<=right;i++)//从左往右进行遍历，第一层
            {
                //left是目前最左边的那个边界，right是目前最右边的边界
                resultList.add(matrix[top][i]);
                count++;
                if(count >= cols*rows)
                    return resultList;
            }
            top++;//遍历完目前的最顶层，那么top就到下一层
            for(int i=top;i<=bottom;i++)
            {
                //从上往下进行遍历，top是目前最上的边界，bottom是目前最下的边界
                resultList.add(matrix[i][right]);
                count++;
                if(count >= cols*rows)
                    return resultList;
            }
            right--;//遍历完最右边的边界，那么right就减一，到下一个最右边边界
            for(int i=right;i>=left;i--)
            {//从右到左，和上面同理
                resultList.add(matrix[bottom][i]);
                count++;
                if(count >= cols*rows)
                    return resultList;
            }
            bottom--;
            for(int i=bottom;i>=top;i--)
            {//从下到上，和上面同理。
                resultList.add(matrix[i][left]);
                count++;
                if(count >= cols*rows)
                    return resultList;
            }
            left++;
        }
        return resultList;
    }
}

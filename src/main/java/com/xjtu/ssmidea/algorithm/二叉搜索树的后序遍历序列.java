package com.xjtu.ssmidea.algorithm;

/**
 * @auther coraljiao
 * @date 2019/3/6 19:51
 * @description
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * 递归的思想，每次去判断左子树的最右边界是不是大于右子树的最左边界，如果大于就不是，如果小于，那么就再往下递归。
 */
public class 二叉搜索树的后序遍历序列 {
    public static void main(String[] args){

    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0)
            return false;
        return verify(sequence,0,sequence.length-1);
    }
    public boolean verify(int [] sequence,int begin,int end)
    {
        if(begin == end)
            return true;
        int rootValue = sequence[end];
        int leftBegin = -1;//左子树的左边界
        int leftEnd = -1;//左子树的右边界
        int rightBegin = -1;//右子树的左边界
        int rightEnd = -1;//右子树的右边界
        if(sequence[begin] < rootValue)// 说明存在左子树，二叉搜索树的性质
            leftBegin = begin;//记录左子树的左边界
        for(int i=begin;i<end;i++)
        {
            if(sequence[i] < rootValue)//如果比根结点的值小，说明就是左子树
                leftEnd = i;//记录下来左子树的右边界，只要比根结点小，就进行记录
            else{
                if(rightBegin == -1) //记录右子树的左边界，这个条件判断只会记录一次。
                    rightBegin = i;
                rightEnd = i;//记录右子树的右边界
            }
        }
        if(rightBegin < leftEnd && rightBegin != -1)
            return false;//如果左子树的右边界 大于 右子树的左边界 就出问题了！false
        return verify(sequence,leftBegin,leftEnd) && verify(sequence,rightBegin,rightEnd);
//否则递归往下去判断
    }
}

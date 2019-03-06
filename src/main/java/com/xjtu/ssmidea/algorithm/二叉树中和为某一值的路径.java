package com.xjtu.ssmidea.algorithm;

import java.util.ArrayList;

/**
 * @auther coraljiao
 * @date 2019/3/6 20:03
 * @description
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * 递归的思想，每次去判断左子树的最右边界是不是大于右子树的最左边界，如果大于就不是，如果小于，那么就再往下递归。
 */
public class 二叉树中和为某一值的路径 {
    ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        FindPath(root,target,0,list);
        return resultList;
    }
    public void FindPath(TreeNode root,int target,int sum,ArrayList<Integer> list)
    {
        if(root == null)
            return;
        sum += root.val; //sum不是引用，所以sum在每一层的递归中都是不同的值，记录当前的节点和
        list.add(root.val);
        if(sum == target && root.left == null && root.right == null)
        {//找到这样的路径了~
            resultList.add(new ArrayList<Integer>(list));//存入结果数组
            list.remove(list.size()-1);//找到以后还要接着找啊，所以先把当前最后的叶子节点删除
            return;
        }
        FindPath(root.left,target,sum,list);//左右子树递归进去去找
        FindPath(root.right,target,sum,list);
        list.remove(list.size()-1);//这里左右子树都找完了，回到了找完的左右子树的父节点
        //由于父节点的左右子树找完了，所以父节点这里也没有用了，把父节点删除
    }
}

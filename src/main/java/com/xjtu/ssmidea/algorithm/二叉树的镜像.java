package com.xjtu.ssmidea.algorithm;

/**
 * @auther coraljiao
 * @date 2019/3/5 11:15
 * @description
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class 二叉树的镜像 {
    public static void main(String[] args){

    }
    public void Mirror(TreeNode root) {
        if(root == null )
            return;
        if(root.left == null && root.right == null)
            return;
        TreeNode tempNode = root.right;
        root.right = root.left;
        root.left = tempNode; //这里三行代码进行 交换根节点的左右子树
        //分别递归左右子树
        Mirror(root.left);//对于左子树 递归调用  就是说对于左子树也进行交换
        Mirror(root.right);//右子树同理
    }
}

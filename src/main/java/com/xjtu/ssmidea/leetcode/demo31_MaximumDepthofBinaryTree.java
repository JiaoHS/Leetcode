package com.xjtu.ssmidea.leetcode;

public class demo31_MaximumDepthofBinaryTree {
    public static void main(String[] args){
        TreeNode treeNode=new TreeNode(3);
        treeNode.val=9;
        treeNode.val=20;
        treeNode.val=15;
        treeNode.val=7;
        int res=maxDepth(treeNode);
        System.out.println(res);
    }
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

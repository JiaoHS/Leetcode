package com.xjtu.ssmidea.algorithm;

import java.util.LinkedList;

/**
 * @auther coraljiao
 * @date 2019/3/8 17:06
 * @description
 */
public class 前序中序后序遍历 {

    //前序递归
    public void qianXu(TreeNode root) {
        if (root != null) {
            qianXu(root.left);
            System.out.println(root.val);
            qianXu(root.right);
        }
    }

    //前序非递归
    public void qianXu2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                System.out.print(node.val + "  ");
                stack.push(node);
                node = node.left;
            } else { //pNode == null && !stack.isEmpty()
                TreeNode node1 = stack.pop();
                node = node1.right;
            }
        }
    }

    //中序递归
    public void zhongXu(TreeNode root) {
        if (root != null) {
            zhongXu(root.left);
            System.out.println(root.val);
            zhongXu(root.right);
        }
    }

    //中序非递归
    public void zhongXu2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode node1 = stack.pop();
                System.out.println(node1.val);
                node1 = node1.right;
            }
        }
    }

    //后序递归
    public void postOrderTraverse1(TreeNode root) {
        if (root != null) {
            postOrderTraverse1(root.left);
            postOrderTraverse1(root.right);
            System.out.print(root.val + "  ");
        }
    }

    //层次遍历
    public void level(){

    }

}

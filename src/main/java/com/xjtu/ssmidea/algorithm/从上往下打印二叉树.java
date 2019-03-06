package com.xjtu.ssmidea.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther coraljiao
 * @date 2019/3/6 19:46
 * @description
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 思路：使用一个队列，实现二叉树的层次遍历
 */
public class 从上往下打印二叉树 {
    public static void main(String[] args){

    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if(root == null)
            return resultList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size() != 0)//队列不为空一直进行
        {
            TreeNode tempRoot = queue.poll();//出队
            if(tempRoot.left != null)//左子节点不为空，左子节点入队
                queue.offer(tempRoot.left);
            if(tempRoot.right != null)//右子节点不为空，右子节点入队
                queue.offer(tempRoot.right);
            resultList.add(tempRoot.val);//把出队的节点的值保留下来
        }
        return resultList;
    }

}

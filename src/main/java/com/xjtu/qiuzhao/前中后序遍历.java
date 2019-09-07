package com.xjtu.qiuzhao;

import java.util.Stack;

/**
 * @auther coraljiao
 * @date 2019/9/7 11:04
 * @description
 */
public class 前中后序遍历 {
    public static void main(String[] args){

    }
    //实现思路：
    //前序遍历的顺序是：根结点 -> 左孩子 -> 右孩子
    //借助一个栈结构先将根结点压入栈，然后循环每次取出栈顶元素，直到栈为空。如果当前结点有右孩子就先将右孩子压入栈中，如果当前结点有左孩子就将左孩子压入栈中，这里注意顺序，因为栈的结构是先进后出的，为了保证先遍历到左孩子就应该后压左孩子~
    public void preOrder(TreeNode head) {
        System.out.println("pre-order:");
        if(head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while(!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.val + " ");
                if (head.right != null)
                    stack.push(head.right);
                if (head.left != null)
                    stack.push(head.left);
            }
        }
    }
    //中序遍历的顺序：左孩子 -> 根结点 -> 右孩子
    //借助栈结构，将当前结点的左孩子依次入栈直到没有左孩子了就弹出栈顶元素并打印，如果弹出的结点有右孩子就将右孩子的左边界依次入栈，循环…
    //比如文章开始的那个图中，先将A，B，D依次入栈，此时栈顶元素是D，弹出并打印，D结点有右孩子，将D的右孩子的左边界依次入栈，压入结点G，结点G没有左孩子所以弹出并打印G，此时栈顶元素是B，循环…直到栈中为空且当前结点为空时遍历结束。
    public static void inOrderTraverse(TreeNode head) {
        System.out.println("in-order:");
        if(head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while(!stack.isEmpty() || head != null) {
                if(head != null) {
                    // 当前节点不为空, 将自己压进栈并将自己的左孩子作为当前节点（压入左边界）
                    stack.push(head);
                    head = head.left;
                }else {
                    // 当前节点为空（没有左孩子了）, 将栈顶元素弹出作为当前节点, 并将当前节点的右孩子压进栈
                    head = stack.pop();
                    System.out.print(head.val + " ");
                    head = head.right;
                }
            }
        }
    }
}

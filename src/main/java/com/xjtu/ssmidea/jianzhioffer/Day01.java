package com.xjtu.ssmidea.jianzhioffer;


import java.util.ArrayList;
import java.util.Stack;

/**
 * @auther coraljiao
 * @date 2019/3/23 08:35
 * @description
 */
public class Day01 {
    public static void main(String[] args) {
        System.out.println(replaceSpace("We Are Happy"));
    }

    //1、二维数组中的查找
//    在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
//    请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
//    思路：剑指offer的思路.就是比较矩阵的右上角的数与target的大小，如果target比这个矩阵右上角的数大，由于矩阵的右上角元素A是A所在行的最大的值，所以target肯定不在A所在            的行了，所以这时候就应该就在除去第一行的剩下的行中去找这个target;
    //如果target比矩阵右上角的数A小，那么由于A所在的列中A是最小的，那么target就在除去最右边的列的其它的列；
    //如果相等，返回true;
    public static boolean find(int target, int[][] arr) {
        if (arr.length == 0 || arr[0].length == 0) return false;
        int rows = arr.length - 1;
        int cols = arr[0].length - 1;
        int i = 0, j = cols;
        while (i <= rows && j >= 0) {
            if (arr[i][j] < target) {
                i++;
            } else if (arr[i][j] > target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

    //2、替换空格
//    请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
    public static String replaceSpace(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    //3、输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
    //思路：剑指offer的思路，递归的思路，只要链表不为空，一直往后进行遍历，然后直到到达链表的末尾，就开始用数组保存下来结果。
    public static ArrayList<Integer> print01(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        if (head == null) return list;
        print01(head, list);
        return list;
    }

    public static void print01(ListNode head, ArrayList<Integer> list) {
        if (head.next != null) {
            print01(head.next, list);
        }
        list.add(head.val);
    }

    //4、输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,2,7,1,5,3,8,6}，则重建二叉树并返回。
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0 || pre.length != in.length) {
            return null;
        }
        return rebuild(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private static TreeNode rebuild(int[] pre, int i, int j, int[] in, int m, int n) {
        int rootVal = pre[i], index = findIndex(rootVal, in, m, n);
        if (index < 0) return null;
        int leftNodes = index - m, rightNode = n - index;
        TreeNode root = new TreeNode(rootVal);
        if (leftNodes == 0) {
            root.left = null;
        } else {
            root.right = rebuild(pre, i + 1, i + leftNodes, in, m, m + leftNodes - 1);
        }
        if (rightNode == 0) {
            root.right = null;
        } else {
            root.left = rebuild(pre, i + leftNodes + 1, j, in, n - rightNode + 1, n);
        }
        return root;
    }

    //找到先序序列根节点在中序中的index
    private static int findIndex(int rootVal, int[] in, int m, int n) {
        for (int i = m; i <= n; i++) {
            if (in[i] == rootVal) {
                return i;
            }
        }
        return -1;
    }

    //5、用两个栈实现队列
    //用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
//    剑指offer的思路，用两个栈来实现队列，栈1的话用来入队，队列每进入一个元素就入栈1，栈2的话用来出队，队列如果要出队，首先判断栈2是不是空，是空，就把栈1弹出来进入栈2（因为栈是先入后出，两次先入后出就是先入先出了，负负得正嘛~），然后从栈2开始弹，如果栈2不为空，直接从栈2开始弹
    public static Stack<Integer> stack1=new Stack<>();
    public static Stack<Integer> stack2=new Stack<>();
    public static void posh(int node){
        stack1.push(node);
    }
    public static int pop(){
        if (stack2.isEmpty()){
            while (stack1.isEmpty()!=true){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()==true){
            return -1;
        }
        return stack2.pop();
    }
}

package com.xjtu.ssmidea.algorithm;

/**
 * @auther coraljiao
 * @date 2019/2/27 11:10
 * @description data域：存储数据元素信息的域称为数据域；
 * next域：存储直接后继位置的域称为指针域，它是存放结点的直接后继的地址（位置）的指针域（链域）。
 * data域+ next域：组成数据ai的存储映射，称为结点；
 * 注意：①链表通过每个结点的链域将线性表的n个结点按其逻辑顺序链接在一起的。
 * ②每个结点只有一个链域的链表称为单链表（Single Linked List）。
 * 所谓的链表就好像火车车厢一样，从火车头开始，每一节车厢之后都连着后一节车厢。
 * 要实现单链表存储，首先是创建一结点类，其Java代码如下：
 */
public class demo01_LinkNodeReverse {
    public static void main(String[] args) {
        Node linkNode1 = new Node();
        linkNode1.data = 1;
        Node linkNode2 = new Node();
        linkNode2.data = 2;
        Node linkNode3 = new Node();
        linkNode3.data = 3;
        Node linkNode4 = new Node();
        linkNode4.data = 4;
        Node linkNode5 = new Node();
        linkNode5.data = 5;
        Node linkNode6 = new Node();
        linkNode6.data = 6;
        linkNode1.next = linkNode2;
        linkNode2.next = linkNode3;
        linkNode3.next = linkNode4;
        linkNode4.next = linkNode5;
        linkNode5.next = linkNode6;

        Node reverseLinkedList = reverseLinkedList(linkNode1);
        System.out.println(reverseLinkedList);
    }

    //定义一个节点类
    static class Node {
        Integer data;
        Node next;
    }


    //递归
    static Node reverseLinkedList(Node node) {
        if (node == null || node.next == null) {
            return node;
        } else {
            Node headnode = reverseLinkedList(node.next);
            node.next.next = node;
            node.next = null;
            return headnode;
        }
    }

    //循环
    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode reverse(ListNode head) {
        ListNode next = null;
        ListNode pre = null;
        while (head != null) {
            //保存要反转到头来的那个节点
            next = head.next;
            // //要反转的那个节点指向已经反转的上一个节点
            head.next = pre;
            //上一个已经反转到头部的节点
            pre = head;
            //一直向链表尾走
            head = next;
        }
        return head;
    }
}

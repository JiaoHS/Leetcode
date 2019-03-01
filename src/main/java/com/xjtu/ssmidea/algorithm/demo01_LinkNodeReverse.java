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
//        Node linkNode1 = new Node();
//        linkNode1.data = 1;
//        Node linkNode2 = new Node();
//        linkNode2.data = 2;
//        Node linkNode3 = new Node();
//        linkNode3.data = 3;
//        Node linkNode4 = new Node();
//        linkNode4.data = 4;
//        Node linkNode5 = new Node();
//        linkNode5.data = 5;
//        Node linkNode6 = new Node();
//        linkNode6.data = 6;
//        linkNode1.next = linkNode2;
//        linkNode2.next = linkNode3;
//        linkNode3.next = linkNode4;
//        linkNode4.next = linkNode5;
//        linkNode5.next = linkNode6;
//
//        Node reverseLinkedList = reverseLinkedList(linkNode1);
//       System.out.println(reverseLinkedList);


        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = null;
        ListNode reverse = reverse7(list1);
        System.out.println(reverse);
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

    static Node reverse3(Node head) {
        if (head == null) {
            return null;
        }
        Node pre = null;
        Node cur = head;
        Node reHead = null;

        //如果当前结点为空，结束循环
        while (cur != null) {
            //保存下一个结点，以免丢失
            Node temp = cur.next;
            //1.对pre和cur结点的关系进行反转。本来是pre指向cur的，用下面这条代码能够把cur指向pre。
            cur.next = pre;

            //2.如果下一个结点为空，那他就是反转链表的头结点
            if (temp == null) {
                reHead = cur;
            }

            //3.上一个结点已经反转完成啦！现在要移动到下一个结点了！
            pre = cur;
            cur = temp;
        }
        return reHead;
    }

    static Node reverse4(Node head) {
        Node pre = null;
        Node temp = null;

        while (head != null) {
            //1.记录下一个结点
            //2.指针反转
            temp = head.next;//需要交换的结点
            head.next = pre;

            //3.光标移向原链表的下一个结点
            pre = head;
            head = temp;
        }

        return pre;
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
        //1->2->3
        ListNode next = null;
        ListNode pre = null;
        while (head != null) {//1
            //保存要反转到头来的那个节点
            next = head.next;//2
            // //要反转的那个节点指向已经反转的上一个节点
            head.next = pre;
            //上一个已经反转到头部的节点
            pre = head;
            //一直向链表尾走
            head = next;
        }
        return head;
    }

    //就地反转法
    static ListNode reverse5(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;//头指针
        ListNode prev = dummy.next;//头结点
        ListNode pCur = prev.next;//需要更换的结点
        //交换
        while (pCur != null) {
            prev.next = pCur.next;//头结点指向交换结点的下一个结点
            pCur.next = dummy.next;//交换结点放在头指针后面
            dummy.next = pCur;//纠正头结点dummy的指向
            pCur = prev.next;//pCur指向下一个要反转的结点
        }
        return dummy.next;//最终返回反转后的单链表
    }

    static ListNode reverse6(ListNode head) {
        if (head == null) return head;
        ListNode dommy = new ListNode(-1);
        //链表结构1->2->3
        dommy.next = head;//1
        ListNode prev = head;//1
        ListNode pCur = prev.next;//2
        while (pCur != null) {//2!=null
            //交换
            prev.next = pCur.next;
            pCur.next = dommy.next;
            dommy.next = pCur;
            pCur = prev.next;
        }
        return dommy.next;
    }

    //头插法
    static ListNode reverse7(ListNode head) {
        //1->2->3
        if (head == null) return head;
        ListNode dommy = new ListNode(-1);
        ListNode pCur = head;
        while (pCur != null) {
            ListNode pNext = pCur.next;//头结点的下一个结点
            pCur.next = dommy.next;//2和1交换，往头结点插
            dommy.next = pCur;
            pCur = pNext;
        }
        return dommy.next;
    }
}

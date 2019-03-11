package com.xjtu.ssmidea.algorithm;

/**
 * @auther coraljiao
 * @date 2019/3/11 14:53
 * @description
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点
 * 给定一个链表: 1->2->3->4->5, 和 n = 2. *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 链表中倒数第N个节点也就是正数第(L-N+1)个节点
 * 基本思路就是： 定义两个节点 node1、node2;node1 节点先跑，node1节点 跑到第 n+1 个节点的时候,node2 节点开始跑.当node1 节点跑到最后一个节点时，node2 节点所在的位置就是第 （L-n ） 个节点（L代表总链表长度，也就是倒数第 n+1 个节点）
 */
public class 删除链表的倒数第N个节点 {
    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode listNode = removeNthFromEnd2(a, 3);
        System.out.println("ok");
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 哑结点，哑结点用来简化某些极端情况，例如列表中只含有一个结点，或需要删除列表的头部
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        // 声明两个指向头结点的节点
        ListNode node1 = dummy, node2 = dummy;
        // node1 节点先跑，node1节点 跑到第 n 个节点的时候,node2 节点开始跑
        // 当node1 节点跑到最后一个节点时，node2 节点所在的位置就是第 （L-n ） 个节点，也就是倒数第 n+1（L代表总链表长度）
        while (node1 != null) {
            node1 = node1.next;
            if (n < 1 && node1 != null) {
                node2 = node2.next;
            }
            n--;
        }
        node2.next = node2.next.next;
        return dummy.next;
    }
    public static ListNode removeNthFromEnd2(ListNode head, int n){
        ListNode dummy2=new ListNode(0);
        dummy2.next=head;
        ListNode before=dummy2,after=dummy2;
        while (before!=null){
            before=before.next;
            if(n<1&&before!=null){
                after=after.next;
            }
            n--;
        }
        after.next=after.next.next;
        return dummy2;
    }
}

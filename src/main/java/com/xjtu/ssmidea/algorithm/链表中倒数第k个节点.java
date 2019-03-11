package com.xjtu.ssmidea.algorithm;

/**
 * @auther coraljiao
 * @date 2019/3/5 10:33
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @description 就是快慢指针，快指针先走k-1步，然后快慢指针一起走，当快指针走到末尾，那么慢指针就到了倒数第K个节点了，可以自己举个例子
 */
public class 链表中倒数第k个节点 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode listNode = FindKthToTail2(a, 2);
        System.out.println("ok");
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        int length = 0;
        ListNode tempHead = head;
        while (tempHead != null) {
            length++;//这里计算链表的长度
            tempHead = tempHead.next;
        }
        if (k > length || k <= 0)//因为倒数第K个节点，如果超过链表长度可不行呀
            return null;
        ListNode before = head;
        ListNode after = head;
        for (int i = 0; i < k - 1; i++)//快指针先走k-1步
            before = before.next;
        while (before.next != null) {
            before = before.next;
            after = after.next;//快慢指针一起走。
        }
        return after;
    }

    public static ListNode FindKthToTail2(ListNode head,int k){
        // 如果链表为空或者k小于等于0
        if (head==null||k<=0){return null;}
        // 声明两个指向头结点的节点
        ListNode node1 = head, node2 = head;
        // 记录节点的个数
        int count = 0;
        // 记录k值，后面要使用
        int index = k;
        // p指针先跑，并且记录节点数，当node1节点跑了k-1个节点后，node2节点开始跑，
        // 当node1节点跑到最后时，node2节点所指的节点就是倒数第k个节点
        while (node1!=null){
            node1=node1.next;
            count++;
            if (k<1&&node1!=null){
                node2=node2.next;
            }
            k--;
        }
        // 如果节点个数小于所求的倒数第k个节点，则返回空
        if (count<index){
            return null;
        }
        return node2;
    }
    public static ListNode FindKthToTail3(ListNode head,int k){
        int length=0;
        ListNode temp=head;
        while (temp!=null){
            length++;
            temp=temp.next;
        }
        if(length<k||k<=0){
            return null;
        }
        ListNode before=head;
        ListNode after=head;
        for (int i = 0; i < k - 1; i++) {
            before=before.next;
        }
        while (before.next!=null){
            before=before.next;
            after=after.next;
        }
        return after;
    }
}

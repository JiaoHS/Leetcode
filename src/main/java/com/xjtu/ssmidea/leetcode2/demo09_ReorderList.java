package com.xjtu.ssmidea.leetcode2;

/**
 * @auther coraljiao
 * @date 2018/12/30 18:55
 * @description
 */
//给出单链表L：L0→L1→......→Ln-1→Ln， 将其重新排序为：L0→Ln→L1→Ln-1→L2→Ln-2→...... 您可能无法修改列表节点中的值，只能更改节点本身。
//Given 1->2->3->4, reorder it to 1->4->2->3   Given 1->2->3->4->5, reorder it to 1->5->2->4->3
public class demo09_ReorderList {
    public static void main(String[] args){

    }
    public void reorderList(ListNode head) {
        //思路：将原链表循环到两个链表中（每隔一个元素）
        if(head==null||head.next==null) return;

        //Find the middle of the list
        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null&&p2.next.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle=p1;
        ListNode preCurrent=p1.next;
        while(preCurrent.next!=null){
            ListNode current=preCurrent.next;
            preCurrent.next=current.next;
            current.next=preMiddle.next;
            preMiddle.next=current;
        }

        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1=head;
        p2=preMiddle.next;
        while(p1!=preMiddle){
            preMiddle.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=preMiddle.next;
        }

    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


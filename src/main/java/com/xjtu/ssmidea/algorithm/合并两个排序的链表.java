package com.xjtu.ssmidea.algorithm;

/**
 * @auther coraljiao
 * @date 2019/3/11 15:04
 * @description
 * 剑指offer:输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
 *
 * 问题分析
 * 我们可以这样分析:
 *
 * 假设我们有两个链表 A,B；
 * A的头节点A1的值与B的头结点B1的值比较，假设A1小，则A1为头节点；
 * A2再和B1比较，假设B1小,则，A1指向B1；
 * A2再和B2比较 就这样循环往复就行了，应该还算好理解。
 * 考虑通过递归的方式实现！
 */
public class 合并两个排序的链表 {
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

        ListNode f = new ListNode(1);
        ListNode g = new ListNode(2);
        ListNode h = new ListNode(3);
        f.next = g;
        g.next = h;

        ListNode merge = Merge(a, f);
        System.out.println("ok");
    }
    public static ListNode Merge(ListNode list1,ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val<list2.val){
            list1.next=Merge(list1.next,list2);
            return list1;
        }else {
            list2.next=Merge(list1,list2.next);
            return list2;
        }
    }
}

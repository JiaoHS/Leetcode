package com.xjtu.ssmidea.algorithm;

import java.util.Scanner;
import java.util.Stack;

/**
 * @auther coraljiao
 * @date 2019/3/20 19:14
 * @description
 */
public class day008 {
    public static void main(String[] args) {
        //test();
        int[] arr = {1, 3, 2, 7, 4};
        sort1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

//        ListNode a = new ListNode(1);
//        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(3);
//        ListNode d = new ListNode(4);
//        ListNode e = new ListNode(5);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
//
//        ListNode f = new ListNode(6);
//        ListNode g = new ListNode(7);
//        f.next = g;
//        ListNode node = sort9(a, f);
//        while (node != null) {
//            System.out.println(node.val);
//            node = node.next;
//        }
    }

    //单链表反转
    private static ListNode sort6(ListNode head) {
        if (head == null) return null;
        ListNode next = null;
        ListNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //返回单链表的第k个
    public static ListNode sort7(ListNode head, int k) {
        if (head == null) return null;
        //先得到单链表的长度
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (length < k || k < 0) {
            return null;
        }
        //定义两个链表，一个先走k-1步，然后两个在一起走
        ListNode before = head;
        ListNode after = head;
        for (int i = k; i > 0; i--) {
            before = before.next;
        }
        while (before != null) {
            before = before.next;
            after = after.next;
        }

        return after;
    }

    //删除链表的第k个元素
    public static ListNode sort8(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode before = dummy, after = dummy;
        while (before != null) {
            before = before.next;
            if (k < 1 && before != null) {
                after = after.next;
            }
            k--;
        }
        after.next = after.next.next;
        return dummy;
    }

    //合并有序的单链表
    public static ListNode sort9(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = sort9(list1.next, list2);
            return list1;
        } else {
            list2.next = sort9(list1, list2.next);
            return list2;
        }
    }

    //快排
    private static void sort1(int[] arr) {
        if (arr.length < 0) return;
        sort2(arr, 0, arr.length - 1);
    }

    //归并排序
    public static void sort3(int[] arr) {
        int[] temp = new int[arr.length];
        sort4(arr, 0, arr.length - 1, temp);
    }

    private static void sort4(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort4(arr, left, mid, temp);
            sort4(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        //合并
        //左边的数组跟右边的数组从第一个数字开始比较
        int i = left, j = mid + 1;
        int t = 0;
        if (i < j && arr[i] < arr[j]) {
            temp[t++] = arr[i++];
        } else {
            temp[t++] = arr[j++];
        }
        //剩余的数
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    private static void sort2(int[] arr, int left, int right) {
        if (left > right) return;
        int temp = arr[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && arr[j] >= temp) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] <= temp) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = temp;
        sort2(arr, left, i - 1);
        sort2(arr, i + 1, right);
    }

    //堆排序
    public static void sort5(int[] arr) {
        //将数组构建堆
        for (int i = arr.length / 2 - 1; i > 0; i--) {
            adjust(arr, i, arr.length - 1);
        }
        //交换调整结构
        for (int i = arr.length - 1; i > 0; i--) {
            adjust(arr, 0, i);
            swap(arr, 0, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void adjust(int[] arr, int left, int right) {
        int first = arr[left];
        for (int k = 2 * left + 1; k < right; k = k * 2 + 1) {
            //先跟兄弟节点比较
            if (k + 1 < right && arr[k] < arr[k + 1]) {
                k++;
            }
            //跟父节点交换
            if (arr[k] > first) {
                arr[left] = arr[k];
                left = k;
            } else {
                break;
            }
        }
        arr[left] = first;
    }
    //反转单链表


    public static void test() {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        char[] array = sc.nextLine().toCharArray();
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < array.length; i++) {
            if (idDigit(array[i])) {
                stack.push(array[i] - '0');
            } else {
                int tmp = 0;
                int index = 1;
                while (!stack.empty()) {
                    tmp += stack.pop() * index;
                    index *= 10;
                }
                if (flag) {
                    sum += tmp;
                } else {
                    sum -= tmp;
                }
                if (array[i] == '-') {
                    flag = false;
                } else {
                    flag = true;
                }
            }
        }
        int tmp = 0;
        int index = 1;
        while (!stack.empty()) {
            tmp += stack.pop() * index;
            index *= 10;
        }
        if (flag) {
            sum += tmp;
        } else {
            sum -= tmp;
        }
        System.out.println(sum);
    }

    private static boolean idDigit(char c) {
        if (c - '0' >= 0 && c - '0' <= 9) {
            return true;
        }
        return false;
    }
}

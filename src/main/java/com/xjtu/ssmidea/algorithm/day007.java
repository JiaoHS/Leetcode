package com.xjtu.ssmidea.algorithm;

/**
 * @auther coraljiao
 * @date 2019/3/17 19:41
 * @description
 */

import java.util.Scanner;


public class day007 {

    public static void main(String[] args) {
        //test();

        int[] arr = {2, 5, 7, 1, 9};
        sort02(arr);
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
//        //ListNode node = sort05(a);
//        ListNode f = new ListNode(7);
//        ListNode g = new ListNode(8);
//        f.next = g;
//        sort06(a, f);
//
//        sort05(a);
////        while (g != null) {
////            System.out.println(g.val);
////            g = g.next;
////        }
//        ListNode node = sort4(g, 2);
//        System.out.println(node.val);
    }

    //选择排序
    public static void sort06(int[] arr) {
        if (arr == null || arr.length < 2) return;


        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    //插入排序
    public static void sort07(int[] arr) {
        //以第一个数为准，从第二个数开始与前面的数比较，然后交换
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j+1);
            }
        }
    }

    //反转单链表
    private static ListNode sort05(ListNode head) {
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

    //合并有序的单链表
    public static ListNode sort06(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = sort06(list1.next, list2);
            return list1;
        } else {
            list2.next = sort06(list1, list2.next);
            return list2;
        }

    }

    //链表中的第k个节点
    public static ListNode sort4(ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (k > length || k <= 0) {
            return null;
        }
        ListNode before = head;
//        ListNode after = head;
        ListNode dummy = new ListNode(0);
        for (int i = 1; i < length; i++) {
            if (k == i) {
                before.next = before.next.next;
            } else {
                dummy.next = before.next;
            }

        }
//        while (before.next != null) {
//            before = before.next;
//            after = after.next;
//        }
//        after.next=after.next.next;
        return before;
    }

    //堆排序
    private static void sort04(int[] arr) {
        //构建堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }
        //交换并调整
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);
            adjust(arr, 0, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void adjust(int[] arr, int left, int right) {
        int first = arr[left];
        //从i结点的左子结点开始，也就是2i+1处开始
        for (int i = left * 2 + 1; i < right; i = 2 * i + 1) {
            //先跟右节点比较
            if (i + 1 < right && arr[i] < arr[i + 1]) {
                i++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (arr[i] > first) {
                arr[left] = arr[i];
                left = i;
            } else {
                break;
            }
        }
        arr[left] = first;
    }

    //归并排序
    private static void sort02(int[] arr) {
        //先初始化一个替换数组
        int[] temp = new int[arr.length];
        sort03(arr, 0, arr.length - 1, temp);
    }

    private static void sort03(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort03(arr, left, mid, temp);
            sort03(arr, mid + 1, right, temp);
            mergeSort(arr, left, mid, right, temp);
        }
    }

    private static void mergeSort(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1;
        int t = 0;
        if (i < j && arr[i] < arr[j]) {
            temp[t++] = arr[i++];
        } else {
            temp[t++] = arr[j++];
        }
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

    private static void sort(int[] arr) {
        sort01(arr, 0, arr.length - 1);
    }

    private static void sort01(int[] arr, int left, int right) {
        if (left > right) return;
        int i = left, j = right;
        int temp = arr[left];
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
        sort01(arr, left, i - 1);
        sort01(arr, i + 1, right);
    }

    public static void test() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] li = new int[n];
        for (int i = 0; i < n; i++) {
            li[i] = scanner.nextInt();
        }
        int[] di = new int[n];
        for (int i = 0; i < n; i++) {
            di[i] = scanner.nextInt();
        }

        //按桌腿长度从大到小排序
        for (int i = 0; i < n - 1; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (li[j] > li[index]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = li[i];
                li[i] = li[index];
                li[index] = temp;
                temp = di[i];
                di[i] = di[index];
                di[index] = temp;
            }
        }

        int result = getMin(li, di, 0, n);
        System.out.println(result);
    }

    //求最优解
    public static int getMin(int[] li, int[] di, int start, int n) {

        int maxNum = 1;
        int count = di[start];
        for (int i = start + 1; i < n; i++) {
            if (li[i] == li[start]) {
                maxNum++;
                count += di[i];
            } else {
                break;
            }
        }

        if (maxNum * 2 > n - start) {
            return 0;
        } else {
            //不保留当前最长桌腿
            int a = getMin(li, di, start + maxNum, n) + count;
            //保留当前最长桌腿
            int b = getCount(li, di, start + maxNum, maxNum, n);
            return a < b ? a : b;
        }
    }

    //保留最长桌腿，砍去其他代价和最小的部分桌腿s
    private static int getCount(int[] li, int[] di, int start, int maxNum, int n) {
        int num = n - start - maxNum;
        if (num < 0) {
            return 0;
        } else {
            int[] arr = new int[n - start];
            int length = arr.length;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = di[start + i];
            }
            int count = 0;
            int x = 0;
            while (num >= 0) {
                int index = x;
                for (int i = x; i < length; i++) {
                    if (arr[i] < arr[index]) {
                        index = i;
                    }
                }
                int temp = arr[index];
                arr[index] = arr[x];
                arr[x] = temp;
                count += arr[x];
                x++;
                num--;
            }
            return count;
        }
    }
}

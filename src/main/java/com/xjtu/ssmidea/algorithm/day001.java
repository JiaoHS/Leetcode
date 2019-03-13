package com.xjtu.ssmidea.algorithm;

/**
 * @auther coraljiao
 * @date 2019/3/13 10:06
 * @description
 */
public class day001 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 1};
        sort2(arr);
        //sort1(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
//        sort3(a);
//        while (e != null) {
//            System.out.println(e.val);
//            e = e.next;
//        }

//        sort5(a, 3);
//        while (a != null) {
//            System.out.println(a.val);
//            a = a.next;
//        }


        ListNode x = new ListNode(1);
        ListNode y = new ListNode(7);
        ListNode z = new ListNode(9);
        x.next = y;
        y.next = z;

//        ListNode sort6 = sort6(a, x);
//
//        while (sort6 != null) {
//            System.out.println(sort6.val);
//            sort6 = sort6.next;
//        }
    }

    //快排
    public static void sort1(int[] array, int low, int high) {
        if (low > high) return;
        int i = low, j = high;
        int temp = array[low];
        while (i < j) {
            while (i < j && array[j] >= temp) {
                j--;
            }
            array[i] = array[j];
            while (i < j && array[i] <= temp) {
                i++;
            }
            array[j] = array[i];
        }
        array[i] = temp;
        sort1(array, low, i - 1);
        sort1(array, i + 1, high);
    }

    //堆排序
    public static void sort2(int[] arr) {
        //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);//重新对堆进行调整
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (arr[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    //反转链表
    public static ListNode sort3(ListNode head) {
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

    //链表中第k个节点
    public static ListNode sort4(ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (length < k || k <= 0) return null;
        ListNode before = head;
        ListNode after = head;
        for (int i = 0; i < k - 1; i++) {
            before = before.next;
        }
        while (before.next != null) {
            before = before.next;
            after = after.next;
        }
        return after;
    }

    //删除第k个节点
    public static ListNode sort5(ListNode head, int k) {
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

    //合并两个排序的链表
    public static ListNode sort6(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = sort6(list1.next, list2);
            return list1;
        } else {
            list2.next = sort6(list1, list2.next);
            return list2;
        }
    }
}

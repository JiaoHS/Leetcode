package com.xjtu.qiuzhao;


import java.io.IOException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @auther coraljiao
 * @date 2019/8/29 16:38
 * @description
 */
public class day001 {
    public static void main(String[] args) throws IOException {
//        StringBuilder stringBuilder=new StringBuilder();
//
//        String str="jiao";
//        System.out.println(str.equals("shan"));
//        System.out.println(str=="sd");

        //try
//        try {
//            int i=1/0;
//            return;
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//            System.exit(1);
//            return;
//        }finally {
//            //int j=1/0;报错不会执行finally里的代码
//            System.out.println("finally");
//        }

        //键盘输入
//        Scanner scanner=new Scanner(System.in);
//        String str=scanner.nextLine();
//        scanner.close();
//        System.out.println(str);

//        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
//        String str=input.readLine();

//        int[] arr = {8, 2, 4, 5, 1};
//        duiSort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }

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
//        ListNode f = new ListNode(7);
//        ListNode g = new ListNode(8);
//        ListNode h = new ListNode(9);
//        f.next = g;
//        g.next = h;
//        //ListNode listNode = reverseNode(a);
////        ListNode nodeIndex = getNodeK(a, 2);
////        System.out.println(nodeIndex.val);
//        ListNode listNode = mergeNode(a, f);
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }

        //两个无序数组,不用set的情况下求二者的交集
        int[] arrayA = new int[]{1, 1, 2, 3, 4, 4, 5, 1, 1};
        int[] arrayB = new int[]{11, 1, 22, 3, 43, 4, 5, 11, 1, 22};
        testArrayIntersectionE(arrayA, arrayB);

    }

    public static void testArrayIntersectionE(int[] arrayA, int[] arrayB) {

        int sizeArrayA = arrayA.length;
        int sizeArrayB = arrayB.length;

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        Queue<Integer> queueA = new ArrayBlockingQueue<Integer>(sizeArrayA);
        Queue<Integer> queueB = new ArrayBlockingQueue<Integer>(sizeArrayB);
        for (int i = 0; i < sizeArrayA; i++) {
            queueA.add(arrayA[i]);
        }
        for (int i = 0; i < sizeArrayB; i++) {
            queueB.add(arrayB[i]);
        }
        Set<Integer> intersectionSet = new HashSet<Integer>();
        //HashMap<Integer,Integer> intersectionSet = new HashMap<Integer>();

        while (!queueA.isEmpty()) {
            Integer valueA = queueA.peek();
            Integer valueB = queueB.peek();
            if (null == valueA || null == valueB) {
                break;
            }
            if (valueA.equals(valueB)) {
                intersectionSet.add(valueA);
                queueA.poll();
                queueB.poll();
            } else if (valueA > valueB) {
                queueB.poll();
            } else if (valueA < valueB) {
                queueA.poll();
            }
        }
        for (Integer str : intersectionSet) {
            System.out.println(str);
        }
    }

    //合并两个有序的单链表
    private static ListNode mergeNode(ListNode list1, ListNode list2) {
        while (list1 == null) return list2;
        while (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeNode(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeNode(list1, list2.next);
            return list2;
        }
    }

    //获取链表中的倒数第k个元素
    private static ListNode getNodeK(ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (length < k || k <= 0) {
            return null;
        }
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

    //反转链表
    private static ListNode reverseNode(ListNode head) {
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

    //冒泡排序
    private static void sort003(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    //归并排序
    private static void sort004(int[] arr) {
        int[] temp = new int[arr.length];
        sort006(arr, 0, arr.length - 1, temp);
    }

    private static void sort006(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort006(arr, left, mid, temp);
            sort006(arr, mid + 1, right, temp);
            merge006(arr, left, mid, right, temp);
        }
    }

    private static void merge006(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
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

    //快排
    private static void sort001(int[] arr) {
        sort002(arr, 0, arr.length - 1);
    }

    private static void sort002(int[] arr, int left, int right) {
        if (left > right) return;
        int i = left, j = right;
        int temp = arr[i];
        while (i != j) {
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
        sort002(arr, left, i - 1);
        sort002(arr, i + 1, right);
    }

    //堆排序
    public static void duiSort(int[] arr) {
        //构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustDui(arr, i, arr.length);
        }
        //调整堆结构，交换堆顶和堆底元素
        for (int j = arr.length - 1; j > 0; j--) {
            swapDui(arr, 0, j);
            adjustDui(arr, 0, j);
        }
    }

    private static void swapDui(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void adjustDui(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }


}

class SingleTon {
    private volatile static SingleTon singleTon;//防止指令重排

    private SingleTon() {
    }

    public static SingleTon getSingleTon() {
        if (singleTon == null) {
            synchronized (SingleTon.class) {
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}

//class ListNode {
//    int val;
//    ListNode next = null;
//
//    ListNode(int var) {
//        this.val = var;
//    }
//}

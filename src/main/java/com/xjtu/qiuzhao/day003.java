package com.xjtu.qiuzhao;

/**
 * @auther coraljiao
 * @date 2019/9/7 08:45
 * @description
 */
public class day003 {
    public static void main(String[] args) {
//        int[] arr = {4, 1, 7, 6};
//        dui003Sort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }

        ListNode a = new ListNode(4);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(6);
        ListNode d = new ListNode(7);
        ListNode e = new ListNode(8);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode f = new ListNode(1);
        ListNode g = new ListNode(9);
        ListNode h = new ListNode(11);
        f.next = g;
        g.next = h;

        ListNode listNode = getNode003(a, 3);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }
    //获取链表中的倒数第k个元素
    private static ListNode getNode003(ListNode a, int k) {
        if (a == null) return null;
        int length = 0;
        ListNode temp = a;
        ListNode before = a;
        ListNode after = a;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (k <= 0 || k > length) return null;
        for (int j = 0; j < length - 1; j++) {
            before = before.next;
        }
        while (before.next != null) {
            before = before.next;
            after = after.next;
        }
        return after;
    }

    //合并有序的单链表
    private static ListNode mergeNode003(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeNode003(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeNode003(list1, list2.next);
            return list2;
        }
    }

    //单链表反转
    private static ListNode reverse003(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    //

    //堆排序
    private static void dui003Sort(int[] arr) {
        //构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            dui003Sort003(arr, i, arr.length);
        }
        //调整堆结构   比较并交换顺序
        for (int j = arr.length - 1; j > 0; j--) {
            dui003Sort003(arr, 0, j);
            sqap003(arr, 0, j);
        }
    }

    private static void sqap003(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void dui003Sort003(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
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

    //归并排序
    private static void guibing003Sort(int[] arr) {
        int[] temp = new int[arr.length];
        guibing003Sort003(arr, 0, arr.length - 1, temp);
    }

    private static void guibing003Sort003(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            guibing003Sort003(arr, left, mid, temp);
            guibing003Sort003(arr, mid + 1, right, temp);
            merge003(arr, left, mid, right, temp);
        }
    }

    private static void merge003(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, t = 0;
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

    //冒泡
    private static void mp003Sort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] > arr[j - 1]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    //快排
    private static void quickSort(int[] arr) {
        quickSort003(arr, 0, arr.length - 1);
    }

    private static void quickSort003(int[] arr, int left, int right) {
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
        //temp复原
        arr[i] = temp;
        quickSort003(arr, left, i - 1);
        quickSort003(arr, i + 1, right);
    }


}
//单例模式 双检查
class Singlon{
    private static volatile Singlon singlon;
    private Singlon(){}
    public static Singlon getSinglon(){
        if (singlon==null){
            synchronized (Singlon.class){
                if (singlon==null){
                    singlon=new Singlon();
                }
            }
        }
        return singlon;
    }
}
//静态内部类
class Sington1{
    private Sington1(){}
    private static class getSington1{
        private static Sington1 sington1=new Sington1();
    }
    public static Sington1 getINs(){
        return getSington1.sington1;
    }
}
//枚举
enum Sington2{
    INSTANCE;
    public void getIns(){}
}

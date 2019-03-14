package com.xjtu.ssmidea.algorithm;

/**
 * @auther coraljiao
 * @date 2019/3/14 10:37
 * @description
 */
public class day002 {
    public static void main(String[] args) {
//        int[] arr = {2, 5, 7, 1, 9};
//        //sort2(arr);
//        //sort002(arr);
//        sort0021(arr, 0, arr.length - 1);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }


        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        //反转链表
//        reverse002(a);
//        while (e != null) {
//            System.out.println(e.val);
//            e = e.next;
//            //a=a.next;
//        }

//        ListNode indexK = getIndexK(a, 3);
//        System.out.println(indexK.val);
//         ListNode deleteIndexK = deleteIndexK(a, 3);
//        while (a != null) {
//            System.out.println(a.val);
//            a = a.next;
//            //a=a.next;
//        }
        ListNode f = new ListNode(7);
        ListNode g = new ListNode(8);
        f.next=g;
        merge(a,f);
                while (a != null) {
            System.out.println(a.val);
            a = a.next;
            //a=a.next;
        }

    }
    //获取链表的第k个节点
    private static ListNode getIndexK(ListNode head, int k) {
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
    private static void reverse002(ListNode head) {
        if (head == null) return;
        ListNode next = null;
        ListNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
    }
    //链表中第k个节点
    private static ListNode deleteIndexK(ListNode head, int k) {
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
    //合并两个有序的链表
    public static ListNode merge(ListNode list1,ListNode list2){
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }
        if (list1.val<list2.val){
            list1.next=merge(list1.next,list2);
            return list1;
        }else {
            list2.next=merge(list1,list2.next);
            return list2;
        }
    }
    //快排
    private static void sort0021(int[] arr, int low, int high) {
        if (low > high) return;
        int i = low, j = high;
        int temp = arr[low];
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
        sort0021(arr, low, i - 1);
        sort0021(arr, i + 1, high);
    }
    //堆排序是一种选择排序，整体主要由构建初始堆+交换堆顶元素和末尾元素并重建堆两部分组成。
    private static void sort2(int[] arr) {
        //构建大顶堆
        for (int i = 0; i < arr.length / 2 - 1; i++) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        // //2.调整堆结构+交换堆顶元素与末尾元素
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
    private static void adjustHeap(int[] array, int i, int length) {
        int first = array[i];//先取出当前元素i
        //从i结点的左子结点开始，也就是2i+1处开始
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && array[k] < array[k + 1]) {
                //如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (array[k] > first) {
                //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                array[i] = array[k];
                i = k;
            } else {
                //如果子节点小于父节点，跳出
                break;
            }
        }
        array[i] = first;//将temp值放到最终的位置
    }
    //归并排序是稳定排序，
    private static void sort002(int[] arr) {
        int[] temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr, 0, arr.length - 1, temp);
    }
    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);//左边归并排序，使得左子序列有序
            sort(arr, mid + 1, right, temp);//右边归并排序，使得右子序列有序
            merge(arr, left, mid, right, temp);//将两个有序子数组合并操作
        }
    }
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针
        //循环比较左右的大小并插入新的数组
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //还有剩余，则将左边剩余全部插入的数组中
        while (i <= mid) {//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }


}

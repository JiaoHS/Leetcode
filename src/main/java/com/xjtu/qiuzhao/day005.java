package com.xjtu.qiuzhao;

import java.util.HashMap;

/**
 * @auther coraljiao
 * @date 2019/9/9 08:46
 * @description
 */
public class day005 {
    public static void main(String[] args) {
//        int[] array = {1, 2, 2, 3, 4};
//        if (array == null && array.length == 0) {
//            System.out.println("no");
//        }
//        /**size:用来统计数组中没有重复的元素个数*/
//        int size = 0;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] != array[size]) {
//                /**修改数组中的值*/
//                array[++size] = array[i];
//            }
//        }
//        /**返回没有重复的个数*/
//        System.out.println(size + 1);

//        int[] arr = {4, 1, 7, 6};
//        MaoPaoSort004Sort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }


//        ListNode a = new ListNode(4);
//        ListNode b = new ListNode(5);
//        ListNode c = new ListNode(6);
//        ListNode d = new ListNode(7);
//        ListNode e = new ListNode(8);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
//
//        ListNode f = new ListNode(1);
//        ListNode g = new ListNode(9);
//        ListNode h = new ListNode(11);
//        f.next = g;
//        g.next = h;
//
//        ListNode listNode = getNode005(a, 2);
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }

        int[] arr = {3, 2, 5, 6};
        int target = 5;

        int[] num = isNum(arr, target);
        System.out.println("ok");
//        Stack<Integer> stack = new Stack<>();
//        Scanner sc = new Scanner(System.in);
//        char[] array = sc.nextLine().toCharArray();
//        int sum = 0;
//        boolean flag = true;
//        for (int i = 0; i < array.length; i++) {
//            if (isDigit(array[i])) {
//                stack.push(array[i]-'0');
//            }else {
//                int tmp = 0;
//                int index = 1;
//                while (!stack.empty()) {
//                    tmp += stack.pop() * index;
//                    index *= 10;
//                }
//                if (flag){
//                    sum += tmp;
//                }else {
//                    sum -= tmp;
//                }
//                if (array[i] == '-'){
//                    flag = false;
//                }else {
//                    flag = true;
//                }
//            }
//        }
//
//        int tmp = 0;
//        int index = 1;
//        while (!stack.empty()) {
//            tmp += stack.pop() * index;
//            index *= 10;
//        }
//        if (flag){
//            sum += tmp;
//        }else {
//            sum -= tmp;
//        }
//        System.out.println(sum);
    }

    //数组中不重复元素的个数
    private static int getCount(int[] nums) {
        if (nums == null && nums.length == 0) {
            return 0;
        }
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[size]) {
                nums[++size] = nums[i];
            }
        }
        return size + 1;
    }

    //求数组中两个数的和等于目标数target
    private static int[] isNum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp) && map.get(temp) != i) {
                return new int[]{i, map.get(temp)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //青蛙跳台阶
    private static int getNum2(int n) {
        if (n != 1) {
            if (n != 2) {
                return getNum2(n - 1) + getNum2(n - 2);
            } else return 2;
        } else return 1;
    }

    //求最大公约数
    private static int getNum(int num1, int num2) {
        if (num1 == num2) return num1;
        int big = num1 > num2 ? num1 : num2;
        int small = num1 > num2 ? num2 : num1;
        return getNum(big - small, small);
    }

    private static ListNode getNode005(ListNode head, int k) {
        if (head == null) return null;
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

    //单链表反转
    private static ListNode reverse005(ListNode head) {
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

    //maopao
    private static void MaoPaoSort004Sort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] > arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    //堆排序
    private static void duiSort004Sort(int[] arr) {
        //构建堆结构
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust004(arr, i, arr.length - 1);
        }
        //调整堆结构  交换元素位置
        for (int j = arr.length - 1; j > 0; j--) {
            adjust004(arr, 0, j);
            swap004(arr, 0, j);
        }
    }

    private static void swap004(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void adjust004(int[] arr, int i, int length) {
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

    //归并
    private static void guiBingSort004Sort(int[] arr) {
        int[] temp = new int[arr.length];
        guiBingSort004Sort004(arr, 0, arr.length - 1, temp);
    }

    private static void guiBingSort004Sort004(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            guiBingSort004Sort004(arr, left, mid, temp);
            guiBingSort004Sort004(arr, mid + 1, right, temp);
            merge004(arr, left, mid, right, temp);
        }
    }

    private static void merge004(int[] arr, int left, int mid, int right, int[] temp) {
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

    //kuaipai
    private static void quickSort004Sort(int[] arr) {
        quickSort004Sort004(arr, 0, arr.length - 1);
    }

    private static void quickSort004Sort004(int[] arr, int left, int right) {
        if (left > right) return;
        int i = left, j = right;
        int temp = arr[left];
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
        quickSort004Sort004(arr, left, i - 1);
        quickSort004Sort004(arr, i + 1, right);
    }

    public static boolean isDigit(char c) {
        if (c - '0' >= 0 && c - '0' <= 9) {
            return true;
        }
        return false;
    }
}

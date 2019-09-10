package com.xjtu.qiuzhao;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @auther coraljiao
 * @date 2019/9/8 09:09
 * @description
 */
public class day004 {
    public static void main(String[] args) {
//        int[] arr = {4, 1, 7, 6};
//        dui004Sort(arr);
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
//        ListNode listNode = reverse(a);
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
        int[] arr = {1, 3, 5, 7, 9, 11};
        int key = 5;
        int position = serch2(arr, key, 0, arr.length - 1);
        System.out.println(position);
    }



    //非递归二分查找
    private static int serch2(int[] arr, int key, int low, int high) {
        if (arr[low] > key || arr[high] < key || low > high) return -1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] > key) {
                high = mid - 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //递归二分查找
    private static int serch(int[] arr, int key, int low, int high) {
        if (key < arr[low] || key > arr[high] || low > high) return -1;
        int mid = (low + high) / 2;
        if (arr[mid] > key) {
            return serch(arr, key, low, mid - 1);
        } else if (arr[mid] < key) {
            return serch(arr, key, low + 1, high);
        } else {
            return mid;
        }
    }

    //二叉树节点的最大值
    public TreeNode maxNode(TreeNode root) {
        if (root == null) return null;
        TreeNode leftMaxNode = root.left != null ? maxNode(root.left) : null;
        TreeNode rightMaxNode = root.right != null ? maxNode(root.right) : null;
        if (leftMaxNode != null && rightMaxNode != null) {
            TreeNode tempNode = leftMaxNode.val > rightMaxNode.val ? leftMaxNode : rightMaxNode;
            return tempNode.val > root.val ? tempNode : root;
        } else if (leftMaxNode != null) {
            return leftMaxNode.val > root.val ? leftMaxNode : root;
        } else if (rightMaxNode != null) {
            return rightMaxNode.val > root.val ? rightMaxNode : root;
        }
        return root;
    }

    //二叉树 第k大节点
    LinkedList<TreeNode> list = new LinkedList<>();

    TreeNode serchNode(TreeNode root, int k) {
        startBuildList(root);
        if (list.size() < k || k < 1) return null;
        else {
            return list.get(k - 1);
        }
    }

    private void startBuildList(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            startBuildList(root.left);
        }
        list.add(root);
        if (root.right != null) {
            startBuildList(root.right);
        }
    }


    //前序
    private static void preSort(TreeNode node) {
        if (node != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                System.out.println(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
    }

    //单链表反转
    private static ListNode reverse(ListNode head) {
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


    //合并有序的单链表
    private static ListNode mergeNode004(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeNode004(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeNode004(list1, list2.next);
            return list2;
        }
        //return null;
    }

    //获取单聊表的倒数第k个元素
    private static ListNode getNode004(ListNode a, int k) {
        if (a == null) return null;
        int length = 0;
        ListNode temp = a;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (k > length || k <= 0) return null;
        ListNode before = a;
        ListNode after = a;
        for (int i = 0; i < k - 1; i++) {
            before = before.next;
        }
        while (before.next != null) {
            before = before.next;
            after = after.next;
        }
        return after;
    }

    //对排序
    private static void dui004Sort(int[] arr) {
        //构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust004(arr, i, arr.length);
        }
        //调整堆结构，交换
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

    //归并
    private static void guiBing004Sort(int[] arr) {
        int[] temp = new int[arr.length];
        guiBing004Sort004(arr, 0, arr.length - 1, temp);
    }

    private static void guiBing004Sort004(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            guiBing004Sort004(arr, left, mid, temp);
            guiBing004Sort004(arr, mid + 1, right, temp);
            mergeGuiBing004(arr, left, mid, right, temp);
        }
    }

    private static void mergeGuiBing004(int[] arr, int left, int mid, int right, int[] temp) {
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
    private static void maoPao004Sort(int[] arr) {
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

    //快排
    private static void kuaiPai004Sort(int[] arr) {
        kuaiPai004Sort004(arr, 0, arr.length - 1);
    }

    private static void kuaiPai004Sort004(int[] arr, int left, int right) {
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
        kuaiPai004Sort004(arr, left, i - 1);
        kuaiPai004Sort004(arr, i + 1, right);
    }
}

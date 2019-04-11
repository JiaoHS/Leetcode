package com.xjtu.ssmidea.jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther coraljiao
 * @date 2019/4/9 21:37
 * @description
 */
public class day05 {
    public static void main(String[] args) {
        //test001();


//        int n = 123321;
//        System.out.println(pali(n));

//        int[] arrs = {5, 3, 7, 1, 2};
//        sort055(arrs);
//        for (int i = 0; i < arrs.length; i++) {
//            System.out.println(arrs[i]);
//        }

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;


        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        f.next = g;
        ListNode node = sort059(a, f);
        System.out.println(node.val);
//        while (node != null) {
//            System.out.println(node.val);
//            node = node.next;
//        }

        ExecutorService pool = Executors.newScheduledThreadPool(4);
    }

    //合并有序的两个链表
    private static ListNode sort059(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = sort059(list1.next, list2);
            return list1;
        } else {
            list2.next = sort059(list1, list2.next);
            return list2;
        }
    }

    //删除第k个
    private static ListNode sort058(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
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
        return after;
    }

    //返回链表的第k个
    private static ListNode sort057(ListNode head, int k) {
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

    //

    private static ListNode sort056(ListNode head) {
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

    //堆排序
    private static void sort055(int[] arrs) {
        //构建堆结构
        for (int i = arrs.length / 2 - 1; i > 0; i--) {
            adjust055(arrs, i, arrs.length - 1);
        }
        //交换并调整
        for (int i = arrs.length - 1; i > 0; i--) {
            adjust055(arrs, 0, i);
            swap055(arrs, 0, i);
        }
    }

    private static void swap055(int[] arrs, int i, int j) {
        int temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }

    private static void adjust055(int[] arrs, int left, int right) {
        int temp = arrs[left];
        for (int k = 2 * left + 1; k < right; k = k * 2 + 1) {
            if (k + 1 < right && arrs[k] < arrs[k + 1]) {
                k++;
            }
            if (arrs[k] > temp) {
                arrs[left] = arrs[k];
                left = k;
            } else {
                break;
            }
        }
        arrs[left] = temp;
    }

    //归并排序
    private static void sort053(int[] arrs) {
        int[] temp = new int[arrs.length];
        sort054(arrs, 0, arrs.length - 1, temp);
    }

    private static void sort054(int[] arrs, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort054(arrs, left, mid, temp);
            sort054(arrs, mid + 1, right, temp);
            merge052(arrs, left, mid, right, temp);
        }
    }

    private static void merge052(int[] arrs, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arrs[i] < arrs[j]) {
                temp[t++] = arrs[i++];
            } else {
                temp[t++] = arrs[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arrs[i++];
        }
        while (j <= right) {
            temp[t++] = arrs[j++];
        }
        t = 0;
        while (left <= right) {
            arrs[left++] = temp[t++];
        }
    }

    //快排
    private static void sort051(int[] arrs) {
        sort052(arrs, 0, arrs.length - 1);
    }

    private static void sort052(int[] arrs, int left, int right) {
        if (left > right) return;
        int i = left, j = arrs.length - 1;
        int temp = arrs[left];
        while (i < j) {
            while (i < j && arrs[j] >= temp) {
                j--;
            }
            arrs[i] = arrs[j];
            while (i < j && arrs[i] <= temp) {
                i++;
            }
            arrs[j] = arrs[i];
        }
        arrs[i] = temp;
        sort052(arrs, left, i - 1);
        sort052(arrs, i + 1, right);
    }

    public static void test001() {
        String s = "abccba";
//        StringBuilder sb = new StringBuilder(s);
//        System.out.println(s.equals(sb.reverse().toString()));

        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                System.out.println(false);
                System.exit(0);
            }
            i++;
            j--;
        }
        System.out.println(true);
    }

    //数字回文
    public static boolean pali(int n) {
        if (n < 0) {
            return false;
        }
        if (n < 10) {
            return true;
        }
        int tmp = n;
        int count = 0;
        while (tmp != 0) {
            count++;
            tmp = tmp / 10;
        }
        int i = 1;
        while (i < count) {
            if (n % pow(i, 10) / pow(i - 1, 10) != n / pow(count - 1, 10) % 10) {
                return false;
            }
            i++;
            count--;
        }
        return true;
    }

    public static int pow(int i, int j) {
        int res = 1;
        while (i > 0) {
            res *= j;
            i--;
        }
        return res;
    }

    //3个重复的数字删除
    public static String paopao(String s, int k) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if (stack.isEmpty()) {
                stack.push(array[i]);
                count.push(1);
            } else {
                if (stack.peek() == array[i]) {
                    count.push(count.peek() + 1);
                } else {
                    count.push(1);
                }
                stack.push(array[i]);

                if (count.peek() == k) {
                    int t = k;
                    while (t > 0) {
                        count.pop();
                        stack.pop();
                        t--;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();

    }

    //二叉树转双向链表
    public static TreeNode change(TreeNode head, TreeNode tail, TreeNode root) {
        if (root == null) {
            return null;
        }
        change(head, tail, root.left);
        if (head == null) {
            head = root;
            tail = root;
        } else {
            tail.right = root;
            root.left = tail;
            tail = root;
        }
        change(head, tail, root.right);
        return head;
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null || (pRootOfTree.left == null && pRootOfTree.right == null))
            return pRootOfTree;
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        BuildArrayList(pRootOfTree, nodeList);//这个函数执行后，数组中每个元素按照大小前后排序
        for (int i = 0; i < nodeList.size(); i++) {
            if (i == 0) {//数组的第一个节点处理，只有右子树指向下一个节点
                nodeList.get(0).right = nodeList.get(1);
            } else if (i == nodeList.size() - 1) {//数组的最后一个节点，只有左子树指向前一个节点
                nodeList.get(i).left = nodeList.get(i - 1);
            } else {//数组中的中间节点，左子树指向上一个节点，右子树指向数组的下一个节点
                nodeList.get(i).left = nodeList.get(i - 1);
                nodeList.get(i).right = nodeList.get(i + 1);
            }
        }
        return nodeList.get(0);
    }

    public void BuildArrayList(TreeNode root, ArrayList<TreeNode> nodeList) {//二叉搜索的中序遍历，并把每个节点存入数组中
        if (root == null)
            return;
        if (root.left != null)//左子树
            BuildArrayList(root.left, nodeList);
        if (root != null)//根节点
            nodeList.add(root);
        if (root.right != null)//右子树
            BuildArrayList(root.right, nodeList);
    }
}

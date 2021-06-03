package com.xjtu.qiuzhao;

import com.sun.org.apache.regexp.internal.RE;
import com.xjtu.ssmidea.jianzhioffer.ListNode;
import com.xjtu.ssmidea.jianzhioffer.TreeNode;
import javafx.scene.transform.Rotate;
import org.apache.coyote.OutputBuffer;
import org.springframework.boot.logging.LogLevel;

import javax.sound.midi.Soundbank;
import javax.xml.stream.FactoryConfigurationError;
import java.lang.reflect.WildcardType;
import java.util.*;

import static com.xjtu.ssmidea.algorithm.MaoPao.swap;

/**
 * @auther coraljiao
 * @date 2020/2/8 10:46
 * @description
 */
public class day009 {
    public static void main(String[] args) {
//        int[] array = {5, 1, 9, 8, 2};
//        quickSort(array);
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }

//        ListNode a = new ListNode(1);
//        ListNode b = new ListNode(1);
//        ListNode c = new ListNode(2);
//        ListNode d = new ListNode(2);
//        ListNode e = new ListNode(8);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
//        ListNode listNode = print20(a);
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }


//        ListNode ele = getEle(a, 2);
//        System.out.println(ele.val);

//        insert('g');
//        insert('0');
//        insert('g');
//        insert('g');
//        insert('g');
//        insert('l');
//        FirstAppearingOnce();

//       int[] nums= {2,3,4,2,6,2,5,1};
//        ArrayList<Integer> arrayList = maxInWindows2(nums, 3);
//        double[] array = {51.72, 52.28, 52.72, 56.08, 61.97, 58.22, 53.28, 51.95, 56.95, 52.78, 56.4, 59.18, 56.43, 52.71, 63.49, 61.97, 62.41, 59.15, 62.46, 55.65, 50.82, 50.88, 50.49, 54.22, 55.05, 57.12, 49.01, 49.94, 49.57, 49.9};
//        duiSort(array);
//        double sum = 0;
//        for (int i = 0; i < array.length; i++) {
//            sum += array[i];
//        }
//        double avg = sum / array.length;
//        System.out.println(sum);
//        System.out.println(avg);
        int [] array = {4,2,1,8,5,9};
        findTopN(array,3);
    }

    //1.单链表反转
    public static ListNode print01(ListNode head) {
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

    //2.符号是否合法
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (Character c : s.toCharArray()) {
            if (c.equals('(')) {
                stack.push(')');
            } else if (c.equals('{')) {
                stack.push('}');
            } else if (c.equals('[')) {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    //3.快排
    public static void quickSort(double[] array) {
        print(array, 0, array.length - 1);
    }

    private static void print(double[] array, int i, int length) {
        if (i > length) return;
        double temp = array[i];
        int left = i, right = length;
        while (left != right) {
            if (left < right && array[right] >= temp) {
                right--;
            }
            array[left] = array[right];
            if (left < right && array[left] <= temp) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = temp;
        print(array, i, left - 1);
        print(array, i + 1, right);
    }

    //4.堆排序
    public static void duiSort(double[] array) {
        //构建大顶堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjust(array, i, array.length - 1);
        }
        //调整堆结构，交换
        for (int i = array.length - 1; i > 0; i--) {
            //先交换再调整结构
            swap1(array, 0, i);
            adjust(array, 0, i);

        }
    }

    private static void swap1(double[] array, int i, int j) {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void adjust(double[] array, int i, int length) {
        double temp = array[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;
            }

            if (array[k] > temp) {
                array[i] = array[k];
                i = k;
            } else {
                break;
            }
        }
        array[i] = temp;
    }

    //5.归并排序
    public static void guiBingSort(int[] array) {
        guiBingSort01(array, 0, array.length - 1);
    }

    private static void guiBingSort01(int[] array, int i, int length) {
        int[] temp = new int[array.length];
        guiBingSort02(array, 0, array.length - 1, temp);
    }

    private static void guiBingSort02(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            guiBingSort02(array, left, mid, temp);
            guiBingSort02(array, mid + 1, right, temp);
            merge02(array, left, mid, right, temp);
        }
    }

    private static void merge02(int[] array, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, t = 0;
        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                temp[t++] = array[i++];
            } else {
                temp[t++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = array[i++];
        }
        while (j <= right) {
            temp[t++] = array[j++];
        }
        t = 0;
        while (left <= right) {
            array[left++] = temp[t++];
        }
    }

    //6.合并有序的单链表
    public static ListNode mergeNode(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val > list2.val) {
            list2.next = mergeNode(list1, list2.next);
            return list2;
        } else {
            list1.next = mergeNode(list1.next, list2);
            return list1;
        }
    }

    //7.获取单聊表的倒数第k个元素
    public static ListNode getEle(ListNode head, int k) {
        if (head == null) return null;
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (length < 0 || k > length) return null;
        ListNode before = head;
        ListNode after = head;
        for (int i = 0; i < k; i++) {
            before = before.next;
        }
        while (before != null) {
            before = before.next;
            after = after.next;
        }
        return after;
    }

    //8.二叉树前序遍历
    public static void preSort01(TreeNode head) {
        //跟左右
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.val);
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }
        }
    }

    //9.二叉树遍历
    public static void inSort(TreeNode node) {
        //左根右
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode node1 = stack.pop();
                System.out.println(node1.val);
                node = node1.right;
            }
        }
    }

    //10.层次遍历
    //层次遍历的代码比较简单，只需要一个队列即可，先在队列中加入根结点。之后对于任意一个结点来说，在其出队列的时候，访问之。同时如果左孩子和右孩子有不为空的，入队列
    public static void levelSort(TreeNode node) {
        if (node == null) return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.println(temp.val);

            if (temp.left != null) {
                queue.offer(temp.left);
            }

            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

    //11.深度优先遍历
    //其实深度遍历就是上面的前序、中序和后序。但是为了保证与广度优先遍历相照应，也写在这。代码也比较好理解，其实就是前序遍历
    public static void deptSort(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> queue = new Stack<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            System.out.println(node.val);

            if (node.right != null) {
                queue.push(node.right);
            }
            if (node.left != null) {
                queue.push(node.left);
            }
        }
    }

    //12.二叉搜索树 第k大节点
    //中序遍历二叉搜索树后就是从小到大排序
    LinkedList<TreeNode> list = new LinkedList<>();

    public TreeNode serchNode(TreeNode root, int k) {
        startBuildList2(root);
        if (list.size() < k || k < 0) return null;
        else {
            return list.get(k - 1);
        }
    }

    private void startBuildList2(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            startBuildList2(root.left);
        }
        list.add(root);
        if (root.right != null) {
            startBuildList2(root.right);
        }
    }

    //13.二叉树节点的最大值
    public TreeNode getMaxNode(TreeNode root) {
        if (root == null) return null;
        TreeNode leftMaxNode = root.left != null ? getMaxNode(root.left) : null;
        TreeNode rigthMaxNode = root.right != null ? getMaxNode(root.right) : null;
        if (leftMaxNode != null && rigthMaxNode != null) {
            TreeNode tempNode = leftMaxNode.val > rigthMaxNode.val ? leftMaxNode : rigthMaxNode;
            return tempNode.val > root.val ? tempNode : root;
        } else if (leftMaxNode != null) {
            return leftMaxNode.val > root.val ? leftMaxNode : root;
        } else if (rigthMaxNode != null) {
            return rigthMaxNode.val > root.val ? rigthMaxNode : root;
        }
        return root;
    }

    //14.//递归二分查找
    public int search(int[] array, int target, int low, int high) {
        if (target < array[low] || target > array[high] || low > high) return -1;
        int mid = (low + high) / 2;
        if (array[mid] > target) {
            return search(array, target, low, mid - 1);
        } else if (array[mid] < target) {
            return search(array, target, mid + 1, high);
        } else {
            return mid;
        }
    }

    //15.//非递归二分查找
    public int search2(int[] array, int target, int low, int high) {
        if (array[low] > target || array[high] < target || low > high) return -1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] > target) {
                high = mid - 1;
            } else if (array[mid] > target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //16.//数组中不重复元素的个数
    public int func01(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != array[count]) {
                array[++count] = array[i];
            }
        }
        return count + 1;
    }

    //17.求数组中两个数的和等于目标数target
    public int[] func02(int[] array, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i] - target)) {
                res[0] = i;
                res[1] = map.get(array[i] - target);
            } else {
                map.put(array[i], i);
            }
        }
        return res;
    }

    //18.青蛙跳台阶
    public int func03(int n) {
        int a = 0;
        int b = 1;
        for (int i = 1; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return a;
    }

    //19.求最大公约数
    public int func04(int num1, int num2) {
        if (num1 == num2) return num1;
        int big = num1 > num2 ? num1 : num2;
        int small = num1 > num2 ? num2 : num1;
        return func04(big - small, small);
    }

    //20.二维数组的查找
    public boolean func05(int[][] array, int target) {
        if (array == null) return false;
        int row = array.length;
        int col = array[0].length;
        int i = row - 1;
        int j = 0;
        while (i >= 0 && j <= col) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                i--;
            } else if (array[i][j] < target) {
                j++;
            }
        }
        return false;
    }

    //21.输入一个链表，按链表从尾到头的顺序返回一个ArrayList
    public ArrayList<Integer> func06(ListNode root) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) return arrayList;
        while (root != null) {
            stack.push(root.val);
            root = root.next;
        }
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    //22.输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树
    public TreeNode func07(int[] pre, int[] in) {
        return getNode(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode getNode(int[] pre, int i, int j, int[] in, int m, int n) {
        if (i > j || m > n) return null;
        int temp = pre[i];
        int k = m;
        for (; k < n; k++) {
            if (in[k] == temp) {
                break;
            }
        }
        TreeNode root = new TreeNode(temp);
        root.left = getNode(pre, 0, i + k - m, in, m, k - 1);
        root.right = getNode(pre, i + k - m - 1, j, in, k + 1, n);
        return root;
    }

    //23.用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    //24.把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。//输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
    //    //例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
    public static int print3(int[] array) {
        if (array.length == 0) return -1;
        int i = 0, j = array.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (array[mid] < array[i]) {
                j = mid;
            } else if (array[mid] > array[j]) {
                i = mid + 1;
            } else {
                j--;
            }
        }
        return -1;
    }

    //25.大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
    public int func08(int n) {
        if (n > 39 || n < 0) return -1;
        int a = 0;
        int b = 1;
        for (int i = 1; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return a;
    }

    //26.一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
    public int func09(int n) {
        if (n <= 2) return n;
        int a = 1, b = 2;
        for (int i = 0; i < n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return a;
    }

    //27.一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
    public int func10(int n) {
        if (n <= 2) {
            return n;
        } else {
            //f(3)=f(1)+f(2) f(n-1)=f(n-2)+f(n-3)+...+f(1) f(n)=f(n-1)+... +f(1)
            //f(n)=2*f(n-1)
            return 2 * func10(n - 1);
        }
    }

    //28.我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
    public int func11(int n) {
        if (n <= 1) return n;
        else {
            return func11(n - 1) + func11(n - 2);
        }
    }

    //29.输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
    public int func12(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    //30.输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
    public int[] func13(int[] array) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                odd.add(array[i]);
            } else {
                even.add(array[i]);
            }
        }
        for (int i = 0; i < odd.size(); i++) {
            array[i++] = odd.get(i);
        }
        for (int i = 0; i < even.size(); i++) {
            array[i++ + odd.size()] = even.get(i);
        }
        return array;
    }

    //31.输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
    public boolean func14(TreeNode A, TreeNode B) {
        if (A == null) return false;
        if (B == null) return false;
        boolean flag = false;
        if (A.val == B.val) {
            if (hasTreee(A.left, B.left) && hasTreee(A.right, B.right)) {
                flag = true;
            }

        }
        if (flag) {
            return true;
        }
        return hasTreee(A.left, B) || hasTreee(A.right, B);
    }

    public boolean hasTreee(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (B == null) return true;
        if (A == null) return false;
        if (A.val == B.val) {
            return hasTreee(A.left, B.left) && hasTreee(A.right, B.right);
        }
        return false;
    }

    //32.操作给定的二叉树，将其变换为源二叉树的镜像。
    private void print18(TreeNode treeNode) {
        if (treeNode == null) return;
        TreeNode temp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = temp;
        print18(treeNode.left);
        print18(treeNode.right);
    }

    //33.输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
    public boolean print19(int[] push, int[] pop) {
        Stack<Integer> stack = new Stack<>();
        stack.push(push[0]);
        int i = 0;
        int j = 1;
        int length = push.length;
        while (!stack.isEmpty()) {
            while (j < length && pop[i] != stack.peek()) {
                stack.push(push[j]);
                j++;
            }

            if (j < length || stack.pop() == pop[i]) {
                stack.pop();
                i++;
            } else {
                return false;
            }
        }
        return true;
    }

    //34.在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (numbers == null || numbers.length == 0) return false;
        int len = numbers.length;
        return false;
    }

    //35.
    static int[] arr = new int[256];
    static int index = 1;

    //index作为字符出现的索引大小，后出现的大于先出现的
    public static void insert(char ch) {
        if (arr[(int) ch] == 0) {
            arr[(int) ch] = index;
            index++;
        } else {
            arr[(int) ch] = -1;
        }
    }

    public static char FirstAppearingOnce() {
        char res = '#';
        int v = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++) {
            if (arr[i] > 0) {
                if (v > arr[i]) {
                    v = arr[i];
                    res = (char) i;
                }
            }
        }
        return res;
    }

    //36.在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    public static ListNode print20(ListNode head) {
        if (head == null || head.next == null) return null;
        //11223
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode pre = first;
        ListNode last = first.next;
        while (last != null) {
            if (last.next != null && last.val == last.next.val) {
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            } else {
                pre = pre.next;
                last = last.next;
            }
        }
        return first.next;
    }

    //37.请实现一个函数按照之字形打印二叉树
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) return list;
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(pRoot);
        Stack<TreeNode> s2 = new Stack<>();
        int layer = 1;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (layer % 2 != 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                while (!s1.isEmpty()) {
                    TreeNode node = s1.pop();
                    if (node != null) {
                        temp.add(node.val);
                    }
                    s2.push(node.left);
                    s2.push(node.right);
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                }
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                while (!s2.isEmpty()) {
                    TreeNode node = s2.pop();
                    if (node != null) {
                        temp.add(node.val);
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }

                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                }
            }
        }
        return list;
    }

    //38.从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行
    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        deptPrint(pRoot, 1, list);
        return list;
    }

    private void deptPrint(TreeNode pRoot, int i, ArrayList<ArrayList<Integer>> list) {
        if (pRoot == null) return;
        if (i > list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(i - 1).add(pRoot.val);
        deptPrint(pRoot.left, i + 1, list);
        deptPrint(pRoot.right, i + 1, list);
    }

    //39.给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4
    int indexN = 0;

    public TreeNode print21(TreeNode root, int k) {
        if (root != null) {
            TreeNode node = print21(root.left, k);
            if (node != null) return node;
            indexN++;
            if (indexN == k) return root;
            node = print21(root.right, k);
            if (node != null) return node;
        }
        return null;
    }

    //40
    public static ArrayList<Integer> maxInWindows2(int[] num, int size) {
        if (num == null || num.length == 0 || size <= 0 || num.length < size) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        //双端队列，用来记录每个窗口的最大值下标
        LinkedList<Integer> qmax = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            while (!qmax.isEmpty() && num[qmax.peekLast()] < num[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            //判断队首元素是否过期
            if (qmax.peekFirst() == i - size) {
                qmax.pollFirst();
            }
            //向result列表中加入元素
            if (i >= size - 1) {
                result.add(num[qmax.peekFirst()]);
            }
        }
        return result;
    }

    //41求一个无序数组的k大
    //找到数组中的前k个最大值
    static Queue<Integer> findTopN(int[] data, int k) {
        if (data == null || data.length == 0)
            return null;

        Queue<Integer> priorityQueue = new PriorityQueue<>(k);
        priorityQueue.add(data[0]);
        for (int i = 1; i < data.length; i++) {
            if (priorityQueue.size() < k)
                priorityQueue.add(data[i]);
            else if (data[i] >= priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.add(data[i]);
            }
        }
        return priorityQueue;
    }
}

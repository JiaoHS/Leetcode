package com.xjtu.qiuzhao;

import com.xjtu.ssmidea.algorithm.RandomListNode;
import com.xjtu.ssmidea.jianzhioffer.ListNode;
import com.xjtu.ssmidea.jianzhioffer.TreeNode;

import java.util.*;

/**
 * @auther coraljiao
 * @date 2020/1/31 14:30
 * @description
 */
public class day008 {
    public static void main(String[] args) {
//        int[] array = {3, 4, 5, 6, 1, 2};
//        int i = print3(array);
//        System.out.println(i);

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
//        ListNode listNode = print10(a, 4);
//        System.out.println(listNode.val);

        //Permutation("abc");

        //NumberOf1Between1AndN_Solution(100);

//        int[] arr = {3, 32, 321};
//        PrintMinNumber(arr);

        //GetUglyNumber_Solution(20);
        //FirstNotRepeatingChar("google");

        //LeftRotateString("XYZdefabc",3);

        //I am a student.
        //ReverseSentence(" ");

        //Sum_Solution(100);
//        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
//        maxInWindows(num, 3);

//        int[] pushA = {1, 2, 3, 4, 5};
//        int[] popB = {1, 2, 3, 4, 5};
//        boolean b = isPopOrder2(pushA, popB);
//        System.out.println(b);

//        Double[] dou = {30.97, 36.53, 25.74, 34.19, 24.46, 29.68, 35.35, 28.96, 35.24, 27.91, 29.69, 34.69, 34.58, 34.27, 29.35, 23.27, 34.86, 30.48, 29.70, 34.22, 23.76, 28.36, 33.71, 31.13, 29.97, 29.55, 34.31, 30.53, 34.64, 27.74};
//        ArrayList<Double> list = new ArrayList<>();
//        Double sum = 0.0;
//        for (int i = 0; i < dou.length; i++) {
//            sum += dou[i];
//            list.add(dou[i]);
//        }
//        Collections.sort(list);
//        Double avg = sum / list.size();
//        System.out.println(avg);

        boolean valid = isValid("()[]{}");
        System.out.println(valid);
    }

    //符号合法
    public static boolean isValid(String s) {
        //(({}))
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

    //数据流中的第k大数
    PriorityQueue<Integer> queue;
    int k;

    public void KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.offer(val);
        } else if (queue.peek() > val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }

    //1.二维数组的查找
    public boolean find(int[][] array, int target) {
        int row = array.length;
        int col = array[0].length;
        int i = row - 1;//最后一行开始
        int j = 0;//第一列开始
        while (i >= 0 && j < col) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    //2.将一个字符串中的每个空格替换成“%20”
    public String repalceSpace(StringBuffer string) {
        if (string == null) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                sb.append('%');
                sb.append('2');
                sb.append('0');
            } else {
                sb.append(string.charAt(i));
            }
        }
        return sb.toString();
    }

    //3.输入一个链表，按链表从尾到头的顺序返回一个ArrayList
    public ArrayList<Integer> print(ListNode node) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (node == null) return null;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    //4.输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树
    public TreeNode print2(int[] pre, int[] in) {
        return getTreeNode(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode getTreeNode(int[] pre, int i, int j, int[] in, int m, int n) {
        //条件判断
        if (i > j || m > n) return null;
        //根据前序找根节点
        int temp = pre[i];
        int k = m;
        for (; k <= n; k++) {
            if (temp == in[k]) {
                break;
            }
        }
        TreeNode root = new TreeNode(temp);
        root.left = getTreeNode(pre, 0, i + k - m, in, m, k - 1);
        root.right = getTreeNode(pre, i + k - m - 1, j, in, k + 1, n);
        return root;
    }

    // 缓存中序遍历数组每个值对应的索引
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++)
            indexForInOrders.put(in[i], i);
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }


    //5.用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
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

    //6.把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。//输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
    //例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
    //二分查找
    public static int print3(int[] array) {
        if (array.length == 0) return 0;
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
        return array[i];
    }

    //7.大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
    public int print4(int n) {
        int a = 0, b = 1;
        for (int i = 1; i <= n; i++) {
            int temp = a + b;//定义变量保存之前的和
            a = b;
            b = temp;
        }
        return a;
    }

    //8.一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
    public int print5(int n) {
        if (n <= 2) return n;
        int a = 1, b = 2;
        for (int i = 1; i <= n; i++) {
            int temp = a + b;//用两个变量临时存下来即可,dp(i) = dp(i-2) + dp(i-1)
            a = b;
            b = temp;
        }
        return a;
    }

    //9.一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
    public int print6(int n) {
        if (n <= 0) return -1;
        if (n == 1) {
            return 1;
        } else {
            //f(n)=f(n-1)+f(n-2)+...+f(1)
            //f(n-1)=f(n-2)+f(n-2)+...+f(1)
            //两式子相减得f(n)=2*f(n-1)
            return 2 * print6(n - 1);
        }
    }

    //10.我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
    public int print7(int n) {
        if (n <= 2) {
            return n;
        } else {
            return print7(n - 1) + print7(n - 2);
        }
    }

    //11.输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
    public int print8(int n) {
        //把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
        //一个二进制数1100，从右边数起第三位是处于最右边的一个1。减去1后，第三位变成0，它后面的两位0变成了1，而前面的1保持不变，因此得到的结果是1011.我们发现减1的结果是把最右边的一个1开始的所有位都取反了。这个时候如果我们再把原来的整数和减去1之后的结果做与运算，从原来整数最右边一个1那一位开始所有位都会变成0。如1100&1011=1000
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
    //12.给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
    //保证base和exponent不同时为0

    //13.输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
    public void print9(int[] array) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                odd.add(array[i]);
            } else {
                even.add(array[i]);
            }
        }
        for (int j = 0; j < odd.size(); j++) {
            array[j++] = odd.get(j);
        }
        for (int k = 0; k < even.size(); k++) {
            array[odd.size() + k++] = even.get(k);
        }
    }

    //14.输入一个链表，输出该链表中倒数第k个结点
    public static ListNode print10(ListNode head, int k) {
        ListNode temp = head;
        while (head != null && k > 0) {
            k--;
            head = head.next;
        }
        //k比head的长度大 超出索引
        if (k > 0) {
            return null;
        }
        while (head != null) {
            head = head.next;
            temp = temp.next;
        }
        return temp;
    }

    //15.输入一个链表，反转链表后，输出新链表的表头
    public ListNode print11(ListNode head) {
        //1 2 3 4 5
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = next;
            head = next;
        }
        return pre;
    }

    public ListNode print111(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode pur = head;
        while (pur != null) {
            //头插法
            ListNode preNext = pur.next;
            pur.next = dummy.next;
            dummy.next = pur;
            pur = preNext;
        }
        return dummy.next;
    }

    //交换两两节点
    public ListNode print1111(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            cur.next = second;
            cur.next.next = first;
            cur = cur.next.next;
        }
        return dummy.next;
    }
    //判断链表是否有环 那我理解的src就是要枚举所有的vpsip么？然后根据探测的数据结果分析出具有权值很大的vpsip代表其他vpsip，被代表的ip就可以，数据集会是很大吧？


    //16.输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
    public ListNode print12(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val > list2.val) {
            list2.next = print12(list1, list2.next);
            return list2;
        } else {
            list1.next = print12(list1.next, list2);
            return list1;
        }
    }

    //17.输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
    public boolean print172(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode2 == null) return false;
        if (treeNode1 == null) return false;

        boolean flag = false;
        if (treeNode1.val == treeNode2.val) {
            if (hasTree(treeNode1.left, treeNode2.left) && hasTree(treeNode1.right, treeNode2.right)) ;
            {
                flag = true;
            }
        }
        if (flag) {
            return true;
        }
        //节点的值不相等
        return hasTree(treeNode1.left, treeNode2) || hasTree(treeNode1.right, treeNode2);
    }

    public boolean hasTree(TreeNode tree1, TreeNode tree2) {
        if (tree2 == null && tree1 == null) return true;
        if (tree2 == null) return true;
        if (tree1 == null) return false;
        if (tree1.val == tree2.val) {
            return hasTree(tree1.left, tree2.left) && hasTree(tree1.right, tree2.right);
        }
        return false;
    }

    public boolean print17(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            if (root1.val == root2.val) {
                //以这个根节点为为起点判断是否包含Tree2
                result = doesTree1HaveTree2(root1, root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }

            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        //返回结果
        return result;
    }

    private boolean doesTree1HaveTree(TreeNode node1, TreeNode node2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (node2 == null) {
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (node1 == null) {
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (node1.val != node2.val) {
            return false;
        }

        //如果根节点对应的上，那么就分别去子节点里面匹配
        return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
    }

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            if (root1.val == root2.val) {
                //以这个根节点为为起点判断是否包含Tree2
                result = doesTree1HaveTree2(root1, root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }

            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        //返回结果
        return result;
    }

    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (node2 == null) {
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (node1 == null) {
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (node1.val != node2.val) {
            return false;
        }

        //如果根节点对应的上，那么就分别去子节点里面匹配
        return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
    }

    //18.操作给定的二叉树，将其变换为源二叉树的镜像。
    private void print18(TreeNode treeNode) {
        if (treeNode != null) {
            TreeNode temp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = temp;
            print18(treeNode.left);
            print18(treeNode.right);
        }
    }

    //19.输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
    public ArrayList<Integer> print19(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0, left = 0, bottom = rows - 1, right = cols - 1;
        int count = 0;
        while (count < rows * cols) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
                count++;
                if (count > rows * cols) {
                    return res;
                }
            }
            top++;
            for (int j = top; j <= bottom; j++) {
                res.add(matrix[j][right]);
                count++;
                if (count > rows * cols) {
                    return res;
                }
            }
            right--;
            for (int m = right; m >= left; m--) {
                res.add(matrix[bottom][m]);
                count++;
                if (count > rows * cols) {
                    return res;
                }
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
                count++;
                if (count > rows * cols) {
                    return res;
                }
            }
            left++;
        }
        return res;
    }

    //20.定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
//    private Stack<Integer> stack1 = new Stack<>();
//    private Stack<Integer> stack2 = new Stack<>();
    public void print20(int node) {
        stack1.push(node);
        if (stack2.empty()) {
            stack2.push(node);
        } else {
            if (node <= stack2.peek()) {
                stack2.push(node);
            } else {
                stack2.push(stack2.peek());
            }
        }
    }

    //21.输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

    public static boolean isPopOrder2(int[] pushA, int[] popB) {
        if (pushA.length == 0 || popB.length == 0) return false;
        Stack<Integer> stack = new Stack<>();
        //标识弹出序列的位置
        int indePos = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            //如果栈不为空 且弹出元素等于栈顶元素
            while (!stack.isEmpty() && stack.peek() == popB[indePos]) {
                stack.pop();//出栈
                //弹出序列的位置后移
                indePos++;
            }
        }
        return stack.isEmpty();
    }

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        stack.push(pushA[0]);
        int i = 0;//1,2,3,4,5  popA
        int j = 1;//1  pushA
        int length = pushA.length;
        while (!stack.isEmpty()) {
            while (popA[i] != stack.peek() && j < length) {
                stack.push(pushA[j]);
                j++;
            }
            //j==5
            if (j < length || stack.pop() == popA[i]) {
                stack.pop();//当stack==空的时候 循环结束 返回true
                i++;
            } else {
                return false;
            }
        }
        return true;
    }


    //22.从上往下打印出二叉树的每个节点，同层节点从左至右打印。
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) return null;
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.getFirst();
            if (node != null) {
                list.add(node.val);
                queue.addLast(root.left);//追加队列
                queue.addLast(root.right);
            }
            queue.removeFirst();
        }
        return list;
    }
    //23.输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return ver(sequence, 0, sequence.length - 1);
    }

    private boolean ver(int[] sequence, int i, int j) {
        if (i >= j) {
            return true;
        }
        int k = i;
        for (; k <= j; k++) {
            if (sequence[k] >= sequence[j]) {
                break;
            }
        }
        int x = k;
        for (; x <= j; x++) {
            if (sequence[x] < sequence[j]) {
                return false;
            }
        }
        return ver(sequence, i, k - 1) && ver(sequence, k + 1, j);
    }

    //24.输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        find(root, 0, target, new ArrayList<Integer>(), res);
        return res;
    }

    public void find(TreeNode root, int sum, int target, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> res) {
        if (root == null) {
            return;
        }
        sum += root.val;
        tmp.add(root.val);
        if (sum == target && root.left == null && root.right == null) {
            res.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
            return;
        }
        find(root.left, sum, target, tmp, res);
        find(root.right, sum, target, tmp, res);
        tmp.remove(tmp.size() - 1);
    }

    //25.输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
    public RandomListNode Clone(RandomListNode pHead) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode p = pHead;
        while (p != null) {
            map.put(p, new RandomListNode(p.label));
            p = p.next;
        }
        p = pHead;
        while (p != null) {
            RandomListNode tmp = map.get(p);
            tmp.next = map.get(p.next);
            tmp.random = map.get(p.random);
            p = p.next;
        }
        return map.get(pHead);
    }

    //26.输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
    //再看！！！
    TreeNode head = null;
    TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null || (pRootOfTree.left == null && pRootOfTree.right == null)) {
            return pRootOfTree;
        }
        build(pRootOfTree);
        return head;
    }

    public void build(TreeNode root) {
        if (root == null) {
            return;
        }
        build(root.left);
        if (head == null) {
            head = root;
            pre = root;
        } else {
            root.left = pre;
            pre.right = root;
            pre = root;
        }
        build(root.right);
    }

    //27.输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
    //再看！！！
    static ArrayList<String> list = new ArrayList<>();
    static TreeSet<String> set = new TreeSet<>();

    public static ArrayList<String> Permutation(String str) {
        if (str.length() == 0) {
            return list;
        }
        //str="abc"
        print(str, 0);
        while (!set.isEmpty()) {
            list.add(set.pollFirst());
        }
        return list;
    }

    public static void print(String s, int index) {
        if (index == s.length() - 1) {
            set.add(s);
            return;
        }
        for (int i = index; i < s.length(); i++) {
            s = swap(s, index, i);
            print(s, index + 1);
            s = swap(s, index, i);
        }

    }

    public static String swap(String s, int i, int j) {
        char[] array = s.toCharArray();
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        return String.valueOf(array);
    }

    //28.数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
    public int MoreThanHalfNum_Solution(int[] array) {
        int length = array.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int count = (map.get(array[i]) == null ? 0 : map.get(array[i])) + 1;
            if (count > length / 2) {
                return array[i];
            }
            map.put(array[i], count);
        }
        return 0;
    }

    //29.输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (k > input.length || input.length == 0) {
            return arrayList;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (i < k) {
                queue.add(input[i]);
            } else {
                if (queue.peek() > input[i]) {
                    queue.poll();
                    queue.add(input[i]);
                }
            }
        }
        while (k > 0) {
            arrayList.add(queue.poll());
            k--;
        }
        return arrayList;
    }

    //30.HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
    // 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length <= 0) {
            return -1;
        }
        int min = Integer.MIN_VALUE;
        int tempSum = 0;
        int index = 0;
        while (index < array.length) {
            if (tempSum > 0) {
                tempSum += array[index];
            } else {
                tempSum = array[index];
            }

            if (min < tempSum) {
                min = tempSum;
            }
            index++;
        }
        return min;
    }

    //31.求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
    //再看！！！
    public static int NumberOf1Between1AndN_Solution(int n) {
        if (n < 1) return 0;
        if (n <= 9) return 1;
        int k = n;
        int i = 1;
        int count = 0;
        while (i <= n) {
            count += k / 10 * i;
            int cur = k % 10;
            if (cur > 1) {
                count += i;
            } else if (cur == 1) {
                count += n - k * i + 1;
            }
            k = k / 10;
            i *= 10;
        }
        return count;
    }

    public int NumberOf1Between1AndN_Solution2(int n) {
        // 统计次数
        int count = 0;
        StringBuffer buffer = new StringBuffer();
        for (int i = 1; i < n + 1; i++) {
            buffer.append(i);
        }
        // 转换成字符串
        String str = buffer.toString();
        // 统计'1'出现的次数
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1')
                count++;
        }
        return count;
    }

    //32.输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
    public static String PrintMinNumber(int[] numbers) {
        int n;
        String s = "";
        ArrayList<Integer> list = new ArrayList<Integer>();
        n = numbers.length;

        for (int i = 0; i < n; i++) {
            list.add(numbers[i]);//将数组放入arrayList中
        }
        //实现了Comparator接口的compare方法，将集合元素按照compare方法的规则进行排序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2) {
                // TODO Auto-generated method stub
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;

                return s1.compareTo(s2);
            }
        });

        for (int j : list) {
            s += j;
        }
        return s;
    }

    //33.把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
    public static int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        if (index == 1) {
            return 1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int count = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        while (count < index) {
            int next = min(list.get(index2) * 2, list.get(index3) * 3, list.get(index5) * 5);
            list.add(next);
            count++;
            while (list.get(index2) * 2 <= next) {
                index2++;
            }
            while (list.get(index3) * 3 <= next) {
                index3++;
            }
            while (list.get(index5) * 5 <= next) {
                index5++;
            }
        }
        return list.get(index - 1);
    }

    public static int min(int a, int b, int c) {
        int tmp = a < b ? a : b;
        tmp = tmp < c ? tmp : c;
        return tmp;
    }

    public int GetUglyNumber_Solution2(int index) {

        if (index <= 0)
            return 0;
        int[] result = new int[index];
        int count = 0;
        //p2，p3，p5分别为三个队列的指针，newNum为从队列头选出来的最小数
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        result[0] = 1;
        int tmp = 0;
        while (count < index - 1) {
            //选出三个队列头最小的数
            tmp = min(result[i2] * 2, min(result[i3] * 3, result[i5] * 5));
            //这三个if有可能进入一个或者多个，进入多个是三个队列头最小的数有多个的情况
            if (tmp == result[i2] * 2) i2++;//三条if防止值是一样的，不要改成else的
            if (tmp == result[i3] * 3) i3++;
            if (tmp == result[i5] * 5) i5++;
            result[++count] = tmp;
        }
        return result[index - 1];
    }

    private int min(int a, int b) {
        return (a > b) ? b : a;
    }

    //34.在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
    public static int FirstNotRepeatingChar(String str) {
        //google
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.get(str.charAt(i)) == null ? 0 : map.get(str.charAt(i)) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    //35.输入两个链表，找出它们的第一个公共结点。
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;


        HashMap<ListNode, Integer> hashMap = new HashMap<ListNode, Integer>();
        while (current1 != null) {
            hashMap.put(current1, null);
            current1 = current1.next;
        }
        while (current2 != null) {
            if (hashMap.containsKey(current2))
                return current2;
            current2 = current2.next;
        }

        return null;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int l1 = 0;
        int l2 = 0;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (pHead1 != null) {
            l1++;
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            l2++;
            pHead2 = pHead2.next;
        }
        int common = Math.abs(l1 - l2);
        if (l1 > l2) {
            while (common > 0) {
                p1 = p1.next;
                common--;
            }
        } else {
            while (common > 0) {
                p2 = p2.next;
                common--;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    //36.统计一个数字在排序数组中出现的次数。
    public int GetNumberOfK(int[] array, int k) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        int firstK = getFirstK(array, k, 0, length - 1);
        int lastK = getLastK(array, k, 0, length - 1);
        if (firstK != -1 && lastK != -1) {
            return lastK - firstK + 1;
        }
        return 0;
    }

    //递归写法
    private int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        if (array[mid] > k) {
            return getFirstK(array, k, start, mid - 1);
        } else if (array[mid] < k) {
            return getFirstK(array, k, mid + 1, end);
        } else if (mid - 1 >= 0 && array[mid - 1] == k) {
            return getFirstK(array, k, start, mid - 1);
        } else {
            return mid;
        }
    }

    //循环写法
    private int getLastK(int[] array, int k, int start, int end) {
        int length = array.length;
        int mid = (start + end) >> 1;
        while (start <= end) {
            if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] < k) {
                start = mid + 1;
            } else if (mid + 1 < length && array[mid + 1] == k) {
                start = mid + 1;
            } else {
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
    }

    //37.输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root != null && root.left == null && root.right == null) {
            return 1;
        }
        return TreeDepth(root.left) > TreeDepth(root.right) ? TreeDepth(root.left) + 1 : TreeDepth(root.right) + 1;
    }

    //38.输入一棵二叉树，判断该二叉树是否是平衡二叉树。
    boolean f = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        IsBalanced(root);
        return f;
    }

    private int IsBalanced(TreeNode root) {
        if (root == null) return 0;
        int left = IsBalanced(root.left);
        int right = IsBalanced(root.right);
        if (Math.abs(left - right) >= 2) {
            f = false;
        }
        return left > right ? left + 1 : right + 1;
    }

    //39.一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
    //晓月姐您好，2月10号是统一办理违约的时间吧？我经过再三的考虑，决定违约，十分抱歉哈，最终还是没跟女朋友协商好工作地点的问题，为了感情的稳定而选择跟对象一起去上海工作，其实我是十分想留在西安，想在绿盟工作，希望以后还有合作的机会
    //https://www.nowcoder.com/profile/963880/codeBookDetail?submissionId=1515736
    //再看！！！
    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        int length = array.length;
        if (length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitResult = 0;
        for (int i = 0; i < length; ++i) {
            bitResult ^= array[i];
        }
        int index = findFirst1(bitResult);
        for (int i = 0; i < length; ++i) {
            if (isBit1(array[i], index)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    private int findFirst1(int bitResult) {
        int index = 0;
        while (((bitResult & 1) == 0) && index < 32) {
            bitResult >>= 1;
            index++;
        }
        return index;
    }

    private boolean isBit1(int target, int index) {
        return ((target >> index) & 1) == 1;
    }

    //40.小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
    //https://www.nowcoder.com/profile/645151/codeBookDetail?submissionId=1519890
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        //存放结果
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow = 1, phigh = 2;
        while (phigh > plow) {
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = plow; i <= phigh; i++) {
                    list.add(i);
                }
                result.add(list);
                plow++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            } else if (cur < sum) {
                phigh++;
            } else {
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                plow++;
            }
        }
        return result;
    }

    //41.输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length == 1) return list;
        int left = 0, right = array.length - 1;
        while (left < right) {
            int temp = array[left] + array[right];
            if (temp == sum) {
                list.add(array[left]);
                list.add(array[right]);
                return list;
            } else if (temp < sum) {
                //2.如果和小于sum，说明太小了，left右移寻找更大的数
                left++;
            } else {
                //大于sum，说明太大了，right左移寻找更小的数
                right--;
            }
        }
        return list;
    }

    //42.汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
    public static String LeftRotateString(String str, int n) {
        if (str == "" || n > str.length()) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String c = str.substring(0, 1);
            str = str.substring(1);
            sb.append(c);
        }
        return str + sb.toString();
    }

    //43.牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
    public static String ReverseSentence(String str) {
        if (str == "" || str.length() == 0) return str;
        Stack<String> stack = new Stack<>();
        String[] s = str.split(" ");
        if (s == null || s.length == 0 || s.length == 1) return str;
        for (int i = 0; i < s.length; i++) {
            stack.push(s[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }

    //44.LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。


    //45.求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    static int res = 0;

    public static int Sum_Solution(int n) {
        boolean f = n > 0 && (res += n) > 0 && Sum_Solution(n - 1) > 0;
        //&&就是逻辑与，逻辑与有个短路特点，前面为假，后面不计算
        return res;
    }

    //46.写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
    //https://www.nowcoder.com/profile/645151/codeBookDetail?submissionId=1512236
    public int Add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;//各位值，不算进位，二进制每位相加就相当于各位做异或操作，101^111。
            num2 = (num1 & num2) << 1;//进位值，相当于各位做与操作得到101，再向左移一位得到1010，(101&111)<<1
            num1 = temp;
        }
        //进位值为0 跳出循环
        return num1;
    }

    //47.将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
    public int StrToInt(String str) {
        //+2147483647
        if (str.equals("") || str.length() == 0)
            return 0;
        char[] a = str.toCharArray();
        int fuhao = 0;
        if (a[0] == '-')
            fuhao = 1;
        int sum = 0;
        for (int i = fuhao; i < a.length; i++) {
            if (a[i] == '+')
                continue;
            if (a[i] < 48 || a[i] > 57)
                return 0;
            sum = sum * 10 + a[i] - 48;
        }
        return fuhao == 0 ? sum : sum * -1;
    }

    //48.在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length <= 1) return false;
        int[] nums = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[numbers[i]]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 1) {
                duplication[0] = i;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    //49.给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
    //https://www.nowcoder.com/profile/645151/codeBookDetail?submissionId=1516453
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if (length != 0) {
            B[0] = 1;
            //计算下三角连乘
            for (int i = 1; i < length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            int temp = 1;//临时变量保存
            //计算上三角
            for (int j = length - 2; j >= 0; j--) {
                temp *= A[j + 1];
                B[j] *= temp;
            }
        }
        return B;
    }

    //50.请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
    //https://www.nowcoder.com/profile/320158/codeBookDetail?submissionId=1500198
    //51.请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }

    //https://www.nowcoder.com/profile/982154/codeBookDetail?submissionId=1513490
    //52.请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
    int[] arr = new int[256];
    int index = 1;

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (arr[(int) ch] == 0) {
            arr[(int) ch] = index;
            index++;
        } else {
            arr[(int) ch] = -1;
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
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

    //53.给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
    //设置快慢指针，都从链表头出发，快指针每次走两步，慢指针一次走一步，假如有环，一定相遇于环中某点(结论1)。接着让两个指针分别从相遇点和链表头出发，两者都改为每次走一步，最终相遇于环入口
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode low = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low) {
                //快慢指针相遇节点
                break;
            }
        }
        if (fast == null || fast.next == null) return null;
        //一个从表头出发  一个从相遇点出发
        low = pHead;
        while (fast != low) {
            fast = fast.next;
            low = low.next;
        }
        return low;
    }

    //hashset判断是否有环 时间复杂度O(n)
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            /*链表为空或仅有一个结点*/
            return false;
        }

        HashSet<ListNode> sets = new HashSet<ListNode>();
        sets.add(head);
        ListNode curr = head.next;//指针
        while (true) {
            if (sets.contains(curr)) {
                return true;
            } else {
                sets.add(curr);
                curr = curr.next;
                if (curr == null) {
                    return false;
                }
            }
        }
    }

    //54.在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    //1. 首先添加一个头节点，以方便碰到第一个，第二个节点就相同的情况
    //
    //2.设置 pre ，last 指针， pre指针指向当前确定不重复的那个节点，而last指针相当于工作指针，一直往后面搜索。
    public ListNode deleteDuplication(ListNode pHead) {
        //1->1->2->3->3->4->4->5
        if (pHead == null || pHead.next == null) return null;
        ListNode Head = new ListNode(0);
        Head.next = pHead;
        ListNode pre = Head;
        ListNode last = Head.next;
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
        return Head.next;
    }

    //55.给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
    public TreeLinkNode GetNext(TreeLinkNode node) {
        if (node == null) return null;
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;

            }
            return node;
        }
        while (node.next != null) {
            if (node.next.left == node) return node.next;
            node = node.next;
        }
        return null;
    }

    //① 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点 否则，向上找第一个左链接指向的树包含该节点的祖先节点
    public TreeLinkNode getNext2(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node != null) {
                node = node.left;
            }
            return node;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode) {
                    return parent;
                } else {
                    pNode = pNode.next;
                }
            }
        }
        return null;
    }

    //56.请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
    boolean isSymmetrical(TreeNode pRoot) {
        return judge(pRoot, pRoot);
    }

    boolean judge(TreeNode p1, TreeNode p2) {
        if (p1 == null && p2 == null) {
            return true;
        }
        if (p1 == null || p2 == null) {
            return false;
        }
        if (p1.left != null && p2.right != null && p1.left.val != p2.right.val) {
            return false;
        }
        if (p1.right != null && p2.left != null && p1.right.val != p2.left.val) {
            return false;
        }
        return judge(p1.left, p2.right) && judge(p1.right, p2.left);
    }

    //57.请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int layer = 1;
        //s1存奇数层节点
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        s1.push(pRoot);
        //s2存偶数层节点
        Stack<TreeNode> s2 = new Stack<TreeNode>();

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        while (!s1.empty() || !s2.empty()) {
            if (layer % 2 != 0) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    if (node != null) {
                        temp.add(node.val);
                        System.out.print(node.val + " ");
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            } else {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    if (node != null) {
                        temp.add(node.val);
                        System.out.print(node.val + " ");
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            }
        }
        return list;
    }

    //58.从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        depth(pRoot, 1, res);
        return res;
    }

    private void depth(TreeNode pRoot, int depth, ArrayList<ArrayList<Integer>> res) {
        if (pRoot == null) return;
        if (depth > res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(depth - 1).add(pRoot.val);
        depth(pRoot.left, depth + 1, res);
        depth(pRoot.right, depth + 1, res);
    }

    //60.给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
    //二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
    ////     所以，按照中序遍历顺序找到第k个结点就是结果。
    int index2 = 0; //计数器

    TreeNode KthNode(TreeNode root, int k) {
        if (root != null) { //中序遍历寻找第k个
            TreeNode node = KthNode(root.left, k);
            if (node != null)
                return node;
            index2++;
            if (index2 == k)
                return root;
            node = KthNode(root.right, k);
            if (node != null)
                return node;
        }
        return null;
    }

    //61.如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
//小顶堆
    //https://www.nowcoder.com/profile/645151/codeBookDetail?submissionId=1521636
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

    //大顶堆
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    //记录偶数个还是奇数个
    int count = 0;

    //每次插入小顶堆的是当前大顶堆中最大的数
    //每次插入大顶堆的是当前小顶堆中最小的数
    //这样保证小顶堆中的数永远大于等于大顶堆中的数
    //中位数就可以方便地从两者的根结点中获取了
    public void Insert(Integer num) {
        //个数为偶数的话，则先插入到大顶堆，然后将大顶堆中最大的数插入小顶堆中
        if (count % 2 == 0) {
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        } else {
            //个数为奇数的话，则先插入到小顶堆，然后将小顶堆中最小的数插入大顶堆中
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
        count++;
    }

    public Double GetMedian() {
        //当前为偶数个，则取小顶堆和大顶堆的堆顶元素求平均
        if (count % 2 == 0) {
            return new Double(minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            //当前为奇数个，则直接从小顶堆中取元素即可
            return new Double(minHeap.peek());
        }
    }

    //62.给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
    public static ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length == 0 || size <= 0 || size > num.length) {
            return res;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            if (i >= size && list.getFirst() <= i - size) {
                list.pollFirst();
            }
            while (list.size() > 0 && num[list.getLast()] <= num[i]) {
                list.pollLast();
            }
            list.addLast(i);
            if (i >= size - 1) {
                res.add(num[list.getFirst()]);
            }
        }
        return res;
    }

    //
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
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
    //63.请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //标志位 初始化为false
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ////循环遍历二维数组，找到起点等于str第一个元素的值，再递归判断四周是否有符合条件的----回溯法
                if (judge2(matrix, i, j, rows, cols, flag, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    //judge(初始矩阵，索引行坐标i，索引纵坐标j，矩阵行数，矩阵列数，待判断的字符串，字符串索引初始为0即先判断字符串的第一位)
    private boolean judge2(char[] matrix, int i, int j, int rows, int cols, boolean[] flag, char[] str, int k) {
        //先根据i和j计算匹配的第一个元素转为一维数组的位置
        int index = i * cols + j;
        //递归终止条件
        if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[index] != str[k] || flag[index] == true)
            return false;
        //若k已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true即可
        if (k == str.length - 1)
            return true;
        //要走的第一个位置置为true，表示已经走过了
        flag[index] = true;

        //回溯，递归寻找，每次找到了就给k加一，找不到，还原
        if (judge2(matrix, i - 1, j, rows, cols, flag, str, k + 1) ||
                judge2(matrix, i + 1, j, rows, cols, flag, str, k + 1) ||
                judge2(matrix, i, j - 1, rows, cols, flag, str, k + 1) ||
                judge2(matrix, i, j + 1, rows, cols, flag, str, k + 1)) {
            return true;
        }
        //走到这，说明这一条路不通，还原，再试其他的路径
        flag[index] = false;
        return false;
    }

    //64.地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
    //核心思路：
    //1.从(0,0)开始走，每成功走一步标记当前位置为true,然后从当前位置往四个方向探索，
    //返回1 + 4 个方向的探索值之和。
    //2.探索时，判断当前节点是否可达的标准为：
    //1）当前节点在矩阵内；
    //2）当前节点未被访问过；
    //3）当前节点满足limit限制。
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return countingSteps(threshold, rows, cols, 0, 0, visited);
    }

    public int countingSteps(int limit, int rows, int cols, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= rows || c < 0 || c >= cols
                || visited[r][c] || bitSum(r) + bitSum(c) > limit) return 0;
        visited[r][c] = true;
        return countingSteps(limit, rows, cols, r - 1, c, visited)
                + countingSteps(limit, rows, cols, r, c - 1, visited)
                + countingSteps(limit, rows, cols, r + 1, c, visited)
                + countingSteps(limit, rows, cols, r, c + 1, visited)
                + 1;
    }

    public int bitSum(int t) {
        int count = 0;
        while (t != 0) {
            count += t % 10;
            t /= 10;
        }
        return count;
    }

    //65.给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
    //首先判断k[0]到k[m]可能有哪些数字，实际上只可能是2或者3
    public int cutRope(int target) {
        if (target == 2) return 1;
        if (target == 3) return 2;

        int x = target % 3;
        int y = target / 3;
        if (x == 0) {
            return (int) Math.pow(3, y);
        } else if (x == 1) {
            //4,7
            return 2 * 2 * (int) Math.pow(3, y - 1);
        } else {
            //5,8
            return 2 * (int) Math.pow(3, y);
        }
    }

    //66.检验二叉搜索树
    public boolean check(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;

        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }

    //67.二叉搜索树  BST的最低公共祖先
    public TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return find(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return find(root.right, p, q);
        } else {
            return root;
        }
    }

    //非递归
    public TreeNode find3(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }

    // 普通二叉树的最低公共祖先
    public TreeNode find2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = find2(root.left, p, q);
        TreeNode right = find2(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    //
    // findMaxLen能够计算出每个节点的左右子树的最大距离，并将该值+1保存在该节点的maxLeftLen和maxRightLen中
    public void findMaxLen(Node node) {
        // 用于保存树中的两个节点的最大距离
        int maxLen = 0;
        if (node == null)
            return;

        // 如果该节点的左子树为空，则该从该节点向左走的最长距离为0
        if (node.left == null) {
            node.maxLeftLen = 0;
        }
        // 如果该节点的右子树为空，则该从该节点向右走的最长距离为0
        if (node.right == null) {
            node.maxRightLen = 0;
        }

        // 如果该节点的左子树不为空，递归的计算出该节点的左孩子节点的maxLeftLen和maxRightLen（并更新maxLen）
        if (node.left != null) {
            findMaxLen(node.left);
        }

        // 如果该节点的右子树不为空，递归的计算出该节点的右孩子节点的maxLeftLen和maxRightLen（并更新maxLen）
        if (node.right != null) {
            findMaxLen(node.right);
        }

        // 如果该节点的左子树不为空，那么该节点的maxLeftLen等于它的左孩子节点的maxLeftLen、maxRightLen中较大的那个 + 1
        if (node.left != null) {
            int maxLeftLenTemp = Math.max(node.left.maxLeftLen, node.left.maxRightLen) + 1;
            node.maxLeftLen = maxLeftLenTemp;
        }
        // 如果该节点的右子树不为空，那么该节点的maxRightLen等于它的右孩子节点的maxLeftLen、maxRightLen中较大的那个 + 1
        if (node.right != null) {
            int maxRightLenTemp = Math.max(node.right.maxLeftLen, node.right.maxRightLen) + 1;
            node.maxRightLen = maxRightLenTemp;
        }
        // 到这一步，当前处理的节点的maxLeftLen和maxLeftLen已经得到了，如果它的maxLeftLen+maxRightLen值比maxLen大，就可以更新maxLen
        if (maxLen < node.maxLeftLen + node.maxRightLen) {
            maxLen = node.maxLeftLen + node.maxRightLen;
        }
    }
}


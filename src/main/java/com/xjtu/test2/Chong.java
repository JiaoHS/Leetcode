package com.xjtu.test2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.xjtu.ssmidea.algorithm.ListNode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @auther coraljiao
 * @date 2021/5/18 22:10
 * @description
 */
public class Chong {
    public static void main(String[] args) {
//        int[] arr = {2, 5, 3, 1, 7, 10};
//        qSort(arr);
//        for (int i : arr) {
//            System.out.println(i);
//        }

//        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
//        ArrayList<Integer> topArr = getTopArr(arr, 5);
//        System.out.println(Arrays.toString(topArr.toArray()));

//        int[] arr = {1, 2, 4, 4, 5};
//        int targer = 4;
//        int search = search(arr, targer);
//        System.out.println(search);

        String str="abcabcbb";
        int i = lengthOfLongestSubstring(str);
        System.out.println(i);
    }

    //1、快排
    public static void qSort(int[] arr) {
        qsort02(arr, 0, arr.length - 1);
    }

    private static void qsort01(int[] arr, int left, int right) {
        if (left > right) return;
        int i = left, j = right, t;
        int temp = arr[left];
        while (i < j) {
            //先看右边，依次往左递减
            while (i < j && arr[j] >= temp) {
                j--;
            }
            //再看左边，依次往右递增
            while (i < j && arr[i] <= temp) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[left] = arr[i];
        arr[i] = temp;
        qsort01(arr, left, i - 1);
        qsort01(arr, i + 1, right);
    }

    private static void qsort02(int[] arr, int left, int right) {
        if (left > right) return;
        int i = left, j = right, t;
        int temp = arr[left];
        while (i < j) {
            //先看右边，依次往左递减
            while (i < j && arr[j] >= temp) {
                j--;
            }
            arr[i] = arr[j];
            //再看左边，依次往右递增
            while (i < j && arr[i] <= temp) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = temp;
        qsort02(arr, left, i - 1);
        qsort02(arr, i + 1, right);
    }


    //2、链表反转
    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //3、给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，
    // 则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
    public static ArrayList<Integer> getTopArr(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (k > input.length || k <= 0) {
            return arrayList;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (i < k) {
                priorityQueue.add(input[i]);
            } else {
                if (input[i] < priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.add(input[i]);
                }
            }
        }
        while (k > 0) {
            arrayList.add(priorityQueue.poll());
            k--;
        }
        return arrayList;
    }

    //4、给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
    public int[] twoSum(int[] numbers, int target) {
        // write code here
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(target - numbers[i]) != null) {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i], i);

        }
        return null;
    }

    //5、给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
    //子数组是连续的，比如[1,2,3,4,5]的子数组有[1,2]，[2,3,4]等等，但是[1,3,4]不是子数组
    public int maxLength(int[] arr) {
        // write code here
//        LinkedList<Integer> list = new LinkedList<>();
//        int p = 0, ans = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (list.contains(arr[i])) {
//                int j = list.indexOf(arr[i]);
//                while (j-- >= 0) {
//                    list.removeFirst();
//                }
//            }
//            list.add(arr[i]);
//            ans = Math.max(ans, list.size());
//        }
//        return ans;
        // write code here
        if (arr == null || arr.length == 0) return 0;
        //用于存放该数字上一次出现的索引
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, max = 1;
        for (int i = 0; i < arr.length; ++i) {
            //获取上次出现的索引位置，若第一次出现则为-1
            int idx = map.getOrDefault(arr[i], -1);
            //该位置是否在当前区间，如果是 以当前元素结尾的最长无重复子串的left只能从idx + 1计算
            if (idx >= left) {
                left = idx + 1;
            }
            map.put(arr[i], i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    //6、给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
    public boolean isValid(String s) {
        // write code here
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.empty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.empty();
    }

    //7、大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）
    public int Fibonacci(int n) {
        // int a = 0;
        //        int b = 1;
        //        for (int i = 1; i <= n; i++) {
        //            int tmp = a+b;
        //            a = b;
        //            b = tmp;
        //        }
        int a = 0, b = 1;
        for (int i = 1; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return a;
    }

    //8、请实现有重复数字的升序数组的二分查找
    //给定一个 元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
    public static int search(int[] nums, int target) {
        // write code here
        int index = -1, low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                index = mid;
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

    //9、对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
    //给定字符串A以及它的长度n，请返回最长回文子串的长度。
    public int getLongestPalindrome(String A, int n) {
        // write code here
        // 第 i 个字符到第 j 个字符是否是回文串
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        // 字符串首尾字母长度差 (d = j-i)
        for (int d = 0; d < n; d++) {
            // 字符串起始位置 i
            for (int i = 0; i < n - d; i++) {
                // 字符串结束位置 j
                int j = i + d;
                // 如果字符串 i 到 j 的首尾相等，再根据字符串 i-1 到 j-1 来确定，即得到递推公式
                if (A.charAt(i) == A.charAt(j)) {
                    if (d == 0 || d == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j]) {
                        // 更新最大长度
                        max = Math.max(max, d + 1);
                    }
                }
            }
        }
        return max;
    }

    //10、数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。你可以假设数组是非空的，并且给定的数组总是存在多数元素。1<=数组长度<=50000
    public int MoreThanHalfNum_Solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int count = map.get(array[i]) == null ? 0 : map.get(array[i]) + 1;
            if (count > array.length / 2) {
                return array[i];
            }
            map.put(array[i], count);
        }
        return 0;
    }

    //11、对于一个给定的链表，返回环的入口节点，如果没有环，返回null
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                //说明有环，记录相遇节点，p1从头开始走，p2从入口开始走  直到两节点再次相遇
                p1 = head;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                break;
            }
        }
        if (p2 == null || p2.next == null) return null;
        return p1;
    }

    //12、给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，
    // 路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
    public int minPathSum(int[][] matrix) {
        // write code here
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }

    //13、判断给定的链表中是否有环。如果有环则返回true，否则返回false。
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    //14、用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pup() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    //15、0-1背包问题
    public int maxValue(int[] weight, int[] value, int W) {
        //这里假定传入的weight和values数组长度总是一致的
        int n = weight.length;
        if (n == 0) return 0;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= W; k++) {
                // 存放 i 号物品（前提是放得下这件物品）
                int valueWith_i = (k - weight[i - 1] >= 0) ? (value[i - 1] + dp[i - 1][k - weight[i - 1]]) : 0;
                // 不存放 i 号物品
                int valueWithout_i = dp[i - 1][k];
                dp[i][k] = Math.max(valueWith_i, valueWithout_i);
            }
        }
        return dp[n][W];
    }

    public int maxValue2(int[] weight, int[] value, int W) {
        int n = weight.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][W + 1];
        // 先初始化第 0 行，也就是尝试把 0 号物品放入容量为 k 的背包中
        for (int k = 1; k <= W; k++) {
            if (k >= weight[0]) dp[0][k] = value[0];
            else dp[0][k] = 0; // 这一步其实没必要写，因为dp[][]数组默认就是0
        }
        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= W; k++) {
                // 存放 i 号物品（前提是放得下这件物品）
                int valueWith_i = (k - weight[i] >= 0) ? (value[i] + dp[i - 1][k - weight[i]]) : 0;
                // 不存放 i 号物品
                int valueWithout_i = dp[i - 1][k];
                dp[i][k] = Math.max(valueWith_i, valueWithout_i);
            }
        }
        return dp[n - 1][W];
    }

    public int maxValue3(int[] weight, int[] value, int W) {
        int n = weight.length;
        if (n == 0) return 0;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int val = ((j - weight[i - 1]) > 0 ? dp[i - 1][j - weight[i - 1]] : 0) + value[i - 1];

                int val2 = dp[i - 1][j];

                dp[i][j] = Math.max(val, val2);
            }
        }
        return dp[n][W];
    }

    //16、给出两个有序的整数数组 和 ，请将数组 合并到数组 中，变成一个有序的数组
    public void merge(int A[], int m, int B[], int n) {
        int right = A.length - 1;
        int curA = m - 1;
        int curB = n - 1;

        while (curA >= 0 && curB >= 0) {
            if (A[curA] > B[curB]) {
                A[right--] = A[curA--];
            } else {
                A[right--] = B[curB--];
            }
        }

        while (curA >= 0) {
            A[right--] = A[curA--];
        }

        while (curB >= 0) {
            A[right--] = B[curB--];
        }
    }

    //17、无重复字符的最长子串：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    public static int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
//        int[] last = new int[128];
//        for(int i = 0; i < 128; i++) {
//            last[i] = -1;
//        }
//        int n = s.length();
//
//        int res = 0;
//        int start = 0; // 窗口开始位置
//        for(int i = 0; i < n; i++) {
//            int index = s.charAt(i);
//            start = Math.max(start, last[index] + 1);
//            res   = Math.max(res, i - start + 1);
//            last[index] = i;
//        }
//
//        return res;

//        if (s.length() == 0) return 0;
//        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//        int max = 0;
//        int left = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i))) {
//                left = Math.max(left, map.get(s.charAt(i)) + 1);
//            }
//            map.put(s.charAt(i), i);
//            max = Math.max(max, i - left + 1);
//        }
//        return max;

        if (s.length() == 0) return 0;
        int left = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-left+1);
        }
        return max;
    }

    //18|给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        if (null==matrix||matrix.length==0){
            return list;
        }
        int left=0,right=matrix[0].length-1,up=0,down=matrix.length-1;
        while (true){
            for (int i = left; i <= right; i++) list.add(matrix[up][i]);
            if (++up>down){
                break;
            }
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            if (--right<left){
                break;
            }
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            if (--down<up){
                break;
            }
            for (int i = down; i >= up; i--) {
                list.add(matrix[i][left]);
            }
            if (++left>right){
                break;
            }
        }
        return list;
    }

    //19给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。


    public static int count(int n, int m) {
        int i = 1;
        int count =0;

        while(n / i != 0){
            //当前位
            int current = n / i % 10;
            //最高位
            int high = n / (i*10);
            //最低位
            int low = n - n / i * i;
            //当前位数字小于指定值时，指定值出现次数为最高位乘数位补差值（如十位补乘10，百位补乘100）
            if(current < m) {
                count += high * i;
            }
            //当前位数字等于指定值时，指定值出现次数为最高位乘数位补差值加上后最低位再加1（k值叠加）
            if(m == current){
                count += high * i + low + 1;
            }
            //当前位数字大于指定值时，指定值出现次数为最高位+1乘数位补差值（k值叠加）
            if(current > m) {
                count += (high + 1) * i;
            }
            //数位补差值更新，每向前推进一位，则补差值乘10（可以理解为最高位后补0）
            i *= 10;
        }

        if(m == 0 && n >= 10){
            count -= i / 10;
        }

        return count;
    }
}

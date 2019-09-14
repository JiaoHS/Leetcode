package com.xjtu.qiuzhao;

import java.util.*;

/**
 * @auther coraljiao
 * @date 2019/9/10 19:50
 * @description
 */
public class day006 {
    public static void main(String[] args) {
        //1、字符串求和
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
        //System.out.println(getSum(str));

        //2、蛇形字符对
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        getSnake(str);

        //3、快排
        int[] arr = {2, 5, 1, 9, 3};
        //sortKuaiPai(arr);
        //4、冒泡
//        maoPaoSort(arr);
        //5、归并排序
//        guiBingSort(arr);
        //6、堆排序
        dui6Sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        //7、和等于k的最长子序列

    }

    private static void dui6Sort(int[] arr) {
        //构建堆结构   //从第一个非叶子节点开始调整堆结构
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustSort(arr, i, arr.length - 1);
        }
        //调整堆结构  交换元素   //交换根元素和第一个元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap6(arr, 0, j);
            adjustSort(arr, 0, j);
        }
    }

    private static void swap6(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //构建最小堆
    private static void adjustSort(int[] arr, int i, int length) {
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

    private static void guiBingSort(int[] arr) {
        int[] temp = new int[arr.length];
        guiBingSort2(arr, 0, arr.length - 1, temp);
    }

    private static void guiBingSort2(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            guiBingSort2(arr, left, mid, temp);
            guiBingSort2(arr, mid + 1, right, temp);
            mergeSort4(arr, left, mid, right, temp);
        }
    }

    private static void mergeSort4(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
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

    private static void maoPaoSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] > arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    private static void sortKuaiPai(int[] arr) {
        sortKuaiPai1(arr, 0, arr.length - 1);
    }

    private static void sortKuaiPai1(int[] arr, int left, int right) {
        if (left > right) return;
        int temp = arr[left];
        int i = left, j = right;
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
        sortKuaiPai1(arr, left, i - 1);
        sortKuaiPai1(arr, i + 1, right);
    }

    private static void getSnake(String array) {
        //char[] array = str.toCharArray();
        int[] AList = new int[26];
        int[] aList = new int[26];
        ArrayList<String> list = new ArrayList<>();
        while (true) {

            //首先将字符串分别放入大小写的数组里头
            for (int i = 0; i < array.length(); i++) {
                if (array.charAt(i) >= 97 && array.charAt(i) <= 122) {
                    aList[array.charAt(i) - 'a'] = 1;
                } else if (array.charAt(i) >= 65 && array.charAt(i) <= 90) {
                    AList[array.charAt(i) - 'A'] = 1;
                }
            }
            //数组循环比较
            StringBuilder sb = new StringBuilder();
            //将当前最大的字符对保存起来
            String s = "";
            for (int i = 0; i < 26; i++) {
                if (AList[i] == 1 && aList[i] == 1) {
                    sb.append((char) (i + 'A'));
                    sb.append((char) (i + 'a'));
                } else {
                    if (sb.length() > s.length()) {
                        s = sb.toString();
                    } else {
                        sb = new StringBuilder();
                    }
                }
            }
            //保存去除当前的字符对后剩下的字符串
            if (s.length() > 0) {
                for (int i = 0; i < s.length(); i++) {
                    if (array.indexOf(s.charAt(i)) != -1) {
                        int index = array.indexOf(s.charAt(i));
                        String temp1 = array.substring(0, index);
                        String temp2 = array.substring(index + 1, array.length());
                        array = temp1 + temp2;
                    }
                }
                list.add(s);
            } else {
                break;
            }
        }
        //list比较器 先按字典 在按长度
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.startsWith(o2)) {
                    return -1;
                } else if (o2.startsWith(o1)) {
                    return 1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        } else {
            System.out.println("Not Found!!!");
        }
    }

    private static int getSum(String str) {
        char[] temp = str.toCharArray();
        Stack<Integer> stack = new Stack<>();
        boolean flag = true;
        int sum = 0;
        for (int i = 0; i < temp.length; i++) {
            if (isNum(temp[i])) {
                stack.push(temp[i] - '0');
            } else {
                int t = 0;
                int index = 1;
                while (!stack.isEmpty()) {
                    t += stack.pop() * index;
                    index *= 10;
                }
                if (flag) {
                    sum += t;
                } else {
                    sum -= t;
                }
                if (temp[i] == '+') {
                    flag = true;
                } else if (temp[i] == '-') {
                    flag = false;
                }
            }
        }
        //最后一个数
        int t2 = 0;
        int index = 1;
        while (!stack.isEmpty()) {
            t2 += stack.pop() * index;
            index *= 10;
        }
        if (flag) {
            sum += t2;
        } else {
            sum -= t2;
        }
        return sum;
    }

    private static boolean isNum(char c) {
        if (c - '0' >= 0 && c - '0' <= 9) {
            return true;
        } else {
            return false;
        }
    }
}

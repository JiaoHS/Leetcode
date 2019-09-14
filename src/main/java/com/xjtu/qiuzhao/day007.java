package com.xjtu.qiuzhao;

import java.util.*;

/**
 * @auther coraljiao
 * @date 2019/9/11 19:37
 * @description
 */
public class day007 {
    public static void main(String[] args) {
        //1、快排
        //int[] arr = {4, 1, 6, 2, 9, 8};
        //kuaiPaiSort(arr);
        //dui7Sort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }

        //2、字符串包含1-9 + -
//        int res = getSum("2+9-1");
//        System.out.println(res);
        //3、蛇形字符串
        getSnake("");
        String s="";
        s.equals("s");

        Objects.equals("","");
    }

    private static void getSnake(String s) {
        //首先将所有的字符串放到数组
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            int[] A = new int[26];
            int[] a = new int[26];
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) - '0' >= 97 && s.charAt(i) - '0' <= 122) {
                    a[s.charAt(i) - 'a'] = 1;
                } else if (s.charAt(i) - '0' >= 65 && s.charAt(i) - '0' <= 90) {
                    A[s.charAt(i) - 'A'] = 1;
                }
            }
            //循环判断
            StringBuilder sb = new StringBuilder();
            String str = "";
            for (int i = 0; i < 26; i++) {
                if (A[i] == 1 && a[i] == 1) {
                    sb.append((char) a[i] + 'A');
                    sb.append((char) A[i] + 'a');
                } else {
                    //将最大的字符对保存到str
                    if (sb.length() > str.length()) {
                        str = sb.toString();
                    } else {
                        sb = new StringBuilder();
                    }
                }
            }
            //将剩余的字符串保存
            if (str.length() > 0) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.indexOf(s.charAt(i)) != -1) {
                        int index = s.indexOf(str.charAt(i));
                        String temp1 = s.substring(0, index);
                        String temp2 = s.substring(index + 1, s.length());
                        s = temp1 + temp2;
                    }
                }
                //将字符对保存到list
                list.add(str);
            } else {
                break;
            }
        }
        //list排序
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
        }else {
            System.out.println("Not Found!!!");
        }
    }

    private static int getSum(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        boolean flag = true;
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (isDig7(chars[i])) {
                stack.push(chars[i] - '0');
            } else {
                int temp = 0;
                int index = 1;
                while (!stack.isEmpty()) {
                    temp += stack.pop() * index;
                    index *= 10;
                }
                if (flag) {
                    sum += temp;
                } else {
                    sum -= temp;
                }
                if (chars[i] == '-') {
                    flag = false;
                } else if (chars[i] == '+') {
                    flag = true;
                }
            }
        }
        //最后一个元素
        int temp = 0;
        int index = 1;
        while (!stack.isEmpty()) {
            temp += stack.pop() * index;
            index *= 10;
        }
        if (flag) {
            sum += temp;
        } else {
            sum -= temp;
        }
        return sum;
    }

    private static boolean isDig7(char c) {
        if (c - '0' >= 0 && c - '0' <= 9) {
            return true;
        } else {
            return false;
        }
    }

    private static void dui7Sort(int[] arr) {
        //构建堆结构
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustDui7(arr, i, arr.length - 1);
        }
        //调整堆结构   交换元素
        for (int j = arr.length - 1; j > 0; j--) {
            sqap7(arr, 0, j);
            adjustDui7(arr, 0, j);
        }
    }

    private static void sqap7(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void adjustDui7(int[] arr, int i, int length) {
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
        guiBingSort7(arr, 0, arr.length - 1, temp);
    }

    private static void guiBingSort7(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            guiBingSort7(arr, left, mid, temp);
            guiBingSort7(arr, mid + 1, right, temp);
            merge7(arr, left, mid, right, temp);
        }
    }

    private static void merge7(int[] arr, int left, int mid, int right, int[] temp) {
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

    //快排
    private static void kuaiPaiSort(int[] arr) {
        kuaiPaiSort7(arr, 0, arr.length - 1);
    }

    private static void kuaiPaiSort7(int[] arr, int left, int right) {
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
        kuaiPaiSort7(arr, left, i - 1);
        kuaiPaiSort7(arr, i + 1, right);
    }
}

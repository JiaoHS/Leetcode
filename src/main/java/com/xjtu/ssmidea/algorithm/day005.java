package com.xjtu.ssmidea.algorithm;

import java.util.*;

/**
 * Created by zxl on 2019/3/16.
 */
public class day005 {

    public static void main(String[] args) {
        //test();
        int[] arr = {2, 5, 7, 1, 9};
        sort5(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void test() {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int[] res = new int[m];

        ArrayList<Integer> array_n = new ArrayList<>();
        List<ArrayList<Integer>> array_num = new ArrayList<>();
        for (int k = 0; k < m; k++) {
            int num = s.nextInt();
            array_n.add(num);
            ArrayList<Integer> a1 = new ArrayList<>();
            for (int l = 0; l < num; l++) {
                a1.add(s.nextInt());
            }
            array_num.add(a1);
        }

        for (int k = 0; k < m; k++) {
            int n = array_n.get(k);
            int[] jiangpin = new int[n];
            Set<Integer> set = new HashSet<>();
            ArrayList<Integer> list1 = array_num.get(k);
            Map<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                jiangpin[i] = 0;
                int tmp = list1.get(i);
                list1.add(tmp);
                set.add(tmp);
                if (map.containsKey(tmp)) {
                    map.get(tmp).add(i);
                } else {
                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(i);
                    map.put(tmp, a);
                }
            }
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
//            int current = Integer.MIN_VALUE;
            for (int i = 0; i < list.size(); i++) {
                int fenshu = list.get(i);
//                if(fenshu==current) continue;
//                System.out.println("fenshu "+fenshu);
                for (int j : map.get(fenshu)) {
                    // j为原始位置
                    int p = j - 1 >= 0 ? j - 1 : n - 1;
                    int q = j + 1 < n ? j + 1 : 0;
                    if (fenshu == list1.get(p) && fenshu == list1.get(q)) {
                        jiangpin[j] = 1;
                    } else if (fenshu == list1.get(p)) {
                        jiangpin[j] = jiangpin[q] + 1;
                    } else if (fenshu == list1.get(q)) {
                        jiangpin[j] = jiangpin[p] + 1;
                    } else {
                        jiangpin[j] = Math.max(jiangpin[p], jiangpin[q]) + 1;
                    }
//                    System.out.println(jiangpin[j]);
                }
            }
            int sum = 0;
            for (int i : jiangpin) {
//                System.out.println(i);
                sum += i;
            }
            res[k] = sum;
//            System.out.println(sum);
        }
        for (int i : res) {
            System.out.println(i);
        }
    }

    //快排,某一个元素为基准，依次比较并交换位置
    public static void sort01(int[] arr, int low, int high) {
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
        sort01(arr, low, i - 1);
        sort01(arr, i + 1, high);
    }

    //归并排序，构建大顶堆
    public static void sort2(int[] arr) {
        //排序前先定义一个空的数组
        int[] temp = new int[arr.length];
        sort3(arr, 0, arr.length - 1, temp);
    }

    private static void sort3(int[] arr, int low, int high, int[] temp) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort3(arr, low, mid, temp);
            sort3(arr, mid + 1, high, temp);
            merge3(arr, low, mid, high, temp);
        }
    }

    private static void merge3(int[] arr, int low, int mid, int high, int[] temp) {
        //定义指针
        int i = low, j = mid + 1;
        int t = 0;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //还有剩余，则将左边剩余全部插入的数组中
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= high) {
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp复制给arr
        while (low <= high) {
            arr[low++] = temp[t++];
        }
    }

    //堆排序
    public static void sort5(int[] arr){
        //先建大顶堆或者小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr,i,arr.length);
        }
        //交换并调整堆结构
        for (int j = arr.length - 1; j > 0; j--) {
            //将堆顶元素和堆底元素互换
            swap(arr,0,j);
            adjust(arr,0,j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    private static void adjust(int[] arr, int left, int right) {
        //先取出当前元素
        int first=arr[left];
        //从i结点的左子结点开始，也就是2i+1处开始
        for (int k=2*left+1;k<right;k=2*k+1){
            //如果左子结点小于右子结点，k指向右子结点
            if (k+1<right&&arr[k]<arr[k+1]){
                k++;
            }
            //交换子节点与父节点
            if (arr[k]>first){
                arr[left]=arr[k];
                left=k;
            }else {
                break;
            }
        }
        arr[left]=first;
    }
}



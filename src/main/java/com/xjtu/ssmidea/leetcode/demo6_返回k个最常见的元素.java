package com.xjtu.ssmidea.leetcode;

import java.util.*;

public class demo6_返回k个最常见的元素 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        int[] nums = {1};
        list = topKFrequentN(nums, 1);
    }

    public static List<Integer> topKFrequentN(int[] nums, int k) {
        List<Integer> list = new ArrayList();
        int[] arr = new int[nums.length + 1];
        HashMap<Integer, Integer> count = new HashMap();
        HashMap<Integer, List<Integer>> countList = new HashMap();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            list = new ArrayList();
            list.add(entry.getKey());
            if (countList.containsKey(entry.getValue())) {
                list = countList.get(entry.getValue());
                list.add(entry.getKey());
            }
            countList.put(entry.getValue(), list);
        }
        List<Integer> top_k = new LinkedList();
        for (Map.Entry<Integer, List<Integer>> entry : countList.entrySet()) {
            top_k.addAll(entry.getValue());
        }
        Collections.reverse(top_k);
        List<Integer> top_kk = new LinkedList();
        for (int i = 0; i <k; i++) {
            top_kk.add(top_k.get(i));
        }
        return top_kk;
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList();
        Map<Integer, Integer> map = new HashMap<>();
        Integer iger;
        Integer c;
        for (int i = 0; i < nums.length; i++) {
            iger = 0;
            c = nums[i];
            if (map.containsKey(c)) {
                iger = map.get(c);
                iger++;
            } else {
                iger++;
            }
            map.put(c, iger);
        }
        int index = 0;

        for (Integer value : map.values()) {

            System.out.println("Value = " + value);

        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            entry.getValue();

            for (int i = 0; i < k; i++) {

            }
            list.add(entry.getKey());
        }
        return list;
    }

    public static List<Integer> topKFrequent2(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> count = new HashMap();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        // keep k top frequent elements in the heap
        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // build output list
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;
    }

    public static List<Integer> topKFrequent3(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                if (e1.getValue() < e2.getValue())
                    return 1;
                else if (e1.getValue() > e2.getValue())
                    return -1;
                else
                    return 0;
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            q.offer(entry);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(q.poll().getKey());
        }

        return result;
    }
}

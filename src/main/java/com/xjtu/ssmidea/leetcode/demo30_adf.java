package com.xjtu.ssmidea.leetcode;

//假设你有从1到N的N个整数。如果在这个数组中第i个位置（1 <= i <= N）的下列之一为真，我们将这个N个数字成功构造的数组定义为一个漂亮的排列：
//第i个位置的数字可以被i整除。我可以被第i个位置的数字整除 现在给出N，你可以建造多少美丽的安排?
//N is a positive integer and will not exceed 15
class demo30_BeautifulArrangement {

    private static int count = 0;

    public static void main(String[] args) {
        int num = 2;
        int res = countArrangement(num);
        System.out.println(res);
    }

    public static int countArrangement(int N) {

        if (N == 0) return 0;
        helper(N, 1, new int[N + 1]);
        return count;
    }

    private static void helper(int N, int pos, int[] used) {
        if (pos > N) {
            count++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (used[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                used[i] = 1;
                helper(N, pos + 1, used);
                used[i] = 0;
            }
        }
    }
}

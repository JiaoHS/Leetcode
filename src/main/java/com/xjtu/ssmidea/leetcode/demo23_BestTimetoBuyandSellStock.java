package com.xjtu.ssmidea.leetcode;

public class demo23_BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int[] nums = {7,6,4,3,1};
        int res = maxProfit2(nums);
        System.out.println(res);
    }

    private static int maxProfit2(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int soFarMin = prices[0];
        int max = 0;
        for(int i = 1; i < prices.length; i++){
            if(soFarMin > prices[i]){
                soFarMin = prices[i];
            }else{
                max = Math.max(max, prices[i] - soFarMin);
            }
        }
        return max;
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int index = prices[0], sum = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < index) {
                index = Math.min(index, prices[i]);
            } else {
                sum = Math.max(sum, prices[i] - index);
            }
        }
        return sum;
    }
}

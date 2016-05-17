package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/5/7.
 * Email:zhangfei614@126.com
 思路：动态规划，当前值减去前面所有的最小值。
 */

public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int maxProfit = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            int profit = prices[i]-min;
            if(profit > maxProfit) maxProfit = profit;
            if(prices[i] < min) min = prices[i];
        }
        return maxProfit;
    }

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.

     Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     * @param prices
     * @return
     */
    public int maxProfitII(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int sum = 0;
        int buy = prices[0],sel = Integer.MIN_VALUE;
        int i= 1;
        while(true){
            while(i < prices.length && prices[i] <= prices[i-1]) buy = prices[i++];
            while(i < prices.length && prices[i] > prices[i-1]) sel = prices[i++];
            if(sel > buy){
                sum +=(sel - buy);
                sel = Integer.MIN_VALUE;
                buy = Integer.MAX_VALUE;
            }
            if(i == prices.length) break;
        }
        return sum;
    }

    public static void main(String[] args){
        int[] test = {6,5,4,3,2,1,2,3,4,3,2,1,2};
        int res = new BestTimeBuySellStock().maxProfitII(test);
        System.out.println(res);
    }
}

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
}

package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/7/4.
 * Email:zhangfei614@126.com
 * 从前到后遍历：1--k的最大值
 * 从后往前遍历：k--n的最大值
 */

public class BestTimeBuySellStockIII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[] profitLeft = new int[n];
        int[] profitRight = new int[n];
        int min = prices[0];
        for(int i = 1; i < n ; i++){
            profitLeft[i] = Math.max(prices[i]-min,profitLeft[i-1]);
            min = Math.min(min,prices[i]);
        }
        int max = prices[n-1];
        for(int i = n-2; i >= 0; i--){
            profitRight[i] = Math.max(max - prices[i],profitRight[i+1]);
            max = Math.max(prices[i],max);
        }
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0; i < n-1; i++)
            maxProfit = Math.max(maxProfit,profitLeft[i]+profitRight[i+1]);
        return Math.max(maxProfit,profitLeft[n-1]);
    }

    public int maxProfitSimple(int[] prices){
        int sel1 = 0, sel2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            buy1 = Math.max(buy1,-prices[i]);
            sel1 = Math.max(sel1,prices[i] + buy1);
            buy2 = Math.max(buy2,sel1 - prices[i]);
            sel2 = Math.max(sel2,buy2+prices[i]);
        }
        return sel2;
    }
    public static void main(String[] args){
        int[] arr = {1,7,4,2,11};
        System.out.println(new BestTimeBuySellStockIII().maxProfit(arr));
    }
}

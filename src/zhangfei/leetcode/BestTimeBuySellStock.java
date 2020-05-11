package zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/5/7.
 * Email:zhangfei614@126.com
 * 思路：动态规划，当前值减去前面所有的最小值。
 */

public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int maxProfit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - min;
            if (profit > maxProfit) maxProfit = profit;
            if (prices[i] < min) min = prices[i];
        }
        return maxProfit;
    }

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     *
     * @param prices
     * @return
     */
    public int maxProfitII(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int sum = 0;
        int buy = prices[0], sel = Integer.MIN_VALUE;
        int i = 1;
        while (true) {
            while (i < prices.length && prices[i] <= prices[i - 1]) buy = prices[i++];
            while (i < prices.length && prices[i] > prices[i - 1]) sel = prices[i++];
            if (sel > buy) {
                sum += (sel - buy);
                sel = Integer.MIN_VALUE;
                buy = Integer.MAX_VALUE;
            }
            if (i == prices.length) break;
        }
        return sum;
    }

    public int maxProfitIII(int[] prices) {
        int sel1 = 0, sel2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sel1 = Math.max(sel1, prices[i] + buy1);
            buy2 = Math.max(buy2, sel1 - prices[i]);
            sel2 = Math.max(sel2, buy2 + prices[i]);
        }
        return sel2;
    }

    public int maxProfitIV(int k, int[] prices) {
        int n = prices.length;
        if (n <= 0) return 0;
        //如果交易次数大于n/2，则可以任意交易，获得最大利润
        if (k >= n / 2) {
            int maxPro = 0;
            for (int i = 1; i < n - 1; i++)
                if (prices[i] > prices[i - 1])
                    maxPro += (prices[i] - prices[i - 1]);
            return maxPro;
        }

        //利用III同样的思路，申请两个数组分别表示第k次买入和k次卖出
        int[] hold = new int[k + 1], release = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            hold[i] = Integer.MIN_VALUE;
            release[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            int cur = prices[i];
            for (int j = k; j > 0; j--) {
                release[j] = Math.max(release[j], hold[j] + cur);
                hold[j] = Math.max(hold[j], release[j - 1] - cur);
            }
        }
        return release[k];
    }

    public static void main(String[] args) {
        int[] test = {6, 5, 4, 3, 2, 1, 2, 3, 4, 3, 2, 1, 2};
        int res = new BestTimeBuySellStock().maxProfitII(test);
        System.out.println(res);
    }
}

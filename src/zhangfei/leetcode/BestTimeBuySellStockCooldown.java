package zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/6/27.
 * Email:zhangfei614@126.com
 * 从一开始思路就是错的，还浪费了那么多时间。
 * 原先思路：认为只跟前面的两天有关，而忘记了递推关系。
 * 正确思路：确定递推关系验算，不要一开始就想实现。
 */

public class BestTimeBuySellStockCooldown {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int len = prices.length;
        int[] sell = new int[len];
        int[] cooldown = new int[len];
        sell[1] = prices[1] - prices[0];
        for(int i = 2; i < prices.length; i++){
            //如果这一天是cooldown，则价格是前一天cooldown的和前一天卖掉的最大值
            cooldown[i] = Math.max(sell[i-1],cooldown[i-1]);
            //如果这一天卖掉，则获得的收益是前一天的收益和前两天卖掉的最大值
            sell[i] = prices[i]-prices[i-1] + Math.max(sell[i-1],cooldown[i-2]);
        }
        return Math.max(sell[len-1],cooldown[len-1]);
    }

    public static void main(String[] args){
        int[] price = {8,6,4,3,3,2,3,5,8,3,8,2,6};
        System.out.println(new BestTimeBuySellStockCooldown().maxProfit(price));
    }
}

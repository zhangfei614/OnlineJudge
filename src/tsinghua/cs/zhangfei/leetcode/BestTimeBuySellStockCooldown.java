package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/6/27.
 * Email:zhangfei614@126.com
 */

public class BestTimeBuySellStockCooldown {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int buy = 0, sel = prices.length ,sum = 0;
        int i = 1;
        while (true){
            while(i < prices.length && prices[i] <= prices[i-1]) buy = i++;
            while(i < prices.length && prices[i] > prices[i-1]) sel = i++;
            if(sel < prices.length - 2){
                if(prices[sel] - prices[sel-1] > prices[sel+2] - prices[sel+1] && prices[sel + 2] < prices[buy]){
                    sum += (prices[sel] - prices[buy]);
                    buy = sel + 2;
                }else if(prices[sel + 1] < prices[buy]){
                    sum += (prices[sel-1] - prices[buy]);
                    buy = sel + 1;
                }
            }else if (sel < prices.length){
                sum +=(prices[sel] - prices[buy]);
                break;
            }
            if(i == prices.length) break;
        }
        return sum;
    }

    public static void main(String[] args){
        int[] price = {6,1,3,2,4,7};
        System.out.println(new BestTimeBuySellStockCooldown().maxProfit(price));
    }
}

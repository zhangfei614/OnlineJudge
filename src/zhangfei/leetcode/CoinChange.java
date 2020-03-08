package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/7/11.
 * Email:zhangfei614@126.com
 *
 */

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp =new  int[amount+1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            int min = Integer.MAX_VALUE;
            for(int k = 0; k < coins.length; k++){
                if( i - coins[k] < 0 || dp[i-coins[k]] == Integer.MAX_VALUE) min = Math.min(min,Integer.MAX_VALUE);
                else min = Math.min(min,dp[i-coins[k]]+1);
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args){
        int[] coins = {2};
        int amount = 3;
        System.out.println(new CoinChange().coinChange(coins,amount));
    }
}

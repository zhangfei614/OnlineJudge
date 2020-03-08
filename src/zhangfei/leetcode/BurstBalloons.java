package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/6/28.
 * Email:zhangfei614@126.com
 */

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length ;
        int[] newNums = new int[n+2];
        int[][] dp = new int[n+2][n+2];

        for(int i = 0; i < n; i++) newNums[i+1] = nums[i];
        newNums[0] = newNums[n+1] = 1;
        for(int len = 2; len <= n-2; len++){
            for(int left = 1; left + len <= n+1; left++){
                int right = left + len - 1;
                for(int k = left; k <= right; k++ ){
                    //和矩阵相乘十分相似，这里容易混淆的是，这里的第k个，是作为最后一个被消灭的来考虑
                    //而不是第一个被消灭的来考虑
                    //k两边的已经消失了，然后再来消灭k，则结果应该是left-1 * k * right+1
                    dp[left][right] = Math.max(dp[left][right],newNums[left-1]*newNums[k]*newNums[right+1]+dp[left][k-1]+dp[k+1][right]);
                }
            }
        }
        return dp[1][n];
    }
}

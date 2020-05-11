package zhangfei.leetcode;

import java.util.Arrays;

/**
 * Created by zhangfei614 on 2017/6/27.
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * 0,1背包问题，求解部分和是否等于sum/2.
 * 对于简单的假设：
 * d[i][j] 表示前i的数和能达到j
 * 则d[i][j] 分两种情况：
 * 如果选择第i个物品，则i-1是j-nums[i]。
 * 如果不选择第i个物品，则i-1是j。
 * 所以，d[i][j] = d[i-1][j] || d[i-1][j - nums[i]
 * 因为只牵扯到上一个的步骤，所以只需要一维即可。
 * 即：d[0]=true，然后通过替换整个一维。
 * <p/>
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) == 1) return false;
        sum >>= 1;

        boolean dp[] = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }
        return dp[sum];
    }
}

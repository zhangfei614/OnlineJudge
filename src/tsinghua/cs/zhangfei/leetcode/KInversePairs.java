package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2017/9/10.
 * Email:zhangfei614@126.com
 */

public class KInversePairs {
    public int kInversePairs(int n, int k) {
        if (n == 0) return 0;
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = k; j >= 0; j--) {
                for (int p = 0; p < n && j - p >= 0; p++)
                    dp[j] += dp[j - p];
                if (dp[j] > 1000000007)
                    dp[j] = dp[j] % 1000000007;
            }
        return dp[k];
    }

    public static void main(String[] args) {
        System.out.println(new KInversePairs().kInversePairs(3, 1));
    }
}

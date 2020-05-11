package zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2017/9/6.
 * Email:zhangfei614@126.com
 */

public class PalindromePartitioningII {

    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int n = chars.length, min, sum = 0;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n ; i++)
            dp[i][i] = 0;
        for (int k = 2; k <= chars.length; k++) {
            for (int i = 0; i <= n - k; i++) {
                int j = i + k - 1;
                if (isPalindrome(chars, i, j)) {
                    dp[i][j] = 0;
                } else {
                    min = Integer.MAX_VALUE;
                    for (int t = i; t < j; t++) {
                        sum = dp[i][t] + dp[t + 1][j] + 1;
                        if (sum < min)
                            min = sum;
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][n - 1];
    }

    private boolean isPalindrome(char[] chars, int i, int j) {
        while (i <= j) {
            if (chars[i++] != chars[j--]) return false;
        }
        return true;
    }

    public int minCut2(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }

    public static void main(String[] args) {
        String s = "cdd";
        System.out.println(new PalindromePartitioningII().minCut(s));
    }
}

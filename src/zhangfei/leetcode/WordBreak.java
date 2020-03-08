package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangfei614 on 2017/6/27.
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int l = 1; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                if (wordDict.contains(String.valueOf(chars, i - 1, l))) {
                    dp[i][j] = true;
                    continue;
                } else {
                    boolean flag = false;
                    for (int k = i + 1; k <= j; k++) {
                        flag = flag || (dp[i][k - 1] && dp[k][j]);
                    }
                    dp[i][j] = flag;
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        String str = "leetcode";
        List<String> strs = new ArrayList<>();
        strs.add("leet");
        strs.add("code");
        System.out.println(new WordBreak().wordBreak(str,strs));
    }
}

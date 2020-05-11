package zhangfei.leetcode;

import java.util.*;

/**
 * Created by zhangfei614 on 2017/6/27.
 */
public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean[][] dp = new boolean[n + 1][n + 1];
        HashMap<String, Set<String>> map = new HashMap<>();
        for (int l = 1; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                boolean flag = false;
                if (wordDict.contains(String.valueOf(chars, i - 1, l))) {
                    flag = true;
                    Set<String> list = map.getOrDefault(getKey(i, j), new HashSet<>());
                    list.add(String.valueOf(chars, i - 1, l));
                    map.put(getKey(i, j), list);
                }
                for (int k = i + 1; k <= j; k++) {
                    if (dp[i][k - 1] && dp[k][j]) {
                        flag = true;
                        Set<String> leftList = map.getOrDefault(getKey(i, k - 1), new HashSet<>());
                        Set<String> rightList = map.getOrDefault(getKey(k, j), new HashSet<>());
                        Set<String> list = map.getOrDefault(getKey(i, j), new HashSet<>());
                        for (String left : leftList)
                            for (String right : rightList)
                                list.add(left + " " + right);
                        map.put(getKey(i, j), list);
                    }
                }
                dp[i][j] = flag;
            }
        }
        return new ArrayList<>(map.getOrDefault(getKey(1, n), new HashSet<>()));
    }

    private String getKey(int i, int j) {
        return "" + i + "," + j;
    }

    public static void main(String[] args) {
        String str = "catsanddog";
        String[] strs = new String[]{"cat", "cats", "and", "sand", "dog"};
        List<String> list = Arrays.asList(strs);
        List<String> l = new WordBreakII().wordBreak2(str, list);
        for (String s : l) {
            System.out.println(s);
        }
    }

    public List<String> wordBreak2(String s, List<String> str) {
        return dfs(s, str, new HashMap<>());
    }

    private List<String> dfs(String s, List<String> wordDict, HashMap<String, List<String>> map) {
        if (map.containsKey(s))
            return map.get(s);
        List<String> list = new LinkedList<>();
        if (s.length() == 0) {
            list.add("");
            return list;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subList = dfs(s.substring(word.length()), wordDict, map);
                for (String sub : subList)
                    list.add(word + (s.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, list);
        return list;
    }

}

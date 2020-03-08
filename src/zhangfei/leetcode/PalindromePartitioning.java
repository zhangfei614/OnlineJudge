package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayList;

/**
 * Created by Fei Zhang on 2017/9/6.
 * Email:zhangfei614@126.com
 */

public class PalindromePartitioning {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (s == null) return res;
        char[] chars = s.toCharArray();
        return dfs(chars, 0);
    }

    public ArrayList<ArrayList<String>> dfs(char[] arr, int index) {
        if (index >= arr.length) {
            return new ArrayList<ArrayList<String>>();
        }
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        for (int i = index; i < arr.length; i++) {
            if (arr[i] == arr[index] && isPalindrome(arr, index, i)) {
                String pre = String.valueOf(arr, index, i - index + 1);
                ArrayList<ArrayList<String>> list = dfs(arr, i + 1);
                if (list.isEmpty()) {
                    ArrayList<String> strs = new ArrayList<String>();
                    strs.add(0, pre);
                    res.add(strs);
                } else {
                    for (ArrayList<String> strs : list) {
                        strs.add(0, pre);
                        res.add(strs);
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(char[] arr, int i, int j) {
        while (i <= j) {
            if (arr[i++] != arr[j--]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        ArrayList<ArrayList<String>> lists = new PalindromePartitioning().partition(s);
        System.out.println(lists);
    }
}

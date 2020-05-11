package zhangfei.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangfei on 2017/7/19.
 */
public class StringPermutation {

    public ArrayList<String> Permutation(String str) {
        Set<String> result = new HashSet<String>();
        char[] chars = str.toCharArray();
        helper(chars, 0, chars.length - 1, result);
        return new ArrayList<>(result);
    }

    private void helper(char[] chars, int start, int end, Set<String> result) {
        if (start == end) {
            result.add(new String(chars));
        }
        for (int i = start; i <= end; i++) {
            exchange(chars, start, i);
            helper(chars, start + 1, end, result);
            exchange(chars, start, i);
        }
    }

    private void exchange(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

    public static void main(String[] args) {

    }
}

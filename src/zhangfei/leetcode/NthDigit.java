package zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2017/4/24.
 * Email:zhangfei614@126.com
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * <p/>
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 * <p/>
 * Example 1:
 * <p/>
 * Input:
 * 3
 * <p/>
 * Output:
 * 3
 * Example 2:
 * <p/>
 * Input:
 * 11
 * <p/>
 * Output:
 * 0
 * <p/>
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 */

public class NthDigit {
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;
        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        return Character.getNumericValue(Integer.toString(start).charAt((n - 1) % len));
    }
}

package zhangfei.microsoft;


import java.util.*;

//Numbers With Equal Digit Sum
class A {
    private int computeDigitSum(int a) {
        // supposed to be valid for negative numbers and the output must be non-negative integer.
        a = Math.abs(a);
        int res = 0;
        while (a > 0) {
            res += a % 10;
            a /= 10;
        }
        return res;
    }

    public int maxSum(int[] A) {
        int N = A.length;
        if (N <= 1) return -1;
        Map<Integer, Integer> map = new HashMap<>();
        int res = -1;
        for (int i = 0; i < N; ++i) {
            int digitsum = computeDigitSum(A[i]);
            if (!map.containsKey(digitsum)) {
                map.put(digitsum, A[i]);
            } else {
                res = Math.max(res, map.get(digitsum) + A[i]);
                map.put(digitsum, Math.max(A[i], map.get(digitsum)));
            }
        }
        return res;
    }
}

/**
 * Numbers With Equal Digit Sum
 * map求解，直接找到
 * Min Moves to Make String Without 3 Identical Consecutive Letters
 * 递归求解，转换成5的字符串，然后递归求解
 * Max Network Rank
 * Min Swaps to Make Palindrome
 * Longest Substring Without 2 Contiguous Occurrences of Letter
 * Lexicographically Smallest String
 * Min Deletions to Make Frequency of Each Letter Unique
 * String Without 3 Identical Consecutive Letters
 * Longest Semi-Alternating Substring
 * Min Steps to Make Piles Equal Height
 * Day of Week
 * Max Possible Value
 * Max Inserts to Obtain String Without 3 Consecutive 'a'
 * Concatenated String Length with unique Characters
 * Largest K such that both K and -K exist in array
 * Min Swaps to Group Red Balls
 * Max Length of a Concatenated String with Unique Characters
 * Unique Integers That Sum Up To 0
 * Min Deletions To Obtain String in Right Format
 * Particle Velocity
 * Partition array into N subsets with balanced sum
 * Widest Path Without Trees [Experienced]
 * Jump Game [Experienced]
 * Fair Indexes
 * Meeting Rooms II
 * Light Bulb Switcher
 * Plane Seat Reservation
 * Crop Words
 *
 * Max Chunks to Sort Array
 * Largest number X which occurs X times
 * Largest M-aligned Subset
 * Min Cost to Get String Without 2 Identical Consecutive Letters
 * Count Visible Nodes in Binary Tree 🆕
 * Largest Alphabetic Character 🆕
 */
public class main {
}

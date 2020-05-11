package zhangfei.leetcode;

import java.util.Arrays;

/**
 * Created by zhangfei614 on 2017/5/26.
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * <p/>
 * You need to find the shortest such subarray and output its length.
 * <p/>
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * 思路1:现将数组进行排序，然后左右扫描，找到不同的数字为止。
 * 思路2：O(n)的复杂度用于维护beg 和 end维护
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        int left, right;
        for (left = 0; left < arr.length && arr[left] == nums[left]; left++) ;
        for (right = arr.length - 1; right >= 0 && arr[right] == nums[right]; right--) ;
        if (left <= right) return right - left + 1;
        else return 0;
    }

    public int findUnsortedSubarry2(int[] nums) {
        int n = nums.length, begin = -1, end = -2, max = nums[0], min = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                end = i;
            }

            if (nums[n - i - 1] <= min) {
                min = nums[n - i - 1];
            } else {
                begin = n - i - 1;
            }
        }
        return end - begin + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 4, 8, 10, 9, 15};
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarry2(arr));
    }
}

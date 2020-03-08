package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2017/3/7.
 * Email:zhangfei614@126.com
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */

public class FindPeakElement {
    /**
     * 找到第一个比两边都打的元素
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int index = 0;
        for (int i = 1; i < nums.length && nums[i] > nums[i - 1]; i++)
            index = i;
        return index;
    }

    /**
     * 1.取中间元素，如果中间元素最大，则是峰值。
     * 2.如果左边元素大，则左边的区域必然有峰值。
     * 3.如果右边元素大，则右边的区域必然有峰值。
     *
     * @param nums
     * @return
     */
    public int findPeakElement2(int[] nums) {
        if (nums.length == 1) return 0;
        int start = 0, end = nums.length - 1, mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if ((mid == 0 || nums[mid] >= nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] >= nums[mid + 1])) {
                return mid;
            } else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(new FindPeakElement().findPeakElement2(arr));
    }
}

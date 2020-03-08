package tsinghua.cs.zhangfei.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangfei614 on 2017/3/30.
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 */
public class FindAllDuplicates {
    //使用1 ≤ a[i] ≤ n (n = size of array)条件.
    // when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that occurs twice.
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) list.add(Math.abs(nums[i]));
            nums[index] = -nums[index];
        }
        return list;
    }
}

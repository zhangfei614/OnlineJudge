package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/3/30.
 * Email:zhangfei614@126.com
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 ) return 0;
        int rlength = 1;
        int i = 1;
        while(i<nums.length){
            if(nums[i]==nums[rlength-1]){
                i++;
                continue;
            }else{
                nums[rlength++]=nums[i];
            }
        }
        return rlength;
    }

}

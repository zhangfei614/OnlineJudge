package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/3/30.
 * Email:zhangfei614@126.com
 Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 思路：利用一个flag标识是否已经是两个数了。
 */

public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int rlength = 1;
        boolean flag = false;
        int i =1;
        while(i<nums.length){
            if(nums[i] == nums[rlength-1]){
                if(flag==false){
                    nums[rlength++]=nums[i];
                    flag = true;
                }
                i++;
                continue;
            }else{
                nums[rlength++]=nums[i++];
                flag = false;
            }
        }
        return rlength;
    }
}

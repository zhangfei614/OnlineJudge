package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/3/31.
 * Email:zhangfei614@126.com
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 思路：遍历数组，找到转折点。
 */

public class FindMinimumRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i] > nums[(i+1)%nums.length])
                return nums[(i+1)%nums.length];
        }
        return 0;
    }

    public int findMin2(int[] nums){
        int l,h,m;
        l = 0;
        h = nums.length - 1;
        while(l < h){
            m = l +(h-l)/2;
            if(nums[m] > nums[h]) l = m+1;
            else h = m;
        }
        return nums[h];
    }

    public static void main(String[] args){
        int[] array = {3,1,2};
        System.out.println(new FindMinimumRotatedSortedArray().findMin2(array));
    }
}

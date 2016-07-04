package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/6/29.
 * Email:zhangfei614@126.com
 * 思路：采用分治的策略是Ｏ(nlgn)的
 * 采用动态规划:
 * sum(0..i) = a[i] + (sum(0,i-1) < 0 ? 0: sum(0,i-1))
 */

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return maxSubArray(nums,0,nums.length-1);
    }
    public int maxSubArray(int[] nums,int left,int right){
        if(left == right ) return nums[left];
        int mid = (left+right)/2;
        int lmax = Integer.MIN_VALUE;
        int rmax = Integer.MIN_VALUE;
        int lsum = 0;
        int rsum = 0;
        for(int i = mid; i >= left; i--){
            lsum+=nums[i];
            if(lsum > lmax) lmax = lsum;
        }
        for(int i = mid+1; i <= right; i++){
            rsum+=nums[i];
            if(rsum > rmax) rmax = rsum;
        }
        return Math.max(maxSubArray(nums,left,mid),Math.max(maxSubArray(nums,mid+1,right),lmax+rmax));
    }
    public int maxSubArray_Simple(int[] nums){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = nums[i] + (sum < 0 ? 0 : sum);
            max = sum > max ? sum : max;
        }
        return max;
    }
}

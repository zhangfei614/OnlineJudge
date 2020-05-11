package zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/7/5.
 * Email:zhangfei614@126.com
 * 只需要记录前面的最小值和最大值，如果为负，则取最小值时为最大，如果为正，则取最大值时为最大。
 *
 */

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int maxPre = nums[0], minPre = nums[0],maxSofar = nums[0];
        int maxHere,minHere;
        for(int i = 1; i < nums.length; i++){
            maxHere = Math.max(Math.max(maxPre*nums[i],minPre*nums[i]),nums[i]);
            minHere = Math.min(Math.min(maxPre*nums[i],minPre*nums[i]),nums[i]);
            maxSofar = Math.max(maxHere,maxSofar);
            maxPre = maxHere;
            minPre = minHere;
        }
        return maxSofar;
    }

    public static void main(String[] args){
        int[] arr = {-2};
        System.out.println(new MaximumProductSubarray().maxProduct(arr));
    }
}

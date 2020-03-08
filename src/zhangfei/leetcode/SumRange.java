package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/4/7.
 * Email:zhangfei614@126.com
 */

public class SumRange {
    private int[] sum;
    public SumRange(int[] nums) {
        sum = new int[nums.length];
        if(nums.length > 0){
            sum[0] = nums[0];
            for(int i = 1; i < nums.length; i++){
                sum[i] = nums[i]+sum[i-1];
            }
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0) return sum[j];
        else return sum[j]-sum[i-1];
    }
}

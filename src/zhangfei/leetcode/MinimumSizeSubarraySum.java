package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/3/31.
 * Email:zhangfei614@126.com
 Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.
 思路：不断求子序列的和，然后判断序列差
 */

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int i,j,sum,min;
        i = j = sum = 0;
        min = nums.length + 1;
        while(!(i==j && j== nums.length)){
            while (sum < s && j<nums.length) sum+=nums[j++];
            if(sum >= s){
                if(min > j-i) min = j-i;
            }
            sum -= nums[i++];
        }
        if(min != nums.length + 1) return min;
        else return 0;
    }

    public static void main(String[] args){
        int[] array = {1,2,3,4,5};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(11,array));
    }
}

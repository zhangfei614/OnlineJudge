package tsinghua.cs.zhangfei.leetcode;

import java.util.Arrays;

/**
 * Created by Fei Zhang on 2016/5/16.
 * Email:zhangfei614@126.com
 */

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums.length == 0) return ;
        k = k % nums.length;
        int[] temp = Arrays.copyOfRange(nums,nums.length-k,nums.length);
        for(int i = nums.length-k-1; i >=0 ; i--) nums[i+k] = nums[i];
        for(int i = 0; i < k; i++) nums[i] = temp[i];
    }

    public void rotate_reverse(int[] nums,int k){
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    private void reverse(int[] nums,int l,int r){
        while(l < r){
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        new RotateArray().rotate(nums,3);
    }


}

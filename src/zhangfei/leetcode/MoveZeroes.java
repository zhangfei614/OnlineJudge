package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by THU on 2015/9/21.
 */
public class MoveZeroes {
    public static  void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i < n){
            if(nums[i] == 0){
                for(int j=i ; j<n ; j++){
                    if(nums[j] != 0){
                        nums[i]=nums[j];
                        nums[j]=0;
                        break;
                    }
                }
            }
            i++;
        }
    }
    public static void main(String[] args){
        int[] nums = {0,1,2,3};
        moveZeroes(nums);
        for(int i:nums){
            System.out.println(i);
        }
    }

}

package zhangfei.leetcode;

/**
 * Created by zhangfei on 2016/5/17.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length;i++) sum^=nums[i];
        if(nums.length > 2 && nums.length % 2 == 1) return 0 ^ sum;
        else return sum ^ (nums.length | (nums.length-1));
    }

    public static void main(String[] args){
        int[] test = {0,3,5,8,4,6,1,9,7};
        System.out.println(new MissingNumber().missingNumber(test));
    }
}

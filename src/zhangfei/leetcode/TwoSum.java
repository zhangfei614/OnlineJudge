package zhangfei.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by THU on 2015/10/21.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        for(int i=0;i<nums.length;i++){
            int flag = 0;
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    output[0]=i+1;
                    output[1]=j+1;
                    flag = 1;
                    break;
                }
            }
            if(flag == 1)
                break;
        }
        return output;
    }

    public int[] twoSum2(int[] nums,int target){
        int[] output = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target - nums[i])){
                output[1] = i+1;
                output[0] = map.get(target-nums[i]);
                return output;
            }
            map.put(nums[i],i+1);
        }
        return null;
    }
}

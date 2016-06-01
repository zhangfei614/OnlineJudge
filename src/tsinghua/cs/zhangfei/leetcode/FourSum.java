package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Fei Zhang on 2016/5/29.
 * Email:zhangfei614@126.com
 */

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-3; i++){
            if(nums[i] > (target/4)) break;
            if (i != 0 && nums[i]==nums[i-1]) continue;
            int threeSum = target-nums[i];
            for(int j = i+1; j < nums.length-2; j++){
                if(nums[j] > (threeSum/3)) break;
                if (j != i+1 && nums[j]==nums[j-1]) continue;

                int low = j+1, high = nums.length-1,twoSum = threeSum-nums[j];
                while(low < high){
                    if(nums[low]>(twoSum/2) || nums[high]<(twoSum/2)) break;
                    if(nums[low]+nums[high] == twoSum){
                        res.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                        while(++low < high && nums[low]==nums[low-1]);
                        while(low < --high && nums[high] == nums[high+1]);
                    }else if(nums[low]+nums[high] < twoSum){
                        while(++low < high && nums[low]==nums[low-1]);
                    }else {
                        while(low < --high && nums[high] == nums[high+1]);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] array = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = new FourSum().fourSum(array,-1);
        for(List<Integer> list: res){
            for(Integer integer : list) System.out.print(" "+integer);
            System.out.println();
        }
    }
}

package zhangfei.leetcode;

import java.util.*;

/**
 * Created by Fei Zhang on 2016/5/27.
 * Email:zhangfei614@126.com
 */

public class ThreeSum {
    public List<List<Integer>> threeSumLoop(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length <3) return res;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length; ){
            //如果最小数已经大于0，则不需要向后循环。
            if(nums[i]>0) return res;
            for(int j = i+1; j < nums.length; ){
                for(int k = j+1; k < nums.length;){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    }
                    k++;
                    while(k < nums.length && nums[k]==nums[k-1]) k++;
                }
                j++;
                while(j < nums.length && nums[j]==nums[j-1]) j++;
            }
            i++;
            while(i < nums.length && nums[i] == nums[i-1]) i++;
        }
        return res;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length <3) return res;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length;i++){
            if(nums[i] > 0) return res;
            //这种方法只需要O(n^2)的方法，后面的部分只需要扫描一遍。
            if(i == 0 || nums[i] != nums[i-1]){
                int low = i+1, high = nums.length-1,target = -nums[i];
                while(low < high){
                    if(nums[high] < 0 || nums[low] > target) break;
                    if(nums[low] + nums[high] == target){
                        res.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while(++low<high && nums[low] == nums[low-1]);
                        while(low<--high && nums[high] == nums[high+1]);
                    }else if(nums[low] + nums[high] < target){
                        while(++low<high && nums[low] == nums[low-1]);
                    }else{
                        while(low<--high && nums[high] == nums[high+1]);
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] array = {2,5,-12,4,-11,11,2,7,2,-5,-14,-3,-3,3,2,-10,9,-15,2,14,-3,-15,-3,-14,-1,-7,11,-4,-11,12,-15,-14,2,10,-2,-1,6,7,13,-15,-13,6,-10,-9,-14,7,-12,3,-1,5,2,11,6,14,12,-10,14,0,-7,11,-10,-7,4,-1,-12,-13,13,1,9,3,1,3,-5,6,9,-4,-2,5,14,12,-5,-6,1,8,-15,-10,5,-15,-2,5,3,3,13,-8,-13,8,-5,8,-6,11,-12,3,0,-2,-6,-14,2,0,6,1,-11,9,2,-3,-6,3,3,-15,-5,-14,5,13,-4,-4,-10,-10,11};
        long current = System.currentTimeMillis();
        List<List<Integer>> res = new ThreeSum().threeSum(array);
        System.out.println((System.currentTimeMillis()-current)+"ms");
        for(List<Integer> list : res){
            for(Integer integer : list)
                System.out.print(integer+" ");
            System.out.println();
        }
    }
}

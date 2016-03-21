package tsinghua.cs.zhangfei.leetcode;

import java.util.Arrays;
import java.util.HashSet;


public class ContainsDuplicate {
    public static void main(String[] args){

    }

    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 0) return  false;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]) return true;
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {     //O(n)级别
        HashSet<Integer> set = new HashSet<Integer>();
        for( int i : nums){
            set.add(i);
        }
        return set.size() < nums.length ? true : false;
    }

//    public boolean containsDuplicate3(int[] nums) {
//
//        return nums.length != Arrays.stream(nums)
//                .distinct()
//                .count();
//    }
}

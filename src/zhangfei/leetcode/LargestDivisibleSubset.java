package zhangfei.leetcode;

import java.util.*;

/**
 * Created by Fei Zhang on 2016/6/28.
 * Email:zhangfei614@126.com
 * 先找出最大的值，然后再推回去。
 */

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return res;

        int max = 0;
        int[] len = new int[nums.length];
        int[] parent = new int[nums.length];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            len[i] = 1;
            parent[i] = i;
            for(int j = i-1; j >= 0 ;j--){
                if(nums[i] % nums[j] == 0){
                    len[i] += len[j];
                    parent[i] = j;
                    break;
                }
            }
            if(len[i] > len[max]) max = i;
        }
        while(parent[max] != max){
            res.add(0,nums[max]);
            max = parent[max];
        }
        res.add(0,nums[max]);
        return res;
    }

    public static void main(String[] args) {
        int[] t = {1,2,3,4,6,24};
        List<Integer> res = new LargestDivisibleSubset().largestDivisibleSubset(t);
        for (Integer i : res)
            System.out.println(i);
    }
}

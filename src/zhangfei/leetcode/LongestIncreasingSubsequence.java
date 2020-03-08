package tsinghua.cs.zhangfei.leetcode;

import java.util.Arrays;

/**
 * Created by Fei Zhang on 2016/6/30.
 * Email:zhangfei614@126.com
 * 思路1：统计第i个数组前面所有比其小的数字个数
 * 思路2：对每一个不同长度的字串维护最大数，
 * 例如：2 4 9 3 7
 * 2 4 9
 * 如果num[i] > num[len] 则说明可以继续追加到字串后面，所以可以使arr[++len] = num[i]
 * 否则，就要更新前面对应的字串的最大数。
 */

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] arr = new int[nums.length];
        int max = 1;

        Arrays.fill(arr,1);
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i])
                    arr[i] = Math.max(arr[i],arr[j]+1);
            }
            max = Math.max(arr[i],max);
        }
        return max;
    }

    public int lengthOfLIS_Simple(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int[] maxNums = new int[nums.length];
        maxNums[0] = nums[0];
        int len = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > maxNums[len]){
                maxNums[++len] = nums[i];
            }else{
                maxNums[search(maxNums,len,nums[i])]=nums[i];
            }
        }
        return len+1;
    }

    public int search(int[] arr,int len,int key){
        int low = 0, high = len;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == key) return mid;
            else if(arr[mid] < key) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
}

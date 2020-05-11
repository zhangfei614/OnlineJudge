package zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/7/7.
 * Email:zhangfei614@126.com
 */

public class CreateMaximumNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] max = new int[k];
        for(int i = Math.max(0,k - m); i <= k && i <= n; i++){
            int[] number = merge(maxNumber(nums1,i),maxNumber(nums2,k-i));
            if(greater(number,0,max,0)) max = number;
        }
        return max;
    }

    private int[] merge(int[] a,int[] b){
        int[] ans = new int[a.length + b.length];
        for(int i = 0,j = 0, r = 0; r < a.length + b.length; r++){
            ans[r] = greater(a,i,b,j) ? a[i++] : b[j++];
        }
        return ans;
    }
    private boolean greater(int[] a,int i,int[] b,int j){
        while(i < a.length && j < b.length && a[i] == b[j]){
            i++;
            j++;
        }
        return  j == b.length || (i < a.length && a[i] > b[j] );
    }
    private int[] maxNumber(int[] nums,int k){
        int[] ans = new int[k];
        int n = nums.length;
        for(int i = 0,j = 0; i < n; i++){
            while(n - i + j > k && j > 0 && ans[j-1] < nums[i]) j--;
            if(j < k) ans[j++] = nums[i];
        }
        return ans;
    }

    public static void main(String args[]){
        int[] test1 = {6,7};
        int[] test2 = {6,0,4};
        CreateMaximumNumber c = new CreateMaximumNumber();
        c.maxNumber(test1,test2,5);
    }
}

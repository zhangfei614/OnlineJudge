package tsinghua.cs.zhangfei.leetcode;

import tsinghua.cs.zhangfei.OJTools;

import java.util.Scanner;

/**
 * Created by Fei Zhang on 2017/5/31.
 * Email:zhangfei614@126.com
 */

public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int n = nums.length, max = Integer.MIN_VALUE;
        for (int k = 0; k < n; k++) {
            int count = 1, t = nums[k];
            while (t != k) {
                count++;
                t = nums[t];
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = OJTools.testFileScanner();
        String[] test = scanner.nextLine().split(",");
        int[] arr = new int[test.length];
        for(int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(test[i].trim());
        System.out.println(new ArrayNesting().arrayNesting(arr));
    }
}

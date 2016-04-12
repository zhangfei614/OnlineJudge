package tsinghua.cs.zhangfei.leetcode;

import java.util.List;

/**
 * Created by Fei Zhang on 2016/4/7.
 * Email:zhangfei614@126.com
 Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 思路：利用0（n）的空间存储每一行的最优解，然后递归求取。
 */

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int[] result = new int[triangle.size()];
        result[0] = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size();i++)
            for(int j = triangle.get(i).size()-1; j >= 0; j--){
                int temp = triangle.get(i).get(j);
                if(j == 0){
                    result[j] = temp + result[0];
                }else if(j == triangle.get(i).size() -1){
                    result[j] = temp + result[j-1];
                }else{
                    result[j] = Math.min(temp + result[j-1],temp+result[j]);
                }
            }
        for(int i = 1; i < result.length; i++)
            result[0] = result[0] < result[i] ? result[0] : result[i];
        return result[0];
    }
}

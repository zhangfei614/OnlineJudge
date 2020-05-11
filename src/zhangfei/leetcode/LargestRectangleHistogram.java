package zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/5/30.
 * Email:zhangfei614@126.com
 */

public class LargestRectangleHistogram {
    public int largestRectangleAreaSimple(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        if(heights.length == 1) return heights[0];
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            int left = i,right = i;
            while(left >= 0 && heights[left]>=heights[i]) left--;
            while(right < heights.length && heights[right]>=heights[i]) right++;
            int area = (right-left-1)*heights[i];
            if(area > max) max = area;
        }
        return max;
    }
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        if(heights.length == 1) return heights[0];
        int res = Integer.MIN_VALUE;
        for(int k = 2; k <= heights.length; k++){
            int max = 0;
            for(int i = 0; i <=heights.length-k; i++){
                heights[i] = Math.min(heights[i],heights[i+1]);
                if(heights[i]>max) max = heights[i];
            }
            if(max*k > res) res = max*k;
        }
        return res;
    }
}

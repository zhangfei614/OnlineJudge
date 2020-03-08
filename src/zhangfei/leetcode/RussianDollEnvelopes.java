package tsinghua.cs.zhangfei.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Fei Zhang on 2016/6/30.
 * Email:zhangfei614@126.com
 * 和最长递增子序列使用的是一个解法
 */

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int max = 0;
        int[] dp = new int[envelopes.length];
        for(int i = 0; i < envelopes.length;i++){
            dp[i] = 1;
            for(int j = 0; j < i ;j ++){
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    /**
     *
     * @param envelopes
     * @return
     * 思路：对于width进行升序排列，而对相同的width进行降序排列。
     * - Since the width is increasing, we only need to consider height.
     * - [3, 4] cannot contains [3, 3], so we need to put [3, 4] before [3, 3] when sorting otherwise it will be counted as an increasing number if the order is [3, 3], [3, 4]
     */
    public int maxEnvelopesSimple(int[][] envelopes){
        if(envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o2[1]-o1[1];
                else
                    return o1[0]-o2[0];
            }
        });
        int dp[] = new int[envelopes.length];
        int len = 0;
        for(int[] envelop:envelopes){
            int index = Arrays.binarySearch(dp,0,len,envelop[1]);
            if(index < 0)
                index = - (index+1);
            dp[index] = envelop[1];
            if(index == len)
                len++;
        }
        return len;
    }
}

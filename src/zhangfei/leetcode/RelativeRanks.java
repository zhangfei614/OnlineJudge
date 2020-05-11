package zhangfei.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Fei Zhang on 2017/9/5.
 * Email:zhangfei614@126.
 */

public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        Integer[] index = new Integer[nums.length];
        for (int i = 0; i < index.length; i++) index[i] = i;
        Arrays.sort(index, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o2] - nums[o1];
            }
        });
        String[] res = new String[nums.length];
        for (int i = 0; i < index.length; i++) {
            if (i == 0)
                res[index[i]] = "Gold Medal";
            else if (i == 1)
                res[index[i]] = "Silver Medal";
            else if (i == 2)
                res[index[i]] = "Bronze Medal";
            else
                res[index[i]] = "" + (i + 1);
        }
        return res;
    }
}

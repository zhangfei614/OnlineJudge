package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by zhangfei614 on 2017/3/30.
 * nums = [1, 2, 3]
 * target = 4
 * <p/>
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * <p/>
 * Note that different sequences are counted as different combinations.
 * <p/>
 * Therefore the output is 7.
 *
 */
public class CombinationSumIV {
    //使用动态规划，对每一个f(n) = f(n-1) + f(n-2) + f(n-3)+...。

    public int combinationSum4(int[] nums, int target) {
        int[] result = new int[target + 1];
        for (int k : nums) {
            if (k <= target) result[k] = 1;
        }
        for (int i = 1; i <= target; i++) {
            for (int k : nums) {
                if (i - k >= 0) result[i] += result[i - k];
            }
        }
        return result[target];
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumIV().combinationSum4(new int[]{1, 2, 3}, 4));
    }
}

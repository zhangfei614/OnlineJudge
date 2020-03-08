package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2017/3/21.
 * Email:zhangfei614@126.com
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p/>
 * The above arrows point to positions where the corresponding bits are different.
 */

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        //取异或值
        int t = x ^ y;
        //统计有多少个1
        int count = 0;
        while (t > 0) {
            if ((t & 1) == 1) count++;
            t >>= 1;
        }
        return count;
    }

    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        System.out.println(new HammingDistance().hammingDistance2(1, 0));
    }
}

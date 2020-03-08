package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/3/30.
 * Email:zhangfei614@126.com
 Given an integer n, return the number of trailing zeroes in n!.

 Note: Your solution should be in logarithmic time complexity.

 思路：因为因子2的数目肯定比因子5的数目多，所以只需要数因子2的数目。
 */

public class FactorialTrailingZeroes {
    int trailingZeroes(int n) {
        int res = 0;
        while(n > 0) res+=n=n/5;
        return res;
    }

    public static void main(String[] args){
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(1808548329));
    }
}

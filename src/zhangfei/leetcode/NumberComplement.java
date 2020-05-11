package zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2017/3/21.
 * Email:zhangfei614@126.com
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 */

public class NumberComplement {
    public int findComplement(int num) {
        int mask = ~0;
        //求mask
        while ((num & mask) > 0) mask <<= 1;
        //return mask和num的异或
        return ~mask & ~num;
    }

    public static void main(String[] args) {
        System.out.println(new NumberComplement().findComplement(5));
    }
}

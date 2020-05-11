package zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2017/4/10.
 * Email:zhangfei614@126.com
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
 */

public class ReverseBits {
    public int reverseBits(int n) {
        int m = 0;
        for (int i = 1; i <= 32; i++) {
            m |= ((n & 1)<<(32-i));
            n >>= 1;
        }
        return m;
    }

    public static void main(String[] args){
        System.out.println(Integer.toBinaryString(43261596 ));
        System.out.println(Integer.toBinaryString(new ReverseBits().reverseBits(43261596)));
    }
}

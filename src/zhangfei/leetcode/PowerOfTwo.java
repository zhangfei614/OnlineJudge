package zhangfei.leetcode;

/**
 * Created by zhangfei on 2016/5/7.
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n < 0) return false;
        int sum = 0;
        for(int i = 0 ; i < 32; i++)
            sum += ((n>>i)&1);
        return sum == 1;
    }

    public boolean isPowerOfTwoBitCount(int n){
        if(n < 0) return false;
        if(Integer.bitCount(n) == 1) return true;
        else return false;
    }

    /**
     * 3: 0011, -4: 1100, -3: 1101
     * 6: 0110, -7: 1001, -6: 1010
     * num & -num: least significant non-zero digit
     */
    public boolean isPowerOfTwoOppositeNumber(int n){
        return n > 0 && n == (n & -n);
    }

    public boolean isPowerOfTwoSub(int n){
        return n > 0 && (n & (n-1)) == 0 ;
    }
}

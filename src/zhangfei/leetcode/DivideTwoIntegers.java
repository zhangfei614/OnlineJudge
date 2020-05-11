package zhangfei.leetcode;

import zhangfei.Main;

/**
 * Created by zhangfei on 2016/5/19.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        if(dividend == 0) return 0;
        boolean negative = dividend > 0 ? (divisor > 0 ? false : true) : (divisor < 0 ? false:true );
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int sum = 0;
        while(divisor <=dividend){
            sum++;
            divisor += divisor;
        }
        if(negative) return -sum;
        else return sum;
    }
}

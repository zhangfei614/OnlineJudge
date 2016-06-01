package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/5/29.
 * Email:zhangfei614@126.com
 */

public class FractionRecurrinDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) return null;
        int a = numerator/denominator;
        int b = numerator%denominator;
        if(b == 0) return ""+a;
        return null;
    }

    public static void main(String[] args){
        System.out.println(new FractionRecurrinDecimal().fractionToDecimal(1,2));
    }
}

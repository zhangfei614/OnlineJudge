package zhangfei.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fei Zhang on 2016/5/29.
 * Email:zhangfei614@126.com
 */

public class FractionRecurrinDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) return null;
        boolean flag = (numerator >= 0 && denominator > 0) || (numerator <= 0 && denominator < 0);

        long n = numerator;
        long d = denominator;
        n = Math.abs(n);
        d = Math.abs(d);

        long a = n / d;
        long b = n % d;
        if(b == 0) return flag ? ""+a : "-"+a;
        StringBuilder sb = new StringBuilder();
        Map<Long,Integer> map = new HashMap<Long, Integer>();
        while(b != 0){
            b = b*10;
            if(map.containsKey(b)){
                sb.insert(map.get(b).intValue(),'(');
                sb.append(')');
                break;
            }
            sb.append(b/d);
            map.put(b, sb.length() - 1);
            b = b % d;
        }
        return flag ? a+"."+sb.toString() : "-"+a+"."+sb.toString();
    }

    public static void main(String[] args){
        System.out.println(new FractionRecurrinDecimal().fractionToDecimal(-1,-2147483648));
    }
}

package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/5/6.
 * Email:zhangfei614@126.com
 Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 */

public class AddBinary {
    /**
     * 利用StringBuilder每一位进行求解
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int add = 0;
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0){
            //原有的值加上一位
            int temp = add + (i < 0 ? 0 : a.charAt(i--)-'0')+(j < 0 ? 0 : b.charAt(j--)-'0');
            //取最后一位
            sb.append(temp & 1);
            //移一位
            add = temp>>1;
        }
        if(add > 0) sb.append(add);
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        System.out.println(new AddBinary().addBinary("10","1"));
    }
}

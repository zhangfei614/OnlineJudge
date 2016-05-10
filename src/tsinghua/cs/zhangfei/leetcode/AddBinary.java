package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/5/6.
 * Email:zhangfei614@126.com
 * 李荣sb来进行
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        int add = 0;
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0){
            int temp = add + (i < 0 ? 0 : a.charAt(i--)-'0')+(j < 0 ? 0 : b.charAt(j--)-'0');
            sb.append(temp & 1);
            add = temp>>1;
        }
        if(add > 0) sb.append(add);
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        System.out.println(new AddBinary().addBinary("10","1"));
    }
}

package tsinghua.cs.zhangfei.niuke;

import java.util.Scanner;

/**
 * Created by zhangfei on 2017/7/27.
 * 给定一个字符串，请你将字符串重新编码，将连续的字符替换成“连续出现的个数+字符”。比如字符串AAAABCCDAA会被编码成4A1B2C1D2A。
 */
public class EncodeString {

    public static String encodeString(String s) {
        if (s == null || s.equals("")) return "";
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            } else {
                sb.append(count).append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count).append(c);
        return sb.toString();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(encodeString(scanner.nextLine()));
        }
    }
}

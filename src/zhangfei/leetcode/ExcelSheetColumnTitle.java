package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by zhangfei614 on 2017/3/30.
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        //26进制的运算
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            //模多少
            stringBuilder.append((char) ('A' + (n - 1) % 26));
            n = (n - 1) / 26;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(28));
    }
}

package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by THU on 2015/10/19.
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("AA"));
    }
    public int titleToNumber(String s) {
        int sum = 0;
        for(int i=s.length();i>=1;i--){
            int weight = 1;
            for(int j=0;j<s.length()-i;j++){
                weight *= 26;
            }
            sum = sum+(weight*(s.charAt(i-1)-'A'+1));
        }
        return sum;
    }
}

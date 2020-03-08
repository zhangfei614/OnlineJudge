package tsinghua.cs.zhangfei.offer;

/**
 * Created by zhangfei614 on 2017/6/11.
 */
public class NumberOf1 {
    public int numberOf1(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        return numberOf1(chars, 0);
    }

    public int numberOf1(char[] chars, int begin) {
        if (begin >= chars.length) return 0;
        int first = chars[begin] - '0';
        if (begin == chars.length - 1) {
            if (first == 0) return 0;
            else return 1;
        }
        int result = 0;
        //第一位为1的所有数字
        if (first > 1) {
            result += (int) Math.pow(10, chars.length - begin - 1);
        } else if (first == 1) {
            result += Integer.valueOf(String.valueOf(chars, begin + 1, chars.length - begin - 1)) + 1;
        }
        //1346~21345中，除了第一位为1的其他为为1的所有数字,固定某一位为1，其他为取值0~9
        result += first * (chars.length - begin - 1) * (int) Math.pow(10, chars.length - begin - 2);
        //递归求解1~1345的个数
        result += numberOf1(chars, begin + 1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1().numberOf1(13));
    }
}

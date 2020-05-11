package zhangfei.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhangfei on 2017/7/19.
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class MinValueOfArray {

    public String PrintMinNumber(int[] numbers) {
        String[] strs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) strs[i] = String.valueOf(numbers[i]);

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.equals(o2)) return 0;
                char[] chars1 = o1.toCharArray();
                char[] chars2 = o2.toCharArray();
                int i = 0, j = 0;
                while (i < chars1.length && j < chars2.length) {
                    if (chars1[i] < chars2[j]) return -1;
                    else if (chars1[i] > chars2[j]) return 1;
                    else {
                        i++;
                        j++;
                    }
                    if (i == chars1.length && j < chars2.length) i = 0;
                    if (j == chars2.length && i < chars1.length) j = 0;
                }
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : strs) sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] test = new int[]{3, 32, 321};
        System.out.println(new MinValueOfArray().PrintMinNumber(test));
    }
}

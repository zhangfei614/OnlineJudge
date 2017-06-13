package tsinghua.cs.zhangfei.offer;

import java.util.Arrays;

/**
 * Created by Fei Zhang on 2017/6/12.
 * Email:zhangfei614@126.com
 * 数组中只出现一次的数
 * 一个整形数组中除了两个数字之外，其它数字都出现了两次，找出这两个值出现一次的数字。
 */

public class FindAppearOneNumbers {
    public int[] findAppearOneNumbers(int[] arr) {
        int data = 0;
        for (int i = 0; i < arr.length; i++) data ^= arr[i];

        int mask = 1;
        while ((data & mask) == 0) mask <<= 1;

        int num1 = 0, num2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & mask) != 0) {
                num1 ^= arr[i];
            } else {
                num2 ^= arr[i];
            }
        }
        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,4,3,6,3,2,5,5};
        System.out.println(Arrays.toString(new FindAppearOneNumbers().findAppearOneNumbers(test)));
    }
}

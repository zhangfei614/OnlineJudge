package tsinghua.cs.zhangfei.algorithms.sort;

import java.util.Random;

/**
 * Created by Fei Zhang on 2017/3/8.
 * Email:zhangfei614@126.com
 */

public class SortUtils {

    private final static int TEST_LENGTH = 10;
    public final static int MAX_VALUE = 100;
    private final static Random random = new Random();

    public static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] randomTest() {
        int[] arr = new int[TEST_LENGTH];
        for (int i = 0; i < TEST_LENGTH; i++) {
            arr[i] = random.nextInt(MAX_VALUE);
        }
        return arr;
    }

    public static String arrToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

package zhangfei.offer;

import zhangfei.OJTools;

import java.util.Arrays;

/**
 * Created by zhangfei614 on 2017/6/3.
 * 输入一个整数数组，将所有的奇数位于前半部分，偶数位于后半部分。
 */
public class PartitionArray {

    public void partitionArray(int[] array) {
        int start = -1;
        for (int i = 1; i < array.length; i++) {
            if ((array[i] & 1) != 0) {
                start++;
                exchange(array, start, i);
            }
        }
        exchange(array, start, 0);
    }

    private void exchange(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 4, 5, 2, 3};
        new PartitionArray().partitionArray(test);
        System.out.println(Arrays.toString(test));
    }
}

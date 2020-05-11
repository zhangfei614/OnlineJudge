package zhangfei.algorithms.sort;

/**
 * Created by Fei Zhang on 2017/3/8.
 * Email:zhangfei614@126.com
 * 思路：
 * 　将第i个元素插入到前面有序元素中合适的位置
 */

public class InsertionSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            //从i-1个开始交换，直至到正确的位置
            for (int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j--)
                SortUtils.exchange(arr, j + 1, j);
        }
    }

    public static void main(String[] args) {
        int[] arr = SortUtils.randomTest();
        System.out.println("Before:" + SortUtils.arrToString(arr));
        InsertionSort.sort(arr);
        System.out.println("After:" + SortUtils.arrToString(arr));
    }
}

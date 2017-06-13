package tsinghua.cs.zhangfei.algorithms.sort;

/**
 * Created by Fei Zhang on 2017/3/8.
 * Email:zhangfei614@126.com
 * 思路：
 * 每次选择最小的元素与第i个元素进行交换
 */

public class SelectionSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            //从第i+1个开始寻找最小值
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            SortUtils.exchange(arr, i, min);
        }
    }

    public static void main(String[] args) {
        int[] arr = SortUtils.randomTest();
        System.out.println("Before:" + SortUtils.arrToString(arr));
        SelectionSort.sort(arr);
        System.out.println("After:" + SortUtils.arrToString(arr));
    }
}

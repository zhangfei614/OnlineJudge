package tsinghua.cs.zhangfei.algorithms.sort;

/**
 * Created by Fei Zhang on 2017/3/9.
 * Email:zhangfei614@126.com
 * 思路：　先将数组的两个子数组进行排序，然后进行归并。采用递归的思想，即不断递归左子数组，使其有序，再递归右子数组。
 */

public class MergeSort {

    public static void sort(int[] arr) {
        //创建一个临时数组
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    public static void sort(int[] arr, int start, int end, int[] temp) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        //左侧数组排序
        sort(arr, start, mid, temp);
        //右侧数组排序
        sort(arr, mid + 1, end, temp);
        //合并
        merge(arr, start, mid, end, temp);
    }

    public static void merge(int[] arr, int start, int mid, int end, int[] temp) {
        int i = start, j = mid + 1, k = start;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= end) temp[k++] = arr[j++];
        //复制回原数组
        for (k = start; k <= end; k++) {
            arr[k] = temp[k];
        }
    }

    public static void downToUpSort(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        //从最低的1开始，依次向上归并，每次步长为上次的2倍
        for (int step = 1; step < n; step += step) {
            for (int low = 0; low < n - step; low += (step * 2))
                merge(arr, low, low + step - 1, Math.min(low + step * 2 - 1, n - 1), temp);
        }
    }

    public static void main(String[] args) {
        int[] arr = SortUtils.randomTest();
        System.out.println("Before:" + SortUtils.arrToString(arr));
        MergeSort.downToUpSort(arr);
        System.out.println("After:" + SortUtils.arrToString(arr));
    }
}

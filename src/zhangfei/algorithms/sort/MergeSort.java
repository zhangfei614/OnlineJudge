package zhangfei.algorithms.sort;

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
        int[] arr = {364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601, 650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575};
        System.out.println("Before:" + SortUtils.arrToString(arr));
        MergeSort.sort(arr);
        System.out.println("After:" + SortUtils.arrToString(arr));
    }
}

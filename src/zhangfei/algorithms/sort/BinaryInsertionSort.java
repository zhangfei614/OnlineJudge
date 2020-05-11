package zhangfei.algorithms.sort;

/**
 * Created by Fei Zhang on 2017/3/9.
 * Email:zhangfei614@126.com
 * 思路：在查找第i个元素在前面有序元素的位置时，采用二分查找的策略。
 */

public class BinaryInsertionSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            //查询需要插入的位置
            int index = binarySearch(arr, 0, i - 1, key);
            //移动数据
            for (int j = i - 1; j >= index; j--) arr[j + 1] = arr[j];
            arr[index] = key;
        }
    }

    private static int binarySearch(int[] arr, int i, int j, int key) {
        int low = i, high = j, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = SortUtils.randomTest();
        System.out.println("Before:" + SortUtils.arrToString(arr));
        BinaryInsertionSort.sort(arr);
        System.out.println("After:" + SortUtils.arrToString(arr));
    }
}

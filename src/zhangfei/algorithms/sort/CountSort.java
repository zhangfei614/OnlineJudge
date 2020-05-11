package zhangfei.algorithms.sort;

/**
 * Created by Fei Zhang on 2017/3/10.
 * Email:zhangfei614@126.com
 * 思路：建立一个排序序列取值范围大小的数组C，然后根据C的下标，统计序列中每个元素出现的次数，然后累加每个元素之前元素的个数到该元素所在C中。最后根据C得到最后的排序序列。
 */

public class CountSort {

    public static void sort(int[] arr, int max) {
        int n = arr.length;
        int[] count = new int[max + 1];
        for (int i = 0; i <= max; i++) count[i] = 0;
        //计数
        for (int i = 0; i < n; i++) count[arr[i]]++;
        //累加
        for (int i = 0; i < max; i++) count[i + 1] += count[i];
        //排序
        int[] temp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            count[arr[i]]--;
            temp[count[arr[i]]] = arr[i];
        }
        //复制回原数组
        System.arraycopy(temp, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = SortUtils.randomTest();
        System.out.println("Before:" + SortUtils.arrToString(arr));
        CountSort.sort(arr, SortUtils.MAX_VALUE);
        System.out.println("After:" + SortUtils.arrToString(arr));
    }
}

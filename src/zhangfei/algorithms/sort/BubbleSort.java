package zhangfei.algorithms.sort;

/**
 * Created by Fei Zhang on 2017/3/9.
 * Email:zhangfei614@126.com
 * 思路：每一次冒泡过程两两比较，如果发生逆序，则进行交换。总共需要n-1次冒泡，地k次冒泡需要比较n-k次。
 */

public class BubbleSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        //冒泡n-1次
        for (int i = 0; i < n - 1; i++) {
            //改进，如果当前次已经没有冒泡，则直接返回
            boolean flag = true;
            //每次冒出一个最大值到最后边
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    //交换相邻位置的
                    SortUtils.exchange(arr, j, j + 1);
                    flag = false;
                }
            if (flag)
                return;
        }
    }

    public static void main(String[] args) {
        int[] arr = SortUtils.randomTest();
        System.out.println("Before:" + SortUtils.arrToString(arr));
        BubbleSort.sort(arr);
        System.out.println("After:" + SortUtils.arrToString(arr));
    }
}

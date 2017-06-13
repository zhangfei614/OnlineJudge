package tsinghua.cs.zhangfei.algorithms.sort;

import java.util.Random;

/**
 * Created by Fei Zhang on 2017/3/9.
 * Email:zhangfei614@126.com
 * 思路：采用分治的策略，选取一个切分元，将数组切分为两个子数组，再分别对这两个子数组进行排序。
 */

public class QuickSort {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int start, int end) {
        if (start >= end) return;
        //划分数组
//        int index = simplePartition(arr, start, end);
//        int index = twoWayPartition(arr, start, end);
        int index = randomPartition(arr, start, end);
        //递归排序
        sort(arr, start, index - 1);
        sort(arr, index + 1, end);
    }

    private static int simplePartition(int[] arr, int start, int end) {
        //默认选取第一个元素为切分元
        int key = arr[start];
        int i = start;
        //j后移
        for (int j = start + 1; j <= end; j++) {
            //遇到小于切分元的key，则交换
            if (arr[j] <= key)
                SortUtils.exchange(arr, ++i, j);
        }
        SortUtils.exchange(arr, i, start);
        return i;
    }

    private static int twoWayPartition(int[] arr, int start, int end) {
        //默认选择第一个元素为切分元
        int key = arr[start];
        int i = start + 1, j = end;
        while (i <= j) {
            //向右寻找大的元素
            while (i <= j && arr[i] <= key) ++i;
            //向左寻找小的元素
            while (i <= j && arr[j] >= key) --j;
            //交换元素
            if (i < j) {
                SortUtils.exchange(arr, i, j);
                ++i;
                --j;
            }
        }
        //将切分元移到中间
        SortUtils.exchange(arr, start, j);
        return j;
    }

    private static int oneWayPartition(int[] arr, int start, int end) {
        int key = arr[start];
        int i = start, j = end;
        while (i < j) {
            //向左寻找最小元素
            while (i < j && arr[j] >= key) j--;
            //覆盖元素
            if (i < j) arr[i++] = arr[j];
            //向右寻找最大元素
            while (i < j && arr[i] <= key) i++;
            //覆盖元素
            if (i < j) arr[j--] = arr[i];
        }
        arr[j] = key;
        return j;
    }

    private static int randomPartition(int[] arr, int start, int end) {
        //选取随机元素索引
        int randomIndex = new Random().nextInt(end - start + 1) + start;
        //交换
        SortUtils.exchange(arr, start, randomIndex);
        return simplePartition(arr, start, end);
    }

    public static void main(String[] args) {
        int[] arr = SortUtils.randomTest();
        System.out.println("Before:" + SortUtils.arrToString(arr));
        QuickSort.sort(arr);
        System.out.println("After:" + SortUtils.arrToString(arr));
    }
}

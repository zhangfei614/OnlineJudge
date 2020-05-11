package zhangfei.algorithms.sort;

/**
 * Created by Fei Zhang on 2017/3/9.
 * Email:zhangfei614@126.com
 * 思路：将待排序元素构造成一个大顶堆，每次将堆顶元素和最后一个元素互换，然后再维护前n-1个元素形成大顶堆。
 */

public class HeapSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        //调整所有非叶子结点，形成最大堆
        for (int i = n / 2 - 1; i >= 0; i--)
            adjustHeap(arr, i, n - 1);
        for (int i = n - 1; i >= 0; i--) {
            //取出堆顶元素到最后
            SortUtils.exchange(arr, 0, i);
            //调整前面的元素仍称为最大堆
            adjustHeap(arr, 0, i - 1);
        }
    }

    private static void adjustHeap(int[] arr, int start, int end) {
        int dad = start;
        int son = dad * 2 + 1;
        while (son <= end) {
            //选中son中较大的结点
            if (son < end && arr[son] < arr[son + 1]) ++son;
            if (arr[dad] < arr[son]) {
                //dad小于son则调整
                SortUtils.exchange(arr, dad, son);
                dad = son;
                son = dad * 2 + 1;
            } else {
                //如果不需要调整，则直接退出
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = SortUtils.randomTest();
        System.out.println("Before:" + SortUtils.arrToString(arr));
        HeapSort.sort(arr);
        System.out.println("After:" + SortUtils.arrToString(arr));
    }
}

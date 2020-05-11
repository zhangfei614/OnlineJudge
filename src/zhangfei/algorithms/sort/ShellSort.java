package zhangfei.algorithms.sort;

/**
 * Created by Fei Zhang on 2017/3/9.
 * Email:zhangfei614@126.com
 * 思路：选取一个序列作为步长，然后通过大步长排序将元素移动到较远的地方（原始插入排序为一步步移动），
 * 从而使数组局部有序，最终再利用插入排序进行全局排序。
 */

public class ShellSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        int step = n / 2;
        //不断缩小step直至为1
        while (step >= 1) {
            //对每一组进行排序，一共step组
            for (int i = 0; i < step; i++) {
                //对每一组从第二个开始插入排序
                for (int j = i + step; j < n; j += step) {
                    //一直交换到合适的位置
                    for (int k = j - step; k >= 0 && arr[k + step] < arr[k]; k -= step)
                        SortUtils.exchange(arr, k + step, k);
                }
            }
            step = step / 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = SortUtils.randomTest();
        System.out.println("Before:" + SortUtils.arrToString(arr));
        ShellSort.sort(arr);
        System.out.println("After:" + SortUtils.arrToString(arr));
    }
}

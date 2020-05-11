package zhangfei.offer;

/**
 * Created by zhangfei on 2017/7/25.
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class InversePairs {

    private int count;

    public int InversePairs(int[] array) {
        count = 0;
        int[] temp = new int[array.length];
        sort(array, 0, array.length - 1, temp);
        return count;
    }

    private void sort(int[] arr, int start, int end, int[] temp) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        sort(arr, start, mid, temp);
        sort(arr, mid + 1, end, temp);
        merge(arr, start, mid, end, temp);
    }

    private void merge(int[] arr, int start, int mid, int end, int[] temp) {
        int i = mid, j = end, k = end;
        while (i >= start && j > mid) {
            if (arr[i] > arr[j]) {
                //产生逆序对
                count += (j - mid);
                if (count > 1000000007) count = count % 1000000007;
                temp[k--] = arr[i--];
            } else {
                temp[k--] = arr[j--];
            }
        }
        while (i >= start) temp[k--] = arr[i--];
        while (j > mid) temp[k--] = arr[j--];
        //复制回原数组
        for (i = start; i <= end; i++)
            arr[i] = temp[i];
    }


    public static void main(String[] args) {
        int[] test = {364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601, 650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575};
        System.out.println(new InversePairs().InversePairs(test));
    }
}

package test;

/**
 * Created by zhangfei614 on 2017/4/26.
 */
public class Main3 {

    public static void main(String[] args) {
        int[] test = new int[]{3,2,1,9};
        new Main3().quickSort(test,0,test.length-1);
    }

    private void quickSort(int[] a, int s, int e) {
        if (s >= e) return;
        int mid = partition(a, s, e);
        quickSort(a, s, mid - 1);
        quickSort(a, mid + 1, e);
    }

    private int partition(int[] a, int s, int e) {
        int key = a[s];
        int i = s;
        for (int j = i + 1; j <= e; j++) {
            if (a[j] <= key) {
                i++;
                exchange(a, j, i);
            }
        }
        exchange(a, i, s);
        return i;
    }

    private static void exchange(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

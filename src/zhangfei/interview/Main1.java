package zhangfei.interview;

import java.util.Scanner;

/**
 * Created by zhangfei614 on 2017/8/12.
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int[] res = revert(arr);
        System.out.print(res[0]);
        for (int i = 1; i < n; i++)
            System.out.print(" " + res[i]);
    }

    private static int[] revert(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int i = 0, j = n - 1, k = n - 1;
        boolean flag = true;
        while (k >= 0) {
            if (flag) {
                res[i++] = arr[k--];
            } else {
                res[j--] = arr[k--];
            }
            flag = !flag;
        }
        return res;
    }
}

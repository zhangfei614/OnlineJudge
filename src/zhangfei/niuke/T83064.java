package zhangfei.niuke;

import java.util.Scanner;

/**
 * Created by zhangfei on 2017/8/11.
 */
public class T83064 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < k; i++) {
            int t = arr[0];
            for (int j = 0; j < n - 1; j++) {
                arr[j] = (arr[j] + arr[j + 1]) % 100;
            }
            arr[n - 1] = (arr[n - 1] + t) % 100;
        }
        System.out.print(arr[0]);
        for (int i = 1; i < n; i++)
            System.out.print(" " + arr[i]);
    }
}

package tsinghua.cs.zhangfei.niuke;

import java.util.Scanner;

/**
 * Created by zhangfei on 2017/8/11.
 */
public class T83062 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(Math.min(boyFirst(s.toCharArray()), girlFirst(s.toCharArray())));
    }


    private static int boyFirst(char[] arr) {
        int n = arr.length;
        int count = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (arr[j] == 'G' && arr[j + 1] == 'B') {
                    exchange(arr, j, j + 1);
                    count++;
                }
            }
        }
        return count;
    }

    private static int girlFirst(char[] arr) {
        int n = arr.length;
        int count = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (arr[j] == 'B' && arr[j + 1] == 'G') {
                    exchange(arr, j, j + 1);
                    count++;
                }
            }
        }
        return count;
    }

    private static void exchange(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

package zhangfei.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhangfei614 on 2017/8/12.
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        Arrays.sort(arr);
    }


}

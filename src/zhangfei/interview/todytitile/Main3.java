package tsinghua.cs.zhangfei.interview.todytitile;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int max = 0;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                int t = arr[i];
                int l = i, r = i;
                int sum = 0;
                while (l >= 0 && arr[l] >= t)
                    sum += arr[l--];
                while (r < n && arr[r] >= t)
                    sum += arr[r++];
                sum -= t;
                if ((sum * t) > max)
                    max = sum * t;

            }
            System.out.println(max);
        }
    }
}

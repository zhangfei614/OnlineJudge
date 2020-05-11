package zhangfei.interview.netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhangfei614 on 2017/8/26.
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.valueOf(scanner.nextLine());
            int m = Integer.valueOf(scanner.nextLine());
            int dr[] = new int[n];
            int he[] = new int[m];
            for (int i = 0; i < n; i++)
                dr[i] = scanner.nextInt();
            for (int i = 0; i < m; i++)
                he[i] = scanner.nextInt();
            System.out.println(sum(dr, n, he, m));
        }
    }

    public static int sum(int[] dr, int n, int[] he, int m) {
        Arrays.sort(dr);
        Arrays.sort(he);
        int sum = 0, j = 0;
        for (int i = 0; i < n; i++) {
            while (j < m && he[j] < dr[i]) j++;
            if (j == m) return -1;
            else sum += he[j];
        }
        return sum;
    }
}

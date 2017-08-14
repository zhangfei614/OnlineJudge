package tsinghua.cs.zhangfei.niuke;

import java.util.Scanner;

/**
 * Created by zhangfei on 2017/7/27.
 */
public class MatrixMaxSum {

    public static int findMax(int[][] matrix, int s) {
        int m = matrix.length, n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        //横向
        for (int i = 0; i < m; i++)
            for (int j = 0; j <= n - s; j++) {
                sum = 0;
                for (int k = 0; k < s; k++)
                    sum += matrix[i][j + k];
                if (sum > max) max = sum;
            }
        //纵向
        for (int i = 0; i <= m - s; i++)
            for (int j = 0; j < n; j++) {
                sum = 0;
                for (int k = 0; k < s; k++)
                    sum += matrix[i + k][j];
                if (sum > max) max = sum;
            }
        //右斜下
        for (int i = 0; i <= m - s; i++)
            for (int j = 0; j <= n - s; j++) {
                sum = 0;
                for (int k = 0; k < s; k++)
                    sum += matrix[i + k][j + k];
                if (sum > max) max = sum;
            }
        //左斜下
        for (int i = 0; i <= m - s; i++)
            for (int j = n - 1; j >= s - 1; j--) {
                sum = 0;
                for (int k = 0; k < s; k++)
                    sum += matrix[i + k][j - k];
                if (sum > max) max = sum;
            }
        return max;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = scanner.nextInt();
        System.out.println(findMax(matrix, s));
    }
}

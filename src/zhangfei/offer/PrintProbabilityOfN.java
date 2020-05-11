package zhangfei.offer;

/**
 * Created by Fei Zhang on 2017/6/12.
 * Email:zhangfei614@126.com
 */

public class PrintProbabilityOfN {
    private static final int MAX_VALUE = 6;

    public void printProbability(int n) {
        if (n <= 0) return;
        int[][] count = new int[2][n * MAX_VALUE + 1];
        int flag = 0;
        for (int i = 1; i <= MAX_VALUE; i++) count[flag][i] = 1;
        for (int i = 2; i <= n; i++) {
            //小于i的都为0
            for (int j = 0; j < i; j++) count[1 - flag][j] = 0;
            for (int j = i; j <= i * MAX_VALUE; j++) {
                for (int k = 1; k <= j && k <= MAX_VALUE; k++)
                    count[1 - flag][j] += count[flag][j - k];
            }
            flag = 1 - flag;
        }
        double total = Math.pow(MAX_VALUE, n);
        for (int i = n; i <= n * MAX_VALUE; i++) {
            System.out.printf("%d : % .6f\n", i, count[flag][i] / total);
        }
    }

    public static void main(String[] args) {
        new PrintProbabilityOfN().printProbability(7);
    }
}

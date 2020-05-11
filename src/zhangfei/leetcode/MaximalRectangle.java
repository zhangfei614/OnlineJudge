package zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/5/30.
 * Email:zhangfei614@126.com
 */

public class MaximalRectangle {

    public int maximalRectangleOptimal(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int N, M;
        if (matrix[0].length < matrix.length) {
            N = matrix[0].length;
            M = matrix.length;
        } else {
            N = matrix.length;
            M = matrix[0].length;
        }
        int[][] table = new int[N][N];
        int max = 0;
        for (int i = 0; i < M; i++) {
            //先填入第一行
            for (int j = 0; j < N; j++) {
                if (matrix[0].length < matrix.length && matrix[i][j] == '1') {
                    table[j][j] = table[j][j]+1;
                } else if(matrix[0].length >= matrix.length && matrix[j][i] == '1'){
                    table[j][j] = table[j][j]+1;
                } else table[j][j] = 0;
                if (table[j][j] > max) max = table[j][j];
            }

            //然后填入剩下的上三角区域
            for (int k = 2; k <= N; k++)
                for (int m = 0; m <= N - k; m++) {
                    int n = m + k - 1;
                    if (table[m][n - 1] != 0 && table[m + 1][n] != 0) {
                        table[m][n] += k;
                        if (table[m][n] > max) max = table[m][n];
                    } else {
                        table[m][n] = 0;
                    }
                }
        }
        return max;
    }

    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int N = matrix[0].length;
        int[][] table = new int[N][N];
        int max =0;
        for(int i = 0; i < matrix.length; i++){
            //先填入第一行
            for(int j = 0; j < N ; j++){
                if(matrix[i][j]=='1') {
                    table[j][j]=table[j][j]+1;
                    if(table[j][j] > max) max = table[j][j];
                }
                else table[j][j]=0;
            }
            //然后填入剩下的上三角区域
            for(int k = 2; k <= N; k++ )
                for(int m = 0; m <= N - k; m++){
                    int n = m+k-1;
                    if(table[m][n-1] != 0 && table[m+1][n] != 0){
                        table[m][n] +=k;
                        if(table[m][n] > max) max = table[m][n];
                    }else{
                        table[m][n] = 0;
                    }
                }
        }
        return max;
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j]);
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] strs = {"10100", "10111", "11111", "10010"};
        char[][] test = new char[strs.length][];
        for (int i = 0; i < strs.length; i++) test[i] = strs[i].toCharArray();
        System.out.println(new MaximalRectangle().maximalRectangle(test));
    }
}

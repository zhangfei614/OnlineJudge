package zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/7/6.
 * Email:zhangfei614@126.com
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0

 思路1：不断收缩区域，判断邻近4个值是否同时为1，使用空间为O(1),但时间复杂度最多为O(m^2n)
 思路2：使用矩阵，然后让直接使用动态规划。b[i][j] = Math.min(b[i-1][j],b[i][j-1],b[i-1][j-1])+1,
 当所有三个为1时，才有可能使其为2

 */

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int max = 0;
        int m = matrix.length, n = matrix[0].length;
        int l = Math.min(m,n);
        for(int k = 0; k < l ; k++){
            boolean flag = false;
            for(int i = 0; i < m - k; i++){
                for(int j = 0; j < n - k ; j++){
                    if((k == 0 && matrix[i][j] == '1') ||
                            (k > 0 && matrix[i][j] == '1'
                                    && matrix[i+1][j] == '1'
                                    && matrix[i][j+1] == '1'
                                    && matrix[i+1][j+1]=='1')){
                        matrix[i][j] = '1';
                        max = (k + 1)*( k + 1);
                        flag = true;
                    }else{
                        matrix[i][j] = '0';
                    }
                }
            }
            if(!flag) break;
        }
        return max;
    }

    public int maximalSquareSimple(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int[][] dp  = new int[matrix.length+1][matrix[0].length+1];
        int max = 0;
        for(int i = 1; i <= matrix.length; i++)
            for(int j = 1; j <=matrix[0].length; j++)
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    max = Math.max(max,dp[i][j]);
                }
        return max*max;
    }

    public static void main(String[] args){
        char[][] m = {  {'1', '0' ,'1' ,'0', '0'},
                        {'1', '0' ,'1' ,'1', '1'},
                        {'1' ,'1', '1' ,'1', '1'},
                        {'1', '0', '0' ,'1' ,'0'}};
        char[][] m2 = {{'1','0'}};
        System.out.println(new MaximalSquare().maximalSquareSimple(m2));
    }
}

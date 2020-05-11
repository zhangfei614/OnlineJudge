package zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2017/3/11.
 * Email:zhangfei614@126.com
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */

public class SprialMatrixII {
    /**
     * 思路：按照四个边界，依次填写每个数字，直到填写到n*n
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int count = 0;
        int top = 0, left = 0, right = 0, bottom = 0;
        while (top + bottom < n && left + right < n) {
            //向右走，直到遇到left边界
            for (int i = left; i < n - right; i++) result[top][i] = ++count;
            if (++top + bottom >= n) break;
            //向下走，直到遇到bottom边界
            for (int i = top; i < n - bottom; i++) result[i][n - right - 1] = ++count;
            if (++right + left >= n) break;
            for (int i = n - right - 1; i >= left; i--) result[n - bottom - 1][i] = ++count;
            if (++bottom + top >= n) break;
            for (int i = n - bottom - 1; i >= top; i--) result[i][left] = ++count;
            if (++left + right >= n) break;
        }
        return result;
    }
}

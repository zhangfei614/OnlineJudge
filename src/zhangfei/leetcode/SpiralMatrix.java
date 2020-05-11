package zhangfei.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fei Zhang on 2016/4/7.
 * Email:zhangfei614@126.com
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */

public class SpiralMatrix {

    //使用四个变量分别控制边界,然后在四个方向上进行循环
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if (matrix.length == 0) return list;
        int M = matrix.length, N = matrix[0].length;
        int top = 0, left = 0, right = 0, bottom = 0;
        while (top + bottom < M && left + right < N) {
            //向右走，直到遇到left边界
            for (int i = left; i < N - right; i++) list.add(matrix[top][i]);
            if (++top + bottom >= M) break;
            //向下走，直到遇到buttom边界
            for (int i = top; i < M - bottom; i++) list.add(matrix[i][N - right - 1]);
            if (++right + left >= N) break;
            for (int i = N - right - 1; i >= left; i--) list.add(matrix[M - bottom - 1][i]);
            if (++bottom + top >= M) break;
            for (int i = M - bottom - 1; i >= top; i--) list.add(matrix[i][left]);
            if (++left + right >= N) break;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {{6, 9, 7},{2,3,4},{2,5,6}};
        List<Integer> list = new SpiralMatrix().spiralOrder(matrix);
        System.out.println(list.toString());
    }
}

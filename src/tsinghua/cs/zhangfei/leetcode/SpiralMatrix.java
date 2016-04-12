package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fei Zhang on 2016/4/7.
 * Email:zhangfei614@126.com
 */

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix.length == 0 ) return list;

        int M = matrix.length;
        int N = matrix[0].length;
        int m = M;
        int n = N;
        while(m > 0 && n > 0){
            int bm = (M - m)/2;
            int bn = (N - n)/2;
            for(int i = 0; i < n && bm >= 0; i++) list.add(matrix[bm][bn+i]);
            for(int i = 1; i < m-1 && N-bn-1>=0; i++) list.add(matrix[bm+i][N-bn-1]);
            for(int i = 1; i < n-1 && M-bm-1>=0; i++) list.add(matrix[M-bm-1][N-bn-i-1]);
            for(int i = 1; i < m-2 && bn >= 0; i++) list.add(matrix[M-bm-i-1][bn]);
            m--;
            n--;
        }
        return list;
    }

    public static void main(String[] args){
        int[][] matrix = {{6,9,7}};
        new SpiralMatrix().spiralOrder(matrix);

    }
}

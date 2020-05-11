package zhangfei.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Fei Zhang on 2016/6/1.
 * Email:zhangfei614@126.com
 */

public class SudokuSolver {
    private final static int N = 9;
    public void solveSudoku(char[][] board) {
        List<int[]> emptyCells  = new LinkedList<int[]>();
        boolean[][] row = new boolean[N][N];
        boolean[][] col = new boolean[N][N];
        boolean[][] sec = new boolean[N][N];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++){
                if(board[i][j]=='.'){
                    emptyCells.add(new int[]{i,j});
                }else{
                    int idx = board[i][j]-'1';
                    row[i][idx] = true;
                    col[j][idx] = true;
                    int k = i/3*3 + j/3;
                    sec[k][idx] = true;
                }
            }
        if (!emptyCells.isEmpty()){
            subSloveSudoku(board,row,col,sec,emptyCells,0);
        }
    }

    private boolean subSloveSudoku(char[][] board,boolean[][] row,boolean[][] col,boolean[][] sec,List<int[]> emptyCells,int idx){
        if(idx == emptyCells.size()){
            return true;
        }
        int[] cell = emptyCells.get(idx);
        int x = cell[0];
        int y = cell[1];
        int k = x/3*3 + y/3;
        for(int i = 0; i < N; i++){
            if(!row[x][i] && !col[y][i] && !sec[k][i]){
                board[x][y] = (char)('1'+i);
                row[x][i] = true;
                col[y][i] = true;
                sec[k][i] = true;
                if(subSloveSudoku(board,row,col,sec,emptyCells,idx+1)){
                    return true;
                }
                board[x][y] = '.';
                row[x][i] = false;
                col[y][i] = false;
                sec[k][i] = false;
            }
        }
        return false;
    }
}

package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zhangfei on 2016/5/26.
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0) return false;
        int n = 9;
        if(board.length != n) return false;
        boolean[] table = new boolean[n];
        for(int i = 0; i < n; i++){
            Arrays.fill(table,false);
            for(int j = 0; j < n ; j++){
                if(board[i][j] != '.'){
                    if(table[board[i][j]-'1']) return false;
                    else table[board[i][j]-'1']=true;
                }
            }
        }
        for(int j = 0; j < n; j++){
            Arrays.fill(table,false);
            for(int i = 0; i < n; i++){
                if(board[i][j] != '.'){
                    if(table[board[i][j]-'1']) return false;
                    else table[board[i][j]-'1']=true;
                }
            }
        }
        for(int k = 0; k < n; k++){
            Arrays.fill(table,false);
            int left = (k%3)*3;
            int right = left+3;
            int top = (k/3)*3;
            int bottom = top+3;
            for(int i = left; i < right;i++)
                for(int j = top;j < bottom; j++)
                    if(board[i][j] != '.'){
                        if(table[board[i][j]-'1']) return false;
                        else table[board[i][j]-'1']=true;
                    }
        }
        return true;
    }
}

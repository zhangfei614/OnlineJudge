package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2017/3/21.
 * Email:zhangfei614@126.com
 * Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 * Example:
 * X..X
 * ...X
 * ...X
 * In the above board there are 2 battleships.
 */

public class BattleshipsBoard {
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                if ((j - 1 >= 0 && board[i][j - 1] == 'X')
                        || (i - 1 >= 0) && board[i - 1][j] == 'X')
                    continue;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] board = {"X..X".toCharArray(), "...X".toCharArray(), "...X".toCharArray()};
        System.out.println(new BattleshipsBoard().countBattleships(board));
    }
}

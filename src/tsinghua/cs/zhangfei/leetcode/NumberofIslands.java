package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/4/4.
 * Email:zhangfei614@126.com
 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011
 Answer: 3

 思路：如果使用队列来进行广度优先遍历，不仅会浪费空间，也会超时。可以使用修改数据为‘0’的方法来完成递归的深度优先的遍历。


 */

public class NumberofIslands {

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;

        int result = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') continue;
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid,i,j);
                }
            }
        return result;
    }

    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        if (i - 1 >= 0 && grid[i - 1][j]=='1') dfs(grid,i-1,j);
        if (i + 1 < grid.length && grid[i + 1][j]=='1') dfs(grid,i+1,j);
        if (j - 1 >= 0 && grid[i][j - 1]=='1') dfs(grid,i,j-1);
        if (j + 1 < grid[i].length && grid[i][j + 1]=='1') dfs(grid,i,j+1);
    }

    public static void main(String[] args) {
        char[][] test = {{'1', '1'}};
        System.out.println(new NumberofIslands().numIslands(test));
    }
}

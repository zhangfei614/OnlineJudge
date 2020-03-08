package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by zhangfei614 on 2017/3/29.
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 */
public class IslandPerimeter {
    //如果每个iland快周围有一个水域，则周长加1
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (i - 1 < 0 || grid[i - 1][j] == 0) perimeter++;
                    if (i + 1 == grid.length || grid[i + 1][j] == 0) perimeter++;
                    if (j - 1 < 0 || grid[i][j - 1] == 0) perimeter++;
                    if (j + 1 == grid[i].length || grid[i][j + 1] == 0) perimeter++;
                }
            }
        return perimeter;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        System.out.println(new IslandPerimeter().islandPerimeter(grid));
    }
}

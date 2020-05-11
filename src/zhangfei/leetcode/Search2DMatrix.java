package zhangfei.leetcode;

/**
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 思路：先二分查找到在哪一行，再二分查找在那一列。
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int low, mid, high;
        //search for which row
        low = 0;
        high = matrix.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target == matrix[mid][0]) return true;
            else if (target < matrix[mid][0]) high = mid - 1;
            else low = mid + 1;
        }

        int row = low - 1;
        if (row < 0) return false;
        //search for which column
        low = 0;
        high = matrix[row].length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target == matrix[row][mid]) return true;
            else if (target < matrix[row][mid]) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }

    public static int searchIndex(int[] array, int target) {
        int low, mid, high;
        low = 0;
        high = array.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target == array[mid]) return mid;
            else if (target < array[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return low - 1;
    }

    public static void main(String[] args) {

    }
}

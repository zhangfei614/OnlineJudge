package zhangfei.microsoft;

import java.util.Arrays;

class Solution {
    public int solution(int[] A, int M) {

        // write your code in Java SE 8
        if (A == null) return 0;
        if (A.length <= 1) return A.length;
        int[] res = new int[M];
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                res[A[i] % M]++;
            } else {
                res[(A[i] % M + M) % M]++;
            }
        }
        int max = res[0];
        for (int i = 1; i < M; i++) {
            max = Math.max(max, res[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {-3, -2, 1, 0, 8, 7, 1};
        System.out.println(new Solution().solution(array,3));
    }


    private static int getLargestMAlignedSubset(int[] array, int M) {
        int result = 0;
        if (array == null || array.length == 0) return 0;

        int length = array.length;
        // aggregate numbers by the reminder
        int[] subsetSizeArray = new int[M];
        for (int num : array) {
            // get reminders, and convert non-positive reminders to non-negative
            int index = num < 0 ? (num % M + M) % M : num % M;
            result = Math.max(++subsetSizeArray[index], result);
        }
        return result;
    }
}

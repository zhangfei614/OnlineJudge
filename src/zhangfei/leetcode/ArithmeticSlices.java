package zhangfei.leetcode;

/**
 * Created by zhangfei614 on 2017/3/29.
 * A = [1, 2, 3, 4]
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 */
public class ArithmeticSlices {
    //对于一个n的序列长度的，其结果为(n-2+1)*（n-2)/2个
    //找到所有连续的递增或递减序列，统计每个序列的长度即可。
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        int i = 0, j = 2, x = A[1] - A[0], sum = 0;
        while (j < A.length) {
            //找到序列
            while (j < A.length && A[j] - A[j - 1] == x) j++;
            //如果长度大于3
            if (j - i >= 3) {
                sum += ((j - i - 2 + 1) * (j - i - 2) / 2);
            }
            //如果已经遍历完成
            if (j >= A.length) break;
            else {
                //未遍历完，则修改前面一个指针的位置
                i = j - 1;
                x = A[j] - A[j - 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 3, 5, 7,9};
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(test));
    }
}

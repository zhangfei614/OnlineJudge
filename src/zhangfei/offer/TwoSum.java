package zhangfei.offer;

import java.util.ArrayList;

/**
 * Created by zhangfei on 2017/8/1.
 */
public class TwoSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = array.length, i = 0, j = n - 1;
        if (n < 2) return res;
        while (i < j) {
            int t = array[i] + array[j];
            if (t == sum) {
                res.add(array[i]);
                res.add(array[j]);
                break;
            } else if (t < sum) {
                i++;
            } else if (t > sum) {
                j--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("test".substring(2));
    }
}

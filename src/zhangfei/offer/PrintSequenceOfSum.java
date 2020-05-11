package zhangfei.offer;

/**
 * Created by Fei Zhang on 2017/6/12.
 * Email:zhangfei614@126.com
 */

public class PrintSequenceOfSum {

    public void printSequenceOfSum(int sum) {
        int small = 1, big = 2;
        while (small <= (sum + 1) / 2) {
            int curSum = (small + big) * (big - small + 1) / 2;
            if (curSum == sum) {
                print(small, big);
            }
            if (curSum >= sum) {
                small++;
            } else {
                big++;
            }
        }
    }

    private void print(int small, int big) {
        for (int i = small; i <= big; i++)
            System.out.print(i + ",");
        System.out.println();
    }

    public static void main(String[] args) {
        new PrintSequenceOfSum().printSequenceOfSum(15);
    }
}

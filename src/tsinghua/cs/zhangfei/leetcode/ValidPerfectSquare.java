package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by zhangfei614 on 2017/6/28.
 * 1.所有的完全平方数是1+2+3+5+7的组合
 * 2.利用long类型存储mid，利用二分查找来找到中间的平方数
 * 3.利用牛顿法，
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    public boolean isPerfectSquare2(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = low + (high - low) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }

    private boolean isPerfectSquare3(int num) {
        int x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare(16));
    }
}

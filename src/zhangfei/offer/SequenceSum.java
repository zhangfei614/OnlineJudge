package tsinghua.cs.zhangfei.offer;

import java.util.ArrayList;

/**
 * Created by zhangfei on 2017/8/1.
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class SequenceSum {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum < 3) return res;
        int small = 1, big = 2;
        while (small < big) {
            int cur = (small + big) * (big - small + 1) / 2;
            if (cur == sum) {
                ArrayList<Integer> arr = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    arr.add(i);
                }
                res.add(arr);
                small++;
            } else if (cur < sum) {
                big++;
            } else if (cur > sum) {
                small++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf("+0001"));
    }
}

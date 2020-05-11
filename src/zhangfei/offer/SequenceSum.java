package zhangfei.offer;

import java.util.ArrayList;

/**
 * Created by zhangfei on 2017/8/1.
 * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100�����������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22�����ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!
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

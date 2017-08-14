package tsinghua.cs.zhangfei.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by zhangfei on 2017/8/4.
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 思路：双向队列：队列的头存当前窗口的最大值的索引
 * 1. 判断当前最大值有没有失效。
 * 2. 如果新加入的数比队未的数大，则更有可能成为最大值，将比起小的数删掉。
 */
public class WindowMax {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num.length <= 0 || size <= 0 || size >= num.length) return res;
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < num.length; i++) {
            int begin = i - size + 1;
            if (deque.isEmpty()) {
                deque.add(i);
            } else if (begin > deque.getFirst()) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && num[i] >= num[deque.getLast()])
                deque.pollLast();
            deque.add(i);
            if (begin >= 0) res.add(num[deque.getFirst()]);
        }
        return res;
    }
}

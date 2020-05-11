package zhangfei.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by zhangfei on 2017/8/4.
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ�����磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3��
 * ��ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6����
 * {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}�� {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
 * ˼·��˫����У����е�ͷ�浱ǰ���ڵ����ֵ������
 * 1. �жϵ�ǰ���ֵ��û��ʧЧ��
 * 2. ����¼�������ȶ�δ����������п��ܳ�Ϊ���ֵ��������С����ɾ����
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

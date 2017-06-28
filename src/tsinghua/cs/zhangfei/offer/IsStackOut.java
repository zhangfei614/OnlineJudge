package tsinghua.cs.zhangfei.offer;

import java.util.Stack;

/**
 * Created by zhangfei614 on 2017/6/3.
 * 输入两个整数序列，第一个序列为入栈的序列，判断第二个序列是否为第一个序列合法的出栈序列。
 */
public class IsStackOut {
    public boolean isStackOut(int[] in, int[] out) {
        if (in.length != out.length) return false;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0, j = 0;
        for (; j < out.length; j++) {
            while (stack.isEmpty() || stack.peek() != out[j]) {
                if (i >= in.length) return false;
                stack.push(in[i++]);
            }
            stack.pop();
            continue;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] in = new int[]{1, 2, 3, 4, 5};
        int[] out = new int[]{1, 2, 3, 4, 5};
        System.out.println(new IsStackOut().isStackOut(in, out));
    }
}
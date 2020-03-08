package tsinghua.cs.zhangfei.offer;

import java.util.Stack;

/**
 * Created by zhangfei614 on 2017/6/3.
 * 输入两个整数序列，第一个序列为入栈的序列，判断第二个序列是否为第一个序列合法的出栈序列。
 */
public class IsStackOut {

    private Stack<Integer> stack = new Stack<>();

    public boolean isStackOut(int[] pushA, int[] popA) {
        if (pushA.length != popA.length) return false;
        int index = 0;
        for (int i = 0; i < popA.length; i++) {
            int data = popA[i];
            if (stack.isEmpty() || stack.peek() != data) {
                while (index < pushA.length) {
                    stack.push(pushA[index]);
                    if (pushA[index++] == data)
                        break;
                }
                if (stack.peek() != data && index >= pushA.length)
                    return false;
            }
            stack.pop();
        }
        return true;
    }

    public static void main(String[] args) {
        int[] in = new int[]{1, 2, 3, 4, 5};
        int[] out = new int[]{4, 5, 3, 2, 1};
        System.out.println(new IsStackOut().isStackOut(in, out));
    }
}
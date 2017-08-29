package tsinghua.cs.zhangfei.offer;

import java.util.Stack;

/**
 * Created by zhangfei614 on 2017/7/14.
 */
public class MinStack {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    private int minIndex = -1;
    private int minValue = Integer.MIN_VALUE;

    public void push(int node) {
        stack.push(node);
        if (minIndex == -1) {
            minIndex = 0;
            minValue = node;
        } else {
            if (node <= minValue) {
                minIndex = stack.size() - 1;
                minValue = node;
            }
        }
        minStack.push(minIndex);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stack.get(minStack.peek());
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(3);
        minStack.push(1);
        System.out.println(minStack.min());
    }
}

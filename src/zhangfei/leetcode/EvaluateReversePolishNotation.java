package tsinghua.cs.zhangfei.leetcode;

import java.util.Stack;

/**
 * Created by Fei Zhang on 2017/9/8.
 * Email:zhangfei614@126.com
 */

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int right = stack.pop();
                int left = stack.pop();
                if (s.equals("+")) stack.push(left + right);
                if (s.equals("-")) stack.push(left - right);
                if (s.equals("*")) stack.push(left * right);
                if (s.equals("/")) stack.push(left / right);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}

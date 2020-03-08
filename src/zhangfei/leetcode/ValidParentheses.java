package tsinghua.cs.zhangfei.leetcode;

import java.util.Stack;

/**
 * Created by Fei Zhang on 2016/4/19.
 * Email:zhangfei614@126.com
 */

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s == null || s.equals("")) return true;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(char c:chars){
            if(c == '(' || c=='[' || c=='{') stack.push(c);
            else {
                if(stack.empty()) return false;
                char p = stack.pop().charValue();
                if((c==')'&&p!='(') || (c==']'&& p!='[') || (c=='}'&&p!='{'))
                    return false;
            }
        }
        if(!stack.empty()) return false;
        else return true;
    }
}

package zhangfei.leetcode;

import java.util.Stack;

/**
 * Created by zhangfei614 on 2017/6/26.
 */
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("sd2[f2[e]g]i"));
    }

    public String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                numberStack.push(Integer.valueOf(sb.toString()));
                sb.setLength(0);
            } else if (c == ']') {
                if (sb.length() > 0) {
                    stringStack.push(sb.toString());
                    sb.setLength(0);
                }
                String str = stringStack.pop();
                int n = numberStack.pop();
                if (!stringStack.isEmpty()) {
                    sb.append(stringStack.pop());
                }
                for (int j = 0; j < n; j++) sb.append(str);
                stringStack.push(sb.toString());
                sb.setLength(0);
            } else {
                if (Character.isDigit(c)) {
                    if (sb.length() > 0 && Character.isLetter(sb.charAt(sb.length()-1 ))) {
                        stringStack.push(sb.toString());
                        sb.setLength(0);
                    }
                }
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            stringStack.push(sb.toString());
            sb.setLength(0);
        }
        for (String str : stringStack)
            sb.append(str);
        return sb.toString();
    }

}

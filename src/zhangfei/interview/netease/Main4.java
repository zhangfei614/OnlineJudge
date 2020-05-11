package zhangfei.interview.netease;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by zhangfei614 on 2017/8/26.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            if (str == null || str.length() == 0)
                System.out.printf("");
            System.out.println(process(str));
        }
    }

    private static String process(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '}') {
                stack.push(str.charAt(i));
            } else {
                sb.setLength(0);
                while (!stack.isEmpty()) {
                    char c = stack.pop();
                    if (c != '{' && Character.isLetter(c))
                        sb.append(c);
                    else
                        break;
                }
                String s = sb.reverse().toString();
                sb.setLength(0);
                while (!stack.isEmpty()) {
                    char c = stack.peek();
                    if (Character.isDigit(c)) {
                        sb.append(stack.pop());
                    } else {
                        break;
                    }
                }
                int count = Integer.valueOf(sb.reverse().toString());

                if (s == null || s.equals("") || count <= 0)
                    continue;
                for (int j = 0; j < count; j++) {
                    for (int k = 0; k < s.length(); k++) {
                        stack.push(s.charAt(k));
                    }
                }
            }
        }
        sb.setLength(0);
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

package tsinghua.cs.zhangfei.leetcode;

import java.util.Stack;

/**
 * Created by zhangfei614 on 2017/4/18.
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 */
public class SimplifyPath {

    //使用栈来进行处理，当为..时进行pop操作。
    public String simplifyPath(String path) {
        if (path == null || path.equals("")) return "";
        String[] strs = path.split("/");
        if (strs.length == 0) return "/";
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].trim().equals("")) continue;
            if (strs[i].equals(".")) continue;
            if (strs[i].equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(strs[i]);
            }
        }
        if (stack.isEmpty()) return "/";
        else {
            StringBuilder sb = new StringBuilder();
            for (String str : stack) {
                sb.append("/" + str);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/home//foo/"));
    }
}

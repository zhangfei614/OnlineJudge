package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Fei Zhang on 2016/4/19.
 * Email:zhangfei614@126.com
 Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

 Note: The input string may contain letters other than the parentheses ( and ).

 Examples:
 "()())()" -> ["()()()", "(())()"]
 "(a)())()" -> ["(a)()()", "(a())()"]
 ")(" -> [""]
 思路：利用深度优先遍历判断一个括号是否被删除，可以进一步提高条件下不在继续向下执行。
 思路2：不太懂这个，先正向扫一遍，再反向扫一遍。
 */

public class RemoveInvalidParentheses {
    private Set<String> result;
    private char[] array;
    public List<String> removeInvalidParentheses(String s) {
        result = new HashSet<String>();
        array = s.toCharArray();
        int removeL = 0, removeR = 0;
        for(char c : array){
            if(c == '(') removeL++;
            if(c == ')'){
                if(removeL != 0) removeL--;
                else removeR++;
            }
        }
        DFS(0,removeL,removeR,0,new StringBuilder());
        return new ArrayList(result);
    }

    private void DFS(int index,int removeL,int removeR,int open,StringBuilder stringBuilder){
        if(index == array.length && removeL == 0 && removeR == 0 && open == 0){
            result.add(stringBuilder.toString());
            return ;
        }
        if(index == array.length || removeL < 0 || removeR < 0 || open < 0 ) return;

        char c = array[index];
        if(c == '(') {
            DFS(index + 1, removeL - 1, removeR, open, stringBuilder);
            DFS(index + 1, removeL, removeR, open + 1, stringBuilder.append(c));
        }else if(c == ')'){
            DFS(index+1,removeL,removeR-1,open,stringBuilder);
            DFS(index+1,removeL,removeR,open-1,stringBuilder.append(c));
        }else{
            DFS(index+1,removeL,removeR,open,stringBuilder.append(c));
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
    }

    public List<String> removeInvalidParentheses2(String s) {
        List<String> ans = new ArrayList<String>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            for (int j = last_j; j <= i; ++j)
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') // finished left to right
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else // finished right to left
            ans.add(reversed);
    }

    public static void main(String[] args){
        List<String> result = new RemoveInvalidParentheses().removeInvalidParentheses(")((f");
        System.out.println(result.size());
        for(String s : result) System.out.println(s);
    }
}

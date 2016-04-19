package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fei Zhang on 2016/4/19.
 * Email:zhangfei614@126.com
 */

public class RemoveInvalidParentheses {
    private List<String> result;
    private char remove;
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<String>();
        if(s == null) return result;
        char[] array = s.toCharArray();
        int count = diffChars(array);
        if(count == 0){
            addString(new StringBuilder().append(array));
        }else{
            dfs(array,0,count,new StringBuilder());
        }
        if(result.isEmpty()) result.add("");
        return result;
    }

    private void dfs(char[] array,int begin,int count,StringBuilder stringBuilder){
        if(begin >= array.length){
            addString(stringBuilder);
            return;
        }

        stringBuilder.append(array[begin]);
        dfs(array,begin+1,count,stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        if(array[begin] == remove && count > 0)
            dfs(array,begin+1,count-1,stringBuilder);

    }
    private int diffChars(char[] array){
        int left = 0;
        int right = 0;
        for(int i = 0; i < array.length;i++){
            if(array[i] == '(') left++;
            if(array[i] == ')') right++;
        }
        if(left < right){
            remove = ')';
            return right - left;
        }else if( left > right){
            remove = '(';
            return left - right;
        }
        return 0;
    }

    private void addString(StringBuilder stringBuilder){
        int left = 0;
        for(int i = 0; i<stringBuilder.length();i++){
            if(stringBuilder.charAt(i) == '(') left++;
            if(stringBuilder.charAt(i) == ')'){
                if(--left < 0) return ;
            }
        }
        if(left != 0) return;
        if(!result.contains(stringBuilder.toString()))
            result.add(stringBuilder.toString());
    }

    public static void main(String[] args){
        List<String> result = new RemoveInvalidParentheses().removeInvalidParentheses(")(");
        System.out.println(result.size());
        for(String s : result) System.out.println(s);
    }
}

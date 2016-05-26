package tsinghua.cs.zhangfei.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Fei Zhang on 2016/5/26.
 * Email:zhangfei614@126.com
 */

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null && str == null) return true;
        if(pattern == null || str == null) return false;
        if(pattern.equals("") && str.equals("")) return true;
        String[] words = str.split(" ");
        if(pattern.length() != words.length) return false;
        String[] table = new String[30];
        Set<String> set = new HashSet<String>();
        for(int i = 0; i < pattern.length(); i++){
            int index = pattern.charAt(i) - 'a';
            if(table[index] != null){
                if(!table[index].equals(words[i]))
                    return false;
            }else{
                if(set.contains(words[i])) return false;
                table[index] = words[i];
                set.add(words[i]);
            }
        }
        return true;
    }
}

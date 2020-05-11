package zhangfei.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangfei on 2016/5/26.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null && str == null) return true;
        if(pattern == null || str == null) return false;
        if(pattern.equals("") && str.equals("")) return true;
        String[] words = str.split(" ");
        if(pattern.length() != words.length) return false;
        Map<String,Character> map = new HashMap<String, Character>();
        for(int i = 0; i < pattern.length();i++){
            char c = pattern.charAt(i);
            if(map.containsKey(words[i])){
                if(!map.get(words[i]).equals(c)) return false;
            }else{
                map.put(words[i],c);
            }
        }
        return true;
    }
    public static void main(String[] args){
        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(new WordPattern().wordPattern(pattern,str));
    }
}

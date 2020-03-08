package tsinghua.cs.zhangfei.leetcode;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by zhangfei on 2016/5/30.
 */
public class MinimumWindowSubstring {
    public String minWindowMap(String s, String t) {
        if(s == null || t == null || s.equals("") || t.equals("")) return "";
        HashMap<Character,Integer> map= new HashMap<Character, Integer>();
        HashMap<Character,Integer> target = new HashMap<Character, Integer>();
        HashMap<Character,Integer> finish = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length(); i++){
            if(!target.containsKey(t.charAt(i))) target.put(t.charAt(i),1);
            else target.put(t.charAt(i),target.get(t.charAt(i))+1);
        }
        int i = 0,j = 0;
        String min = null;
        while(i < s.length() && j < s.length()){

            //寻找含有所有字符的串
            for(; j < s.length() && finish.size() != target.size();j++){
                Character c = s.charAt(j);
                if(!target.containsKey(c)) continue;
                if(finish.containsKey(c)) finish.put(c,finish.get(c)+1);
                else{
                    if(map.containsKey(c)){
                        map.put(c,map.get(c)+1);
                    }else{
                        map.put(c,1);
                    }
                    if(map.get(c) == target.get(c)){
                        finish.put(c,map.get(c));
                        map.remove(c);
                    }
                }
            }
            //收缩串
            if(finish.size() == target.size()){
                for(; i < s.length();i++){
                    Character c = s.charAt(i);
                    if(!target.containsKey(c)) continue;
                    if(finish.get(c) > target.get(c)){
                        finish.put(c,finish.get(c)-1);
                    }else{
                        break;
                    }
                }
                String str = s.substring(i,j);
                if(min == null || str.length() < min.length()) min = str;
            }

            //去掉一个字符
            if(finish.size() == target.size()){
                Character c = s.charAt(i++);
                map.put(c,finish.get(c)-1);
                finish.remove(c);
            }else{
                break;
            }
        }
        if(min == null) return "";
        else return min;
    }

    public String minWindow(String s,String t){
        if(s == null || t == null || s.equals("") || t.equals("")) return "";
        int[] map = new int[256];
        int min = Integer.MAX_VALUE, min_start = 0;
        int sLen = s.length(),tLen = t.length();
        int start = 0,end = 0;
        int count = 0;
        for(int i = 0; i < tLen; i++) map[t.charAt(i)]++;
        while(end < sLen){
            //找到所有字符串
            if(map[s.charAt(end)]>0){
                count ++;
            }
            map[s.charAt(end)]--;
            while(count == tLen){
                //收缩字符串
                if(end - start + 1 < min){
                    min = end-start+1;
                    min_start = start;
                }
                map[s.charAt(start)]++;
                //只要原来需要查找的字符串才有可能大于0，因此遇见第一个大于0的，即为去掉的第一个字符。
                if(map[s.charAt(start)] > 0){
                    count--;
                }
                start++;
            }
            end++;
        }
        if(min_start + min > sLen)
            return "";
        else
            return s.substring(min_start,min_start+min);
    }
    public static void main(String[] args){
        String s ="cabwefgewcwaefgcf";
        String t ="cae";
        System.out.println(new MinimumWindowSubstring().minWindow(s,t));
    }
}

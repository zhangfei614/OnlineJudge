package zhangfei.leetcode;

import java.net.Inet4Address;
import java.util.*;

/**
 * Created by zhangfei on 2016/5/31.
 */
public class SubstringConcatenationAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if(s == null || s.equals("") || words == null || words.length == 0) return res;
        int len = words[0].length();
        int n = words.length;
        if(s.length() < len*n) return res;
        Map<String,Integer> table = new HashMap<String, Integer>();
        for(String word : words){
            if(!table.containsKey(word)) table.put(word,1);
            else table.put(word,table.get(word)+1);
        }
        for(int i = 0; i < len; i++){
            int start = i, end = i;
            int count = 0;
            Map<String,Integer> map = new HashMap<String, Integer>(table);
            while(end <= s.length()-len){
                String word = s.substring(end,end+len);
                if(map.containsKey(word)){
                    if(map.get(word) > 0){
                        count++;
                    }
                    map.put(word,map.get(word)-1);
                    while(start <= s.length()-n*len && count == n){
                        if((end-start+len)==n*len && (start-i)%len==0) res.add(start);
                        String str = s.substring(start,start+len);
                        if(map.containsKey(str)){
                            map.put(str,map.get(str)+1);
                            if(map.get(str)>0){
                                count--;
                            }
                        }
                        start+=len;
                    }
                }
                end+=len;
            }
        }
        return res;
    }

    public static void main(String[] args){
        long current = System.currentTimeMillis();
        String s = "ababaab";
        String[] words = {"ab","ba","ba"};
        List<Integer> res = new SubstringConcatenationAllWords().findSubstring(s,words);
        System.out.println((System.currentTimeMillis()-current)+"ms");
        for(Integer i : res)
            System.out.println(i);
    }
}

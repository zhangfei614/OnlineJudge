package zhangfei.leetcode;

import java.util.*;

/**
 * Created by Fei Zhang on 2016/5/26.
 * Email:zhangfei614@126.com
 */

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<String, List<String>>();
        for(String s : strs){
            String key = sortString(s);
            if(!map.containsKey(key)) map.put(key,new ArrayList<String>());
            map.get(key).add(s);
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for(List<String> list : map.values()){
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
    private String sortString(String s){
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
}

package tsinghua.cs.zhangfei.leetcode;

import java.util.*;

/**
 * Created by Fei Zhang on 2016/5/26.
 * Email:zhangfei614@126.com
 */

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<String>();
        Map<String,Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i <= s.length()-10; i ++){
            String str = s.substring(i,i+10);
            if(!map.containsKey(str)) map.put(str,1);
            else{
                if(map.get(str) == 1) list.add(str);
                map.put(str,Integer.MAX_VALUE);
            }
        }
        return list;
    }

    public static void main(String[] args){
        List<String> res = new RepeatedDNASequences().findRepeatedDnaSequences("AAAAAAAAAAA");
        for(String s : res) {
            System.out.println(s+s.length());
        }
    }
}

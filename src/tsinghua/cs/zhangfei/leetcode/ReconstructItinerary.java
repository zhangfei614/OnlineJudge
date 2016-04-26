package tsinghua.cs.zhangfei.leetcode;

import java.util.*;

/**
 * Created by Fei Zhang on 2016/4/22.
 * Email:zhangfei614@126.com
 */

public class ReconstructItinerary {
    private Map<String,List<String>> map;
    private List<String> result;
    public List<String> findItinerary(String[][] tickets) {
        result = new ArrayList<String>();
        if(tickets == null || tickets.length == 0) return result;
        map = new HashMap<String, List<String>>();
        for(int i = 0; i < tickets.length; i++){
            if(!map.containsKey(tickets[i][0]))
                map.put(tickets[i][0],new ArrayList<String>());
            map.get(tickets[i][0]).add(tickets[i][1]);
        }
        for(List<String> list: map.values())
            Collections.sort(list);

        backtracing("JFK");
        return result;
    }
    void backtracing(String key){
        while(map.containsKey(key) && !map.get(key).isEmpty()){
            String next = map.get(key).remove(0);
            backtracing(next);
        }
        result.add(0,key);
    }

    public static void main(String[] args){
        String[][] array = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        List<String> result = new ReconstructItinerary().findItinerary(array);
        for(String s:result) System.out.println(s);
    }
}

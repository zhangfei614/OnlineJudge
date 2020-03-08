package tsinghua.cs.zhangfei.leetcode;

import java.util.*;

/**
 * Created by Fei Zhang on 2016/5/17.
 * Email:zhangfei614@126.com
 Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 思路2：使用select算法，选取前k个元素。
 */

public class TopKFrequentElements {

    //对所有元素进行排序，取前k个。
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        for(int num : nums){
            if(hashMap.containsKey(num)) hashMap.put(num,hashMap.get(num)+1);
            else hashMap.put(num,1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(hashMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < k; i++)
            res.add(list.get(i).getValue());
        return res;
    }

    public static void main(String[] args){
        int[] array = {1,1,1,2,2,3};
        List<Integer> res = new TopKFrequentElements().topKFrequent(array,2);
        for(Integer integer : res)
            System.out.println(integer.toString());
    }
}

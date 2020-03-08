package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Fei Zhang on 2016/5/26.
 * Email:zhangfei614@126.com
 */

public class IntersectionTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums1.length ; i++){
            if(map.containsKey(nums1[i])) map.put(nums1[i],map.get(nums1[i])+1);
            else map.put(nums1[i],1);
        }
        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i])){
                list.add(nums2[i]);
                int count = map.get(nums2[i]);
                if(--count == 0) map.remove(nums2[i]);
                else map.put(nums2[i],count);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }
}

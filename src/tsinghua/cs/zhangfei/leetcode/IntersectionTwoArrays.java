package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Fei Zhang on 2016/5/18.
 * Email:zhangfei614@126.com
 */

public class IntersectionTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums1) set.add(i);
        List<Integer> list = new ArrayList<Integer>();
        for(int i : nums2)
            if(set.contains(i) && !list.contains(i)) list.add(i);
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length ; i++) res[i] = list.get(i);
        return res;
    }

    public int[] intersectionSet(int[] nums1,int[] nums2){
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for(int i : nums1) set1.add(i);
        for(int i : nums2)
            if(set1.contains(i))
                set2.add(i);
        int[] res = new int[set2.size()];
        int i = 0;
        for(Integer integer : set2) res[i++] = integer;
        return res;
    }
}

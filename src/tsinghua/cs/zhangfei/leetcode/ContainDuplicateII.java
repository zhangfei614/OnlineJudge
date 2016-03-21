package tsinghua.cs.zhangfei.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;

/**
 * Created by Fei Zhang on 2016/3/21.
 * Email:zhangfei614@126.com
 Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 思路：利用HashMap来存储已有的数，然后取出后进行比较
 思路2：利用排序算法进行排序，再扫一遍完成。
 */

public class ContainDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Hashtable<Integer,Integer> hashtable = new Hashtable<Integer, Integer>();
        Integer i,j;
        for(i=0;i<nums.length;i++){
            if((j=hashtable.get(nums[i]))!=null){
                if(i - j <=k && i - j > 0) return true;

            }
            hashtable.put(nums[i],i);
        }
        return false;
    }
    public boolean containNearbyDuplicate(int[] nums,int k){
        class Node{
            int val;
            int index;
        }
        Node[] nodeArray = new Node[nums.length];
        for(int i=0;i<nums.length;i++){
            nodeArray[i] = new Node();
            nodeArray[i].index=i;
            nodeArray[i].val = nums[i];
        }
        Arrays.sort(nodeArray, 0, nodeArray.length, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val - o2.val;
            }
        });
        for(int i=0;i<nodeArray.length-1;i++){
            if(nodeArray[i].val==nodeArray[i+1].val && Math.abs(nodeArray[i].index - nodeArray[i+1].index)<=k)
                return true;
        }
        return false;
    }
    public static void main(String[] args){
        int[] array = {-1,-1};
        System.out.println(new ContainDuplicateII().containsNearbyDuplicate(array,1));
    }
}

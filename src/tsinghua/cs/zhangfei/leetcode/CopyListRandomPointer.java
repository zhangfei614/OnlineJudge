package tsinghua.cs.zhangfei.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangfei on 2016/5/24.
 */
class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
    public static RandomListNode buildTree(int[] array){
        if(array.length == 0) return null;
        RandomListNode head = new RandomListNode(array[0]);
        RandomListNode p = head;
        for(int i = 1; i < array.length; i++){
            p.next = new RandomListNode(array[i]);
            p = p.next;
        }
        p.next = null;
        return head;
    }
}
public class CopyListRandomPointer {
    /**
     * 此种方法调用栈过多，已经stackoverflow
     */
    private Map<RandomListNode,RandomListNode> hashMap = new HashMap<RandomListNode, RandomListNode>();
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null ) return null;
        if(hashMap.containsKey(head))
            return hashMap.get(head);

        RandomListNode newNode = new RandomListNode(head.label);
        hashMap.put(head,newNode);

        if(head.next != null) newNode.next = copyRandomList(head.next);
        if(head.random != null) newNode.random = copyRandomList(head.random);
        return newNode;
    }


    public static void main(String[] args){
        int[] array = {-1,-1};
        RandomListNode head = RandomListNode.buildTree(array);
        head = new CopyListRandomPointer().copyRandomList(head);
        while(head != null){
            System.out.println(head.label);
            head = head.next;
        }
    }
}

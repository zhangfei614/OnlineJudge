package tsinghua.cs.zhangfei.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangfei on 2016/5/24.
 *
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
    public RandomListNode copyRandomListRecursion(RandomListNode head) {
        if(head == null ) return null;
        if(hashMap.containsKey(head))
            return hashMap.get(head);

        RandomListNode newNode = new RandomListNode(head.label);
        hashMap.put(head,newNode);

        if(head.next != null) newNode.next = copyRandomListRecursion(head.next);
        if(head.random != null) newNode.random = copyRandomListRecursion(head.random);
        return newNode;
    }

    public RandomListNode copyRandomList(RandomListNode head){
        if(head == null) return null;
        RandomListNode p,q,t,newHead;
        //生成新的节点，并插入到原节点后。
        p = head;
        while(p.next != null){
            RandomListNode node = new RandomListNode(p.label);
            t = p.next;
            p.next = node;
            node.next = t;
            p = t;
        }
        p.next = new RandomListNode(p.label);

        //构建random指针
        p = head;
        while(p != null){
            if(p.random != null)
                p.next.random = p.random.next;
            p = p.next.next;
        }

        //恢复原始链和生成新链。
        newHead = head.next;
        p = head;
        q = newHead;
        while(p != null && q != null){
            p.next = q.next;
            p = p.next;
            if(p != null){
                q.next = p.next;
                q = q.next;
            }
        }
        return newHead;
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

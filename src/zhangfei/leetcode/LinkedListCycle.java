package zhangfei.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangfei on 2016/5/7.
 Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?

 Subscribe to see which companies asked this question
 思路1：记录已经访问的过的节点。
 思路2：利用一个快速遍历和慢速遍历，如果有环，则快的必然能赶上慢的。但并不是快递的只访问一遍。
 */
public class LinkedListCycle {
    public boolean hasCycleSet(ListNode head) {
        Set<ListNode> visvited = new HashSet<ListNode>();
        ListNode p = head;
        while( p!= null && !visvited.contains(p)){
            visvited.add(p);
            p = p.next;
        }
        if(p != null) return true;
        else return false;
    }

    public boolean hasCycle(ListNode head) {
        if(head == null ) return false;
        ListNode fast = head,slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow ) return true;
        }
        return false;
    }
}

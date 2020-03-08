package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/5/23.
 * Email:zhangfei614@126.com
 */

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode less = new ListNode(Integer.MAX_VALUE);
        ListNode greater = new ListNode(Integer.MAX_VALUE);
        ListNode equal = new ListNode(Integer.MAX_VALUE);
        int key = head.val;
        ListNode p = less , q= greater, e = equal;
        while(head != null){
            if(head.val < key){
                p.next = head;
                p = p.next;
            }else if(head.val > key){
                q.next = head;
                q = q.next;
            }else{
                e.next = head;
                e = e.next;
            }
            head = head.next;
        }
        p.next = null;
        q.next = null;
        e.next = null;
        less = sortList(less.next);
        greater = sortList(greater.next);
        equal = equal.next;
        for( p = less ; p != null && p.next != null; p = p.next);
        for( e = equal; e != null && e.next != null; e = e.next);
        if(less == null){
            if(equal == null) return greater;
            else{
                e.next = greater;
                return equal;
            }
        }else{
            if(equal == null){
                p.next = greater;
            }else{
                p.next = equal;
                e.next = greater;
            }
            return less;
        }
    }

    public static void main(String[] args){
        int[] arr = {3,2,1};
        ListNode head = ListNode.buildListNode(arr);
        head = new SortList().sortList(head);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}

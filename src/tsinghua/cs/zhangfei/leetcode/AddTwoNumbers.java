package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by THU on 2015/10/21.
 */


public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p,q;
        p = l1;
        q = l2;
        while (p != null && q != null){
            q.val = q.val + p.val;
            p = p.next;
            q = q.next;
        }
        if(p != null){
            q = l2;
            while (q.next != null) q = q.next;
            q.next = p;
        }
        q = l2;
        while(q.next != null){
            if(q.val > 9){
                q.val = q.val % 10;
                q.next.val += 1;
            }
            q = q.next;
        }
        if(q.val > 9){
            ListNode a = new ListNode(q.val/10);
            q.val = q.val % 10;
            q.next = a;
        }
        return  l2;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }
}

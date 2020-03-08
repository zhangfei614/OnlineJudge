package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by zhangfei on 2016/5/24.
 (CIRCLE-START-POINT)
 |
 -------A----@----------------
            |               |
            |               |
            C               B
            |               |
            |-------@-------|
                    |
                (MEET-POINT)
 (A+B+n*L)/2S = (A+B)/S
 A+B+n*L = 2A+2B
 A = n*L - B
    = (n-1)*L + C
 A-C = (n-1)*L
 所以从起点和从Meet-Point开始相同速度，会相遇在环的起点。
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head,fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                while(head != fast){
                    fast = fast.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }
}

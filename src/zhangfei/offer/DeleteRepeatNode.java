package zhangfei.offer;

import zhangfei.leetcode.ListNode;

/**
 * Created by zhangfei on 2017/8/4.
 */
public class DeleteRepeatNode {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        ListNode head = new ListNode(0);
        ListNode pre = head, p = pHead, q;
        while (p != null) {
            q = p.next;
            while (q != null && q.val == p.val) q = q.next;
            if (q == p.next) {
                pre.next = p;
                pre = p;
            }
            p = q;
        }
        pre.next = null;
        return head.next;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 1, 2, 3, 3, 4, 5, 5};
        System.out.println(new DeleteRepeatNode().deleteDuplication(ListNode.buildListNode(test)));
    }
}

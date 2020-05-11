package zhangfei.leetcode;

/**
 * Created by zhangfei on 2016/4/8.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode p = next;
        while (p != null) {
            sb.append("," + p.val);
            p = p.next;
        }
        return sb.toString();
    }

    public static ListNode buildListNode(int[] array) {
        if (array.length == 0) return null;
        ListNode head = new ListNode(array[0]);
        ListNode p = head;
        for (int i = 1; i < array.length; i++) {
            p.next = new ListNode(array[i]);
            p = p.next;
        }
        p.next = null;
        return head;
    }
}

package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by THU on 2015/10/21。
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */


public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 1.将所有的值都加到l2上
     * 2.将l2上所有超过10的值进行进制转换
     * 3.返回l2
     * @param l1
     * @param l2
     * @return
     */
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

    /**
     * 1.构件一个新的链表用于存储结果数据
     * 2.如果大于10，则新节点值为(sum%10)
     * @param l1
     * @param l2
     * @return
     */
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

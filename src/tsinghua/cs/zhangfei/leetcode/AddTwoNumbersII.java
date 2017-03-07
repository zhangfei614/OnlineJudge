package tsinghua.cs.zhangfei.leetcode;

import java.util.Stack;

/**
 * Created by Fei Zhang on 2017/3/7.
 * Email:zhangfei614@126.com
 You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Follow up:
 What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

 Example:

 Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 8 -> 0 -> 7
 */

public class AddTwoNumbersII {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 利用递归的栈的特性，在返回后值的时候完成与前值的连接和前值的更新
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        int len1 = 1, len2 = 1;
        while (p.next != null) {
            p = p.next;
            len1++;
        }
        while (q.next != null) {
            q = q.next;
            len2++;
        }
        ListNode head = new ListNode(1);
        head.next = len1 < len2 ? helper(l2, l1, len2 - len1) : helper(l1, l2, len1 - len2);
        if (head.next.val > 9) {
            head.next.val = head.next.val % 10;
            return head;
        }
        return head.next;
    }

    private ListNode helper(ListNode l1, ListNode l2, int offset) {
        if (l1 == null) return null;
        //计算当前值，如果已经对齐，则为和，否则为l1的值
        ListNode result = offset == 0 ? new ListNode(l1.val + l2.val) : new ListNode(l1.val);
        //递归计算后续的值，如果已经对齐，则offset为0，否则则offset-1
        ListNode post = offset == 0 ? helper(l1.next, l2.next, 0) : helper(l1.next, l2, offset - 1);
        //如果后值大于10，则更新当前值
        if (post != null && post.val > 9) {
            result.val += 1;
            post.val = post.val % 10;
        }
        result.next = post;
        return result;
    }

    /**
     * 直接利用栈进行计算
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode list = new ListNode(0);
        while (!stack1.empty() || !stack2.empty()) {
            if (!stack1.empty()) sum += stack1.pop();
            if (!stack2.empty()) sum += stack2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }

        return list.val == 0 ? list.next : list;
    }
}

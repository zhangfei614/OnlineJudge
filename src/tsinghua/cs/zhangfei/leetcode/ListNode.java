package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by zhangfei on 2016/4/8.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){val = x;}

    public static ListNode buildListNode(int[] array){
        if(array.length == 0) return null;
        ListNode head = new ListNode(array[0]);
        ListNode p = head;
        for(int i = 1; i < array.length; i++){
            p.next = new ListNode(array[i]);
            p = p.next;
        }
        p.next = null;
        return head;
    }
}

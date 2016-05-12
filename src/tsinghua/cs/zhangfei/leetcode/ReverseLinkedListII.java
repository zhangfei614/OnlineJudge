package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by zhangfei on 2016/4/12.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) return head;
        ListNode p1,p2,p3,p4;
        if(m == 1){
            p1 = null;
            p2 = p4 = head;
            p3 = p2.next;
        }else{
            p1 = head;
            for(int i = 0; i < m -2; i++) p1=p1.next;
            p2 = p4 = p1.next;
            p3 = p2.next;
        }
        for(int i = 0; i < n-m; i++){
            ListNode temp = p3.next;
            p3.next = p2;
            p2 = p3;
            p3 = temp;
        }
        p4.next = p3;
        if(p1 == null) return p2;
        else{
            p1.next = p2;
            return head;
        }
    }

    public static void main(String[] args){
        int[] test = {3,5};
        new ReverseLinkedListII().reverseBetween(ListNode.buildListNode(test),1,2);
    }
}

package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/5/6.
 * Email:zhangfei614@126.com
 * 思路：先计算两个链表的大小，再从相同长度进行处进行判断。
 */

public class IntersectionTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        int lenA = 0, lenB = 0;

        while(pA != null){
            pA = pA.next;
            lenA++;
        }
        while(pB != null){
            pB = pB.next;
            lenB++;
        }
        pA = headA;
        pB = headB;
        if(lenA > lenB){
            for(int i = 0; i < lenA - lenB; i++) pA = pA.next;
        }else{
            for(int i = 0; i < lenB - lenA;i++) pB = pB.next;
        }
        while(pA != pB){
            pA = pA.next;
            pB = pB.next;
        }
        return pA;
    }
}

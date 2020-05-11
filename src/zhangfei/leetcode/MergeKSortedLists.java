package zhangfei.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Fei Zhang on 2016/5/23.
 * Email:zhangfei614@126.com
 */

public class MergeKSortedLists {
    public ListNode mergeKListsHeap(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        ListNode h = new ListNode(Integer.MAX_VALUE);
        ListNode p = h;
        Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(int i = 0; i < lists.length ; i++){
            if(lists[i] != null)
                queue.add(lists[i]);
        }
        while(!queue.isEmpty()){
            ListNode listNode = queue.remove();
            p.next = listNode;
            if(!queue.isEmpty()){
                ListNode nextNode = queue.element();
                while(listNode != null && listNode.val <= nextNode.val){
                    p = listNode;
                    listNode = listNode.next;
                }
                if(listNode != null) queue.add(listNode);
            }
        }
        return h.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        if(lists.length == 1) return lists[0];
        int mid = lists.length/2;
        ListNode[] left = new ListNode[mid];
        ListNode[] right = new ListNode[lists.length - mid];
        System.arraycopy(lists,0,left,0,mid);
        System.arraycopy(lists,mid,right,0,lists.length-mid);
        ListNode p = mergeKLists(left);
        ListNode q = mergeKLists(right);

        ListNode h = new ListNode(Integer.MAX_VALUE);
        ListNode t = h;
        while(p != null && q !=null){
            if(p.val < q.val){
                t.next = p;
                p = p.next;
            }else{
                t.next = q;
                q = q.next;
            }
            t = t.next;
        }
        if(p == null) t.next = q;
        else t.next = p;
        return h.next;
    }
    public static void main(String[] args){
        ListNode[] lists = new ListNode[2];
        int[] arr1 = {1,2,3,4,8,9,10};
        int[] arr2 = {5,6,7,8,11,12};
        lists[0] = ListNode.buildListNode(arr1);
        lists[1] = ListNode.buildListNode(arr2);
        ListNode listNode = new MergeKSortedLists().mergeKLists(lists);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

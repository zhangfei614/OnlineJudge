package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by zhangfei on 2016/4/8.
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 思路：采用分治递归的策略，先解决1个或者2个节点的，然后自底向上构造BST
 */
public class ConvertSortedListBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        int count = 0;
        ListNode listNode = head;
        while(listNode!=null){
            count++;
            listNode = listNode.next;
        }
        return buildBST(head,count);
    }

    private TreeNode buildBST(ListNode begin,int length){
        if(length <= 0) return null;
        if(length == 1) return new TreeNode(begin.val);
        if(length == 2){
            TreeNode treeNode = new TreeNode(begin.val);
            treeNode.right = new TreeNode(begin.next.val);
            return treeNode;
        }
        int mid = length/2+1;
        ListNode listNode = begin;
        for(int i = 0; i < mid-1; i++) listNode = listNode.next;
        TreeNode leftNode = buildBST(begin,mid-1);
        TreeNode rightNode = buildBST(listNode.next,length-mid);
        TreeNode result = new TreeNode(listNode.val);
        result.left = leftNode;
        result.right = rightNode;
        return result;
    }
}

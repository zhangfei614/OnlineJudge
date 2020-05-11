package zhangfei.leetcode;

/**
 * Created by zhangfei on 2016/4/8.
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * 思路：采用分治递归的策略，先解决1个或者2个节点的，然后自底向上构造BST
 */
public class ConvertSortedListBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        int count = 0;
        ListNode listNode = head;
        //计算链表长度
        while(listNode!=null){
            count++;
            listNode = listNode.next;
        }
        return buildBST(head,count);
    }

    private TreeNode buildBST(ListNode begin,int length){
        if(length <= 0) return null;
        //如果长度为1，说明是叶子结点，返回节点值
        if(length == 1) return new TreeNode(begin.val);
        if(length == 2){
            TreeNode treeNode = new TreeNode(begin.val);
            treeNode.right = new TreeNode(begin.next.val);
            return treeNode;
        }
        //寻找中间结点
        int mid = length/2+1;
        ListNode listNode = begin;
        for(int i = 0; i < mid-1; i++) listNode = listNode.next;
        //构建左子树
        TreeNode leftNode = buildBST(begin,mid-1);
        //构建右子树
        TreeNode rightNode = buildBST(listNode.next,length-mid);
        TreeNode result = new TreeNode(listNode.val);
        result.left = leftNode;
        result.right = rightNode;
        return result;
    }
}

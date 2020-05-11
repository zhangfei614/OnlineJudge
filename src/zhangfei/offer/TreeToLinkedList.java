package zhangfei.offer;

import zhangfei.leetcode.TreeNode;

/**
 * Created by zhangfei on 2017/7/19.
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class TreeToLinkedList {
    public TreeNode Convert(TreeNode pRootOfTree) {
        return rightOrder(pRootOfTree);
    }

    private TreeNode leftOrder(TreeNode node) {
        if (node == null) return null;
        node.left = leftOrder(node.left);
        node.right = rightOrder(node.right);
        link(node);
        while (node.right != null)
            node = node.right;
        return node;
    }

    private TreeNode rightOrder(TreeNode node) {
        if (node == null) return null;
        node.left = leftOrder(node.left);
        node.right = rightOrder(node.right);
        link(node);
        while (node.left != null)
            node = node.left;
        return node;
    }

    private void link(TreeNode node) {
        TreeNode p = node, q = p.left;
        while (q != null) {
            q.right = p;
            p = q;
            q = q.left;
        }
        p = node;
        q = p.right;
        while (q != null) {
            q.left = p;
            p = q;
            q = q.right;
        }
    }


    public static void main(String[] args) {
        Integer[] test = new Integer[]{10, 6, 14, 4, 8, 12, 16};
        TreeNode head = new TreeToLinkedList().Convert(TreeNode.buildTree(test));
        while (head != null) {
            System.out.println(head.val);
            head = head.right;
        }
    }
}

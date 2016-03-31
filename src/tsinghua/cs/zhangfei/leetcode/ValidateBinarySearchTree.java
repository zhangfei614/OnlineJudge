package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fei Zhang on 2016/3/30.
 * Email:zhangfei614@126.com
 Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 思路：利用中序遍历获得序列，根据序列是否递增。
 */

public class ValidateBinarySearchTree {
    private List<Integer> order;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        order = new ArrayList<Integer>();
        middleTravle(root);
        for(int i = 1; i < order.size(); i++){
            if(order.get(i)<=order.get(i-1)) return false;
        }
        return true;
    }

    private void middleTravle(TreeNode node){
        if(node == null ) return;
        middleTravle(node.left);
        order.add(node.val);
        middleTravle(node.right);
    }


}

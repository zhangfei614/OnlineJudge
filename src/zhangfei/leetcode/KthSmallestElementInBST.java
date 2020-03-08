package tsinghua.cs.zhangfei.leetcode;

import java.util.Stack;

/**
 * Created by Fei Zhang on 2016/3/21.
 * Email:zhangfei614@126.com
 Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

 Hint:

 Try to utilize the property of a BST.
 What if you could modify the BST node's structure?
 The optimal runtime complexity is O(height of BST).

 思路1：利用非递归的中序遍历，然后计数获得第k个最小的数。
 思路2：采用递归的中需便利，外部变量进行计数。
 思路3：在Node结点中加入size信息，利用size直接 判断第k个大小。和《算法》书中处理一致。
 */

public class KthSmallestElementInBST {

    //非递归方式
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int count = 0;
        while( root != null || !stack.empty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                TreeNode treeNode = stack.pop();
                if(++count == k) return treeNode.val;
                root = treeNode.right;
            }
        }
        return 0;
    }

    //递归方式
    private int count = 0;
    private int result = 0;
    public int kthSmallestRecursive(TreeNode root,int k){
        if(count < k && root.left != null){
            kthSmallestRecursive(root.left,k);
        }
        if(++count == k){
            result = root.val;
        }
        if(count < k && root.right != null){
            kthSmallestRecursive(root.right,k);
        }
        return result;
    }
    public static void main(String[] args){
        Integer[] array = {2,1,null};
        TreeNode root = TreeNode.buildTree(array);
        System.out.println(new KthSmallestElementInBST().kthSmallestRecursive(root,2));
    }
}

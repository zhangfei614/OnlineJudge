package zhangfei.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Fei Zhang on 2016/4/4.
 * Email:zhangfei614@126.com
 Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 思路一：层次便利，遇到一个叶子结点时结束，返回当前层数。
 思路二：递归调用minDepth，对depth为0的子树特别处理。
 */

public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int result = 1;
        int parentSize = 1;
        int childSize = 0;

        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.remove();
            if(treeNode.left == null && treeNode.right == null) return result;
            if(treeNode.left != null){
                queue.add(treeNode.left);
                childSize++;
            }
            if(treeNode.right != null){
                queue.add(treeNode.right);
                childSize++;
            }

            parentSize--;
            if(parentSize == 0){
                parentSize=childSize;
                childSize = 0;
                result++;
            }
        }
        return 0;
    }

    public int minDepthSimple(TreeNode root) {
        if(root==null){
            return 0;
        }
        int rightSide = minDepthSimple(root.right);
        int leftSide = minDepthSimple(root.left);

        if(leftSide == 0){
            return rightSide+1;
        }
        else if(rightSide == 0){
            return leftSide+1;
        }

        if(rightSide<leftSide){
            return rightSide+1;
        }
        return leftSide+1;
    }
}

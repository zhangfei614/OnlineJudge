package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Fei Zhang on 2016/4/4.
 * Email:zhangfei614@126.com
 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]
 思路1：利用BFS来层次便利一个数
 思路2：利用Java的特性，深度优先遍历，每遇到一个结点就把其加入到对应的结果集中。
 */

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;

        int parentSize = 1;
        int childSize = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode treeNode = queue.remove();
            list.add(treeNode.val);

            if(treeNode.left != null){
                childSize++;
                queue.add(treeNode.left);
            }
            if(treeNode.right != null){
                childSize++;
                queue.add(treeNode.right);
            }

            if(--parentSize == 0){
                parentSize = childSize;
                childSize = 0;
                result.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return result;
    }

    private void dfs(List<List<Integer>> result,TreeNode treeNode,int level){
        if(treeNode == null) return ;
        if(result.size() == level) result.add(new ArrayList<Integer>());
        result.get(level).add(treeNode.val);
        dfs(result,treeNode.left,level+1);
        dfs(result,treeNode.right,level+1);
    }
}

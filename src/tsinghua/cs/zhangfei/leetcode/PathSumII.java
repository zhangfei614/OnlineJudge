package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Fei Zhang on 2016/4/21.
 * Email:zhangfei614@126.com
 */

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;

        List<List<TreeNode>> stacks = new ArrayList<List<TreeNode>>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.push(root);
        int s = 0;
        while(!stack.isEmpty()){
            TreeNode treeNode = stack.firstElement();
            s += treeNode.val;
            if(treeNode.left != null){
                stack.push(treeNode.left);
                continue;
            }
            if(treeNode.right != null){
                stack.push(treeNode.right);
                continue;
            }
            if(treeNode.left == null && treeNode.right == null && s == sum ) stacks.add(new ArrayList<TreeNode>(stack));

            s -= treeNode.val;
            treeNode.left = null;
            treeNode.right= null;
            stack.pop();
        }

        for(List<TreeNode> treeNodeList : stacks){
            List<Integer> list = new ArrayList<Integer>();
            for(TreeNode treeNode : treeNodeList)
                list.add(treeNode.val);
            result.add(list);
        }
        return result;
    }
}

package zhangfei.leetcode;

import java.util.*;

/**
 * Created by Fei Zhang on 2016/4/21.
 * Email:zhangfei614@126.com
 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 思路1：利用stack来做深度优先遍历，然后将栈内的所有元素作为路径。
 思路2：
 */

public class PathSumII {
    public List<List<Integer>> pathSumStack(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;

        List<List<TreeNode>> stacks = new ArrayList<List<TreeNode>>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> visited = new HashSet<TreeNode>();

        stack.push(root);
        int s = 0;
        while(!stack.isEmpty()){
            TreeNode treeNode = stack.lastElement();
            if(!visited.contains(treeNode)){
                s += treeNode.val;
                visited.add(treeNode);
            }
            if(treeNode.left != null && !visited.contains(treeNode.left)){
                stack.add(treeNode.left);
                continue;
            }
            if(treeNode.right != null && !visited.contains(treeNode.right)){
                stack.add(treeNode.right);
                continue;
            }
            if(treeNode.left == null && treeNode.right == null && s == sum) stacks.add(new ArrayList<TreeNode>(stack));

            s -= treeNode.val;
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

    private List<List<Integer>> result ;
    private int sum;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<List<Integer>>();
        this.sum = sum;
        dfs(root,0,new ArrayList<Integer>());
        return result;
    }

    public void dfs(TreeNode treeNode,int s,List<Integer> path){
        if(treeNode == null) return;
        s += treeNode.val;
        path.add(treeNode.val);
        if(treeNode.left == null && treeNode.right == null && sum == s){
            result.add(new ArrayList<Integer>(path));
        }
        dfs(treeNode.left,s,path);
        dfs(treeNode.right,s,path);
        path.remove(path.size()-1);
    }
    public static void main(String[] args){
        Integer[] array = {0,1,1};
        TreeNode root = TreeNode.buildTree(array);
        List<List<Integer>> result = new PathSumII().pathSum(root, 1);
        for(List<Integer> list: result){
            for(Integer integer:list)
                System.out.print(" "+integer.toString());
            System.out.println();
        }
    }
}

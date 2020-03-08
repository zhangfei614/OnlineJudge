package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/5/10.
 * Email:zhangfei614@126.com
 思路：利用深度优先遍历，记录当前子树可能达到的最大值，返回子树的最大路径。
 */

public class BinaryTreeMaximumPathSum {
    private int maxRoot = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        return Math.max(dfs(root),maxRoot);
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int max = Math.max(node.val + left + right,Math.max(node.val + left,node.val + right));
        if(max > maxRoot) maxRoot = max;
        return Math.max(Math.max(node.val + left, node.val + right), node.val);
    }

    public static void main(String[] args){
        Integer[] array = {-2,6,null,0,-6};
        TreeNode root = TreeNode.buildTree(array);
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
    }
}

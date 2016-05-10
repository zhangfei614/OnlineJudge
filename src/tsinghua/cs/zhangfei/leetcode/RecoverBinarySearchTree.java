package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/5/10.
 * Email:zhangfei614@126.com
 */

public class RecoverBinarySearchTree {
    private TreeNode prev = null;
    private TreeNode first = null;
    public void recoverTree(TreeNode root) {
        if(root == null ) return ;
        dfs(root);
        dfs_print(root);
    }

    private void dfs(TreeNode node){
        if(node == null) return;
        dfs(node.left);
        if(prev == null) prev = node;
        else{
            if(prev.val > node.val){
                if(first == null) first = prev;
                else{
                    int temp = first.val;
                    first.val = node.val;
                    node.val = temp;
                }
            }
            if(first != null && node.val > first.val){
                int temp = first.val;
                first.val = prev.val;
                prev.val = temp;
            }
            prev = node;
        }
        dfs(node.right);
    }

    public static void main(String[] args){
        Integer[] array = {0,1,null};
        TreeNode root = TreeNode.buildTree(array);
        new RecoverBinarySearchTree().recoverTree(root);
    }

    private void dfs_print(TreeNode node){
        if(node == null) return;
        dfs_print(node.left);
        System.out.println(node.val);
        dfs_print(node.right);
    }
}

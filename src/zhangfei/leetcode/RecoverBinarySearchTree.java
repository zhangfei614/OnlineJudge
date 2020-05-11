package zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/5/10.
 * Email:zhangfei614@126.com
 */

public class RecoverBinarySearchTree {
    private TreeNode prev = null;
    private TreeNode first = null;
    private static TreeNode MAX_TREENODE = new TreeNode(Integer.MAX_VALUE);
    public void recoverTree(TreeNode root) {
        if(root == null ) return ;
        dfs(root);
        //无序数有可能是最后一位，可以利用强行在最后一个加入最大结点解决。
        dfs(MAX_TREENODE);
    }

    private void dfs(TreeNode node){
        if(node == null) return;
        dfs(node.left);
        if(prev == null) prev = node;
        else{
            //出现第一个无序数时，记录下来。
            if(prev.val > node.val){
                if(first == null) first = prev;
            }
            //找到无序数所处位置，必然是前面一个与其进行交换。
            if(first != null && node.val >= first.val){
                int temp = prev.val;
                prev.val = first.val;
                first.val = temp;
                first = null;
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

}

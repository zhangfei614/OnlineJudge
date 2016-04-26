package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/4/25.
 * Email:zhangfei614@126.com
 */

public class ConstructBinaryTreeInorderPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0) return null;
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder,int x,int y,int[] postorder,int m,int n){
        if(x > y || m > n) return null;
        if(x == y && m == n) return new TreeNode(inorder[x]);
        int i;
        for(i = x; i <= y; i++)
            if(inorder[i] == postorder[n]) break;
        TreeNode treeNode = buildTree(inorder,i,i,postorder,n,n);
        treeNode.left = buildTree(inorder,x,i-1,postorder,m,n-(y-i)-1);
        treeNode.right = buildTree(inorder,i+1,y,postorder,n-(y-i),n-1);
        return treeNode;
    }
}

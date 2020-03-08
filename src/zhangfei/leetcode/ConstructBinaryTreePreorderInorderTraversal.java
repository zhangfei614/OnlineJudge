package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/4/25.
 * Email:zhangfei614@126.com

 */

public class ConstructBinaryTreePreorderInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder,int x,int y,int[] inoreder,int m,int n){
        if(x > y || m > n) return null;
        if(x == y && m == n) return new TreeNode(preorder[x]);
        int i;
        for(i = m; i<=n; i++){
            if(inoreder[i]==preorder[x]) break;
        }
        TreeNode treeNode = buildTree(preorder,x,x,inoreder,i,i);
        treeNode.left = buildTree(preorder,x+1,x+i-m,inoreder,m,i-1);
        treeNode.right = buildTree(preorder,x+i-m+1,y,inoreder,i+1,n);
        return treeNode;
    }
}

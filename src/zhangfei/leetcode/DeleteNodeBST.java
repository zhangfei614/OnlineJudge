package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2017/5/17.
 * Email:zhangfei614@126.com
 */

public class DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node = root;
        TreeNode p = null;
        while(node != null && node.val != key){
            p = node;
            if(node.val < key){
                node = node.right;
            }else{
                node = node.left;
            }
        }
        if(node == null) return root;
        while(node != null){
            if(node.right == null){
                if(p == null){
                    root = node.left;
                }else{
                    if(node == p.left) p.left = node.left;
                    else p.right = node.left;
                }
                break;
            }else{
                TreeNode cur = node;
                p = node;
                node = node.right;
                while(node.left != null){
                    p = node;
                    node = node.left;
                }
                cur.val = node.val;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        new DeleteNodeBST().deleteNode(root,3);
    }
}

package zhangfei.leetcode;

/**
 * Created by zhangfei on 2016/4/8.
 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 But the following is not:
 1
 / \
 2   2
 \   \
 3    3

 思路：递归调用判断左右两个节点是否对称。
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null ) return true; //可以传入root,root来省掉这个判读。
        else return symmetricNode(root.left,root.right);
    }

    private boolean symmetricNode(TreeNode left,TreeNode right){
        if(left == null && right == null) return true;
        else if(left == null || right == null) return false;
        else if(left.val != right.val) return false;
        else return symmetricNode(left.left,right.right) && symmetricNode(left.right,right.left);
    }
}

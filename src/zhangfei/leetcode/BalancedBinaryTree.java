package zhangfei.leetcode;

/**
 * Created by zhangfei on 2016/4/8.
 *
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        int hight = hight(root);
        if(hight != -1) return true;
        else return false;
    }

    private int hight(TreeNode node){
        if(node == null) return 0;
        int leftHight = hight(node.left);
        int rightHight = hight(node.right);
        if(leftHight == -1 || rightHight == -1)
            return -1;
        else if(Math.abs(leftHight-rightHight) <= 1)
            return Math.max(leftHight,rightHight)+1;
        else
            return -1;
    }
}

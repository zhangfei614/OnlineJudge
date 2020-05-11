package zhangfei.leetcode;

import java.util.Stack;

/**
 * Created by zhangfei on 2016/5/11.
 */
public class BSTIterator {
    private Stack<TreeNode> path;
    public BSTIterator(TreeNode root) {
        path = new Stack<TreeNode>();
        push_left(root);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !path.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = path.pop();
        push_left(node.right);
        return node.val;
    }

    private void push_left(TreeNode node){
        while(node != null){
            path.push(node);
            node = node.left;
        }
    }
    public static void main(String[] args){
        Integer[] arr = {10,5,15,3,8,11,16,1,4,6,7,null,null,null,null};
        TreeNode root = TreeNode.buildTree(arr);
        BSTIterator it = new BSTIterator(root);
        while(it.hasNext()) System.out.println(it.next());
    }
}

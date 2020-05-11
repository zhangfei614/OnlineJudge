package zhangfei.leetcode;

import java.util.*;

/**
 * Created by zhangfei on 2016/3/29.
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null ) return result;
        q1.add(root);
        while(!q1.isEmpty() || !q2.isEmpty()){
            List<Integer> layer = new ArrayList<Integer>();
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    TreeNode temp = q1.remove();
                    layer.add(temp.val);
                    if(temp.left != null) q2.add(temp.left);
                    if(temp.right != null) q2.add(temp.right);
                }
                result.add(layer);
                continue;
            }
            while(!q2.isEmpty()){
                TreeNode temp = q2.remove();
                layer.add(temp.val);
                if(temp.left != null) q1.add(temp.left);
                if(temp.right != null) q1.add(temp.right);
            }
            result.add(layer);
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args){
        Integer[] test = {1,2,null};
        TreeNode root = TreeNode.buildTree(test);
        new BinaryTreeLevelOrderTraversalII().levelOrderBottom(root);
    }
}

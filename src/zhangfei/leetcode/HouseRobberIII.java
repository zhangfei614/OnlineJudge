package zhangfei.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by THU on 2016/3/14.
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

 Determine the maximum amount of money the thief can rob tonight without alerting the police.

 Example 1:
 3
 / \
 2   3
 \   \
 3   1
 Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 Example 2:
 3
 / \
 4   5
 / \   \
 1   3   1
 Maximum amount of money the thief can rob = 4 + 5 = 9.

 思路：利用DP，分情况讨论是否包括根节点和不包括根结点。
 */
public class HouseRobberIII {
    //此种方案在[4,1,null,2,null,3]下失效，并不是相隔层来进行计算。
    public int rob_wrong(TreeNode root){
        if(root == null){
            return 0;
        }
        int rootRob = 0;
        int noRootRob = 0;
        Queue<TreeNode> rootQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> noRootQueue = new LinkedList<TreeNode>();

        rootQueue.add(root);
        while(!rootQueue.isEmpty() || !noRootQueue.isEmpty()){
            if(!rootQueue.isEmpty()){
                TreeNode t = rootQueue.remove();
                rootRob += t.val;
                if(t.left != null ) noRootQueue.add(t.left);
                if(t.right != null) noRootQueue.add(t.right);
            }
            if(!noRootQueue.isEmpty()){
                TreeNode t = noRootQueue.remove();
                noRootRob += t.val;
                if(t.left != null) rootQueue.add(t.left);
                if(t.right != null) rootQueue.add(t.right);
            }
        }
        if(rootRob > noRootRob){
            return rootRob;
        }else{
            return  noRootRob;
        }
    }

    //利用递归实现，分情况讨论包含根结点和不包含根结点
    public int rob(TreeNode root){
        if(root == null) return 0;
        return Math.max(rootExclude(root),rootInclude(root));
    }

    public int rootInclude(TreeNode root){
        if(root == null) return 0;
        return rootExclude(root.left)+rootExclude(root.right)+root.val;
    }
    public int rootExclude(TreeNode root){
        if(root == null) return 0;
        return rob(root.left)+rob(root.right);
    }


    public static void main(String[] args){
        Integer[] test = {3,2,3,null,3,null,1};
        TreeNode root = TreeNode.buildTree(test);
        int result = new HouseRobberIII().rob(root);
        System.out.println(result);
    }
}



package tsinghua.cs.zhangfei.leetcode;

import java.util.*;

/**
 * Created by Fei Zhang on 2016/4/3.
 * Email:zhangfei614@126.com
 Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]
 思路：广度优先遍历，利用记录paretSize来记录每一层的个数，每一层遍历完后进行reverse。
 思路2:直接在index为0的位置添加数据，不需要reverse。
 */

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        List<Integer> list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        int parentSize = 1;
        int childSize = 0;
        boolean leftToRight = true;
        queue.add(root);
        list = new ArrayList<Integer>();
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.remove();

            list.add(treeNode.val);
            if(treeNode.left != null) {
                queue.add(treeNode.left);
                childSize++;
            }
            if(treeNode.right != null) {
                queue.add(treeNode.right);
                childSize++;
            }

            parentSize--;
            if(parentSize == 0){
                parentSize = childSize;
                childSize = 0;
                if(!leftToRight) Collections.reverse(list);
                result.add(list);
                list = new ArrayList<Integer>();
                leftToRight = !leftToRight;
            }

        }
        return result;
    }

    public static void main(String[] args){
        Integer[] test = {1,2,3,4,null,null,5};
        TreeNode root = TreeNode.buildTree(test);
        new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root);
    }
}

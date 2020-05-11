package zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/3/22.
 * Email:zhangfei614@126.com
 Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 思路1：修改树结构，将每个Node的值更改为上层的值累加和。然后将所有叶子节点的值累加。
 思路2：不修改树的结构，在写一个方法，将上层累加和作为参数传入。
 */

public class SumRootToLeafNumbers {
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null ) return 0;
        if(root.left == null && root.right == null){
            sum += root.val;
            return sum;
        }
        if(root.left != null){
            root.left.val = root.val*10 + root.left.val;
            sumNumbers(root.left);
        }
        if(root.right != null) {
            root.right.val = root.val*10 + root.right.val;
            sumNumbers(root.right);
        }
        return sum;
    }

    //solution 2
    public int sumNumbersSimple(TreeNode root){
        sumRoot(root,0);
        return sum;
    }

    private void sumRoot(TreeNode root,int val){
        if(root==null) return;
        val = val*10 + root.val;
        if(root.left==null && root.right==null){
            sum += val;
            return;
        }
        sumRoot(root.left,val);
        sumRoot(root.right,val);
    }

}

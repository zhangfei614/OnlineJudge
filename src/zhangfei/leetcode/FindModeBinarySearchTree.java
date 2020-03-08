package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fei Zhang on 2017/4/7.
 * Email:zhangfei614@126.com
 */

public class FindModeBinarySearchTree {
    private Integer pre = null;
    private int count = 0;
    private int max = Integer.MIN_VALUE;
    private List<Integer> list = new ArrayList<Integer>();

    public int[] findMode(TreeNode root) {
        if (pre != null) {
            if (count > max) {
                list.clear();
                list.add(pre);
            } else if (count == max) {
                list.add(pre);
            }
        }
        int[] result = new int[list.size()];
        int i = 0;
        for (Integer e : list) result[i++] = e.intValue();
        return result;
    }

    private void helper(TreeNode node) {
        if (node == null) return;
        helper(node.left);
        if (pre == null) {
            pre = node.val;
            count = 1;
        } else {
            if (node.val != pre) {
                if (count > max) {
                    max = count;
                    count = 1;
                    list.clear();
                    list.add(pre);
                } else if (count == max) {
                    count = 1;
                    list.add(pre);
                }
            } else {
                count++;
            }
        }
        helper(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(new Integer[]{1, null, 2, 2});
    }
}

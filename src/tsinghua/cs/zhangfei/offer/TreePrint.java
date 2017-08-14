package tsinghua.cs.zhangfei.offer;

import tsinghua.cs.zhangfei.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangfei on 2017/8/7.
 */
public class TreePrint {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(pRoot);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                res.add(list);
                list = new ArrayList<>();
                if (!queue.isEmpty()) queue.add(null);
            } else {
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        System.out.println(Arrays.toString(res.toArray()));
    }
}

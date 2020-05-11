package zhangfei.offer;

import zhangfei.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by zhangfei on 2017/8/7.
 */
public class ZPrintTree {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        boolean flag = false;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.add(pRoot);
        res.add(convert(new ArrayList<>(s1)));
        while (!s1.empty()) {
            TreeNode node = s1.pop();
            if (flag) {
                if (node.left != null) s2.add(node.left);
                if (node.right != null) s2.add(node.right);
            } else {
                if (node.right != null) s2.add(node.right);
                if (node.left != null) s2.add(node.left);
            }
            if (s1.empty() && !s2.empty()) {
                ArrayList<TreeNode> treeNodes = new ArrayList<>(s2);
                res.add(convert(treeNodes));
                flag = !flag;
                s1 = s2;
                s2 = new Stack<>();
            }
        }
        return res;
    }

    private ArrayList<Integer> convert(ArrayList<TreeNode> nodes) {
        ArrayList<Integer> res = new ArrayList<>();
        for (TreeNode node : nodes) res.add(node.val);
        return res;
    }

}

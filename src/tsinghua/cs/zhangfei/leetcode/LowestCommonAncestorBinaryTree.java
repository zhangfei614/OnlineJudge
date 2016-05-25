package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangfei on 2016/5/12.
 * 思路：记录查找p,q的查找路径，然后比对路径获得共同祖先。
 */
public class LowestCommonAncestorBinaryTree {
    public TreeNode lowestCommonAncestorComplex(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;
        List<TreeNode> pPath = new ArrayList<TreeNode>();
        List<TreeNode> qPath = new ArrayList<TreeNode>();
        lookPath(root,p,pPath);
        lookPath(root,q,qPath);
        for(int i = 0; i < pPath.size() && i < qPath.size(); i++){
            if(pPath.get(i)!=qPath.get(i)) return pPath.get(i-1);
        }
        if(pPath.size() < qPath.size()) return pPath.get(pPath.size()-1);
        else return qPath.get(qPath.size()-1);
    }

    private void lookPath(TreeNode node, TreeNode p,List<TreeNode> list){
        list.add(node);
        if(node == p) return;
        if(node.left != null && list.get(list.size()-1)!=p)
            lookPath(node.left,p,list);
        if(node.right != null && list.get(list.size()-1)!=p)
            lookPath(node.right,p,list);
        if(list.get(list.size()-1) != p)
            list.remove(list.size()-1);
    }

    /**
     * @param root
     * @param p
     * @param q
     * @return
     * 这才是真真的算法，我晕~~。遇到查找问题，尽量向分治靠。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        //如果查找到一个，则无论是否在在子树内都返回。在子树内，则说明已经找到，不在子树内，则不需要继续查找。
        if(root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //如果left和right都有值，说明在不同的子树内，所以返回root。如果有一侧子树为空，则说明没有查找到。
        return left != null && right != null ? root : left != null ? left : right;
    }

    public static void main(String[] args){
        Integer[] array = {1,2,null};
        TreeNode root = TreeNode.buildTree(array);
        System.out.println(new LowestCommonAncestorBinaryTree().lowestCommonAncestor(root,root,root.left).val);
    }
}

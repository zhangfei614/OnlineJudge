package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/5/11.
 * Email:zhangfei614@126.com
 */

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int hleft = 0, hright = 0;
        TreeNode left = root,right = root;
        while(left != null){ hleft++; left = left.left;}
        while(right != null){ hright++; right = right.right;}
        //如果左子树树高等于右子树树高，则是一颗满树。所以直接返回树的节点个数。
        if(hleft == hright) return (1 << hleft) -1;
        //如果不等于，递归调用时，其子树必然有一个是满树。因此会在上一行就返回，所以整体复杂度应该为O(lgN*lgN)
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int countNodes_NonRecursicve(TreeNode root){
        int res = 0;
        int lh = 0 , rh = 0;
        while(root != null){
            if(lh == 0)
                for(TreeNode p = root.left; p != null ; p = p.left) lh++;
            if(rh == 0)
                for(TreeNode p = root.right; p != null ; p = p.left) rh++;

            //左子树是满的，右子树不确定满不满，因此应迭代右子树。
            if(lh == rh){
                res += 1<<lh;
                root = root.right;
            }else{
                //右子树是满的，左子树不确定满不满，因此应迭代左子树。
                res += 1<<rh;
                root = root.left;
            }
            //每一次迭代后，都需要重新计算右子树的高度。
            --lh;
            rh = 0;
        }
        return res;
    }

}

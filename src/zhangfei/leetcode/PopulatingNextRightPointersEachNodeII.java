package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/4/25.
 * Email:zhangfei614@126.com
 */

public class PopulatingNextRightPointersEachNodeII {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        while(root != null){
            TreeLinkNode temp = root;
            TreeLinkNode next = null;
            while(temp != null){
                if(temp.left != null){
                    if(temp.right != null) temp.left.next = temp.right;
                    else{
                        TreeLinkNode t = temp.next;
                        while(t != null && t.left == null && t.right == null) t = t.next;
                        if(t == null) temp.left.next = null;
                        else if(t.left != null) temp.left.next = t.left;
                        else if(t.right != null) temp.left.next = t.right;
                    }
                    if(next == null) next = temp.left;
                }
                if(temp.right != null){
                    TreeLinkNode t = temp.next;
                    while(t != null && t.left == null && t.right == null) t = t.next;
                    if(t == null) temp.right.next = null;
                    else if(t.left != null) temp.right.next = t.left;
                    else if(t.right != null) temp.right.next = t.right;
                    if(next == null ) next = temp.right;
                }
                temp = temp.next;
            }
            root = next;
        }
    }

    public static void main(String[] args){
        Integer[] array = {1,2,3,4,5,null,6,7,null,null,null,null,8};
        TreeLinkNode root = TreeLinkNode.buildTree(array);
        new PopulatingNextRightPointersEachNodeII().connect(root);
    }
}

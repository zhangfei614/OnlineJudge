package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/4/21.
 * Email:zhangfei614@126.com
 */

public class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }

    public static TreeLinkNode buildTree(int n){
        TreeLinkNode[] array = new TreeLinkNode[n];
        for(int i = 0; i < n; i++) array[i] = new TreeLinkNode(i);
        for(int i = 0; i < n/2;i++) {
            array[i].left = array[2*i+1];
            array[i].right = array[2*i+2];
        }
        return array[0];
    }
}

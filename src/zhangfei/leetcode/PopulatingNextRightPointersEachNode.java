package zhangfei.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Fei Zhang on 2016/4/21.
 * Email:zhangfei614@126.com
 * Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 For example,
 Given the following perfect binary tree,
 1
 /  \
 2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL
 思路1：利用BFS层次便利，每一个元素等于队列头元素。
 思路2：利用上一层已经构造的信心，每一层便利，然后构建下一层！！！（太难想）
 */

public class PopulatingNextRightPointersEachNode {
    public void connectBFS(TreeLinkNode root) {
        if(root == null) return;
        int parentSize = 1;
        int childSize = 0;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeLinkNode treeLinkNode = queue.remove();
            parentSize--;
            if(treeLinkNode.left != null){
                queue.add(treeLinkNode.left);
                childSize++;
            }
            if(treeLinkNode.right != null){
                queue.add(treeLinkNode.right);
                childSize++;
            }

            if(parentSize == 0){
                treeLinkNode.next = null;
                parentSize = childSize;
                childSize = 0;
            }else{
                treeLinkNode.next = queue.peek();
            }
        }
    }

    public void connect(TreeLinkNode root){
        if(root == null) return;
        while(root.left != null){
            TreeLinkNode temp = root;
            while(temp != null){
                temp.left.next = temp.right;
                if(temp.next != null) temp.right.next = temp.next.left;
                temp = temp.next;
            }
            root = root.left;
        }
    }

    public static void main(String[] args){
        TreeLinkNode root = TreeLinkNode.buildTree(7);
        new PopulatingNextRightPointersEachNode().connect(root);
    }
}

package zhangfei.leetcode;

/**
 * Created by zhangfei on 2016/4/8.
 Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:
 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6
 思路：找到左子树的最后一个元素，将有子树挂到该元素的右节点。
 */
public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode node = root;
        while(node != null ){
            if(node.left != null){
                TreeNode last = lastElement(node.left);
                last.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }

    private TreeNode lastElement(TreeNode root){
        TreeNode result = root;
        while(result.left != null || result.right != null){
            if(result.right != null){
                result = result.right;
                continue;
            }else{
                result = result.left;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Integer[] array = {1,2,null,null,3};
        TreeNode root = TreeNode.buildTree(array);
        new FlattenBinaryTreetoLinkedList().flatten(root);
    }
}

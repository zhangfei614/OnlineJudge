package zhangfei.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Fei Zhang on 2016/5/12.
 * Email:zhangfei614@126.com
 */

public class BinaryTreeTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        push_left(root,stack);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null) push_left(node.right,stack);
        }
        return result;
    }

    private void push_left(TreeNode node,Stack<TreeNode> stack){
        while(node != null){stack.push(node); node = node.left;}
    }

    class Node{
        boolean flag;
        TreeNode treeNode;
        public Node(TreeNode treeNode){this.treeNode = treeNode;this.flag = false;}
        public void visit(){this.flag = true;}
        public boolean isVisited(){return this.flag;}
    }

    //用一位标识该节点是否访问完成。
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<Node> stack = new Stack<Node>();
        stack.push(new Node(root));
        while(!stack.isEmpty()){
            Node node = stack.peek();
            if(node.isVisited()) {
                result.add(node.treeNode.val);
                stack.pop();
            }else{
                if(node.treeNode.right != null) stack.push(new Node(node.treeNode.right));
                if(node.treeNode.left != null) stack.push(new Node(node.treeNode.left));
                node.visit();
            }
        }
        return result;
    }

    public List<Integer> postorderTraversalInsert(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        if(root == null ) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(0,node.val);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return result;
    }
    public static void main(String[] args){
        Integer[] array = {1,2,null};
        TreeNode root = TreeNode.buildTree(array);
        new BinaryTreeTraversal().postorderTraversal(root);
    }
}

package tsinghua.cs.zhangfei.leetcode;


import java.util.StringTokenizer;

/**
 * Created by Fei Zhang on 2016/5/15.
 * Email:zhangfei614@126.com
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * 思路1：采用先序和中序遍历，然后利用这两个遍历恢复，但出现运行时错误，不知道为啥？超时？
 * 思路2：采用先序遍历，将空数据也记录为一个特殊位，恢复时也采用相同的顺序，因此递归调用。
 */

public class SerializeDeserializeBinaryTree {
    /*
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        List<Integer> preorder = new ArrayList<Integer>();
        List<Integer> inorder = new ArrayList<Integer>();
        dfs(root,preorder,inorder);
        return serializeList(preorder)+';'+serializeList(inorder);
    }

    private void dfs(TreeNode node,List<Integer> preorder,List<Integer> inorder){
        preorder.add(node.val);
        if(node.left != null) dfs(node.left,preorder,inorder);
        inorder.add(node.val);
        if(node.right != null) dfs(node.right,preorder,inorder);
    }

    private String serializeList(List<Integer> list){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            if(i != 0) sb.append(',');
            sb.append(list.get(i).toString());
        }
        return sb.toString();
    }

    private Integer[] deserializeList(String s){
        List<Integer> list = new ArrayList<Integer>();
        for(String i : s.split(","))
            list.add(Integer.valueOf(i));
        Integer[] res = new Integer[list.size()];
        return list.toArray(res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.equals("")) return null;
        String[] travels = data.split(";");
        Integer[] preorder = deserializeList(travels[0]);
        Integer[] inorder = deserializeList(travels[1]);
        return buildTree(preorder,inorder);
    }

    private TreeNode buildTree(Integer[] preorder, Integer[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode buildTree(Integer[] preorder,int x,int y,Integer[] inoreder,int m,int n){
        if(x > y || m > n) return null;
        if(x == y && m == n) return new TreeNode(preorder[x]);
        int i;
        for(i = m; i<=n; i++){
            if(inoreder[i]==preorder[x]) break;
        }
        TreeNode treeNode = buildTree(preorder,x,x,inoreder,i,i);
        treeNode.left = buildTree(preorder,x+1,x+i-m,inoreder,m,i-1);
        treeNode.right = buildTree(preorder,x+i-m+1,y,inoreder,i+1,n);
        return treeNode;
    }
*/

    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    private void serialize(TreeNode node,StringBuilder sb){
        if(node == null)
            sb.append("#").append(",");
        else{
            sb.append(node.val).append(",");
            serialize(node.left,sb);
            serialize(node.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.equals("")) return null;
        StringTokenizer st = new StringTokenizer(data,",");
        return deserialize(st);
    }

    private TreeNode deserialize(StringTokenizer st){
        if(!st.hasMoreTokens())
            return null;
        String s = st.nextToken();
        if(s.equals("#"))
            return null;
        TreeNode node = new TreeNode(Integer.valueOf(s));
        node.left = deserialize(st);
        node.right = deserialize(st);

        return node;
    }
    public static void main(String[] args){
        Integer[] arr = {1, 10, null, 9, 11};
        TreeNode root = TreeNode.buildTree(arr);
        long begin = System.currentTimeMillis();
        SerializeDeserializeBinaryTree s = new SerializeDeserializeBinaryTree();
        String code = s.serialize(root);
        System.out.println(code);
        TreeNode node = s.deserialize(code);
        System.out.println((System.currentTimeMillis()-begin)+"ms");
        s.dfs_print(node);
    }

    private void dfs_print(TreeNode node){
        if(node == null) return;
        System.out.println(node.val);
        dfs_print(node.left);
        dfs_print(node.right);
    }
}

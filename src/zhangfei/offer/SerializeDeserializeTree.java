package zhangfei.offer;

import zhangfei.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangfei on 2017/8/7.
 */
public class SerializeDeserializeTree {
    String Serialize(TreeNode root) {
        List<Integer> preList = new ArrayList<>();
        List<Integer> inList = new ArrayList<>();
        preOrder(root, preList);
        inOrder(root, inList);
        if (preList.size() == 0 || inList.size() == 0)
            return "";
        return listToString(preList) + "#" + listToString(inList);
    }

    TreeNode Deserialize(String str) {
        if (str == null || str.equals(""))
            return null;
        String[] strs = str.split("#");
        return null;
    }

    private String listToString(List<Integer> list) {
        String str = Arrays.toString(list.toArray());
        return str.substring(str.indexOf('['), str.lastIndexOf(']'));
    }

    private int[] stringToArray(String str) {
        String[] strs = str.split(",");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) arr[i] = Integer.valueOf(strs[i]);
        return arr;
    }

    private void preOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }


    private TreeNode reCons(int[] pre, int ps, int pe, int[] in, int is, int ie) {
        if (pe < ps || ie < is) return null;
        int index = is, target = pre[ps];
        for (int i = is; i <= ie; i++) {
            if (in[i] == target) {
                index = i;
                break;
            }
        }
        TreeNode node = new TreeNode(target);
        node.left = reCons(pre, ps + 1, ps + (index - is), in, is, index - 1);
        node.right = reCons(pre, ps + (index - is) + 1, pe, in, index + 1, ie);
        return node;
    }

    public static void main(String[] args) {

    }
}

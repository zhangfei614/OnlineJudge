package zhangfei.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fei Zhang on 2016/4/4.
 * Email:zhangfei614@126.com
 *
 Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,
 1            <---
 /   \
 2     3         <---
 \     \
 5     4       <---
 You should return [1, 3, 4].
 思路1：每层保留一个数字，不断替换。
 思路2：层次便利，两层循环，略过不关心的结点。
 */

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        dfs(result,root,0);
        return result;
    }

    private void dfs(List<Integer> result,TreeNode treeNode,int level){
        if(treeNode == null) return;
        if(result.size() == level){
            result.add(treeNode.val);
        }else{
            result.set(level,treeNode.val);
        }
        dfs(result,treeNode.left,level+1);
        dfs(result,treeNode.right,level+1);
    }
}

package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayList;

/**
 * Created by THU on 2016/3/14.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static TreeNode buildTree(Integer[] array){
        if(array.length != 0){
            ArrayList<TreeNode> treeNodeArrayList = new ArrayList<TreeNode>();
            for(int i=0;i<array.length;i++){
                if(array[i]!=null){
                    treeNodeArrayList.add(new TreeNode(array[i]));
                }else{
                    treeNodeArrayList.add(null);
                }
            }
            for(int i=0;i<treeNodeArrayList.size()/2;i++){
                if(treeNodeArrayList.get(i)!=null){
                    treeNodeArrayList.get(i).left = (i*2+1 < treeNodeArrayList.size() ? treeNodeArrayList.get(i*2+1):null);
                    treeNodeArrayList.get(i).right = (i*2+2 < treeNodeArrayList.size() ? treeNodeArrayList.get(i*2+2):null);
                }
            }
            return treeNodeArrayList.get(0);
        }else{
            return null;
        }
    }
}

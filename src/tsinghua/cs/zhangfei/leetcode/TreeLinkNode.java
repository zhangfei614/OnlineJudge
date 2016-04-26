package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayList;

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

    public static TreeLinkNode buildTree(Integer[] array){
        if(array.length != 0){
            ArrayList<TreeLinkNode> treeNodeArrayList = new ArrayList<TreeLinkNode>();
            for(int i=0;i<array.length;i++){
                if(array[i]!=null){
                    treeNodeArrayList.add(new TreeLinkNode(array[i]));
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

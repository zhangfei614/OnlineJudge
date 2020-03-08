package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fei Zhang on 2016/5/12.
 * Email:zhangfei614@126.com
 * 思路：利用动态规划求解n长度的，分割成两部分。
 */

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n == 0) return 0;
        int[] record = new int[n+1];
        record[0] = 1;
        record[1] = 1;
        //依次求长度为2到长度为n的方案数
        for(int k = 2; k <= n; k++){
            //对每一个点进行分割
            for(int i = 1; i <= k ; i++)
                //左边子树方案数*右边子树方案数，每一个子问题都已经求解。
                record[k]+=(record[i-1]*record[k-i]);
        }
        return record[n];
    }

    public static void main(String[] args){
        System.out.println(new UniqueBinarySearchTrees().numTrees(3));
    }

    //采用动态规划算法，利用前面的构造后面的，复杂度较低。
    public List<TreeNode> generateTreesDP(int n) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(n == 0) return result;
        List[][] record = new List[n][n];
        for(int i = 0; i < n; i++){
            record[i][i] = new ArrayList<TreeNode>();
            record[i][i].add(new TreeNode(i+1));
            for(int j = i+1; j < n; j++) record[i][j] = new ArrayList<TreeNode>();
        }
        for(int k = 2; k <= n; k++){
            for(int i = 0; i <= n-k; i++){
                for(Object right : record[i+1][i+k-1]){
                    TreeNode node = new TreeNode(i+1);
                    node.left = null;
                    node.right = (TreeNode)right;
                    record[i][i+k-1].add(node);
                }
                for(int j = i+1 ; j < i+k-1; j++){
                    for(Object left: record[i][j-1])
                        for(Object right:record[j+1][i+k-1]){
                            TreeNode node = new TreeNode(j+1);
                            node.left = (TreeNode)left;
                            node.right = (TreeNode)right;
                            record[i][i+k-1].add(node);
                        }
                }
                for(Object left:record[i][i+k-2]){
                    TreeNode node = new TreeNode(i+k);
                    node.left = (TreeNode)left;
                    node.right = null;
                    record[i][i+k-1].add(node);
                }
            }
        }
        return record[0][n-1];
    }

    //采用递归深度优先的思路来进行计算，但复杂度较高，因为含有重复计算的子问题。
    public List<TreeNode> generateTrees(int n) {
        if(n == 0 ) return new ArrayList<TreeNode>();
        return help(1,n);
    }
    private List<TreeNode> help(int a,int b){
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(a>b){
            res.add(null);
        }else{
            for(int i = a; i <= b; i++){
                List<TreeNode> leftList = help(a,i-1);
                List<TreeNode> rightList = help(i+1,b);
                for(TreeNode left : leftList)
                    for(TreeNode right: rightList){
                        TreeNode node = new TreeNode(i);
                        node.left = left;
                        node.right = right;
                        res.add(node);
                    }
            }
        }
        return res;
    }
}

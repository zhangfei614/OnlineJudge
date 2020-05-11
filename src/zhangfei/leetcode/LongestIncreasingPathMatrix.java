package zhangfei.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Fei Zhang on 2016/4/26.
 * Email:zhangfei614@126.com
 * 思路1：将所有元素排序，从大到小进行依次扩展周围四个元素。
 * 思路2: 利用dfs遍历所有元素即可，每次遇到比它小且没有访问的元素则递归调用dfs。
 */

class Node implements Comparable<Node>{
    int data;
    int i,j;
    public Node(int data,int i,int j){
        this.data = data;
        this.i = i;
        this.j = j;
    }

    @Override
    public int compareTo(Node o) {
        return o.data - this.data;
    }
}
public class LongestIncreasingPathMatrix {

    public int longestIncreasingPathSort(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        List<Node> list = new ArrayList<Node>();
        int[][] paths = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length; j++){
                list.add(new Node(matrix[i][j],i,j));
                paths[i][j]=1;
            }

        Collections.sort(list);
        int max = 0;
        for(Node node:list){
            if(node.i-1 >= 0 && matrix[node.i-1][node.j] > node.data && paths[node.i][node.j] <= paths[node.i-1][node.j])
                paths[node.i][node.j] = paths[node.i-1][node.j] + 1;
            if(node.i+1 < matrix.length && matrix[node.i+1][node.j] > node.data && paths[node.i][node.j] <= paths[node.i+1][node.j])
                paths[node.i][node.j] = paths[node.i+1][node.j] + 1;
            if(node.j-1 >= 0 && matrix[node.i][node.j-1] > node.data && paths[node.i][node.j] <= paths[node.i][node.j-1])
                paths[node.i][node.j] = paths[node.i][node.j-1] + 1;
            if(node.j+1 < matrix[node.i].length && matrix[node.i][node.j+1] > node.data && paths[node.i][node.j] <= paths[node.i][node.j+1])
                paths[node.i][node.j] = paths[node.i][node.j+1] + 1;
            if(paths[node.i][node.j] > max)
                max = paths[node.i][node.j];
        }

        return max;
    }

    private static int[][] shifs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int[][] longestPath = new int[matrix.length][matrix[0].length];
        int result = 0;
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++){
                if(longestPath[i][j] == 0)
                    dfs(matrix,i,j,longestPath);
                result = Math.max(result,longestPath[i][j]);
            }
        return result;
    }

    private void dfs(int[][] matrix,int x,int y,int[][] longestPath){
        longestPath[x][y] = 1;
        for(int[] shif:shifs){
            int newX = x + shif[0];
            int newY = y + shif[1];

            if(newX < matrix.length && newX >= 0 && newY < matrix[0].length && newY >= 0 && matrix[x][y] < matrix[newX][newY]){
                if(longestPath[newX][newY] == 0){
                    dfs(matrix,newX,newY,longestPath);
                }
                longestPath[x][y] = Math.max(longestPath[x][y],1+longestPath[newX][newY]);
            }
        }
    }
    public static void main(String[] args){
        int[][] matrix = {
        {9,9,4},
                {6, 6, 8},
                {2, 1, 1}
        };
        System.out.println(new LongestIncreasingPathMatrix().longestIncreasingPath(matrix));
    }
}

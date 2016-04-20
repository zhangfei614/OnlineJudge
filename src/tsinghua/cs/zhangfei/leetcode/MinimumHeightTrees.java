package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Fei Zhang on 2016/4/20.
 * Email:zhangfei614@126.com
 */

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        boolean[][] matrix = new boolean[n][n];
        int[] path = new int[n];
        int[] edgeTo = new int[n];
        int maxPath = 0;

        for(int i = 0; i < edges.length; i++){
            matrix[edges[i][0]][edges[i][1]] = true;
            matrix[edges[i][1]][edges[i][0]] = true;
        }

        for(int i  = 0; i < n; i++){
            path[i] = -1;
            edgeTo[i] = -1;
        }

        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(0);
        path[0] = 0;
        edgeTo[0] = 0;

        while(!queue.isEmpty()){
            int w = queue.remove().intValue();
            for(int v = 0; v < n; v++){
                if(matrix[w][v] && path[v] == -1){
                    path[v] = path[w]+1;
                    if(path[v] > maxPath) maxPath = path[v];
                    edgeTo[v] = w;
                    queue.add(v);
                }
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int v = 0; v < n; v++)
            if(path[v] == maxPath){
                int w = v;
                for(int i = 0; i < maxPath/2; i++) w = edgeTo[w];
                if(!result.contains(w)) result.add(w);
                if(maxPath % 2 == 1) w = edgeTo[w];
                if(!result.contains(w)) result.add(w);
            }
        return result;
    }

}

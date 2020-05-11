package zhangfei.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fei Zhang on 2016/4/20.
 * Email:zhangfei614@126.com
 For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

 Format
 The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

 You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

 Example 1:

 Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

 0
 |
 1
 / \
 2   3
 return [1]

 Example 2:

 Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

 0  1  2
 \ | /
 3
 |
 4
 |
 5
 return [3, 4]
 return [3, 4]

 For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

 Format
 The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

 You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

 Example 1:

 Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

 0
 |
 1
 / \
 2   3
 return [1]

 Example 2:

 Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

 0  1  2
 \ | /
 3
 |
 4
 |
 5
 思路：最后含有两个根节点，并且依次删除叶节点即可得到。反向利用BFS算法。
 */

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> leaves = new ArrayList<Integer>();
        if(n == 0) return leaves;
        if(n == 1){
            leaves.add(0);
            return leaves;
        }

        List<Integer>[] graph = new ArrayList[n];

        for(int i  = 0; i < n; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < edges.length;i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        for(int i = 0; i < n; i++)
            if(graph[i].size() == 1)
                leaves.add(i);

        int count  = n;
        while(count > 2){
            count -= leaves.size();
            List<Integer> newLeaves = new ArrayList<Integer>();
            for(int i = 0; i < leaves.size(); i++){
                int leaf = leaves.get(i);
                int toRemove = graph[leaf].get(0);
                graph[toRemove].remove(Integer.valueOf(leaf));
                if(graph[toRemove].size() == 1) newLeaves.add(toRemove);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}

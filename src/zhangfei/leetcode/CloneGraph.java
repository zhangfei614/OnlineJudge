package tsinghua.cs.zhangfei.leetcode;

import java.util.*;

/**
 * Created by Fei Zhang on 2016/4/13.
 * Email:zhangfei614@126.com
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * 思路：广度优先遍历该图，注意形成的自环，另外不能一条边遍历两边，因此在获得neighbor时就应该标记已访问。
 * 思路2：利用广度优先遍历改图，更快，也更容易理解。
 */

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<Integer,UndirectedGraphNode> newNodes = new HashMap<Integer,UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Set<Integer> visited = new HashSet<Integer>();
        queue.add(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode n = queue.remove();
            if(!newNodes.containsKey(n.label)){
                newNodes.put(n.label,new UndirectedGraphNode(n.label));
            }
            UndirectedGraphNode newN = newNodes.get(n.label);
            for(UndirectedGraphNode neighbor:n.neighbors){
                if(neighbor.label != n.label && !visited.contains(neighbor.label)){
                    queue.add(neighbor);
                    visited.add(neighbor.label);
                }
                if(!newNodes.containsKey(neighbor.label)){
                    newNodes.put(neighbor.label,new UndirectedGraphNode(neighbor.label));
                }
                newN.neighbors.add(newNodes.get(neighbor.label));
            }
            visited.add(n.label);
        }
        return newNodes.get(node.label);
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode node,Map<Integer,UndirectedGraphNode> graphNodeMap){
        if(node == null) return null;
        if(graphNodeMap.containsKey(node.label)) return graphNodeMap.get(node.label);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        graphNodeMap.put(newNode.label,newNode);
        for(UndirectedGraphNode neighbor : node.neighbors)
            newNode.neighbors.add(dfs(newNode,graphNodeMap));
        return newNode;
    }
}

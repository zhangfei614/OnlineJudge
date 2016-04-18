package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Fei Zhang on 2016/4/13.
 * Email:zhangfei614@126.com
 */

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<Integer,UndirectedGraphNode> hashMap = new HashMap<Integer, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

        UndirectedGraphNode s = new UndirectedGraphNode(node.label);
        s.neighbors = new ArrayList<UndirectedGraphNode>(node.neighbors);


        return s;
    }
}

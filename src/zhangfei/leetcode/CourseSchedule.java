package zhangfei.leetcode;

import java.util.ArrayList;

/**
 * Created by Fei Zhang on 2016/4/7.
 * Email:zhangfei614@126.com
 here are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 思路：判断是否为有向无环图，利用onStack记录在调用栈上的点，然后如果遇上栈上的点，则说明存在环。
 思路2：不使用矩阵来表示图，而是使用ArrayList来表示。
 */

public class CourseSchedule {
//    private boolean[] marked;
//    private boolean[] onStack;
//    private boolean hasCycle;
//    private boolean[][] graph;
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        if(numCourses == 0) return true;
//
//        marked = new boolean[numCourses];
//        onStack = new boolean[numCourses];
//        hasCycle = false;
//        graph = new boolean[numCourses][numCourses];
//        for(int i = 0; i < prerequisites.length; i++)
//            graph[prerequisites[i][0]][prerequisites[i][1]] = true;
//        for(int s = 0; s < numCourses; s++){
//            if(!marked[s])
//                dfs(graph,s);
//        }
//        return !hasCycle;
//    }
//
//    private void dfs(boolean[][] graph,int v){
//        marked[v]=true;
//        onStack[v]=true;
//        for(int i = 0; i < graph[v].length ; i++){
//            if(graph[v][i]){
//                if(hasCycle) return;
//                if(!marked[i])
//                    dfs(graph,i);
//                else if(onStack[i]) hasCycle=true;
//            }
//
//        }
//        onStack[v]=false;
//    }
    private boolean[] marked;
    private boolean[] onStack;
    private boolean hasCycle;
    private ArrayList<Integer>[] graph;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return true;

        marked = new boolean[numCourses];
        onStack = new boolean[numCourses];
        hasCycle = false;
        graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) graph[i] = new ArrayList<Integer>();
        for(int[] edge:prerequisites) graph[edge[0]].add(edge[1]);
        for(int s = 0; s < numCourses; s++){
            if(!marked[s])
                dfs(graph,s);
        }
        return !hasCycle;
    }

    private void dfs(ArrayList<Integer>[] graph,int v){
        marked[v]=true;
        onStack[v]=true;
        for(int w : graph[v]){
            if(hasCycle) return;
            if(!marked[w])
                dfs(graph,w);
            else if(onStack[w]) hasCycle=true;
        }
        onStack[v]=false;
    }
}

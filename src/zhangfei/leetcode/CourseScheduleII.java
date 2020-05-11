package zhangfei.leetcode;

import java.util.ArrayList;

/**
 * Created by Fei Zhang on 2016/4/11.
 * Email:zhangfei614@126.com
 */

public class CourseScheduleII {
//    private boolean[] marked;
//    private boolean[] onStack;
//    private boolean hasCycle;
//    private ArrayList<Integer>[] graph;
//    private Stack<Integer> reversePost;
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        reversePost = new Stack<Integer>();
//        marked = new boolean[numCourses];
//        onStack = new boolean[numCourses];
//        hasCycle = false;
//        graph = new ArrayList[numCourses];
//        for(int i = 0; i < numCourses; i++) graph[i] = new ArrayList<Integer>();
//        for(int[] edge:prerequisites) graph[edge[1]].add(edge[0]);
//        for(int s = 0; s < numCourses; s++){
//            if(!marked[s])
//                dfs(graph,s);
//        }
//        if(hasCycle) reversePost.clear();
//        int[] result = new int[reversePost.size()];
//        for(int i = 0; i < result.length; i++) result[i]= reversePost.pop().intValue();
//        return result;
//    }
//
//    private void dfs(ArrayList<Integer>[] graph,int v){
//        marked[v]=true;
//        onStack[v]=true;
//        for(int w : graph[v]){
//            if(hasCycle) return;
//            if(!marked[w])
//                dfs(graph,w);
//            else if(onStack[w]) hasCycle=true;
//        }
//        onStack[v]=false;
//        reversePost.push(v);
//    }
    private boolean[] marked;
    private boolean[] onStack;
    private boolean hasCycle;
    private ArrayList<Integer>[] graph;
    private int[] result;
    private int size;
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        size = numCourses;
        result = new int[numCourses];
        marked = new boolean[numCourses];
        onStack = new boolean[numCourses];
        hasCycle = false;
        graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) graph[i] = new ArrayList<Integer>();
        for(int[] edge:prerequisites) graph[edge[1]].add(edge[0]);
        for(int s = 0; s < numCourses; s++){
            if(!marked[s])
                dfs(graph,s);
        }
        if(hasCycle) return null;
        else return result;
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
        result[--size]=v;
    }
}

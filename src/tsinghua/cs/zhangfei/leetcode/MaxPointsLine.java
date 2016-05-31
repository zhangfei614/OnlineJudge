package tsinghua.cs.zhangfei.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangfei on 2016/5/31.
 */
public class MaxPointsLine {
    static class  Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public int maxPoints(Point[] points) {
        if(points == null ) return 0;
        if(points.length < 3) return points.length;
        int n = points.length;
        Set[][] table = new Set[n][n];
        for(int i = 0; i < n; i++)
            for(int j = i+1; j < n; j++)
                table[i][j] = new HashSet<Integer>();
        for(int k = 2; k<=n; k++){
            for(int i = 0; i <= n-k; i++){
                int j = i+k-1;
                //对没两个点进行判断。
                table[i][j].add(i);
                table[i][j].add(j);
                for(int p = j+1; p < n ; p++)
                    if(!table[i][j].contains(p)){
                        if(isSameLine(points[i],points[j],points[p])){
                            //如果第三个点和前两个点一致，则加入。
                            if(isSamePoint(points[i],points[j])&&isSamePoint(points[j],points[p]))
                                table[i][j].add(p);
                            //如果前两个点相同，则不加入
                            if(!isSamePoint(points[i],points[j]))
                                table[i][j].add(p);
                            //如果后两个点相同，则不加入
                            if(!isSamePoint(points[i],points[p]))
                                table[i][p].add(j);
                            if(!isSamePoint(points[j],points[p]))
                                table[j][p].add(i);
                        }
                    }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
            for(int j = i+1; j < n; j++)
                if(table[i][j].size() > max)
                    max = table[i][j].size();
        return max;
    }

    public int maxPointsSimple(Point[] points){
        if(points == null ) return 0;
        if(points.length < 3) return points.length;
        int max = Integer.MIN_VALUE;
        int n = points.length;
        for(int i = 0; i < n-2; i++){
            int dup = 0;
            for(int j = i+1; j < n; j++){
                int count = 0;
                if(isSamePoint(points[i],points[j])){
                    dup++;
                }else{
                    count = 1;
                    for(int k = j+1; k < n; k++){
                        if(isSameLine(points[i],points[j],points[k])) count++;
                    }
                }
                max = Math.max(max,count+dup+1);
            }
        }
        return max;
    }

    private boolean isSamePoint(Point p1,Point p2){
        return p1.x == p2.x && p1.y == p2.y;
    }
    private boolean isSameLine(Point p1,Point p2,Point p3){
        return (p1.x - p2.x)*(p1.y - p3.y) == (p1.x - p3.x)*(p1.y - p2.y);
    }

    public static void main(String[] args){
        //int[][] test = {{84,250},{0,0},{1,0},{0,-70},{0,-70},{1,-1},{21,10},{42,90},{-42,-230},{1,1}};
        int[][] test = {{0,0},{0,0},{0,0}};
        Point[] points = new Point[test.length];
        for(int i = 0; i < test.length; i++)
            points[i] = new Point(test[i][0],test[i][1]);
        System.out.println(new MaxPointsLine().maxPointsSimple(points));
    }
}

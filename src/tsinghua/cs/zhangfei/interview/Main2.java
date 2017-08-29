package tsinghua.cs.zhangfei.interview;

import java.util.List;
import java.util.Scanner;

/**
 * Created by zhangfei614 on 2017/8/12.
 */
public class Main2 {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static final int[][] dist = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

    }


    public static int minPath(List<List<Point>> list) {
        int minPath = Integer.MAX_VALUE;
        for (List<Point> points : list) {
            int path = path(points);
            if (path < minPath)
                minPath = path;
        }
        return minPath;
    }

    public static int path(List<Point> list) {
        int sumx = 0, sumy = 0, sum = 0;
        for (Point p : list) {
            sumx += p.x;
            sumy += p.y;
        }
        Point mid = new Point(sumx / list.size(), sumy / list.size());
        for (Point p : list) sum += distance(p, mid);
        return sum;
    }

    public static int distance(Point a, Point b) {
        return Math.abs(a.x + b.x) + Math.abs(a.y + b.y);
    }

}

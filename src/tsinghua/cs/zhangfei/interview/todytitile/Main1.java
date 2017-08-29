package tsinghua.cs.zhangfei.interview.todytitile;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by zhangfei614 on 2017/8/22.
 */
public class Main1 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            Point[] points = new Point[n];
            for (int i = 0; i < n; i++) {
                points[i] = new Point(in.nextInt(), in.nextInt());
            }
            sort(points);

        }
    }

    private static boolean less(Point a, Point b) {
        return a.x < b.x && a.y < b.y;
    }

    private static void sort(Point[] points) {
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Integer.compare(o1.x * o1.x + o1.y * o1.y, o2.x * o2.x + o2.y * o2.y);
            }
        });
        for (Point p : points) {
            if (p == null)
                continue;
            System.out.println(p.x + " " + p.y);
        }
    }
}

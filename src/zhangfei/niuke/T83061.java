package zhangfei.niuke;

import java.util.Scanner;

/**
 * Created by zhangfei on 2017/8/11.
 */
public class T83061 {
    static class Point {
        int x;
        int y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point();
            points[i].x = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            points[i].y = scanner.nextInt();
        }
        Point target = new Point();
        target.x = scanner.nextInt();
        target.y = scanner.nextInt();
        int walkCost = scanner.nextInt();
        int taxtCost = scanner.nextInt();
        int min = minPath(points, target, walkCost, taxtCost);
        System.out.println(Math.min((Math.abs(target.x) + Math.abs(target.y)) * walkCost, min));
    }

    private static int minPath(Point[] points, Point target, int walkCost, int taxiCost) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int cost = (Math.abs(points[i].x) + Math.abs(points[i].y)) * walkCost
                    + (Math.abs(points[i].x - target.x) + Math.abs(points[i].y - target.y)) * taxiCost;
            if (cost < min)
                min = cost;
        }
        return min;
    }
}

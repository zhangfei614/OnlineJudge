package tsinghua.cs.zhangfei.offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangfei on 2017/8/3.
 * ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ�񣬵��ǲ��ܽ���
 * ����������������λ֮�ʹ���k�ĸ��ӡ� ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18�����ǣ������ܽ�
 * �뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
 */
public class RobotCount {
    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean[][] flag;
    private int count;

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0) return 0;
        Queue<Point> queue = new LinkedList<>();
        flag = new boolean[rows][cols];
        count = 1;
        for (boolean[] arr : flag)
            Arrays.fill(arr, false);

        queue.add(new Point(0, 0));
        flag[0][0] = true;
        while (!queue.isEmpty()) {
            Point p = queue.remove();
            if (p.x + 1 < rows && !flag[p.x + 1][p.y] && inRange(p.x + 1, p.y, threshold)) {
                queue.add(new Point(p.x + 1, p.y));
            }
            if (p.x - 1 >= 0 && !flag[p.x - 1][p.y] && inRange(p.x - 1, p.y, threshold)) {
                queue.add(new Point(p.x - 1, p.y));
            }
            if (p.y + 1 < cols && !flag[p.x][p.y + 1] && inRange(p.x, p.y + 1, threshold)) {
                queue.add(new Point(p.x, p.y + 1));
            }
            if (p.y - 1 >= 0 && !flag[p.x][p.y - 1] && inRange(p.x, p.y - 1, threshold)) {
                queue.add(new Point(p.x, p.y - 1));
            }
        }
        return count;
    }

    private boolean inRange(int x, int y, int threshold) {
        int sum = 0;
        flag[x][y] = true;
        while (x > 0) {
            sum += (x % 10);
            x /= 10;
        }
        while (y > 0) {
            sum += (y % 10);
            y /= 10;
        }
        if (sum <= threshold) count++;
        return sum <= threshold;
    }

    public static void main(String[] args) {
        System.out.println(new RobotCount().movingCount(1, 2, 2));
    }
}

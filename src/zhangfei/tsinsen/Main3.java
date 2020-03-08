package tsinghua.cs.zhangfei.tsinsen;

import java.util.*;

/**
 * Created by zhangfei614 on 2017/7/27.
 */
public class Main3 {

    private static final Integer DIMMISON = 5;
    private static final int[] cost = new int[]{1, 1, 1, 10, 100};
    private static final List<Long> originPoint = Arrays.asList(new Long[]{0L, 0L, 0L, 0L, 0L});

    public static Long minDistance(List<List<Long>> points) {
        Set<List<Long>> visited = new HashSet<>();
        List<Long> currentPoint = originPoint;
        Long minDistance = 0L;
        visited.add(originPoint);
        while (!points.isEmpty()) {
            int i, minIndex = 0;
            Long min = distance(currentPoint, points.get(minIndex));
            for (i = 1; i < points.size(); i++) {
                Long d = distance(currentPoint, points.get(i));
                if (d < min) {
                    min = d;
                    minIndex = i;
                }
            }
            minDistance += min;
            currentPoint = points.get(minIndex);
            visited.add(points.get(minIndex));
            points.remove(minIndex);
        }
        minDistance += distance(currentPoint, originPoint);
        return minDistance;
    }

    public static Long distance(List<Long> list1, List<Long> list2) {
        Long distance = 0L;
        for (int i = 0; i < DIMMISON; i++) {
            distance += Math.abs(list1.get(i) - list2.get(i)) * cost[i];
        }
        return distance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Long>> points = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<Long> point = new ArrayList<>();
            for(int j = 0; j < DIMMISON; j ++)
                point.add(scanner.nextLong());
            points.add(point);
        }
        System.out.println(minDistance(points));
    }
}

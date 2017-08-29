package tsinghua.cs.zhangfei.interview.netease;

import java.util.Scanner;

/**
 * Created by zhangfei614 on 2017/8/26.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int path = scanner.nextInt();
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int total = scanner.nextInt();
            double l1 = path / (double) v1;
            double t = 0;
            int count = 0;
            int travel = 0;
            while (t + l1 <= total) {
                t += l1;
                travel++;
                int p = (int) (v2 * t);
                if (p % path != 0) continue;
                if ((p / path - travel) % 2 == 1) count++;
            }
            System.out.println(count);
        }
    }
}

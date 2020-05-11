package zhangfei.interview.todytitile;

import java.util.*;

/**
 * Created by zhangfei614 on 2017/8/22.
 */
public class Main2 {

    static class Task {
        int id;
        int pm;
        int start;
        int level;
        int time;

        public Task(int id, int pm, int start, int level, int time) {
            this.id = id;
            this.pm = pm;
            this.start = start;
            this.level = level;
            this.time = time;
        }
    }

    private static int time = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int s = in.nextInt();
            Map<Integer, List<Task>> map = new HashMap<>();
            for (int i = 0; i < s; i++) {
                Task t = new Task(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
                List<Task> list = map.get(t.pm);
                if (list == null) {
                    map.put(t.pm, new ArrayList<>());
                }
                map.get(t.pm).add(t);
            }
            List<Task> done = new ArrayList<>();
            while (done.size() != s) {
                time++;

            }
        }
    }


    private static void sort(List<Task> list) {
        Collections.sort(list, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.start > time && o2.start > time)
                    return 0;
                if (o1.start > time)
                    return -1;
                if (o2.start > time)
                    return 1;
                if (o1.level != o2.level)
                    return -Integer.compare(o1.level, o2.level);
                if (o1.time != o2.time)
                    return Integer.compare(o1.time, o2.time);
                if (o1.start != o2.start)
                    return Integer.compare(o1.start, o2.start);
                return 0;
            }
        });
    }


}

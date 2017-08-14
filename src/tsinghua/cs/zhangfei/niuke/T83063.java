package tsinghua.cs.zhangfei.niuke;

import java.util.*;

/**
 * Created by zhangfei on 2017/8/11.
 */
public class T83063 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(scanner.nextInt(), i);
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        if (!list.isEmpty()) {
            System.out.print(list.get(0).getKey());
            for (int i = 1; i < list.size(); i++) {
                System.out.print(" " + list.get(i).getKey());
            }
        }
    }
}

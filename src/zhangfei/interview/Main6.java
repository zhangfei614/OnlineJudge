package zhangfei.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }
        int max = list.get(0), sum = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            sum = Math.max(sum, 0) + list.get(i);
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}

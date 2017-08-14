package tsinghua.cs.zhangfei.niuke;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by zhangfei on 2017/8/11.
 * 一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，假设已知CPU的每个核1秒可以处理1kb，每个核同时只能处理一项任务。n个任务可以按照任意顺序放入CPU进行处理，现在需要设计一个方案让CPU处理完这批任务所需的时间最少，求这个最小的时间。
 * 输入描述:
 * 输入包括两行：
 * 第一行为整数n(1 ≤ n ≤ 50)
 * 第二行为n个整数length[i](1024 ≤ length[i] ≤ 4194304)，表示每个任务的长度为length[i]kb，每个数均为1024的倍数。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个整数，表示最少需要处理的时间
 */
public class T83060 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(maxTime(arr));
    }

    private static int maxTime(Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
        int cpu1 = 0, cpu2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cpu1 <= cpu2) {
                cpu1 += arr[i];
            } else {
                cpu2 += arr[i];
            }
        }
        return Math.max(cpu1, cpu2);
    }
}

package test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Created by zhangfei614 on 2017/4/26.
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        System.out.println(String.valueOf(sumAll(n)));
    }

    static int sumAll(int n) {
        int[] arr = new int[n + 1];
        List<Integer> prims = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                if (isPrime(i)) {
                    arr[i] = 1;
                    prims.add(i);
                    for (int j : prims) {
                        if (i * j <= n && i * j > 0) arr[i * j] = 2;
                    }
                } else {
                    ListIterator<Integer> li = prims.listIterator(prims.size());
                    while (li.hasPrevious()) {
                        int j = li.previous();
                        if (i % j == 0) {
                            arr[i] = arr[i/j] + 1;
                            break;
                        }
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum += arr[i];
        }
        return sum;
    }

    static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }

}

package test;

import java.util.Scanner;

/**
 * Created by Fei Zhang on 2017/4/1.
 * Email:zhangfei614@126.com
 */


public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            String[] strArr = str.split(" ");
            if (strArr.length == 2)
                System.out.println(Integer.parseInt(strArr[0]) * Integer.parseInt(strArr[1]));
            if (strArr.length == 3)
                System.out.println(area(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2])));
        }
    }

    private static int area(int a, int b, int c) {
        double p = (a + b + c) / 2.0;
        return (int) Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
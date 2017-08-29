package tsinghua.cs.zhangfei;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by THU on 2015/9/8.
 */
public class OJTools {
    public static Scanner testFileScanner() {
        Scanner input = null;
        try {
            input = new Scanner(new File("D:\\code\\OnlineJudge\\data.in"));
        } catch (FileNotFoundException e) {
            System.out.println("Data.in file not found!");
        }
        return input;
    }

    public static void exhange(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static final int[][] dist = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static final int[][] dist8 = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {1, -1}, {-1, -1}, {1, 1}};
}

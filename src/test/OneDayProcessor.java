package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhangfei614 on 2017/3/28.
 */
public class OneDayProcessor {

    private final static String NUMBER_REGEX = "\\d+";
    private final static int ARRARY_LENGTH = 4;

    public static void main(String[] args) {
        String str;
        int number;
        int[] data = new int[ARRARY_LENGTH];

        Arrays.fill(data, -1);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data for today:");
        for (int i = 0; i < ARRARY_LENGTH; i++) {
            do {
                System.out.print("  Enter the blood sugar test reading for test " + (i + 1) + ":");
                str = scanner.nextLine();
                if (!str.matches(NUMBER_REGEX)) {
                    System.out.println("Please input a validate number!");
                    continue;
                }
                number = Integer.parseInt(str);
                if (number < 0 || number > 600) {
                    System.out.println("Please input a number between 0 and 600!");
                    continue;
                }
                data[i] = number;
            } while (data[i] == -1);
        }

        int max = 0, min = 0, sum = data[0];
        for (int i = 1; i < ARRARY_LENGTH; i++) {
            if (data[max] < data[i]) max = i;
            if (data[min] > data[i]) min = i;
            sum += data[i];
        }
        System.out.println();
        System.out.print("Test Reading " + (max + 1) + " had the highest blood sugar level with " + (double) data[max] + " mg/dL\n");
        System.out.print("Test Reading " + (min + 1) + " had the lowest blood sugar level with " + (double) data[min] + " mg/dL\n");
        System.out.print("Your average blood sugar level for today was " + (sum / (double) ARRARY_LENGTH) + " mg/dL\n");

    }
}

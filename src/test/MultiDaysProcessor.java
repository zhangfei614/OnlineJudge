package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhangfei614 on 2017/3/28.
 */
public class MultiDaysProcessor {

    private final static String NUMBER_REGEX = "\\d+";
    private final static int ARRARY_LENGTH = 4;

    public static void main(String[] args) {
        String str;
        int n, number, all_sum = 0;
        int[] data = new int[ARRARY_LENGTH];

        Scanner scanner = new Scanner(System.in);
        System.out.print("How many days of blood sugar test reading would you like to enter:");
        n = Integer.parseInt(scanner.nextLine());
        double[] all_averages = new double[n];
        for (int k = 1; k <= n; k++) {
            Arrays.fill(data, -1);
            System.out.println("\nEnter data for day " + k);
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
                    all_sum += number;
                } while (data[i] == -1);
            }

            int max = 0, min = 0, sum = data[0];
            for (int i = 1; i < ARRARY_LENGTH; i++) {
                if (data[max] < data[i]) max = i;
                if (data[min] > data[i]) min = i;
                sum += data[i];
            }
            all_averages[k - 1] = sum / (double) ARRARY_LENGTH;

            System.out.println();
            System.out.print("Test Reading " + (max + 1) + " had the highest blood sugar level with " + (double) data[max] + " mg/dL\n");
            System.out.print("Test Reading " + (min + 1) + " had the lowest blood sugar level with " + (double) data[min] + " mg/dL\n");
            System.out.print("Your average blood sugar level for day " + k + " was " + all_averages[k - 1] + " mg/dL\n");
        }
        System.out.println("\nOverall Results:\n");

        int all_max = 0, all_min = 0;
        for (int i = 1; i < n; i++) {
            if (all_averages[all_max] < all_averages[i]) all_max = i;
            if (all_averages[all_min] > all_averages[i]) all_min = i;
        }
        System.out.print("Day " + (all_max + 1) + " had the highest average blood sugar level with " + all_averages[all_max] + " mg/dL\n");
        System.out.print("Day " + (all_min + 1) + " had the lowest average blood sugar level with " + all_averages[all_min] + " mg/dL\n");
        System.out.print("\nYour average blood sugar over " + n + " days was " + ((double) all_sum / (n * ARRARY_LENGTH)) + " mg/dL\n");
    }

}

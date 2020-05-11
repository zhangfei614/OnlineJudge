package zhangfei.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhangfei614 on 2017/8/26.
 */
public class Main7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] strs = str.split(" ");
            int[] arr = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                arr[i] = Integer.valueOf(strs[i].trim());
            }
            int k = scanner.nextInt();
            Arrays.sort(arr);
            System.out.println(arr[arr.length - k]);
        }
    }
}

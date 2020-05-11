package zhangfei.hiCoder;

import zhangfei.OJTools;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MainWeek62 {

    public static void main(String args[]) {
        Scanner input = OJTools.testFileScanner();
//        Scanner input = new Scanner(System.in);
        int m, n;
        String[] urls;
        Map<String, Integer> lastVisted;
        while (input.hasNext()) {
            m = input.nextInt();
            n = input.nextInt();
            input.nextLine(); //orz...
            urls = new String[m];
            lastVisted = new HashMap<String, Integer>(n);

            for (int i = 0; i < m; i++) {
                urls[i] = input.nextLine();
            }
            int cashCount = 0;
            int s = 0;
            for (int i = 0; i < m; i++) {
                if (lastVisted.containsKey(urls[i])) {
                    System.out.println("Cache");
                } else {
                    cashCount++;
                    if (cashCount > m) {
                        s = s + 1;
                    }
                    System.out.println("Internet");
                }
                lastVisted.put(urls[i], i);
                while (lastVisted.get(urls[s]) != s) s = s + 1;
            }
        }

    }
}

package tsinghua.cs.zhangfei.interview.netease;

import java.util.Scanner;

/**
 * Created by zhangfei614 on 2017/8/26.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int s1Length = Integer.valueOf(scanner.nextLine());
            int s2Length = Integer.valueOf(scanner.nextLine());

            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();

            int[][] dp = new int[s1Length+1][s2Length+1];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i <= s1Length; i++)
                for (int j = 0; j <=s2Length; j++) {
                    if (i == 0 || j == 0){
                        dp[i][j] = 0;
                        continue;
                    }
                    if(s1.charAt(i-1) == s2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1]+1;
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                    max = Math.max(max, dp[i][j]);
                }
            System.out.println(max);
        }
    }
}

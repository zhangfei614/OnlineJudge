package zhangfei.apac;

import zhangfei.OJTools;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Fei Zhang on 2016/8/28.
 * Email:zhangfei614@126.com
 */

public class SherlockWatsonGymSecrets {
    public static void main(String[] args){
        Scanner scanner = OJTools.testFileScanner();
        try {
            System.setOut(new PrintStream("e:\\code\\OJ\\data.out"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int t = scanner.nextInt();
        for(int x = 0; x< t; x++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long n = scanner.nextLong();
            long k = scanner.nextInt();
            long count = 0;
            for (long i = 1; i <= n; i++) {
                for (long j = 1 ; j <= n; j++) {
                    if(j == i) continue;
                    long ik = mod(i,a,k);
                    long jk = mod(j,b,k);
                    if(((ik+jk)%k)==0){
                        count++;
                    }
                    if(count == 1000000007) count = 0;
                }
            }
            System.out.println("Case #"+(x+1)+" "+count);
        }
    }
    public static long mod(long i,long a,long k){
        long sum = 1;
        for(int x = 0; x < a ; x++){
            if(i < k){
                if(k % i == 0) k = k/i;
                else sum*=i;
            }else if(i == k){
                return 0;
            }else{
                if(i%k == 0) return 0;
                else sum*=i;
            }
        }
        return sum%k;
    }
}

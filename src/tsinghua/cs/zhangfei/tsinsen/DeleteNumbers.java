package tsinghua.cs.zhangfei.tsinsen;

import java.util.Scanner;

/**
 * Created by Fei Zhang on 2016/5/7.
 * Email:zhangfei614@126.com
 */

public class DeleteNumbers {
    public static void main(String[] args){

        //Scanner input = OJTools.testFileScanner();
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int m = input.nextInt();
            for(int i = 0; i < m; i++){
                String s = input.next();
                int k = input.nextInt();
                char[] array = s.toCharArray();
                int n = array.length;
                for(int j = 0; j < k; j++,n--){
                    int p = 1;
                    while(p < n && array[p]<=array[p-1]) p++;
                    for(int q = p; q < n; q++) array[q-1] = array[q];
                }
                for(int r = 0; r < n; r++) System.out.print(array[r]);
                System.out.println();
            }
        }
    }
}

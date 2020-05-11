package zhangfei.tsinsen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Fei Zhang on 2016/4/12.
 * Email:zhangfei614@126.com
 */

public class CherryPick {
    private static int[] count;
    private static int MAX = Integer.MIN_VALUE;
    private static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
//        Scanner input = OJTools.testFileScanner();
        int n,m,k,l,r;
        int[] array;
        int temp;
        while(input.hasNext()){
            n = input.nextInt();
            array = new int[n+1];
            for(int i = 1; i <= n; i++) {
                temp=input.nextInt();
                if(temp > MAX) MAX = temp;
                if(temp < MIN) MIN = temp;
                array[i] = temp;
            }
            count = new int[MAX-MIN+1];
            m = input.nextInt();
            for(int i = 0; i < m; i++){
                k = input.nextInt();
                l = input.nextInt();
                r = input.nextInt();
                List<Integer> result = query(array,k,l,r);
                if(result == null || result.size() == 0) System.out.println("EMPTY");
                else{
                    boolean flag = true;
                    for(Integer integer : result){
                        if(flag){
                            System.out.print(integer.intValue());
                            flag = false;
                        }else{
                            System.out.print(" "+integer.intValue());
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

    private static List<Integer> query(int[] array,int k,int l,int r){
        if(r < l) return null;
        if(k > r-l+1) return null;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int temp;

        Arrays.fill(count, 0);
        for(int i = l; i <= r; i++) {
            temp = array[i];
            count[temp-MIN]++;
            if(temp > max) max = temp;
            if(temp < min) min = temp;
        }

        List<Integer> result = new ArrayList<Integer>();
        temp = 0;
        for(int i = min; i <= max; i++){
            if(count[i-MIN]!=0){
                temp+=count[i-MIN];
                while(temp >= k){
                    result.add(i);
                    temp-=k;
                }
            }
        }
        return result;
    }
}

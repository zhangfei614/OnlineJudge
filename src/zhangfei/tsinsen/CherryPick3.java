package tsinghua.cs.zhangfei.tsinsen;

import tsinghua.cs.zhangfei.OJTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Fei Zhang on 2016/4/12.
 * Email:zhangfei614@126.com
 */

public class CherryPick3 {
    public static void main(String[] args){
//        Scanner input = new Scanner(System.in);
        Scanner input = OJTools.testFileScanner();
        int n,m,k,l,r;
        int[] array;
        while(input.hasNext()){
            n = input.nextInt();
            array = new int[n+1];
            for(int i = 1; i <= n; i++) array[i] = input.nextInt();
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
                            System.out.print(integer);
                            flag = false;
                        }else{
                            System.out.print(" "+integer);
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
        int[] temp = Arrays.copyOfRange(array,l,r+1);
        Arrays.sort(temp);

        List<Integer> result = new ArrayList<Integer>();
        for(int i= k-1; i < temp.length;i+=k) result.add(temp[i]);
        return result;
    }
}

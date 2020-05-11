package zhangfei.hiCoder;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by THU on 2016/3/11.
 描述
 Give you two integers P and Q. Let all divisors of P be X-coordinates. Let all divisors of Q be Y-coordinates.

 For example, when P=6 and Q=2, we can get the coordinates (1,1) (1,2) (2,1) (2,2) (3,1) (3,2) (6,1) (6,2).

 You should print all possible coordinates in the order which is first sorted by X-coordinate when coincides, sorted by Y-coordinate.

 输入
 One line with two integers P and Q(1 <= P, Q <= 10000).

 输出
 The output may contains several lines , each line with two integers Xi and Yi, denoting the coordinates.

 思路：
 先算除数，再循环。
 */
public class MainWeek88 {

    static ArrayList<Integer> divisors(int number){
        ArrayList<Integer> divisors = new ArrayList<Integer>();
        for(int i=1;i <=number ;i++){
            if(number%i==0) divisors.add(i);
        }
        return divisors;
    }
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int m,n;
        while(input.hasNext()){
            m = input.nextInt();
            n = input.nextInt();
            ArrayList<Integer> mDivisors = divisors(m);
            ArrayList<Integer> nDivisors = divisors(n);
            for(Integer i : mDivisors){
                for(Integer j: nDivisors){
                    System.out.println(i+" "+j);
                }
            }
        }
    }
}

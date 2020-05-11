package zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/3/21.
 * Email:zhangfei614@126.com
 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 思路：动态规划问题，找出递归关系式，斐波那契数列。
 */

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        int a = 1,b = 2;
        int result = 0;
        for(int i=3;i<=n;i++){
            result = a+b;
            a = b;
            b = result;
        }
        return result;
    }

    public int climbStairsSimple(int n){
        int answer = 1;
        for(int i = 0, pre = 0; i < n; i++) pre = (answer += pre) - pre;
        return answer;
    }
    public static void main(String[] args){
        System.out.println(new ClimbingStairs().climbStairs(5));
    }
}

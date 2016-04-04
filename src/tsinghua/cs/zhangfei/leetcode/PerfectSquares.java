package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Fei Zhang on 2016/4/4.
 * Email:zhangfei614@126.com
 Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

 思路1：记录每一个数的结果，利用动态规划获依次尝试每一个比它小的平方数，取最小的结果。
 思路2：逆向思维，利用广度优先策略，将n与所有与他小的平方数的差值作为下一层,直到差值为0，则返回。例如，对于24，则有：
 （24）（8,15,20,23）（4,7,6,11,14，....)(0,....)这样的空间复杂度比动态规划多出几个量级，十分不恰当；如果使用ArrayDeque可以，但如果使用LinkedList则完全不行。
 */

public class PerfectSquares {
    public int numSquares(int n) {
        int[] a = new int[n+1];
        a[0]=0;
        for(int i = 1; i <= n; i++){
            a[i]=i;
            for(int j = 1; j*j<=i; j++){
                if(a[i-j*j]+1 < a[i])
                    a[i] = a[i-j*j]+1;
            }
        }
        return a[n];
    }

    public int numSquaresBFS(int n){
        if(n <= 0) return 0;

        Queue<Integer> queue = new LinkedList<Integer>();
        int parentSize = 1;
        int childSize = 0;
        int deep = 1;

        queue.add(n);
        while(true){
            int num = queue.remove();
            int sq =(int) Math.sqrt(num);

            for(int i = sq; i > 0; i--){
                int delta = num - i*i;
                if(delta == 0) return deep;
                else{
                    queue.add(delta);
                    childSize++;
                }
            }

            if(--parentSize == 0){
                parentSize = childSize;
                childSize = 0;
                deep++;
            }
        }
    }

    public int numSquaresBFS2(int n){
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        queue.add(n);
        int depth = 1, m = 1, tmp = 0;

        while(true){
            if(m == 0){
                depth++;
                m = tmp;
                tmp = 0;
            }

            int cur = queue.remove();
            m--;

            int l = (int) Math.sqrt(cur);
            for(int i=l; i>0; i--){
                int sq = i*i;
                int delta = cur - sq;
                if(delta == 0)
                    return depth;
                queue.add(delta);
                tmp++;
            }
        }
    }
    public static void main(String[] args){
        System.out.println(new PerfectSquares().numSquaresBFS2(1535));
    }
}

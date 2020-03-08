package tsinghua.cs.zhangfei.leetcode;

import java.util.Arrays;

/**
 * Created by Fei Zhang on 2017/9/6.
 * Email:zhangfei614@126.com
 * There are N children standing in a line. Each child is assigned a rating value.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */

public class Candy {
    public int candy(int[] ratings) {
        if (ratings.length == 0) return 0;
        int[] candy = new int[ratings.length];
        int sum = 0;
        //默认每个人分1个糖果
        Arrays.fill(candy, 1);
        for(int i = 1; i < candy.length; i++){
            //正向扫描，找到递增序列
            if(ratings[i] > ratings[i-1]) candy[i] = candy[i-1]+1;
        }
        for(int i = candy.length-1; i > 0 ; i--){
            if(ratings[i-1] > ratings[i]){
                //反向扫描，找到的递减序列，并取较大的值。
                candy[i-1] = Math.max(candy[i]+1,candy[i-1]);
            }
        }

        for (int c : candy) sum += c;
        return sum;
    }
    public static void main(String[] args) {
        int[] test = new int[]{2, 2, 1};
        System.out.println(new Candy().candy(test));
    }
}

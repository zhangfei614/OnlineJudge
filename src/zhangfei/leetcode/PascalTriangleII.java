package zhangfei.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by THU on 2016/3/14.
 * Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 思路：递归调用，产生新的List不断计算。

 Could you optimize your algorithm to use only O(k) extra space?

 思路：只保留上一行，不采用递归的形式。每一行由上一行结果先追加一个1，再从后往前计算下一行。
 */
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex < 0) return null;
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        if(rowIndex == 0){
            return  result;
        }
        if(rowIndex == 1){
            result.add(1);
            return result;
        }
        List<Integer> upLine = getRow(rowIndex - 1);
        for(int i = 0;i<upLine.size()-1;i++){
            result.add(upLine.get(i)+upLine.get(i+1));
        }

        result.add(1);
        return result;
    }

    public List<Integer> getRowSimple(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++) {
            res.add(1);
            for(int j = i-1; j > 0; j--) {
                res.set(j, res.get(j-1) + res.get(j));
            }
        }
        return res;
    }
}

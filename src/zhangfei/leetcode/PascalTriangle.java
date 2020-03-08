package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fei Zhang on 2016/4/7.
 * Email:zhangfei614@126.com
 */

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows == 0) return result;
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <= numRows; i++){
            list = new ArrayList<Integer>(list);
            list.add(1);
            for(int j = i - 2; j > 0; j--)
                list.set(j,list.get(j-1)+list.get(j));
            result.add(list);
        }
        return result;
    }
}

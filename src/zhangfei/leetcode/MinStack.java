package zhangfei.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fei Zhang on 2016/3/31.
 * Email:zhangfei614@126.com
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 思路：用另外一个栈保存最小值的索引。
 */

public class MinStack {
    private List<Integer> array = new ArrayList<Integer>();
    private List<Integer> minIndex = new ArrayList<Integer>();

    private int index = 0;

    public void push(int x) {
        array.add(x);
        if(index == 0){
            minIndex.add(0);
        }else{
            if(x >= array.get(minIndex.get(index-1))){
                minIndex.add(minIndex.get(index-1));
            }else{
                minIndex.add(index);
            }
        }
        index++;
    }

    public void pop() {
        if(index == 0) return;
        else{
            index--;
            array.remove(index);
            minIndex.remove(index);
        }
    }

    public int top() {
        return array.get(index-1);
    }

    public int getMin() {
        return array.get(minIndex.get(index-1));
    }
}

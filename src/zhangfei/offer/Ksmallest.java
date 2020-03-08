package tsinghua.cs.zhangfei.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangfei614 on 2017/7/16.
 */
public class Ksmallest {

    public List<Integer> kSmallest(int[] input, int k) {
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) arr[i] = input[i];

        //调整树
        for (int i = k / 2 - 1; i >= 0; i--) {
            adjust(arr, i, k - 1);
        }
        //朝后遍历
        for (int i = k; i < input.length; i++) {
            if (input[i] < arr[0]) {
                arr[0] = input[i];
                adjust(arr, 0, k - 1);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i : arr) list.add(i);
        return list;
    }

    private void adjust(int[] input, int start, int end) {
        int dad = start;
        int son = dad * 2 + 1;
        while (son <= end) {
            //选取子节点中较大的那个数
            if (son < end && input[son + 1] > input[son]) son += 1;
            if (input[dad] < input[son]) {
                exchange(input, dad, son);
                dad = son;
                son = dad * 2 + 1;
            } else {
                break;
            }
        }
    }

    private void exchange(int[] input, int i, int j) {
        int t = input[i];
        input[i] = input[j];
        input[j] = t;
    }

    public static void main(String[] args) {
        int i = 5;
        System.out.println(((i++)+(++i)+(i--)+(--i)));
    }
}

package tsinghua.cs.zhangfei.tsinsen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Fei Zhang on 2016/4/12.
 * Email:zhangfei614@126.com
 */

public class CherryPick4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        Scanner input = OJTools.testFileScanner();
        int n, m, k, l, r;
        int[] array;
        while (input.hasNext()) {
            n = input.nextInt();
            array = new int[n + 1];
            for (int i = 1; i <= n; i++) array[i] = input.nextInt();
            m = input.nextInt();
            for (int i = 0; i < m; i++) {
                k = input.nextInt();
                l = input.nextInt();
                r = input.nextInt();
                List<Integer> result = query(array, k, l, r);
                if (result == null || result.size() == 0) System.out.println("EMPTY");
                else {
                    boolean flag = true;
                    for (Integer integer : result) {
                        if (flag) {
                            System.out.print(integer);
                            flag = false;
                        } else {
                            System.out.print(" " + integer);
                        }
                    }
                    System.out.println();
                }
            }
        }

    }

    private static List<Integer> query(int[] array, int k, int l, int r) {
        if (r < l) return null;
        if (k > r - l + 1) return null;
        List<Integer> result = new ArrayList<Integer>();
        for (int i = k; l + i - 1 <= r; i += k) {
            result.add(selectKth(array, l, r, i));
        }
        return result;
    }

    private static int selectKth(int[] array, int begin, int end, int k) {
        int mid = partition(array, begin, end);
        int kMid = mid - begin + 1;
        if (k == kMid) return array[mid];
        else if (k < kMid) return selectKth(array, begin, mid - 1, k);
        else return selectKth(array, mid + 1, end, k - kMid);
    }


    //第最后一个数作为key进行partition
    private static int partition(int[] array, int begin, int end) {
        int index = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] <= array[end]) exchange(array, index++, i);
        }
        exchange(array, index, end);
        return index;
    }


    private static void exchange(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

}

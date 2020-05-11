package zhangfei.tsinsen;

import zhangfei.OJTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Fei Zhang on 2016/4/13.
 * Email:zhangfei614@126.com
 */

public class CherryPick5 {

    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
        Scanner input = OJTools.testFileScanner();
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

    private static void kQuantile(int[] array,int begin,int end,int k,int[] result){
        //太复杂省略
    }

    private static int selectKth(int[] array, int begin, int end, int k) {
        if (begin >= end) return array[begin];
        int median = findMedian(array,begin,end);
        int mid = partition(array,begin,end,median);
        int kMid = mid - begin + 1;
        if (k == kMid) return array[mid];
        else if (k < kMid) return selectKth(array, begin, mid - 1, k);
        else return selectKth(array, mid + 1, end, k - kMid);
    }

    private static int findMedian(int[] array, int begin, int end) {
        int length = end - begin + 1;
        int h = (length % 5 == 0) ? length / 5 : length / 5 + 1;
        int[] medians = new int[h];
        for (int i = 0; i < h; i++) {
            int s = begin + i *5;
            int e = begin + (i + 1) * 5 < end ? begin + (i + 1) * 5 : end+1;
            Arrays.sort(array,s,e);
            medians[i] =array[(s+e-1)/2];
        }
        if(h == 1) return medians[0];
        else return selectKth(medians,0,h-1,(h-1)/2+1);
    }

    private static int partition(int[] array, int begin, int end, int key) {
        int index = begin;
        int keyIndex = begin;
        for (int i = begin; i <= end; i++) {
            if (array[i] < key) exchange(array, index++, i);
            if (array[i] == key) keyIndex = i;
        }
        exchange(array, index, keyIndex);
        return index;
    }

    private static void exchange(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}

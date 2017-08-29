package tsinghua.cs.zhangfei;

import java.util.Arrays;
import java.util.Comparator;

public class Main {


    public static void main(String[] args) {
        int[] test = new int[]{345,30,34,5,9};
        System.out.println(new Main().maxValue(test));
    }


    public String maxValue(int[] arr) {
        String[] strs = new String[arr.length];
        for (int i = 0; i < arr.length; i++) strs[i] = String.valueOf(arr[i]);
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.equals(o2)) return 0;
                char[] chars1 = o1.toCharArray();
                char[] chars2 = o2.toCharArray();
                int i = 0, j = 0;
                while (i < chars1.length && j < chars2.length) {
                    if (chars1[i] > chars2[j]) return -1;
                    else if (chars1[i] < chars2[j]) return 1;
                    else {
                        i++;
                        j++;
                    }
                    if (i == chars1.length && j < chars2.length) i = 0;
                    if (j == chars2.length && i < chars1.length) j = 0;
                }
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s : strs) sb.append(s);
        return sb.toString();
    }
}

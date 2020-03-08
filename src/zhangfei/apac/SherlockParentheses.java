package tsinghua.cs.zhangfei.apac;

import tsinghua.cs.zhangfei.OJTools;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Fei Zhang on 2016/8/28.
 * Email:zhangfei614@126.com
 */

public class SherlockParentheses {
    public static void main(String[] args){
        Scanner scanner = OJTools.testFileScanner();
        try {
            System.setOut(new PrintStream("e:\\code\\OJ\\data.out"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            double m = Math.min(l,r);
            System.out.println("Case #"+(i+1)+": " + (int)(m*(m+1)/2));
        }
    }
}

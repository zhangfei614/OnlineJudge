package zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/6/29.
 * Email:zhangfei614@126.com
 * 仅需要到上一行的内容，所以只需使用O(m)的变量
 */

public class UniquePaths {
    public int uniquePaths(int m ,int n){
        if(m == 0 || n == 0) return 1;
        if(m > n) return uniquePaths(n,m);
        int[] arr = new int[m];
        for(int i = 0; i < m+n-1; i++){
            for(int j = m-1; j > 0; j--){
                if(j > i) arr[j] = 0;
                else arr[j] = arr[j]+arr[j-1];
            }
            arr[0] = 1;
        }
        return arr[m-1];
    }

    public static void main(String[] args){
        System.out.println(new UniquePaths().uniquePaths(3,7));
    }
}

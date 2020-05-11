package zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/5/18.
 * Email:zhangfei614@126.com
 */

public class FirstBadVersion {
    private boolean isBadVersion(int n){
        if(n >= 1702766719) return true;
        else return false;
    }

    public int firstBadVersion(int n){
        int l = 1, r = n;
        while(l < r){
            int mid = l + ((r-l)>>1);
            if(!isBadVersion(mid)) l = mid+1;
            else r = mid;
        }
        return l;
    }

    public static void main(String[] args){
        System.out.println(new FirstBadVersion().firstBadVersion(2126753390));
    }
}

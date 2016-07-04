package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/6/30.
 * Email:zhangfei614@126.com
 * 思路：ssume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
 * 有前面的数生成，记录2,3,5各一个指针，看那个生长的更快。
 */

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] count = {1,1,1};
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        for(int i = 2; i <= n; i++){
            nums[i] = Math.min(nums[count[0]]*2,Math.min(nums[count[1]]*3,nums[count[2]]*5));
            count[0] = nums[count[0]]*2 == nums[i] ? count[0]+1 : count[0];
            count[1] = nums[count[1]]*3 == nums[i] ? count[1]+1 : count[1];
            count[2] = nums[count[2]]*5 == nums[i] ? count[2]+1 : count[2];
        }
        return nums[n];
    }

    public int nthUglyNumberLinkedList(int n){
        ListNode current = new ListNode(1);
        ListNode n2 = current, n3 = current, n5 = current;
        for(int i = 2 ; i <= n; i++){
            int min = Math.min(n2.val*2,Math.min(n3.val*3,n5.val*5));
            current.next = new ListNode(min);
            current = current.next;
            n2 = n2.val * 2 == min ? n2.next : n2;
            n3 = n3.val * 3 == min ? n3.next : n3;
            n5 = n5.val * 5 == min ? n5.next : n5;
        }
        return current.val;
    }
    private class ListNode{
        private int val;
        private ListNode next;
        private ListNode(int val){
            this.val=val;
        }
    }
    public static void main(String[] args){
        System.out.println(new UglyNumberII().nthUglyNumber(11));
        int[][] a = {{1,2},{2,3}};
        int[][] b = {{1,2},{2,4}};
        System.out.println(a[0] == b[0]);
    }
}

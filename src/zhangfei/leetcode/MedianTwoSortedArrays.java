package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by zhangfei614 on 2017/5/26.
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p/>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p/>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p/>
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p/>
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int s1 = 0, e1 = nums1.length - 1, s2 = 0, e2 = nums2.length - 1;
        while ((e1 - s1) >= 1 && (e2 - s2) >= 1) {
            int len = Math.min((e1 - s1 + 1) / 2, (e2 - s2 + 1) / 2);
            double med1 = median(nums1, s1, e1);
            double med2 = median(nums2, s2, e2);
            if (med1 < med2) {
                s1 = s1 + len;
                e2 = e2 - len;
            } else if (med1 > med2) {
                s2 = s2 + len;
                e1 = e1 - len;
            } else {
                return med1;
            }
        }
        if (e2 - s2 < 1) {
            int[] nums = nums1;
            nums1 = nums2;
            nums2 = nums;

            int t = e2;
            e2 = e1;
            s2 = s1;
            s1 = t;
        }

        int[] arr = new int[e2 - s2 + 2];
        for (int i = 0; i <= e2 - s2; i++) arr[i] = nums2[s2 + i];
        arr[arr.length - 1] = nums1[s1];
        for (int i = arr.length - 2; i >= 0 && arr[i] >= arr[i + 1]; i--)
            exchange(arr, i, i + 1);
        return median(arr, 0, arr.length - 1);
    }

    private void exchange(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private double median(int[] arr, int s, int e) {
        int mid = s + (e - s) / 2;
        if ((s - e + 1) % 2 == 0) {
            return (arr[mid] + arr[mid + 1]) / 2.0;
        } else {
            return arr[mid];
        }
    }


    public static void main(String[] args){
        int[] nums1 = new int[]{1,2,6};
        int[] nums2 = new int[]{3,4,5};

        System.out.println(new MedianTwoSortedArrays().findMedianSortedArrays(nums1,nums2));
    }


}

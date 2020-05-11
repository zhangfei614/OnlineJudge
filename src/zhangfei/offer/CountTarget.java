package zhangfei.offer;

/**
 * Created by zhangfei on 2017/7/31.
 * ͳ��һ�����������������г��ֵĴ���
 */
public class CountTarget {


    public int GetNumberOfK(int[] array, int k) {
        int left = findLowerBound(array, k);
        int right = findUpperBound(array, k);
        if (left == -1 || right == -1)
            return 0;
        else
            return right - left + 1;
    }

    private int findLowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                if ((mid > 0 && arr[mid - 1] != target) || mid == 0) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    private int findUpperBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                if ((mid < arr.length - 1 && arr[mid + 1] != target) || mid == arr.length - 1) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 3, 3, 3, 3, 5};
        System.out.println(new CountTarget().GetNumberOfK(test, 3));
    }
}

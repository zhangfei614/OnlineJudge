package zhangfei.niuke;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by zhangfei on 2017/8/11.
 * һ��˫��CPU���������ܹ�ͬʱ�Ĵ�������������n����֪��������������Ҫ����CPU����������֪CPU��ÿ����1����Դ���1kb��ÿ����ͬʱֻ�ܴ���һ������n��������԰�������˳�����CPU���д���������Ҫ���һ��������CPU�������������������ʱ�����٣��������С��ʱ�䡣
 * ��������:
 * ����������У�
 * ��һ��Ϊ����n(1 �� n �� 50)
 * �ڶ���Ϊn������length[i](1024 �� length[i] �� 4194304)����ʾÿ������ĳ���Ϊlength[i]kb��ÿ������Ϊ1024�ı�����
 * <p>
 * <p>
 * �������:
 * ���һ����������ʾ������Ҫ�����ʱ��
 */
public class T83060 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(maxTime(arr));
    }

    private static int maxTime(Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
        int cpu1 = 0, cpu2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cpu1 <= cpu2) {
                cpu1 += arr[i];
            } else {
                cpu2 += arr[i];
            }
        }
        return Math.max(cpu1, cpu2);
    }
}

package zhangfei.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Fei Zhang on 2017/8/27.
 * Email:zhangfei614@126.com
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * <p/>
 * Note:
 * The number of people is less than 1,100.
 * <p/>
 * Example
 * <p/>
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p/>
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */

public class QueueReconstructionHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        for (int i = people.length - 1; i >= 0; i--) {
            int t = people[i][1];
            for (int j = i - 1; j >= 0; j--)
                if (people[j][0] == people[i][0])
                    t--;
                else
                    break;
            for (int j = 0; j < t; j++)
                exchange(people, i + j, i + j + 1);
        }
        return people;
    }

    private void exchange(int[][] people, int i, int j) {
        int[] t = people[i];
        people[i] = people[j];
        people[j] = t;
    }

    private void print(int[][] people) {
        for (int i = 0; i < people.length; i++)
            System.out.println(people[i][0] + "," + people[i][1]);
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        QueueReconstructionHeight q = new QueueReconstructionHeight();
        q.reconstructQueue(test);
        q.print(test);

    }
}

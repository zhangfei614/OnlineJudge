package zhangfei.tsinsen;

import java.util.*;

/**
 * Created by Fei Zhang on 2016/4/13.
 * Email:zhangfei614@126.com
 */
class Node {
    int data;
    int index;
    Node(int data, int index) {
        this.data = data;
        this.index = index;
    }
}
public class CherryPick6 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        Scanner input = OJTools.testFileScanner();
        int n, m, k, l, r;
        while (input.hasNext()) {
            n = input.nextInt();
            Node[] array = new Node[n];
            for (int i = 0; i < n; i++){
                array[i] = new Node(input.nextInt(),i+1);
            }
            Arrays.sort(array, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.data - o2.data;
                }
            });
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

    private static List<Integer> query(Node[] array, int k, int l, int r) {
        if (r < l) return null;
        if (k > r - l + 1) return null;
        List<Integer> result = new ArrayList<Integer>();
        int sum = 0;
        for(Node node:array){
            if(node.index >= l && node.index <= r){
                if(++sum == k){
                    result.add(node.data);
                    sum = 0;
                }
            }
        }
        return result;
    }
}

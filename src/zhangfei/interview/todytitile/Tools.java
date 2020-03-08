package tsinghua.cs.zhangfei.interview.todytitile;

import java.util.LinkedList;

/**
 * Created by zhangfei614 on 2017/8/22.
 */
public class Tools {


    public void runPermutation(int[] a) {
        getAllPermutation(a, 0);
    }

    /*index用于控制如上述分析中2加上13的所有全列的*/
    public void getAllPermutation(int[] a, int index) {

        /*与a的元素个数相同则输出*/
        if (index == a.length - 1) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = index; i < a.length; i++) {

            swap(a, index, i);
            getAllPermutation(a, index + 1);
            swap(a, index, i);
        }
    }

    public void swap(int[] a, int i, int j) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //组合

    public void combine(int[] a, int n) {

        if(null == a || a.length == 0 || n <= 0 || n > a.length)
            return;

        int[] b = new int[n];//辅助空间，保存待输出组合数
        getCombination(a, n , 0, b, 0);
    }

    private void getCombination(int[] a, int n, int begin, int[] b, int index) {

        if(n == 0){//如果够n个数了，输出b数组
            for(int i = 0; i < index; i++){
                System.out.print(b[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = begin; i < a.length; i++){

            b[index] = a[i];
            getCombination(a, n-1, i+1, b, index+1);
        }

    }

    int min = Integer.MAX_VALUE;
    int endX = 3;  //目标点横坐标
    int endY = 3;  //目标点纵坐标
    int width = 5;  //迷宫宽度
    int height = 4;  //迷宫高度
    int[][] maze = new int[5][4];
    int[][] mark = new int[5][4];
    LinkedList<Integer> map = new LinkedList<>();

    public void dfs(int startX, int startY, int step) {
        int[][] next = new int[][] { //按右->下->左->上的顺序尝试
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };
        int nextX, nextY;
        int posible;
        if(startX == endX && startY == endY) {
            if(step < min)
                min = step;
            for(int i = map.size() - 1; i >= 0; i -= 2){
                nextX = map.get(i);
                nextY = map.get(i - 1);
                System.out.print("[" + nextX + "," + nextY + "]");
                if(i != 1)
                    System.out.print("->");
            }
            System.out.println();
            return;
        }
        for(posible = 0; posible < next.length; posible++) { //按右->下->左->上的顺序尝试
            nextX = startX + next[posible][0];
            nextY = startY + next[posible][1];
            if(nextX < 0 || nextX >= width || nextY < 0 || nextY >= height) {  //超出边界
                continue;
            }
            if(maze[nextX][nextY] == 0 && mark[nextX][nextY] == 0) {  //非障碍且未标记走过
                map.push(nextX);
                map.push(nextY);
                mark[nextX][nextY] = 1;
                dfs(nextX, nextY, step + 1);  //递归调用, 移动到下一格
                mark[nextX][nextY] = 0;
                map.pop();
                map.pop();
            }
        }
    }
}

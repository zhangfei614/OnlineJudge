package tsinghua.cs.zhangfei.tsinsen;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Fei Zhang on 2016/6/2.
 * Email:zhangfei614@126.com
 */

public class VertexCover {
    public static void main(String[] args){
//        Scanner input = OJTools.testFileScanner();
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int m = input.nextInt();
            int k = input.nextInt();

            int[][] matrix = new int[n][n];
            for(int i = 0; i < m ; i++) matrix[input.nextInt()-1][input.nextInt()-1] = 1;
            List<Integer> vertexs = new LinkedList<Integer>();
            for(int i = 0; i < n; i++)
                for(int j = 0 ; j < n; j++){
                    if(matrix[i][j] == 1){
                        vertexs.add(i);
                        removeEdge(matrix, i);
                        vertexs.add(j);
                        removeEdge(matrix,j);
                    }
                }

            for(int i = 0 ; i < vertexs.size(); i++){
                if(backTrace(vertexs,i,matrix,k)){
                    System.out.println("true");
                    return;
                }
            }
            System.out.println("false");
        }
    }

    private static boolean backTrace(List<Integer> vertexs,int idx,int[][] matrix,int target){
        if(vertexs.size() <= target)
            return true;
        int k = vertexs.remove(idx);
        for(int i = 0; i < matrix.length; i++)
            if((matrix[k][i] == -1 || matrix[i][k] == -1) && !vertexs.contains(i)){
                vertexs.add(idx,k);
                return false;
            }
        for(int i = 0; i < vertexs.size(); i++){
            if(backTrace(vertexs,i,matrix,target))
                return true;
        }
        vertexs.add(idx,k);
        return false;
    }

    private static void removeEdge(int[][] matrix,int k){
        for(int i = 0; i < matrix.length; i++)
            if(matrix[i][k] == 1)
                matrix[i][k] = -1;
        for(int i = 0; i < matrix.length; i++)
            if(matrix[k][i] == 1)
                matrix[k][i] = -1;
    }

}

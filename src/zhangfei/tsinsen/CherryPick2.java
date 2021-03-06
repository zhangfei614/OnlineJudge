package zhangfei.tsinsen;

import java.util.*;


/**
 * Created by Fei Zhang on 2016/4/12.
 * Email:zhangfei614@126.com
 */

public class CherryPick2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
//        Scanner input = OJTools.testFileScanner();
        int n,m,k,l,r;
        int[] array;
        while(input.hasNext()){
            n = input.nextInt();
            array = new int[n+1];
            for(int i = 1; i <= n; i++) array[i] = input.nextInt();
            m = input.nextInt();
            for(int i = 0; i < m; i++){
                k = input.nextInt();
                l = input.nextInt();
                r = input.nextInt();
                List<Integer> result = query(array,k,l,r);
                if(result == null || result.size() == 0) System.out.println("EMPTY");
                else{
                    boolean flag = true;
                    for(Integer integer : result){
                        if(flag){
                            System.out.print(integer);
                            flag = false;
                        }else{
                            System.out.print(" "+integer);
                        }
                    }
                    System.out.println();
                }
            }
        }
    }
    private static List<Integer> query(int[] array,int k,int l,int r){
        if(r < l) return null;
        if(k > r-l+1) return null;
        int temp;

        TreeMap<Integer,Integer> treeMap = new TreeMap<Integer, Integer>();
        for(int i = l; i <= r; i++) {
            if(treeMap.containsKey(array[i])) treeMap.put(array[i],treeMap.get(array[i])+1);
            else treeMap.put(array[i],1);
        }

        List<Integer> result = new ArrayList<Integer>();
        temp = 0;
        for(Map.Entry<Integer,Integer> entry: treeMap.entrySet()){
            temp+=entry.getValue();
            while( temp >= k){
                result.add(entry.getKey());
                temp -= k;
            }
        }
        return result;
    }
}

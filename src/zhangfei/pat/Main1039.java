package zhangfei.pat;

import zhangfei.OJTools;

import java.util.Scanner;

/**
 * Created by THU on 2015/9/8.
 */
public class Main1039 {
    public static void main(String[] args){
        Scanner input = OJTools.testFileScanner();
//        Scanner input = new Scanner(System.in);

        while(input.hasNext()){
            char[] arr1 = input.nextLine().toCharArray();
            char[] arr2 = input.nextLine().toCharArray();

            int count = arr2.length;
            for (char ch: arr2){
                for(int i=0;i<arr1.length;i++){
                    if(ch==arr1[i]){
                        count--;
                        arr1[i]='\0';
                        break;
                    }
                }
            }

            if(count==0){
                System.out.println("Yes "+(arr1.length-arr2.length));
            }else{
                System.out.println("No "+(count));
            }
        }
    }
}

package tsinghua.cs.zhangfei;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by THU on 2015/9/8.
 */
public class OJTools {
    public static Scanner testFileScanner(){
        Scanner input = null;
        try{
            input = new Scanner(new File("D:\\code\\OnlineJudge\\data.in"));
        }catch (FileNotFoundException e){
            System.out.println("Data.in file not found!");
        }
        return input;
    }

}

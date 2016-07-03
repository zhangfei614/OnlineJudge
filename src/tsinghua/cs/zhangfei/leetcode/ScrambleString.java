package tsinghua.cs.zhangfei.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangfei on 2016/7/3.
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if(s1 == null && s2 == null) return true;
        if(s1 == null || s2 == null) return false;
        if(s1.length() != s2.length()) return false;
        List<String> sList = scrambleString(s1);
        for(String s : sList){
            if(s.equals(s2)) return true;
            System.out.println(s);
        }
        return false;
    }

    List<String> scrambleString(String s){
        if(s.length() == 1) return Arrays.asList(s);
        if(s.length() == 2) return Arrays.asList(s,""+s.charAt(1)+s.charAt(0));
        int mid = s.length() / 2;
        List<String> left = scrambleString(s.substring(0,mid));
        List<String> right = scrambleString(s.substring(mid));
        List<String> res = new ArrayList<String>();
        for(String l : left)
            for(String r: right)
                res.add(l+r);
        for(String r : right)
            for(String l:left)
                res.add(r+l);
        mid = (s.length() + 1)/2;
        left = scrambleString(s.substring(0,mid));
        right = scrambleString(s.substring(mid));
        res = new ArrayList<String>();
        for(String l : left)
            for(String r: right)
                res.add(l+r);
        for(String r : right)
            for(String l:left)
                res.add(r+l);
        return res;
    }

    public static void main(String[] args){
        String s1 = "abc";
        String s2 = "acb";
        System.out.println(new ScrambleString().isScramble(s1,s2));
    }
}

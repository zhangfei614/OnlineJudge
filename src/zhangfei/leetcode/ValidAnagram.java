package zhangfei.leetcode;

import java.util.Arrays;

/**
 * Created by Fei Zhang on 2016/3/22.
 * Email:zhangfei614@126.com
 Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.
 */

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null || s.length()!=t.length()) return false;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        s = new String(sArray);
        t = new String(tArray);
        return s.equals(t);
    }

    public static void main(String[] args){
        System.out.println(new ValidAnagram().isAnagram("",""));
    }
}

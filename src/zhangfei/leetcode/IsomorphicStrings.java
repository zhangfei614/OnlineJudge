package zhangfei.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fei Zhang on 2016/5/25.
 * Email:zhangfei614@126.com
 */

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) return true;
        if(s.length() != t.length()) return false;
        if(s.length() == 0 || s.length() == 1) return true;
        Map<Character,Character> sMap = new HashMap<Character, Character>();
        Map<Character,Character> tMap = new HashMap<Character, Character>();
        for(int i = 0; i < s.length() ; i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(!sMap.containsKey(sChar) && !tMap.containsKey(tChar)){
                sMap.put(sChar,tChar);
                tMap.put(tChar,sChar);
            }else{
                if(sMap.containsKey(sChar) && tMap.containsKey(tChar) && sMap.get(sChar) == tChar && tMap.get(tChar) == sChar)
                    continue;
                return false;
            }
        }
        return true;
    }
    public boolean isIsomorphicArray(String s, String t) {
        if(s == null && t == null) return true;
        if(s.length() != t.length()) return false;
        if(s.length() == 0 || s.length() == 1) return true;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        char[] sTable = new char[256];
        char[] tTable = new char[256];

        for(int i = 0; i < s.length(); i++){
            char sChar = sArray[i];
            char tChar = tArray[i];
            if(sTable[tChar] == 0 && tTable[sChar] == 0){
                sTable[tChar] = tChar;
                tTable[sChar] = sChar;
            }else{
                if(sTable[tChar] != tChar || tTable[sChar] != sChar)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(new IsomorphicStrings().isIsomorphicArray("ab","aa"));
    }
}

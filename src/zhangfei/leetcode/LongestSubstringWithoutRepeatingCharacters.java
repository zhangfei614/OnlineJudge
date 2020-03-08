package tsinghua.cs.zhangfei.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by THU on 2015/10/21.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args){
        LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
        int a = test.lengthOfLongestSubstring("abcabcabc");
        System.out.println(a);

    }
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] arr = s.toCharArray();
        int max = 0;
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        int i=0;
        int j=0;
        for(;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],i);
            }else{
                if(i-j>max) max = i-j;
                while(arr[j]!=arr[i]){
                    map.remove(arr[j]);
                    j++;
                }
                j=j+1;
            }
        }
        if(i-j > max) max = i-j;
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}

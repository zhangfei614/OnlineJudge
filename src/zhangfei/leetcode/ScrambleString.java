package zhangfei.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangfei on 2016/7/3.
 */
public class ScrambleString {
    public boolean isScrambleComplexDP(String s1, String s2) {
        if(s1 == null && s2 == null) return true;
        if(s1 == null || s2 == null) return false;
        if(s1.length() != s2.length()) return false;
        int n = s1.length();
        List[][] dp = new List[n][n];
        for(int i = 0; i < n; i++)
            for(int j = i; j < n; j++){
                dp[i][j] = new ArrayList<String>();
                if(i == j) dp[i][j].add(""+s1.charAt(i));
            }

        for(int l = 2; l <= n; l++)
            for (int i = 0; i <= n - l; i++){
                int j = i + l -1;
                for(int k = i; k < j ; k++){
                    List<String> left = dp[i][k];
                    List<String> right = dp[k+1][j];
                    for(String le : left)
                        for(String ri : right){
                            dp[i][j].add(le+ri);
                            dp[i][j].add(ri+le);
                        }
                }
            }

        for(String s : (List<String>)dp[0][n-1]){
            System.out.println(s);
            if(s.equals(s2)) return true;
        }
        return false;
    }

    /**
     * @param s1
     * @param s2
     * @return
     * 递归的使用，判断每一个子串是否是对应为scramble string
     */
    public boolean isScrambleSimple(String s1, String s2) {
        if(s1.endsWith(s2)) return true;
        if(s1.length() != s2.length()) return false;
        int[] letters = new int[26];
        for(int i = 0; i < s1.length(); i++){
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }
        for(int i = 0; i < letters.length; i++)
            if(letters[i] != 0) return false;
        for(int i = 1; i < s1.length(); i++){
            if(isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i)))
                return true;
            if(isScramble(s1.substring(0,i),s2.substring(s2.length()-i)) && isScramble(s1.substring(i),s2.substring(0,s2.length()-i)))
                return true;
        }
        return false;
    }

    /**
     *
     * @param s1
     * @param s2
     * @return
    Scan s1 and s2 in order, if found first cnt chars set are the same in s1 and s2, recursive call.
    Scan s1 in order s2 reversely, if found first cnt chars set are the same, recursive call.
    If s1 and s2 have length of 1, return if there are equal.
     */
    public boolean isScramble(String s1,String s2){
        if(s1.length() != s2.length()) return false;
        if(s1.length() == 1) return s1.equals(s2);
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for(int i = 0,cnt1 = 0, cnt2 = 0; i < s1.length()-1; i++){
            if(map1[s1.charAt(i)-'a']++ < 0) cnt1++;
            if(map1[s2.charAt(i)-'a']-- > 0) cnt1++;
            if(cnt1 == i+1)
                if(isScramble(s1.substring(0,cnt1),s2.substring(0,cnt1)) && isScramble(s1.substring(cnt1),s2.substring(cnt1)))
                    return true;
            if(map2[s1.charAt(i)-'a']++ < 0) cnt2++;
            if(map2[s2.charAt(s2.length()-1-i)-'a']-- > 0) cnt2++;
            if(cnt2 == i+1)
                if(isScramble(s1.substring(0,cnt2),s2.substring(s2.length()-cnt2)) && isScramble(s1.substring(cnt2),s2.substring(0,s2.length()-cnt2)))
                    return true;

        }
        return false;
    }
    public static void main(String[] args){

    }
}

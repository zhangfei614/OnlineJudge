package zhangfei.leetcode;

/**
 * Created by zhangfei on 2016/7/2.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if(word1 == null && word2 == null) return 0;
        if(word1 == null || word1.length() == 0) return word2.length();
        if(word2 == null || word2.length() == 0) return word1.length();
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[] dp = new int[w2.length];

       for(int i = 0; i < w1.length; i++){
           int m = 0, n;
           for(int j =0 ; j < w2.length; j++){
               if(w1[i] == w2[j]){
                   n =  i != 0 && j != 0 ? m: i+j;
               }else{
                   n =  Math.min( i != 0 && j != 0 ? m : i+j ,Math.min(i != 0 ? dp[j]:j ,j != 0 ? dp[j-1]:i))+1;
               }
               m = dp[j];
               dp[j] = n;
           }
       }
        return dp[dp.length-1];
    }

    public static void main(String[] args){
        String w1 = "zoologicoarchaeologist";
        String w2 = "zoogeologist";
        System.out.println(new EditDistance().minDistance(w1,w2));
    }
}

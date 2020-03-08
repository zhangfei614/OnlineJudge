package tsinghua.cs.zhangfei.leetcode;

import java.util.*;

/**
 * Created by zhangfei on 2016/6/1.
 */
public class PalindromePairs {
    public final static int LENGTH = 30;
    public List<List<Integer>> palindromePairsComplex(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(words == null || words.length < 2) return res;
        List[] head = new List[LENGTH];
        List[] tail = new List[LENGTH];
        for(int i = 0; i < LENGTH; i++){
            head[i] = new LinkedList<Integer>();
            tail[i] = new LinkedList<Integer>();
        }
        for(int i = 0; i < words.length ; i++){
            if(words[i].equals("")){
                for(int j = 0; j < LENGTH; j++){
                    head[j].add(i);
                    tail[j].add(i);
                }
            }else{
                int h = words[i].charAt(0)-'a';
                int t = words[i].charAt(words[i].length()-1)-'a';
                head[h].add(i);
                tail[t].add(i);
            }
        }
        for(int i = 0; i < LENGTH; i++){
            for(int j :(LinkedList<Integer>)head[i]){
                for(int k : (LinkedList<Integer>) tail[i]){
                    if(j == k) continue;
                    if(isPalindrome(words[j],words[k]))
                        res.add(Arrays.asList(j,k));
                }
            }
        }
        return res;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(words == null || words.length < 2) return res;
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(int i = 0; i < words.length; i++) map.put(words[i],i);
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j <= words[i].length(); j++){
                String str1 = words[i].substring(0,j);
                String str2 = words[i].substring(j);
                if(isPalindrome(str1)){
                    String r = new StringBuilder(str2).reverse().toString();
                    if(map.containsKey(r)  && map.get(r) != i){
                        res.add(Arrays.asList(map.get(r),i));
                    }
                }
                if(isPalindrome(str2)){
                    String r = new StringBuilder(str1).reverse().toString();
                    if(str2.length() != 0 && map.containsKey(r) && map.get(r) != i ){
                        res.add(Arrays.asList(i,map.get(r)));
                    }
                }
            }
        }
        return res;
    }
    private boolean isPalindrome(String str){
        int n = str.length();
        for( int i = 0; i < n/2; i++ )
            if (str.charAt(i) != str.charAt(n-i-1)) return false;
        return true;
    }
    private boolean isPalindrome(String a,String b){
        String str = a+b;
        int n = str.length();
        for( int i = 0; i < n/2; i++ )
            if (str.charAt(i) != str.charAt(n-i-1)) return false;
        return true;
    }



    public static void main(String[] args){
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> res = new PalindromePairs().palindromePairs(words);
        for(List<Integer> list : res){
            System.out.println(list.get(0)+","+list.get(1));
        }
    }
}

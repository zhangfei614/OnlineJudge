package zhangfei.leetcode;

/**
 * Created by zhangfei on 2016/4/12.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String pre = "1";
        for(int i=1; i < n; i++){
            char[] charArray = pre.toCharArray();
            char temp = charArray[0];
            int sum = 0;
            pre = "";
            for(char c:charArray){
                if(c == temp) sum++;
                else{
                    pre+=sum;
                    pre+=temp;
                    temp = c;
                    sum = 1;
                }
            }
            pre+=sum;
            pre+=temp;
        }
        return pre;
    }

    public String countAndSay2(int n){
        String pre = "1";
        StringBuilder sb = new StringBuilder();
        int count;
        for(int i = 1; i < n; i++){
            sb.setLength(0);
            count = 1;
            for(int j = 1; j < pre.length();j++){
                if(pre.charAt(j)!=pre.charAt(j-1)){
                    sb.append(count);
                    sb.append(pre.charAt(j-1));
                    count = 0;
                }
                count++;
            }
            sb.append(count);
            sb.append(pre.charAt(pre.length()-1));
            pre = sb.toString();
        }
        return pre;
    }

    public static void main(String[] args){
        System.out.println(new CountAndSay().countAndSay2(3));
    }
}

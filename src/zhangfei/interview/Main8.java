package zhangfei.interview;

import java.util.Scanner;

/**
 * Created by Fei Zhang on 2017/8/30.
 * Email:zhangfei614@126.com
 */

public class Main8 {

    private static final String type = "int";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()) {
            sb.append(scanner.nextLine());
        }
        try {
            System.out.println(isSame(sb.toString()));
        } catch (Exception e) {
            System.out.println(0);
        }
    }

    private static int isSame(String str) {
        str = str.replaceAll("\\s*", "");
        if (!str.startsWith(type)) return 0;
        if (!str.endsWith("}")) return 0;
        String var1 = str.substring(str.indexOf('(')+1, str.indexOf(','));
        if (!var1.startsWith(type)) return 0;
        var1 = var1.substring(3);

        String var2 = str.substring(str.indexOf(',')+1, str.indexOf(')'));
        if (!var2.startsWith(type)) return 0;
        var2 = var2.substring(3);

        String[] sens = str.substring(str.indexOf('{')+1, str.lastIndexOf(';')).split(";", -1);
        if (sens.length != 3) return 0;

        if (!sens[0].startsWith(type)) return 0;
        String sum = sens[0].substring(3, sens[0].indexOf('='));
        int init = Integer.valueOf(sens[0].substring(sens[0].indexOf('=')+1));
        if (init != 0) return 0;

        if (!sens[1].equals(sum + "=" + var1 + "+" + var2) && !sens[1].equals(sum + "=" + var2 + "+" + var1))
            return 0;

        if (!sens[2].startsWith("return")) return 0;
        if (!sens[2].substring(6).equals(sum)) return 0;
        return 1;
    }


    private static boolean isEmpty(String str) {
        if (str == null || str.length() == 0) return true;
        else return false;
    }

}

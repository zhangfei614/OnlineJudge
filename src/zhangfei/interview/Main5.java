package zhangfei.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhangfei614 on 2017/8/25.
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<UnilateralLine> lineList = new ArrayList<UnilateralLine>();
        while (scanner.hasNextLine()) {
            String[] options = scanner.nextLine().split(";");
            if (options.length < 5) {
                break;
            }
            lineList.add(new UnilateralLine(options[0], options[1], options[2], options[3], options[4], options[5]));
        }
        scanner.close();

        // wirte your code here
        List<String> result = calculateUnilateral(lineList);

        for (String str : result) {
            System.out.println(str);
        }
    }

    public static List<String> calculateUnilateral(List<UnilateralLine> lineList) {
        List<String> result = new ArrayList<String>();
        //rule 1
        for (int i = 0; i < lineList.size(); i++) {
            for (int j = i + 1; j < lineList.size(); j++) {
                UnilateralLine l1 = lineList.get(i);
                UnilateralLine l2 = lineList.get(j);
                if (l1.sCen.equals(l2.eCen) && l1.eCen.equals(l2.sCen) && l1.tType.equals(l2.tType))
                    result.add("rule1:" + l1.id + "+" + l2.id);
            }
        }
        //rule 2
        for (int i = 0; i < lineList.size(); i++) {
            for (int j = 0; j < lineList.size(); j++) {
                UnilateralLine l1 = lineList.get(i);
                UnilateralLine l2 = lineList.get(j);
                if (l1.eCen.equals(l2.sCen) && !l1.sCen.equals(l2.eCen)) {
                    for (int k = 0; k < lineList.size(); k++) {
                        UnilateralLine l3 = lineList.get(k);
                        if (l3.sCen.equals(l2.eCen) && l3.equals(l1.sCen)) {
                            result.add("rule2:" + l1.id + "+" + l2.id + "+" + l3.id);
                        }
                    }
                }
            }
        }
        return result;
    }


    public static class UnilateralLine {
        private String id;
        private String sCen;//出发分拨
        private String sPro;//出发省
        private String eCen;//到达分拨
        private String ePro;//到达省
        //9.6m/17.5m
        private String tType;//车型

        public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro, String tType) {
            this.id = id;
            this.sCen = sCen;
            this.sPro = sPro;
            this.eCen = eCen;
            this.ePro = ePro;
            this.tType = tType;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSCen() {
            return sCen;
        }

        public void setSCen(String ePro) {
            this.ePro = ePro;
        }

        public String getSPro() {
            return sPro;
        }

        public void setSPro(String sPro) {
            this.sPro = sPro;
        }

        public String getECen() {
            return eCen;
        }

        public void setECen(String eCen) {
            this.eCen = eCen;
        }

        public String getEPro() {
            return ePro;
        }

        public void setEPro(String ePro) {
            this.ePro = ePro;
        }

        public String getTType() {
            return tType;
        }

        public void setTType(String tType) {
            this.tType = tType;
        }
    }
}

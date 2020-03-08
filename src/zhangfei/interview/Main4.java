package tsinghua.cs.zhangfei.interview;

import java.util.*;

public class Main4 {
/** 请完成下面这个process函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/

    static class Box {
        int price;
        int length;
        int width;
        int height;
    }

    static class Model {
        int price;
        int length;
        int width;
        int height;
    }

    private static Box boxTemplate = new Box();
    public static final int CUSTOMS_LIMIT_MONEY_PER_BOX = 2000;
    public static Model[] items;
    public static int boxMinNum;

    private static int process() {
        Arrays.sort(items, new Comparator<Model>() {
            @Override
            public int compare(Model o1, Model o2) {
                return o2.price - o1.price;
            }
        });


//        for (Model item : items) {
//            System.out.println(item.price + "" + item.height);
//        }

        List<Box> boxList = new ArrayList<>();
        boxList.add(getNewBox());
        for (Model item : items) {
            boolean flag = false;
            for (Box box : boxList) {
                if (pub(box, item)) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                Box newBox = getNewBox();
                if (pub(newBox, item)) {
                    boxList.add(newBox);
                } else {
                    return -1;
                }
            }
        }

        return boxList.size();
    }

    private static boolean pub(Box box, Model model) {
        sortBox(box);
        if (box.price < model.price || box.length < model.length || box.width < model.width || box.height < model.height)
            return false;

        box.price -= model.price;
        box.length -= model.length;
        box.width -= model.width;
        box.height -= model.height;
        return true;
    }

    private static void sortBox(Box box){
        int[] temp = new int[3];
        temp[0] = box.length;
        temp[1] = box.width;
        temp[2] = box.height;
        Arrays.sort(temp);
        box.length = temp[0];
        box.width = temp[1];
        box.height = temp[2];
    }

    private static Box getNewBox() {
        Box box = new Box();
        box.price = boxTemplate.price;
        box.length = boxTemplate.length;
        box.height = boxTemplate.height;
        box.width = boxTemplate.width;
        return box;
    }


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        boxTemplate.price = CUSTOMS_LIMIT_MONEY_PER_BOX;

        int[] temp = new int[3];

        while (scanner.hasNext()) {
            for (int i = 0; i < 3; i++)
                temp[i] = scanner.nextInt();
            Arrays.sort(temp);
            boxTemplate.length = temp[0];
            boxTemplate.width = temp[1];
            boxTemplate.height = temp[2];

            int itemNum = scanner.nextInt();
            items = new Model[itemNum];
            for (int i = 0; i < itemNum; i++) {
                Model item = new Model();
                item.price = scanner.nextInt();
                for (int j = 0; j < 3; j++)
                    temp[j] = scanner.nextInt();
                item.length = temp[0];
                item.width = temp[1];
                item.height = temp[2];
                items[i] = item;
            }
            long startTime = System.currentTimeMillis();
            boxMinNum = Integer.MAX_VALUE;
            System.out.println(process());

        }
    }

}
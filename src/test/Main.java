package test;

import java.util.Scanner;

/**
 * Created by Fei Zhang on 2017/3/21.
 * Email:zhangfei614@126.com
 */
class Rectangle {
    private int height;
    private int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getArea() {
        return this.height * this.width;
    }

    public int getPermeter() {
        return 2 * (this.height + this.width);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int width = scanner.nextInt();
        Rectangle rectangle = new Rectangle(height, width);
        System.out.println(rectangle.getArea() + " " + rectangle.getPermeter());
    }
}

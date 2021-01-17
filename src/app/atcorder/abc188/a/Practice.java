package app.atcorder.abc188.a;

import java.util.Scanner;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();

        if (Math.abs(X - Y) < 3) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        sc.close();
    }
}

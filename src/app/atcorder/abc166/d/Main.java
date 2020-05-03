package app.atcorder.abc166.d;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long X = sc.nextLong();
        sc.close();

        for (int i = -118; i < 119; i++) {
            for (int j = -119; j < 118; j++) {
                if (Math.pow(i, 5) - Math.pow(j, 5) == X) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }
}

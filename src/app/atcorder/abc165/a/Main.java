package app.atcorder.abc164.a;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int W = sc.nextInt();

        if (W >= S) {
            System.out.println("unsafe");
        } else {
            System.out.println("safe");
        }
        sc.close();
    }
}

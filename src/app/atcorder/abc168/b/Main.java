package app.atcorder.abc168.b;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        String S = sc.next();
        sc.close();

        if (K - S.length() < 0) {
            System.out.println(S.substring(0, K) + "...");
        } else {
            System.out.println(S);
        }
    }
}

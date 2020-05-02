package app.atcorder.abc164.d;

import java.util.Scanner;

/**
 * 逆元を利用する
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        sc.close();

        int count = 0;
        for (int j = 4; j <= S.length(); j++) {
            for (int i = 0; i < j - 3; i++) {
                if (Float.parseFloat(S.substring(i, j)) % 2019 == 0) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}

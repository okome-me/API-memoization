package app.atcorder.etc.abc086_a;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split("");

        int count=0;
        for (int i = 0; i < s.length; i++) {
            if (Integer.parseInt(s[i])==1) {
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}

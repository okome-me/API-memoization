package app.atcorder.abc165.d;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long N = sc.nextLong();
        sc.close();

        if (N > B) {
            N = B;
        }

        long max = -1;
        for (long x = N; x >= 0; x--) {
            if (x < B - 1 && max != -1) {
                break;
            }
            long letMax = (long) (A * x / B) - A * (long) (x / B);
            if (letMax >= max) {
                max = letMax;
            }
        }

        System.out.println(max);
    }
}

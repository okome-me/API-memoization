package app.atcorder.abc188.b;

import java.util.Scanner;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[N];
        int[] B = new int[N];

        int sum = 0;

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
            sum += A[i] * B[i];
        }

        sc.close();

        if (sum == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

package app.atcorder.abc188.c;

import java.util.Scanner;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max = (int) Math.pow(2, N);
        long[][] A = new long[max][2];
        for (int i = 0; i < max; i++) {
            A[i][0] = i;
            A[i][1] = sc.nextInt();
        }
        for (int i = 1; i <= N - 1; i++) {
            int tmpMax = (int) Math.pow(2, N - i);
            long[][] tmpA = new long[tmpMax][2];
            for (int j = 1; j <= Math.pow(2, N - i); j++) {
                if (A[2 * j - 2][1] > A[2 * j - 1][1]) {
                    tmpA[j - 1] = A[2 * j - 2];
                } else {
                    tmpA[j - 1] = A[2 * j - 1];
                }
//                System.out.print(tmpA[j - 1][1] + ",");
            }
//            System.out.printf("\n");
            A = tmpA;
        }
        if (A[0][1] > A[1][1]) {
            System.out.printf(String.valueOf(A[1][0] + 1));
        } else {
            System.out.printf(String.valueOf(A[0][0] + 1));
        }
    }
}

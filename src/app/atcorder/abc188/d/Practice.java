package app.atcorder.abc188.d;

import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long C = sc.nextLong();

        /**
         * O(NlogN)
         */
        TreeMap<Long, Long> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            Long a = sc.nextLong();
            Long b = sc.nextLong();
            Long c = sc.nextLong();
            map.put(a - 1, map.getOrDefault(a - 1, 0l) + c);
            map.put(b, map.getOrDefault(b, 0l) + -c);
        }
        sc.close();

        Long totalCost = 0L;
        Long time = 0L;
        Long cost = 0L;
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            totalCost += Math.min(C, cost) * (entry.getKey() - time);
            time = entry.getKey();
            cost += entry.getValue();
        }
        System.out.println(totalCost);

        /**
         * 純粋な実装
         * O(N*(最大終了日-最小開始日))
         */
//        int[] a = new int[N];
//        int[] b = new int[N];
//        int[] c = new int[N];
//        int start = 1000000000;
//        int end = 0;
//
//        for (int i = 0; i < N; i++) {
//            a[i] = sc.nextInt();
//            b[i] = sc.nextInt();
//            c[i] = sc.nextInt();
//            if (a[i] < start) {
//                start = a[i];
//            }
//            if (b[i] > end) {
//                end = b[i];
//            }
//        }
//        sc.close();
//
//        long totalCost = 0;
//        for (long i = start; i <= end; i++) {
//            long cost = 0;
//            for (int j = 0; j < N; j++) {
//                if(a[j] <= i && b[j] >= i) {
//                    cost += c[j];
//                }
//                if(j == N-1 && cost >= C) {
//                    cost = C;
//                }
//            }
//            totalCost += cost;
//        }
//        System.out.println(totalCost);
    }
}

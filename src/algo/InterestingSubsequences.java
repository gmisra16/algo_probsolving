package algo;

import java.util.*;

public class InterestingSubsequences {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();
            for (int i = 0; i < tc; i++) {
                int N = scanner.nextInt();
                int K = scanner.nextInt();
                int[] A = new int[N];
                TreeMap<Integer, Integer> map = new TreeMap<>();
                for (int j = 0; j < N; j++) {
                    A[j] = scanner.nextInt();
                    if (map.containsKey(A[j])) {
                        map.put(A[j], map.get(A[j]) + 1);
                    } else {
                        map.put(A[j], 1);
                    }
                }
                Arrays.sort(A);
                int kElement = A[K - 1];
                int kElementCountB4K = 0;
                for (int j = K - 1; j >= 0; j--) {
                    if (A[K - 1] == A[j]) kElementCountB4K++;
                }

                System.out.println(C(map.get(kElement), kElementCountB4K));
            }
        }

    }

    public static long C(int n, int r) {
        long C[] = new long[r + 1];
        C[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, r); j > 0; j--)
                C[j] = C[j] + C[j - 1];
        }
        return C[r];
    }
}

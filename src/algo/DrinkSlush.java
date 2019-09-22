package algo;

import java.util.Scanner;

public class DrinkSlush {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();
            for (int i = 0; i < tc; i++) {
                int N = scanner.nextInt();
                int M = scanner.nextInt();
                int[] C = new int[M];
                int[] D = new int[N];
                int[] F = new int[N];
                int[] B = new int[N];
                for (int c = 0; c < M; c++) {
                    C[c] =scanner.nextInt();
                }
                for (int j = 0; j < N; j++) {
                    D[j] =scanner.nextInt();
                    F[j] =scanner.nextInt();
                    B[j] =scanner.nextInt();
                }
            }

        }
    }
}

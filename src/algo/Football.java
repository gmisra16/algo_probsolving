package algo;

import java.util.Scanner;

public class Football {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();
            for (int i = 0; i < tc; i++) {
                int N = scanner.nextInt();
                int[] A = new int[N];
                int[] B = new int[N];
                for (int j = 0; j < N; j++) {
                    A[j] = scanner.nextInt();
                }
                for (int j = 0; j < N; j++) {
                    B[j] = scanner.nextInt();
                }
                int max = 0;
                for (int j = 0; j < N; j++) {
                    int score = A[j] * 20 - B[j] * 10;
                    if (score > max) max = score;
                }
                System.out.println(max);

            }
        }
    }
}




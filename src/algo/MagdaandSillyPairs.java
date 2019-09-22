package algo;

import java.util.Scanner;

public class MagdaandSillyPairs {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();
            for (int i = 0; i < tc; i++) {
                int N = scanner.nextInt();
                int[] A = new int[N];
                int[] B = new int[N];
                long max = 0;
                int evenA = 0;
                long sumA = 0;
                int evenB = 0;
                long sumB = 0;
                for (int j = 0; j < N; j++) {
                    A[j] = scanner.nextInt();
                    if (A[j] % 2 == 0) evenA++;
                    sumA += A[j];
                }
                for (int j = 0; j < N; j++) {
                    B[j] = scanner.nextInt();
                    if (B[j] % 2 == 0) evenB++;
                    sumB += B[j];
                }
                int evenOddPair = Math.abs(evenA-evenB);
                max = (sumA+sumB-evenOddPair)/2;
                System.out.println(max);



            }

        }
    }
}

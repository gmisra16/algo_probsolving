package algo;

import java.util.Arrays;
import java.util.Scanner;

public class RestoreSequence {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();
            for (int t = 0; t < tc; t++) {
                int N = scanner.nextInt();
                int[] A = new int[N];
                for (int i = 0; i < N; i++) {
                    A[i] = N-i;
                }
                int[] B = new int[N];
                for (int j = 0; j < N; j++) {
                    B[j] = scanner.nextInt();
                    if(B[j]>j+1){
                        A[j] = A[B[j]-1];
                    }
                }
                StringBuilder b = new StringBuilder();
                for (int i = 0; i< N; i++) {
                    b.append(A[i]);
                    if (i == N-1) {
                        System.out.println(b.toString());
                    }else b.append(" ");
                }
            }
        }
    }
}

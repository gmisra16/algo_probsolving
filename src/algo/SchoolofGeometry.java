package algo;

import java.util.Arrays;
import java.util.Scanner;

public class SchoolofGeometry {
  public static void main(String[] args) throws Exception {
    try (Scanner scanner = new Scanner(System.in)) {
      int TC = scanner.nextInt();

      for (int i = 0; i < TC; i++) {
        int N = scanner.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int j = 0; j < N; j++) {
          A[j] = scanner.nextInt();
        }
        Arrays.sort(A);
        for (int j = 0; j < N; j++) {
          B[j] = scanner.nextInt();
        }
        Arrays.sort(B);
        long sum = 0;
        for (int j = 0; j < N; j++) {
          sum += Math.min(A[j],B[j]);
        }
        System.out.println(sum);
      }
    }

  }
}

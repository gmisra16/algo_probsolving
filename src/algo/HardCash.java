package algo;

import java.util.Arrays;
import java.util.Scanner;

public class HardCash {
  public static void main(String[] args) throws Exception {
    try (Scanner scanner = new Scanner(System.in)) {
      int TC = scanner.nextInt();

      for (int i = 0; i < TC; i++) {
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] A = new int[N];
        long sum =0;
        for (int j = 0; j < N; j++) {
          A[j] = scanner.nextInt();
          sum+=(A[j]%K);
        }
        System.out.println(sum%K);
      }
    }
  }
}

package algo;

import java.util.Arrays;
import java.util.Scanner;

public class LasersEverywhere {
  public static void main(String[] args) throws  Exception{
    try(Scanner scanner = new Scanner(System.in)){
      int T = scanner.nextInt();
      for (int tc = 0; tc < T; tc++) {
        final int N = scanner.nextInt();
        final int Q = scanner.nextInt();
        int[] Y = new int[N];
        Y[0]  = scanner.nextInt();
        for (int i = 1; i < N; i++) {
          Y[i]  = scanner.nextInt();

        }
        System.out.println(Arrays.toString(Y));
        int[] X1 = new int[Q];
        int[] X2 = new int[Q];
        int[] YQ = new int[Q];
        for (int i = 0; i < Q; i++) {
          X1[i] = scanner.nextInt();
          X2[i] = scanner.nextInt();
          YQ[i]  = scanner.nextInt();

          System.out.println();
        }
      }
    }

  }
}

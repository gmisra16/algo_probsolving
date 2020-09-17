package algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PintuandFruits {
    public static void main(String[] args) throws java.lang.Exception {
    try (Scanner scanner = new Scanner(System.in)) {
      int T = scanner.nextInt();

      while (T-- > 0) {
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        final int[] F = new int[N];
        for (int i = 0; i < N; i++) {
          F[i] = scanner.nextInt();
        }
        final int[] P = new int[N];
        for (int i = 0; i < N; i++) {
          P[i] = scanner.nextInt();
        }
        Map<Integer,Integer> fp = new HashMap<>();
        for (int i = 0; i < N; i++) {
          final int fruit=F[i];
          final int price=P[i];
          fp.computeIfPresent(fruit,(f,p)->p+price);
          fp.putIfAbsent(fruit,price);
        }
        System.out.println(fp.values().stream().min(Integer::compareTo).get());
      }
    }
  }

}

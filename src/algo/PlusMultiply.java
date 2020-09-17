package algo;

import java.util.Scanner;

public class PlusMultiply {
  public static void main(String[] args) throws java.lang.Exception {
    try (Scanner scanner = new Scanner(System.in)) {
      int T = scanner.nextInt();

      while (T-- > 0) {
        int N = scanner.nextInt();
        int count2 = 0;
        int count0 = 0;
        for (int i = 0; i < N; i++) {
          int A = scanner.nextInt();
          if (A == 2) count2++;
          if (A == 0) count0++;

        }
        int pairs = nC2(count0) + nC2(count2);
        System.out.println(pairs);
      }
    }
  }

  private static int nC2(int n) {
    int res = 0;
    if (n == 2) res = 1;
    else if(n>2){
      res = (n * (n - 1)) / 2;
    }
    return res;
  }

}

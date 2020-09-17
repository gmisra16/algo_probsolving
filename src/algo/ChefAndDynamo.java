package algo;

import java.util.Scanner;

public class ChefAndDynamo {
  public static void main(String[] args) throws Exception {
    try (Scanner scanner = new Scanner(System.in)) {
      int T = scanner.nextInt();
      for (int i = 0; i < T; i++) {
        int N = scanner.nextInt();
        final long MAX = (long)Math.pow(10,N)-1l;
        long A = scanner.nextLong();
        long S = 2*MAX + A+2;
        System.out.println(S);

        long B = scanner.nextLong();
        long C = MAX-B+1;
        System.out.println(C);

        long D = scanner.nextLong();
        long E = MAX-D+1;
        System.out.println(E);

        int res = scanner.nextInt();
        if (res==-1)System.exit(1);
      }
    }
  }
}

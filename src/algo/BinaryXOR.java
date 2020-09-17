package algo;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class BinaryXOR {
  public static void main(String[] args) throws Exception {

    try (Scanner scanner = new Scanner(System.in)) {
      int[][] nCr = new int[1000001][];
      final int MOD = 1000000007;
      int T = scanner.nextInt();

      for (int i = 0; i < T; i++) {
        int len = scanner.nextInt();
        scanner.nextLine();
        String A = scanner.nextLine();
        String B = scanner.nextLine();
        int a1Cnt = 0;
        int b1Cnt = 0;
        for (int j = 0; j < len; j++) {
          if(A.charAt(j)=='1')a1Cnt++;
          if(B.charAt(j)=='1')b1Cnt++;
        }
        int r0 =Math.abs(a1Cnt-b1Cnt);
        int r1 =a1Cnt+b1Cnt-2*Math.min(a1Cnt,len-b1Cnt);
        long result =0;
        for (int j = r0; j <= Math.min(len,r1); j=j+2) {
          result +=nCr(len,j, MOD);
          result%=MOD;
        }
        System.out.println(result);
      }
    }
  }

  private static int nCr(int n, int r, final int MOD) {

    long C[] = new long[r+1];
    C[0] = 1L;
    for (int i = 1; i <=n ; i++) {
      for (int j=  Math.min(i,r); j >0 ; j--) {
        C[j] = Long.sum(C[j], C[j-1])%MOD;
      }
    }

    return (int)C[r];
  }
}

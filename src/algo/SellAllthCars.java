package algo;

import java.util.Arrays;
import java.util.Scanner;

public class SellAllthCars {
  public static void main(String[] args) throws  Exception{
    final int MOD = 1_000_000_007;
    try(Scanner scanner = new Scanner(System.in)) {
      int T = scanner.nextInt();
      for (int i = 0; i < T; i++) {
        int N = scanner.nextInt();
        int P[] = new int[N];
        for (int j = 0; j < N; j++) {
          P[j] = scanner.nextInt();
        }
        Arrays.sort(P);
        long profit = 0;
        for (int year = 0; year < N; year++) {
          int profitForThisYear = P[N-year-1]-year;
          if(profitForThisYear>0)profit+=profitForThisYear;
          else break;
        }
        System.out.println(profit%MOD);
      }
    }
  }
}

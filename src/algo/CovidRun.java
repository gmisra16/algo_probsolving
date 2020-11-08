package algo;

import java.util.Scanner;

public class CovidRun {
  public static void main(String[] args) throws  Exception{
    try(Scanner scanner = new Scanner(System.in)) {
      int T = scanner.nextInt();
      for (int i = 0; i < T; i++) {
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        String yesNo="NO";// YES NO
        // (X + K*i)%N = Y
        for (int j = 0; j < N; j++) {
          int mod = (X+K*j)%N;
          if(mod==Y){
            yesNo="YES";
            break;
          }
        }
        System.out.println(yesNo);
      }
    }
  }
}

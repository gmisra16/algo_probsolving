package algo;

import java.util.Scanner;

public class COVIDPandemicAndLongQueue {
  public static void main(String[] args) throws  Exception{
    try(Scanner scanner = new Scanner(System.in)) {
      int T = scanner.nextInt();
      for (int i = 0; i < T; i++) {
        int N = scanner.nextInt();
        int A[] = new int[N];
        String yesNo="YES";// YES NO
        //assuming initial set index -6
        int prevSetIndex = -6;
        for (int j = 0; j < N; j++) {
          A[j] = scanner.nextInt();
          if(A[j]==1){
            if((j-prevSetIndex) < 6) {
              yesNo="NO";
            }
            prevSetIndex=j;
          }
        }
        System.out.println(yesNo);
      }
    }
  }
}

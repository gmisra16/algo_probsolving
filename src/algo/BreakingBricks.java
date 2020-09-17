package algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BreakingBricks {
  public static void main(String[] args) throws Exception {
    try (Scanner scanner = new Scanner(System.in)) {
      int T = scanner.nextInt();
      for (int i = 0; i < T; i++) {
        int S = scanner.nextInt();
        //assert(W <= S)
        int W1 = scanner.nextInt();
        int W2 = scanner.nextInt();
        int W3 = scanner.nextInt();

        System.out.println(minimize(S,W1,W2,W3));
      }
    }
  }
  public static int minimize(int S,int W1,int W2,int W3){
    int sumW = W1+W2+W3;
    int sumW1W2 = W1+W2;
    int sumW3W2 = W3+W2;
    if(sumW == 0)return 0;
    if(S >= sumW)return 1;
    if((S >= sumW1W2) && (S >= sumW3W2))return 1+Math.min(minimize(S,0, 0, W3),minimize(S, W1, 0,0));
    if((S < sumW1W2) && (S < sumW3W2))return 1+Math.min(minimize(S,0, W2, W3),minimize(S, W1, W2,0));
    if((S >= sumW1W2) && (S < sumW3W2))return 1+Math.min(minimize(S,0, 0, W3),minimize(S, W1, W2,0));
    if((S < sumW1W2) && (S >= sumW3W2))return 1+Math.min(minimize(S,0, W2, W3),minimize(S, W1, 0,0));
    //assuming assert this should not happen
    return 0;
  }

}

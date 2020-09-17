package algo;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NoChangeRequired {
  public static void main(String[] args) throws Exception {
    try (Scanner scanner = new Scanner(System.in)) {
      int T = scanner.nextInt();
      for (int i = 0; i < T; i++) {
        int N = scanner.nextInt();
        int P = scanner.nextInt();
        int[] D = new int[N];
        int[] C = new int[N];
        boolean overpay = false;
        for (int j = 0; j < N; j++) {
          D[j] = scanner.nextInt();
          if (P % D[j] != 0 &&!overpay) {
            overpay = true;
            int c = Math.toIntExact(Math.round(P / D[j] + .5));
            if (c > 0) {
              C[j] = c;
            } else {
              C[j] = 1;
            }
          }
        }
        if (!overpay) {
          //find pair(a,b) gcd !=<a or b>
          for (int j = 0; j < N-1&&!overpay; j++) {
            for (int k = j+1; k < N; k++) {
              if(D[k]%D[j]!=0){
                overpay=true;
                int x = Math.toIntExact(Math.round((P - D[k]) / D[j] + .5));
                C[j]=x;
                C[k]=1;
                break;
              }else{
                j++;
                k=j;
              }
            }
          }
          if(!overpay){
            System.out.println("NO");
          } else{
            System.out.println("YES" + " "+ Arrays.stream(C).mapToObj(x->String.valueOf(x)).collect(Collectors.joining(" ")));
          }
        } else {
          System.out.println("YES" + " "+ Arrays.stream(C).mapToObj(x->String.valueOf(x)).collect(Collectors.joining(" ")));
        }
      }
    }
  }

}

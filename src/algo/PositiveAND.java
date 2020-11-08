package algo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class PositiveAND {
  public static void main(String[] args) throws Exception {
    solve();
  }

  public static void solve() throws IOException {

    try (Scanner scanner = new Scanner(System.in);
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         ) {
      int[] res = new int[100001];
      res[1] = 2;
      res[2] = 3;
      res[3] = 1;
      for (int i = 4; i < 100001; i++) {
        if(((i-1)&(i-2)) == 0){
          res[i] = res[i-1];
          res[i-1] = i;
        }else {
          res[i]  = i;
        }
      }
      //System.out.println(Arrays.toString(res));
      /*for (int i = 1; i < 10000; i++) {
        if((res[i]&res[i+1])==0) System.out.println("**"+i);
      }
      System.out.println("--");*/
      int T = scanner.nextInt();
      for (int t = 0; t < T; t++) {
        int  N = scanner.nextInt();
        if ((N&(N-1)) ==  0){
          if(N==1){
            bw.write(1+ "\n");
          }else{
            bw.write(-1+ "\n");
          }
        }else{
          for (int i = 1; i <= N; i++) {
            if(i!=N) bw.write(res[i]+ " ");
            else bw.write(res[i]+ "\n");
          }
        }
        bw.flush();
      }
    }
  }
}

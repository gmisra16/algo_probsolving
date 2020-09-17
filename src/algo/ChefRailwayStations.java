package algo;

import java.util.Arrays;
import java.util.Scanner;

public class ChefRailwayStations {
  public static void main(String[] args) throws Exception {
    try (Scanner scanner = new Scanner(System.in)) {
      int T = scanner.nextInt();
      for (int tc = 0; tc < T; tc++) {
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] x = new int[N];
        boolean origin =false;
        for (int i = 0; i < N; i++) {
          x[i] = scanner.nextInt();
          if(x[i]==0)origin=true;
        }
        Arrays.sort(x);
        int x_nn_idx=-1;
        for (int i = 0; i < N; i++) {
          if(x[i]>=0)x_nn_idx=i;
        }


        int[] y = new int[M];
        for (int i = 0; i < M; i++) {
          y[i] = scanner.nextInt();
          if(y[i]==0)origin=true;
        }
        Arrays.sort(y);
        int y_nn_idx=-1;
        for (int i = 0; i < M; i++) {
          if(y[i]>=0)y_nn_idx=i;
        }
        long count=0;
        if(origin)count+=(N-1)*(M-1);

      }
    }
  }

}

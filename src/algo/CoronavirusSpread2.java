package algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class CoronavirusSpread2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();
            for (int i = 0; i < tc; i++) {
              int N = scanner.nextInt();
              int[] V = new int[N];
              for (int j = 0; j < N; j++) {
                V[j] = scanner.nextInt();
              }
              int resMin=6;
              int resMax=0;
              double[][] mat = new double[N][N];
              for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                  if(j==k){
                    mat[j][k] = 0;
                  }else if(V[k]==V[j]){
                    mat[j][k] = -1;
                  }else {
                    mat[j][k] = 1d*(j-k)/(V[k]-V[j]);
                  }
                }
                //System.out.println(Arrays.toString(mat[j]));
              }
              for (int infected = 0; infected < N; infected++) {
                int tempCount =0;
                Queue<Integer> queue = new LinkedList<>();
                Set<Integer> visited = new HashSet<>();
                visited.add(infected);
                for (int k = 0; k < N; k++) {
                  if(mat[infected][k]>=0){
                    tempCount++;
                    if(!visited.contains(infected)){
                      queue.add(k);
                      visited.add(k);
                    }
                  }
                  while(!queue.isEmpty()){
                    int probable = queue.poll();
                    for (int j = 0; j < N; j++) {
                      if(!visited.contains(k)
                        && mat[probable][j]>=0
                        && mat[infected][probable]>mat[probable][k]){
                        tempCount++;
                        queue.add(k);
                        visited.add(k);
                      }
                    }
                  }
                }
                if(tempCount>resMax)resMax=tempCount;
                if(tempCount<resMin)resMin=tempCount;
              }
              System.out.println(resMin + " " + resMax);
            }
        }
    }
}

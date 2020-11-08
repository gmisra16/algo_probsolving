package algo;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DDimensionalMST {
  static class Edge implements Comparator<Edge> {
    int v1;
    int v2;
    int w;
    public Edge(int v1,int v2, int w){
      this.v1=v1;
      this.v2=v2;
      this.w=w;
    }

    @Override
    public int compare(Edge o1, Edge o2) {
      return o1.w-o2.w;
    }
  }
  public static void main(String[] args) throws Exception{
    try (Scanner scanner = new Scanner(System.in)) {
      int N = scanner.nextInt();
      int D = scanner.nextInt();
      int[][] nd = new int [N][D];
      for (int n = 0; n < N; n++) {
        for (int d = 0; d < D; d++) {
          nd[n][d] = scanner.nextInt();
        }
      }
      long sum=0;
      Set<Integer> visited = new HashSet<>();
      for (int n = 0; n < N; n++) {
        Edge e=null;
        for (int n1 = n+1; n1 < N; n1++) {
          int currentDistance = 0;
          for (int d = 0; d < D; d++) {
            currentDistance +=  Math.abs(nd[n][d]-nd[n1][d]);
          }
          Edge e1 = new Edge(n+1,n1+1,currentDistance);
          if(e == null || e1.w > e.w){
            if(!visited.contains(e1.v1) || !visited.contains(e1.v2)){
              e=e1;
            }
          }
        }
        if(e!=null){
          visited.add(e.v1);
          visited.add(e.v2);
          sum+=e.w;
          System.out.println("---"+ e.w);
        }

      }
      System.out.println(sum);
    }
  }
}

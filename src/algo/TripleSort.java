package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TripleSort {

  public static void main(String[] args) throws Exception{
    try (Scanner scanner = new Scanner(System.in)) {
      int T  = scanner.nextInt();
      for (int tc = 0; tc < T; tc++) {
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] p = new int[N+1];
        List<Triplet> result = new ArrayList<>(K);
        boolean[] fixed = new boolean[N+1];
        for (int i = 1; i < N+1; i++) {
          p[i] = scanner.nextInt();
          if(i==p[i])fixed[i]=true;
        }
        //System.out.print(Arrays.toString(p));
        int idx=1;
        int fixedIdx = 1;
        boolean flag=true;

        while (idx <= N ) {
          if(p[idx]==idx){
            fixed[idx] = true;
            fixedIdx = idx;
            idx++;
            continue;
          }
          int v1 = p[idx];//i1 =idx
          int v2 = p[v1];//i2 = v1
          int v3 = p[v2];//i3 = v2
          if(v2!=idx){
            p[v1] = v1;
            fixed[v1] = true;
            p[v2] = v2;
            fixed[v2] = true;
            p[idx] = v3;
            Triplet t = new Triplet(idx,v1,v2);
            result.add(t);
            if(result.size()>K){
              //cant sort within K
              flag=false;
              System.out.println(-1);
              //System.out.println("*"+Arrays.toString(p));
              break;
            }
            if(idx == v3){
              fixed[idx] = true;
              idx++;
            }else{
              //no incr
            }
          }else{
            //find next unfixed index
            while(fixedIdx<=N && fixed[fixedIdx] || fixedIdx==v1 || fixedIdx==idx){
              fixedIdx++;
              //loop to reach end or unfixed
            }
            //fixedIdx=tempfixIdx;
            if(fixedIdx>N){
              //cant sort
              flag=false;
              System.out.println(-1);
              //System.out.println(Arrays.toString(p));
              break;
            }else{
              int v0 = p[fixedIdx];
              p[v1] = v1;
              fixed[v1] = true;
              p[v2] = v0;
              p[fixedIdx] = v2;
              Triplet t = new Triplet(idx,v1,fixedIdx);
              result.add(t);
              if(result.size()>K){
                //cant sort within K
                flag=false;
                System.out.println(-1);
                //System.out.println("*"+Arrays.toString(p));
                break;
              }
            }
          }
        }
        if(flag){
          System.out.println(result.size());
          result.forEach(System.out::println);
        }
        //System.out.println(Arrays.toString(p));
      }
    }
  }
  static class Triplet{
    int i;
    int j;
    int k;
    public Triplet(int a, int b, int c){
      i=a;
      j=b;
      k=c;
    }

    @Override
    public String toString() {
      return i + " " + j + " " +k;
    }
  }
}

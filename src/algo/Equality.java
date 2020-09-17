package algo;

import java.util.Arrays;
import java.util.Scanner;

public class Equality {
  public static void main(String[] args) throws Exception {
    try(Scanner scanner = new Scanner(System.in)) {
      int N = scanner.nextInt();
      int Q = scanner.nextInt();
      int[] A = new int[N];
      for (int i = 0; i < N; i++) {
        A[i] = scanner.nextInt();
      }
      int Aincr[] = new int[N];
      int Adecr[] = new int[N];
      Aincr[0]=0;
      Adecr[0]=0;
      if(A[1]>A[0]){
        Aincr[0] = 1;
      }else{
        Adecr[0] = 1;
      }
      for (int i = 1; i < N-1; i++) {
        if(A[i]<A[i-1]&&A[i]<A[i+1]){
          Aincr[i]=Aincr[i-1]+1;
        }else {
          Aincr[i]=Aincr[i-1];
        }
      }
      Aincr[N-1] = Aincr[N-2];

      for (int i = 1; i < N-1; i++) {
        if(A[i]>A[i-1]&&A[i]>A[i+1]){
          Adecr[i]=Adecr[i-1]+1;
        }else {
          Adecr[i]=Adecr[i-1];
        }
      }
      Adecr[N-1] = Adecr[N-2];


      System.out.println(Arrays.toString(Aincr));
      System.out.println(Arrays.toString(Adecr));
      int[] L = new int[Q];
      int[] R = new int[Q];
      for (int i = 0; i < Q; i++) {
        L[i] = scanner.nextInt();
        R[i] = scanner.nextInt();
        int incr=0;
        if(Aincr[L[i]-1] == Aincr[R[i]-1] ){
          incr= Aincr[L[i]-1];
        }else{
          incr=Aincr[L[i]-1]-Aincr[R[i]-1];
        }

        int decr=0;
        if(Adecr[L[i]-1] == Adecr[R[i]-1] ){
          decr= Adecr[L[i]-1];
        } else{
          decr = Adecr[L[i]-1]-Adecr[R[i]-1];
        }
        if(incr==decr){
          System.out.println("YES");
        }else{
          System.out.println("NO");
        }

      }
    }
  }
}

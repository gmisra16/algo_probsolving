package algo;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class ChefDesignedNetwork {
    public static void main(String[] args) {
        int MOD = 1000000007;
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();
            for (int i = 0; i < tc; i++) {
                int N = scanner.nextInt();
                long maxEdge = N*(N-1)/2 + N;
                long M = scanner.nextLong();
                if(M==0||(M < N-1) || M>maxEdge){
                    System.out.println(-1);
                }else if(M==maxEdge){
                    System.out.println(N);
                }else if(N<=2&&M==1){
                    System.out.println(1);
                }else if(M>=(N-1)&&M<=(N+1) ){
                    System.out.println(2);
                }else if(M <= 2*N){
                    System.out.println(3);
                }else if(M>2*N){
                    int Nby2 = N/2;
                    long degree = (long)Math.ceil((double)(M-N*2)/Nby2);
                    System.out.println(3+degree);

                }


            }
        }

    }

}

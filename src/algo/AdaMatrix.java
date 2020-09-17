package algo;

import java.util.Arrays;
import java.util.Scanner;

public class AdaMatrix {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();
            for (int i = 0; i < tc; i++) {
                int N = scanner.nextInt();
                int[] a = new int[N*N];
                for (int j = 0; j < N*N; j++) {
                    a[j] = scanner.nextInt();

                }
                boolean[] displaced = new boolean[N];
                Arrays.fill(displaced,true);
                for (int j = 0; j < N; j++) {
                    if(a[j]==j+1)displaced[j] = false;
                }
                int res=0;
                for (int j = N-1; j > 0; j--) {
                    if(displaced[j]){
                        res++;
                        for (int k = j; k >0 ; k--) {
                            displaced[k] =!displaced[k];
                        }
                    }//else continue
                }

                System.out.println(res);
            }
        }
    }
}

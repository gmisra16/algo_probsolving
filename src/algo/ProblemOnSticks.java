package algo;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemOnSticks {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();
            for (int i = 0; i < tc; i++) {
                int N = scanner.nextInt();
                int[] a = new int[N];
                int max = 0;
                boolean hasZero = false;
                for (int j = 0; j < N; j++) {
                    a[j] = scanner.nextInt();
                    if(a[j]==0)hasZero=true;
                    if(a[j]>max)max = a[j];
                }
                int res = hasZero?0:1;
                if(max!=0){
                    Arrays.sort(a);
                    for (int j = 1; j < N; j++) {
                        if(a[j] > a[j-1])res++;
                    }
                }
                System.out.println(res);
            }
        }
    }
}

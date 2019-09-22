package algo;

import java.util.Scanner;

public class ChefandMean {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();
            for (int i = 0; i < tc; i++) {
                int N = scanner.nextInt();
                int[] A = new int[N];
                long sum=0;
                double mean;
                for (int j = 0; j < N; j++) {
                    A[j] = scanner.nextInt();
                    sum += A[j];
                }
                mean = (sum*1.0)/N;
                //not whole number
                if(mean != Math.floor(mean)){
                    System.out.println("Impossible");
                }else{
                    boolean found=false;
                    for (int j = 0; j < N; j++) {
                        if(A[j] == mean) {
                            System.out.println(j+1);
                            found=true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Impossible");
                }

            }

        }
    }
}

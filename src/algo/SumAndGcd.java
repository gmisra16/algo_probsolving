package algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SumAndGcd {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();

            for (int i = 0; i < tc; i++) {
                int N = scanner.nextInt();
                int[] a = new int[N];
                int max = 0;
                int max2 = 0;
                //int max2Index=-1;
                HashMap<Integer, Integer> found = new HashMap<>();
                for (int n = 0; n < N; n++) {
                    a[n] = scanner.nextInt();
                    if (a[n] > max) {
                        max2 = max;
                        //max2Index = n;
                        max = a[n];
                    } else if (a[n] != max && a[n] > max2) {
                        max2 = a[n];
                    }

                }
                //all elements same
                if (N == 2) System.out.println(a[0] + a[1]);
                else if (max2 == 0) System.out.println(2 * max);
                else {
                    Arrays.sort(a);
                    if (max2 == a[0]) System.out.println(max + max2);
                    else {
                        int gcd = a[0];
                        //gcd of all other elements but max and max2
                        for (int j = 1; j < N - 2; j++) {
                            if (a[j] == max2) break;
                            gcd = gcd(gcd, a[j]);
                        }

                        System.out.println(Math.max(gcd(gcd, max2) + max, gcd(gcd, max) + max2));

                    }
                }

            }

        }
    }

    public static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

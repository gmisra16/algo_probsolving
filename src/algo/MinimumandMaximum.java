package algo;

import java.math.BigInteger;
import java.util.Scanner;

public class MinimumandMaximum {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();
            for (int i = 0; i < tc; i++) {
                int N = scanner.nextInt();
                BigInteger K = scanner.nextBigInteger();
                int modValue = K.mod(BigInteger.valueOf(N)).intValue();
                if (modValue == 0) {
                    System.out.println(0);
                } else if (modValue == 1 || modValue == (N - 1)) {
                    if (N == 2) System.out.println(1);
                    else System.out.println(2);
                } else {
                    if (N == 2) {
                        if (modValue % 2 == 0) {
                            System.out.println(0);
                        } else {
                            System.out.println(1);
                        }
                    } else {
                        if (modValue == N / 2 || modValue == (N + 1) / 2) {
                            System.out.println(N - 1);
                        } else {
                            modValue = Math.min(modValue,N-modValue);
                            if (N > 2 * modValue) {
                                System.out.println(2 * modValue);
                            }else{
                                throw new RuntimeException("T");
                            }
                        }
                    }

                }

            }
        }
    }
}


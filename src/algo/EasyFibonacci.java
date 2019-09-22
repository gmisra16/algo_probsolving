package algo;

import java.util.Scanner;

public class EasyFibonacci {
    public static void main(String[] args) {
        String seq = "011235831459437077415617853819099875279651673033695493257291";
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();
            for (int i = 0; i < tc; i++) {
                long fib = scanner.nextLong();
                long number = power2lessthanEq(fib);
                System.out.println(seq.charAt((int) (number % 60 - 1)));
            }
        }
    }

    public static long power2lessthanEq(long n) {
        int pow = 0;
        while (n > 1) {
            n = n >> 1;
            pow++;
        }
        return (long) Math.pow(2, pow);
    }

}

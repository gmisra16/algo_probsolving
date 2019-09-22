package algo;

import java.math.BigInteger;
import java.util.Scanner;

public class ChefAndIngredients {
    private static final BigInteger MOD = BigInteger.valueOf(1000000007);

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();

            for (int i = 0; i < tc; i++) {
                long N = scanner.nextLong();
                long K = scanner.nextLong();
                if(N==2){
                    System.out.println(BigInteger.valueOf((K - 2)).divide(BigInteger.valueOf(N - 1)).multiply(BigInteger.valueOf(K)).add(BigInteger.valueOf(K-1)).divide(BigInteger.valueOf(2)).mod(MOD));
                }else{
                    BigInteger result = BigInteger.valueOf(K-1);
                }
                BigInteger result = BigInteger.valueOf(((long) Math.ceil(K - 2) / (N - 1))).multiply(BigInteger.valueOf(K)).add(BigInteger.valueOf(K));
                if(result.mod(BigInteger.valueOf(2))!=BigInteger.ZERO)result.add(BigInteger.ONE);
                System.out.println(result.divide(BigInteger.valueOf(2)).mod(MOD));


            }
        }
    }
}

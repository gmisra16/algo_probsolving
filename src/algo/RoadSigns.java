package algo;

import java.math.BigInteger;
import java.util.Scanner;

public class RoadSigns {
    //public static final BigInteger MOD = BigInteger.valueOf(1000000007);
    public static final int MOD = 1000000007;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();
            for (int t = 0; t < tc; t++) {
                int k = scanner.nextInt();
                long count = 0;

                long p = 2L, r = 1L;
                for (long i = 0; k != 0; i++) {
                    long mask = 1L << i;
                    if ((k & mask) == mask) {
                        r = (((r * p) % MOD) + MOD) % MOD;
                        k -= mask;
                    }
                    p = ((p * p) % MOD + MOD) % MOD;
                }

                count = ((r % MOD) + MOD) % MOD;


                System.out.println(count*5%MOD);
                //if(k<=100000){
                //count = (BigInteger.valueOf(2).modPow(BigInteger.valueOf(k),MOD).longValue()*5)%MOD.intValue();
            }

        }
    }

}

    /*int power2(int pow)
    {
        int res = 1;     // Initialize result

        while (pow > 0)
        {
            // If y is odd, multiply x with result
            if ((pow & 1) == 1)
                res = res*x;

            // n must be even now
            y = y>>1; // y = y/2
            x = x*x;  // Change x to x^2
        }
        return res;
    }*/
    /*public static int distinctDigit(int i, int j){
        HashSet<Integer> res=new HashSet<>();
        if(i==0){
            res.add(0);
        }else{
            while(i>0){
                res.add(i%10);
                i/=10;
            }
        }
        if(j==0){
            res.add(j);
        }else{
            while(j>0){
                res.add(j%10);
                j/=10;
            }
        }

        return res.size();

    }*/


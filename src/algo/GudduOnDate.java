package algo;

import java.math.BigInteger;
import java.util.Scanner;

public class GudduOnDate {
    /*public static void main (String[] args) throws java.lang.Exception
    {
        try(Scanner scanner = new Scanner(System.in);){
            int tc = scanner.nextInt();
            for(int i=0;i<tc;i++){
                long n = scanner.nextLong();
                solve(n);
            }

        }
    }
    public static void solve(long n){
        long result = 19 +9*(n-1);
        System.out.println(result);
    }
    public static void sumDigit(long n){

    }*/

    public static int sumOfDigit(BigInteger n){
        int res=0;
        while(n.compareTo(BigInteger.ZERO)>0){
            res+=n.remainder(BigInteger.TEN).intValue();
            n=n.divide(BigInteger.TEN);
        }
        return res;
    }

    public static BigInteger solve(BigInteger n)
    {
        int reminder = sumOfDigit(n)%10;
        int last_digit = reminder!=0?10-reminder:0;
        return n.multiply(BigInteger.TEN).add(BigInteger.valueOf(last_digit));
    }

    public static void main(String[] args)
    {
        System.out.println(solve(new BigInteger("922337203685477570")));
        //System.out.println(sumOfDigit(9223372036854775700L));
    }
}

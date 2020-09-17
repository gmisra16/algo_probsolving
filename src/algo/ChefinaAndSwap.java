package algo;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class ChefinaAndSwap {
    public static void main(String[] args) throws IOException{
        //803760
        try (BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter print= new BufferedWriter(new OutputStreamWriter(System.out))) {
            int tc = Integer.parseInt(scanner.readLine());
            for (int i = 0; i < tc; i++) {
                int N = Integer.parseInt(scanner.readLine());
                long sum = (N*(N+1L))/2L;
                if(sum%2!=0){
                    System.out.println(0);
                }else{
                    long res = 0;
                    long x = binSearch(sum,0,N);
                    long y = N-x;
                    long sumBy2 = (x*(x+1L))/2L;
                    /*//find x such that sum is sum/2
                    //x^2+x-sum a=1 b=1 c=-sum
                    //-b+/- sqrt(b^2-4ac)/2*a
                    //-1 +sqrt(1+4*sum)/2
                    long x = (long)(Math.sqrt(1L+4*sum)-1L)/2L;
                    */
                    if(sum/2 == sumBy2){
                        res = (x*(x-1L))/2L + (y*(y-1L))/2L;
                        res += Math.min(x,y);
                        //if(x==1||y==1)res++;
                    }else if(sum/2 < sumBy2){
                        x--;
                        y++;
                        res += Math.min(x,y);

                    }else{
                        res += Math.min(x,y);
                    }
                  print.write(res+"\n");
                }
            }
            print.flush();
        }
    }
    public static int binSearch(long sum,long low, long high){
        long mid = (high + low)/2;
        while(low<=high){
            mid = (high + low)/2;
            long midSumInto2 = mid*(mid+1L);
            if((midSumInto2 == sum))return (int)mid;
            if(sum > midSumInto2) {
                long midPLus1SumInto2 =(mid+2L)*(mid+1L);
                if(sum == midPLus1SumInto2) return (int)(mid+1);
                else if(sum < midPLus1SumInto2){
                    return (int)mid;
                } else {
                    low = mid;
                }
            } else {
                long midMinus1SumInto2 =(mid)*(mid-1L);
                if(sum == midMinus1SumInto2) return (int)(mid-1);
                else if(sum > midMinus1SumInto2) {
                    return (int)(mid-1);
                } else {
                    high=mid;
                }
            }
        }
        return (int)mid;
    }
  }

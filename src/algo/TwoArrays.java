package algo;
/**
 * You are given two integers 𝑛 and 𝑚. Calculate the number of pairs of arrays (𝑎,𝑏) such that:
 * <p>
 * the length of both arrays is equal to 𝑚;
 * each element of each array is an integer between 1 and 𝑛 (inclusive);
 * 𝑎𝑖≤𝑏𝑖 for any index 𝑖 from 1 to 𝑚;
 * array 𝑎 is sorted in non-descending order;
 * array 𝑏 is sorted in non-ascending order.
 * As the result can be very large, you should print it modulo 109+7.
 */

public class TwoArrays {

  public static void main(String[] args) {
    int N = 2;
    int M = 2;
    int[][] mem = new int[N][M];
    long total=0;
    for (int i = 1; i <= N; i++) {
      total+=count(N,M,i);
    }
    System.out.println(total);
  }
  static long count(int N,int m,int startIdx){

    if(m==0)return 1;
    if(startIdx>N)return 0;
    long sum = 0;
    for (int i = startIdx; i <=N; i++) {
      sum+=count(N,m-1,startIdx);
      sum+=count(N,m-1,startIdx+1);
    }
    return sum;
  }
}

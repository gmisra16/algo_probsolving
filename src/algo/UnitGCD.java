package algo;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UnitGCD {
  static final List<Integer> primes = new ArrayList<>();
  private static final int MAX = 1_000_000;

  public static void main(String[] args) throws Exception{
    try(Scanner scanner = new Scanner(System.in);Print print = new Print()) {
      int T = scanner.nextInt();
      sieve(MAX);
      for (int tc = 0; tc < T; tc++) {
        int N = scanner.nextInt();
        int D=N/2;
        print.println(Math.max(1,D));
        if(N<4){
          print.print(N+" ");
          for (int i = 1; i <= N; i++) {
            if(i==N){
              print.println(i);
            }else{
              print.print(i+" ");
            }
          }
        }else{
          print.println(3+" "+1+" "+2+" "+3);
          for (int i = 4; i <= N; i+=2) {
            if(i==N){
              if(N%2==0){
                print.println(1+" "+i);
              }else{
                print.println(2+" "+i+" "+(i+1));
              }

            }else{
              print.println(2+" "+i+" "+(i+1));
            }
          }
        }
      }
    }
  }
  private static void sieve(int max){
    boolean[] array = new boolean[max+1];
    for (int i = 2; i <= max; i++) {
      if(!array[i]){
        primes.add(i);
      }
      for (int j = 2; i*j <= max ; j++) {
        if(!array[i*j]){
          array[i*j]=true;
        }
      }
    }
  }
  static class Print implements Closeable
  {
    private final BufferedWriter bw;
    public Print()
    {
      this.bw=new BufferedWriter(new OutputStreamWriter(System.out));
    }
    public void print(Object object)throws IOException
    {
      bw.append(String.valueOf(object));
    }
    public void println(Object object)throws IOException
    {
      print(object);
      bw.append("\n");
    }
    @Override
    public void close()throws IOException
    {
      bw.flush();
      bw.close();
    }
  }
}

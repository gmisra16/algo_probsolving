package algo;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class XOREngine {
  public static void main(String[] args) throws Exception {

    try (Scan scanner = new Scan();Print print = new Print()) {
      int T = scanner.scanInt();
      for (int tc = 0; tc < T; tc++) {
        int N = scanner.scanInt();
        int Q = scanner.scanInt();
        int[] A = new int[N];
        int even=0;
        int odd=0;
        for (int i = 0; i < N; i++) {
          A[i] = scanner.scanInt();
          if(setBitCount(A[i])%2==0){
            even++;
          }else{
            odd++;
          }
        }

        for (int i = 0; i < Q; i++) {
          int P = scanner.scanInt();
          int evenB=0;
          int oddB=0;
          if(setBitCount(P)%2==0){
            evenB=even;
            oddB=odd;
          }else{
            evenB=odd;
            oddB=even;
          }
          print.println(evenB + " " + oddB);

        }
      }
    }
  }
  private static int setBitCount(int n){
    return Integer.bitCount(n);
  }
  static class Scan implements Closeable
  {
    private byte[] buf=new byte[1024];
    private int index;
    private InputStream in;
    private int total;
    public Scan()
    {
      in=System.in;
    }
    public int scan()throws IOException
    {
      if(total<0)
        throw new InputMismatchException();
      if(index>=total)
      {
        index=0;
        total=in.read(buf);
        if(total<=0)
          return -1;
      }
      return buf[index++];
    }
    public int scanInt()throws IOException
    {
      int integer=0;
      int n=scan();
      while(isWhiteSpace(n))
        n=scan();
      int neg=1;
      if(n=='-')
      {
        neg=-1;
        n=scan();
      }
      while(!isWhiteSpace(n))
      {
        if(n>='0'&&n<='9')
        {
          integer*=10;
          integer+=n-'0';
          n=scan();
        }
        else throw new InputMismatchException();
      }
      return neg*integer;
    }
    public double scanDouble()throws IOException
    {
      double doub=0;
      int n=scan();
      while(isWhiteSpace(n))
        n=scan();
      int neg=1;
      if(n=='-')
      {
        neg=-1;
        n=scan();
      }
      while(!isWhiteSpace(n)&&n!='.')
      {
        if(n>='0'&&n<='9')
        {
          doub*=10;
          doub+=n-'0';
          n=scan();
        }
        else throw new InputMismatchException();
      }
      if(n=='.')
      {
        n=scan();
        double temp=1;
        while(!isWhiteSpace(n))
        {
          if(n>='0'&&n<='9')
          {
            temp/=10;
            doub+=(n-'0')*temp;
            n=scan();
          }
          else throw new InputMismatchException();
        }
      }
      return doub*neg;
    }
    public String scanString()throws IOException
    {
      StringBuilder sb=new StringBuilder();
      int n=scan();
      while(isWhiteSpace(n))
        n=scan();
      while(!isWhiteSpace(n))
      {
        sb.append((char)n);
        n=scan();
      }
      return sb.toString();
    }
    private boolean isWhiteSpace(int n)
    {
      if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
        return true;
      return false;
    }

    @Override
    public void close() throws IOException {
      in.close();
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

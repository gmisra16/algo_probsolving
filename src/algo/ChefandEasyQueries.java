package algo;

import java.util.Scanner;

public class ChefandEasyQueries {
  public static void main(String[] args) throws  Exception{
    try(Scanner scanner = new Scanner(System.in)) {
      int T = scanner.nextInt();
      for (int i = 0; i < T; i++) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] Q =new int[n];
        long sum =0;
        long ans=100001;
        boolean set=false;
        for (int j = 0; j < n; j++) {
          Q[j] = scanner.nextInt();
          sum+=Q[j];
          if(sum<k*(j+1) &&j<ans){
            ans=j;
            set=true;
          }
        }
        if (!set){
          ans = sum/k;
        }

        System.out.println(++ans);
      }
    }
  }
}

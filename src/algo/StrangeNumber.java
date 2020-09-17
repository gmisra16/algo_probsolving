package algo;

import java.util.Arrays;
import java.util.Scanner;

public class StrangeNumber {
  public static void main(String[] args) throws  Exception {
    try(Scanner scanner = new Scanner(System.in)) {
      int T = scanner.nextInt();
      for (int i = 0; i < T; i++) {
        int X = scanner.nextInt();
        int K = scanner.nextInt();
        if(K>29 || X==1){// beyond X limit || K below 1
          System.out.println(0);
        } else if(K==1) {
          System.out.println(1);
        } else if(K >=2){
            if(possible(X,K)){
              System.out.println(1);
            }else{
              System.out.println(0);
            }
          }
        }
      }
  }
  // O(K)
  private static boolean possible(int n,int k){
    int count=0;
    while(n%2==0){
      n/=2;
      count++;
      if(count>=k)return true;
    }
    for (int i = 3; i * i <= n; i+=2) {
      while(n%i==0){
        n/=i;
        count++;
        if(count>=k)return true;
      }
    }
    //left over prime;
    if(n>1){
      count++;
      if(count>=k)return true;
    }
    return false;
  }
}

package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class D42 {
  public static void main(String[] args) throws NumberFormatException, Exception {
    boolean[] a = new boolean[2000];
    List<Integer> sidon = new ArrayList<>();
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int c = 3;
    a[3] = true;
    sidon.add(1);
    sidon.add(2);
    for (int i=c ;c <= n;i++) {
      boolean canAdd = true;
      Iterator<Integer> it = sidon.iterator();
      while (it.hasNext()) {
        int x = it.next();
        if (a[i + x]) {
          canAdd = false;
          break;
        }
      }
      if (canAdd) {
        sidon.add(i);
        it = sidon.iterator();
        while (it.hasNext()) {
          int x = it.next();
          a[i + x] = true;
        }
        c++;
      }
    }
    System.out.println(Arrays.toString(a));
//		Iterator<Integer> it=b.iterator();
//		while(it.hasNext()) {
//			System.out.print(it.next()+" ");
//		}
    System.out.println(sidon);
    for (int i = 0; i < n; i++) {
      System.out.println();
      for (int j = 0; j < n; j++) {
        if (i == j) {
          System.out.print("0 ");
        } else {
          System.out.print((sidon.get(i) + sidon.get(j)) + " ");
        }
      }
    }
  }

  public static void test() throws Exception {
    int[] sidon= new int[1000];
    boolean ok;
    //begin
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    sidon[1]=1;
    sidon[2]=2;
    sidon[3]=3;
    for (int i = 4; i <=n ; i++) {
      sidon[i] = sidon[i-1]+1;
      while(true){
        ok=true;
        for (int k = 1; k < i; k++) {
          for (int l = k+1; l < i; l++) {
            for (int m = 1; m < i; m++) {
              if(k==l ||k==m || l==m)continue;
              if(sidon[k]+sidon[l]==sidon[m]+sidon[i])ok=false;
            }
          }
        }
        if(ok)break;
        sidon[i]++;
      }

    }
    System.out.println(Arrays.toString(sidon));
  }
}


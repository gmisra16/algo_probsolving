package algo;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
/*
4
5 5 3 3
2 4 6 8 10
5 5 3 4
2 4 6 8 10
5 5 3 2
2 4 6 8 10
5 1 3 2
2 4 6 8 10

1
1
-1
-1

10
5 8 3 5
2 4 6 8 10
5 9 3 5
2 4 6 8 10
5 7 3 5
2 4 6 8 10
5 6 4 5
2 4 6 8 10
5 5 4 5
2 4 6 8 10
5 3 4 5
2 4 6 8 10
5 4 4 5
2 4 6 8 10
8 7 4 7
2 4 6 6 6 6 14 16
5 10 3 4
2 4 6 8 10
5 9 3 4
2 4 6 8 10

-1
-1
-1
1
2
3
2
-1
-1
-1

4
5 8 5 3
2 4 6 8 10
5 7 5 3
2 4 6 8 10
5 6 5 4
2 4 6 8 10
5 5 5 4
2 4 6 8 10
-1
-1
-1
-1

9
5 10 4 3
2 4 6 8 10
5 9 4 3
2 4 6 8 10
5 8 4 3
2 4 6 8 10
5 7 4 3
2 4 6 8 10
5 6 4 3
2 4 6 8 10
8 16 4 3
2 4 6 8 10 12 14 16
8 15 4 3
2 4 6 8 10 12 14 16
8 16 4 3
2 4 6 8 16 16 16 16
8 15 4 3
2 4 6 8 16 16 16 16

1
1
0
-1
-1
4
4
1
1


11
2 3 2 1
2 4
3 3 2 1
1 4 4
3 3 2 1
1 2 4
2 1 1 2
2 4
2 2 1 2
1 3
3 2 1 2
1 3 4
3 2 1 2
3 3 4
3 1 1 2
2 2 4
3 1 1 2
0 2 4
3 1 1 2
0 1 4
3 2 2 3
0 1 4

-1
-1
1
1
-1
-1
1
1
-1
-1
-1

3
2 3 1 1
1 2
2 2 1 1
1 2
1 1 1 1
2

2
1
1

6
3 5 1 1
1 2 3
3 3 1 1
1 2 3
3 5 3 3
1 2 3
5 0 2 2
1 2 2 2 2
5 3 2 2
1 2 2 2 3
3 3 2 2
1 2 3

3
2
1
2
3
1

12
3 3 2 3
1 2 3
2 1 1 2
0 1

2 1 1 2
2 3
3 0 2 2
1 2 3

3 2 2 2
1 2 3
3 4 2 2
1 2 3
3 1 2 2
1 2 3

3 2 2 2
1 2 3
3 3 2 2
1 2 3
5 1 4 4
1 1 1 2 3
5 2 2 2
1 1 1 2 3
3 3 2 2
1 2 3 3 3

-1
-1
1
2
0
2
1
0
1
1
2
1

5
2 0 1 1
1 2
2 2 1 1
1 2
1 2 1 1
1
1 0 1 1
1
1 1 1 1
1

1
1
1
1
0

3 4  5  ----- >0      <0
p IP k  ----- -1      -1   p==IP

IP p k  ----- p-IP  p-(IP-1)

p k IP  ----- -1      -1

k IP p ------ -1      -1

IP k p ------ -1      -1

k p IP ----- IP-p     IP-p   p==k  (p == IP if(A[ip]<X))

1
5 5 5 4
1 1 1 1 1
 */
public class ReplaceforX {
  public static void main(String[] args) throws Exception {
    //int[] aa = {1,2,3,4,5,6,7};
    //System.out.println(Arrays.binarySearch(aa,8));
    try (Scanner scanner = new Scanner(System.in)) {
      int T = scanner.nextInt();
      for (int t = 0; t < T; t++) {
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        int p = scanner.nextInt();
        int k = scanner.nextInt();
        int[] A = new int[N];
        for (int n = 0; n < N; n++) {
          A[n] = scanner.nextInt();
        }
        Arrays.sort(A);
        int xIndex = Arrays.binarySearch(A, X);
        if (A[p - 1] == X) {
          System.out.println(0);
        } else {
          if(p==k){
            int insertPoint;
            if (xIndex < 0) {
              insertPoint = -xIndex;
              if (insertPoint > p) {
                System.out.println(insertPoint - p);
              } else if(insertPoint<p){
                System.out.println(p - insertPoint+1);
              }else{
                System.out.println(1);
              }
            } else {
              insertPoint = xIndex+1;
              if (insertPoint > p) {
                int prev = insertPoint-1;
                while(prev>=1 && X==A[prev-1]){
                  prev--;
                  insertPoint--;
                }
                System.out.println(insertPoint - p);
              } else if(insertPoint<p){
                int next = insertPoint+1;
                while(next <= N && X == A[next-1]){
                  next++;
                  insertPoint++;
                }
                System.out.println(p - insertPoint);
              }else{
                System.out.println(1);
              }
            }
          }else if (p < k) {
            int insertPoint;
            if (xIndex < 0) {
              insertPoint = -xIndex - 1;
            } else {
              insertPoint = xIndex + 1;
              int next = insertPoint+1;
              while(next <= N && X == A[next-1]){
                next++;
                insertPoint++;
              }
            }
            if (insertPoint >= p) {
              System.out.println(-1);
            } else if(insertPoint < p){
              System.out.println(p - insertPoint);
            }
          }else {
            int insertPoint;
            if (xIndex < 0) {
              insertPoint = -xIndex;
            } else {
              insertPoint = xIndex + 1;
              int prev = insertPoint-1;
              while(prev>=1 && X==A[prev-1]){
                prev--;
                insertPoint--;
              }
            }
            if (insertPoint <= p) {
              System.out.println(-1);
            } else if(insertPoint>p){
              System.out.println(insertPoint - p);
            }
          }
        }
      }
    }
  }
}

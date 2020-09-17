package algo;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Addition {
  public static void main(String[] args) throws java.lang.Exception {
    try (Scanner scanner = new Scanner(new FileInputStream(new File("/Users/gmisra/Downloads/test_bin.txt")))) {
      List<String> input = new ArrayList<>(128);
      while (scanner.hasNextLine()) {
        input.add(scanner.nextLine());
      }

      for (int i = 0; i < 1; i++) {
        for (int j = i; j < input.size(); j++) {
          String A = input.get(i);
          String B = input.get(j);
          //System.out.println(A+"-"+B);
          if (is0(B)) {
            System.out.println(0);
          } else if (is0(A)) {
            System.out.println(1);
          } else {
            int count = 0;
            while (!is0(B)) {
              String U = xor(A, B);
              String V = and(A, B);
              System.out.print(U + "-");
              //System.out.println(V);
              A = U;
              B = leftShift(V);
              count++;
            }
            System.out.println(count);
          }
        }
        System.out.println();
      }
    }
  }

  /*{
    try (Scanner scanner = new Scanner(System.in)) {
      int T = scanner.nextInt();
      scanner.nextLine();
      while (T-- > 0) {
        String A = scanner.nextLine();
        String B = scanner.nextLine();
        //System.out.println(A+"-"+B);
        if(is0(B)) {
          System.out.println(0);
        } else if (is0(A)){
          System.out.println(1);
        }else{

          int count = 0;
          //2n-1 diff+2
          //diff>=4 0
          //diff =3 5
          //diff 2 4
          //diff 1 3
          //diff 0

          while (!is0(B)) {
            String U = xor(A, B);
            String V = and(A, B);
            //System.out.println(U);
            //System.out.println(V);
            A=U;
              B=leftShift(V);
              count++;
            }
            System.out.println(count);
        }

      }
    }
  }*/
  private static String xor(String A, String B) {
    StringBuilder xor = new StringBuilder("");
    int lenDiff = A.length() - B.length();
    if (lenDiff > 0) {
      StringBuilder sb1 = new StringBuilder();
      while (lenDiff-- > 0) sb1.append("0");
      B = sb1.append(B).toString();
    } else if (lenDiff < 0) {
      StringBuilder sb1 = new StringBuilder();
      while (lenDiff++ < 0) sb1.append("0");
      A = sb1.append(A).toString();
    }
    //System.out.println(A);
    //System.out.println(B);
    boolean start = false;
    for (int i = 0; i < A.length(); i++) {
      int x = A.charAt(i) - '0';
      int y = B.charAt(i) - '0';
      if ((x ^ y) == 1) start = true;
      if (start) xor.append(x ^ y);
    }

    return xor.toString();
  }

  private static String and(String A, String B) {
    StringBuilder and = new StringBuilder("");
    int lenDiff = A.length() - B.length();
    if (lenDiff > 0) {
      StringBuilder sb1 = new StringBuilder();
      while (lenDiff-- > 0) sb1.append("0");
      B = sb1.append(B).toString();
    } else if (lenDiff < 0) {
      StringBuilder sb1 = new StringBuilder();
      while (lenDiff++ < 0) sb1.append("0");
      A = sb1.append(A).toString();
    }
    //System.out.println(A);
    //System.out.println(B);
    boolean start = false;
    for (int i = 0; i < A.length(); i++) {
      int x = A.charAt(i) - '0';
      int y = B.charAt(i) - '0';
      if ((x & y) == 1) start = true;
      if (start) and.append(x & y);
    }

    return and.toString();
  }

  private static boolean is0(String s) {
    if (s.indexOf('1') >= 0) return false;
    else return true;
  }

  private static String leftShift(String s) {
    return new StringBuilder(s).append("0").toString();
  }


}

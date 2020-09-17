package algo;

import java.util.Arrays;
import java.util.Scanner;

public class EasySubsequenceSelection {
  public static void main(String[] args) throws java.lang.Exception {
    try (Scanner scanner = new Scanner(System.in)) {
      int T = scanner.nextInt();
      while (T-- > 0) {
        int N = scanner.nextInt();
        //a is 0 and z 25
        int[] minDiffArray = new int[26];
        Arrays.fill(minDiffArray, N);
        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex,-1);
        scanner.nextLine();
        String S = scanner.nextLine();

        for (int i = 0; i < N; i++) {
          char s = S.charAt(i);
          int charIndex = s - 'a';
          if (lastIndex[charIndex]!= -1){
            int tempMin = i - lastIndex[charIndex];
            if(tempMin < minDiffArray[charIndex]){
              minDiffArray[charIndex] = tempMin;
            }
          }
          lastIndex[charIndex] = i;
        }
        //System.out.println(Arrays.toString(minArray));
        int minDiff = N;
        for (int i = 0; i < minDiffArray.length; i++) {
          if(minDiffArray[i]<minDiff){
            minDiff = minDiffArray[i];
          }
        }

        System.out.println(N-minDiff);
      }
    }
  }

}

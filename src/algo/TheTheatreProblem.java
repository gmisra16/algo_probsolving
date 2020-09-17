package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TheTheatreProblem {
  static int R=4;
  static int C=4;
  public static void main(String[] args) throws Exception {
    try (Scanner scanner = new Scanner(System.in)) {
      int TC = scanner.nextInt();
      long totalProfit = 0;
      for (int i = 0; i < TC; i++) {
        int N = scanner.nextInt();
        int[][] tab = new int[4][4];
        //A==0 B==1 C==2 D==4

        Map<String, Integer> movieIndexMap = new HashMap<>(4);
        movieIndexMap.put("A", 0);
        movieIndexMap.put("B", 1);
        movieIndexMap.put("C", 2);
        movieIndexMap.put("D", 3);
        //12==0 3==1 6==2 9==3
        Map<Integer, Integer> showIndexMap = new HashMap<>(4);
        showIndexMap.put(12, 0);
        showIndexMap.put(3, 1);
        showIndexMap.put(6, 2);
        showIndexMap.put(9, 3);
        for (int j = 0; j < N; j++) {
          String m = scanner.next();
          int t = scanner.nextInt();
          tab[movieIndexMap.get(m)][showIndexMap.get(t)]++;
        }

        boolean[][] visited = new boolean[4][4];
        List<Integer> showtime = new ArrayList<>(4);
        int profit = calc(tab, visited, showtime);
        System.out.println(profit);
        totalProfit += profit;
      }
      System.out.println(totalProfit);
    }
  }

  private static int calc(int[][] tab, boolean[][] visited, List<Integer> showtime) {
    boolean[][] visited1=new boolean[R][C];
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        visited1[i][j]=visited[i][j];
      }
    }
    for (int j = 0; j < R; j++) {
      for (int k = 0; k < C; k++) {
        if (tab[j][k] > 0 && !visited[j][k]) {
          //mark item visited
          visited1[j][k] = true;
          //System.out.println("-"+showtime);
          int leaveIt = calc(tab, visited1, new ArrayList<>(showtime));
          //visited[j][k] = false;

          //take this
          showtime.add(tab[j][k]);
          //mark row visited
          for (int i = 0; i < R; i++) {
            visited1[j][i] = true;
          }
          //mark col visited
          for (int i = 0; i < C; i++) {
            visited1[i][k] = true;
          }
          int takeIt = calc(tab, visited1, new ArrayList<>(showtime));
          return Math.max(leaveIt, takeIt);
        }
      }
    }

    int profit = (showtime.size() - R) * 100;
    int[] price = {100, 75, 50, 25};
    Collections.sort(showtime, (i1, i2) -> i2 - i1);
    for (int i = 0; i < showtime.size(); i++) {
      profit += (showtime.get(i) * price[i]);
    }
    return profit;
  }

}

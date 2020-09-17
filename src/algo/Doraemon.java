package algo;

import java.util.*;

public class Doraemon {
  public static void main(String[] args) throws Exception {
    try (Scanner scanner = new Scanner(System.in)) {
      int T = scanner.nextInt();
      for (int i = 0; i < T; i++) {
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();
        final int[][] A = new int[N][M];
        //final int[][] result = new int[N][M];
        for (int j = 0; j < N; j++) {
          for (int k = 0; k < M; k++) {
            A[j][k] = scanner.nextInt();
          }
        }
        final Map<RC, Integer> rowLenMap = new HashMap<>();
        for (int row = 1; row < N-1; row++) {
            rowLenMap.putAll(findOddLenPSGT1Man(A[row], row, true));
        }

        Map<RC, Integer> colLenMap = new HashMap<>();
        int[] s = new int[N];
        for (int col = 1; col < M-1; col++) {
          for (int row = 0; row < N; row++) {
            s[row] = A[row][col];
          }
          colLenMap.putAll(findOddLenPSGT1Man(s, col, false));
        }
        //final Map<RC, Set<Integer>> colLenMap = new HashMap<>();
        long res = M * N;
        Iterator<RC> iter = rowLenMap.keySet().iterator();
        while (iter.hasNext()) {
          RC key = iter.next();
          if (colLenMap.containsKey(key) && rowLenMap.containsKey(key)) {
            int min = Math.min(rowLenMap.get(key), colLenMap.get(key));
            int count = min/2;
            res += count;
          }
        }
        System.out.println(res);
      }
    }
  }

  //return mid with set of radius
  public static Map<RC, Set<Integer>> findOddLenPSGT1(int[] s, int index, boolean isRow) {
    Map<RC, Set<Integer>> midLenMap = new HashMap<>();
    for (int idx = 1; idx < s.length - 1; idx++) {
      int radius = 1;
      RC rc = null;
      if (isRow) {
        rc = new RC(index, idx);
      } else {
        rc = new RC(idx, index);
      }
      while ((idx - radius) >= 0 && (idx + radius) < s.length && (s[idx - radius] == s[idx + radius])) {
        if (midLenMap.containsKey(rc)) {
          midLenMap.get(rc).add(radius);
        } else {
          Set<Integer> lens = new HashSet<>();
          lens.add(radius);
          midLenMap.put(rc, lens);
        }
        radius++;
      }

    }
    return midLenMap;
  }

  public static Map<RC, Integer> findOddLenPSGT1Man(int[] s, int index, boolean isRow) {
    Map<RC, Integer> midLenMap = new HashMap<>();
    //add beg -1 end -2 even int 0
    int[] temp = new int[2 * s.length + 3];
    temp[0] = -1;
    temp[2 * s.length + 2] = -2;
    for (int i = 0; i < s.length; i++) {
      temp[2 * i + 1] = 0;
      temp[2 * i + 2] = s[i];
    }
    temp[2 * s.length + 1] = 0;
    int[] pos = new int[temp.length];
    int centre = 0;
    int right = 0;
    for (int i = 1; i < temp.length - 1; i++) {
      int mirror = 2 * centre - i;
      if (right > i) {
        pos[i] = Math.min(right - i, pos[mirror]);
      }
      while (temp[i + (1 + pos[i])] == temp[i - (1 + pos[i])]) {
        pos[i]++;
      }
      if (i + pos[i] > right) {
        centre = i;
        right = i + pos[i];
      }
    }
    for (int idx = 1; idx < s.length - 1; idx++) {
      RC rc = null;
      if (isRow) {
        rc = new RC(index, idx);
      } else {
        rc = new RC(idx, index);
      }
      if (pos[2 * idx + 2] > 1 && pos[2 * idx + 2] % 2 != 0) {
        midLenMap.put(rc, pos[2 * idx + 2]);
      }
    }
    //System.out.println(Arrays.toString(pos));
    return midLenMap;
  }

  static class RC {
    private final int row;
    private final int col;

    public RC(int row, int col) {
      this.row = row;
      this.col = col;
    }

    @Override
    public int hashCode() {
      return Objects.hash(row, col);
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) return true;
      if (o instanceof RC && ((RC) o).col == this.col && ((RC) o).row == this.row) return true;
      return false;
    }

    @Override
    public String toString() {
      return "(" + this.row + "," + this.col + ")";
    }
  }
}

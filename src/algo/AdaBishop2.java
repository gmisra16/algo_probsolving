package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdaBishop2 {

  public static void main(String[] args) throws Exception {
    try (Scanner scanner = new Scanner(System.in)) {
      int T = scanner.nextInt();

      while (T-- > 0) {
        List<Pair> path = new ArrayList<>();
        path.add(new Pair(1, 1));

        path.add(new Pair(2, 2));
        path.add(new Pair(3, 1));
        path.add(new Pair(1, 3));
        path.add(new Pair(2, 2));

        path.add(new Pair(3, 3));
        path.add(new Pair(5, 1));
        path.add(new Pair(1, 5));
        path.add(new Pair(3, 3));

        path.add(new Pair(4, 4));
        path.add(new Pair(7, 1));
        path.add(new Pair(1, 7));
        path.add(new Pair(4, 4));

        path.add(new Pair(5, 5));
        path.add(new Pair(8, 2));
        path.add(new Pair(2, 8));
        path.add(new Pair(5, 5));

        path.add(new Pair(6, 6));
        path.add(new Pair(8, 4));
        path.add(new Pair(4, 8));
        path.add(new Pair(6, 6));

        path.add(new Pair(7, 7));
        path.add(new Pair(8, 6));
        path.add(new Pair(6, 8));
        path.add(new Pair(7, 7));

        path.add(new Pair(8, 8));

        int r0 = scanner.nextInt();
        int c0 = scanner.nextInt();

        if (r0 == c0) {
          if (r0 != 1) {
            path.add(0, new Pair(r0, c0));
          }
        } else {
          path.add(0, new Pair(r0, c0));
          path.add(1, new Pair((r0 + c0) / 2, (r0 + c0) / 2));
        }
        System.out.println(path.size());
        path.forEach(System.out::println);
      }
    }
  }

  static class Pair {
    int r;
    int c;

    Pair(int r, int c) {
      this.r = r;
      this.c = c;
    }

    @Override
    public String toString() {
      return r + " " + c;
    }
  }

}

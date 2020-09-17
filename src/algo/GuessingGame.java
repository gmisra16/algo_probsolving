package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class GuessingGame {

  static ArrayList<Range> ranges = new ArrayList<>();

  public static void main(String[] args) throws java.lang.Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    ranges.add(new Range(1, n));
    String r1 = "";
    String r2 = "";

    while (true) {
      bw.write(trans(n / 3 + 1) + "\n");
      bw.flush();
      r1 = br.readLine();
      if ("E".equals(r1))
        break;
      if ("G".equals(r1)) {
        bw.write(trans(n / 3 + 1) + "\n");
        bw.flush();
        r1 = br.readLine();
        if ("E".equals(r1))
          break;
      }
      if ("L".equals(r1)) {
        bw.write(trans((2 * n) / 3 + 1) + "\n");
        bw.flush();
        r2 = br.readLine();
        if ("E".equals(r2))
          break;
      }
      if ("G".equals(r1)) {
        rem(trans(0), trans(n / 3 + 1));
        n = (n - n / 3 - 1);
      } else if ("G".equals(r2)) {
        rem(trans(n / 3 + 1), trans((2 * n) / 3 + 1));
        n = (n - ((2 * n) / 3 - n / 3 + 1));
      } else {
        rem(trans((2 * n) / 3 + 1), trans(n));
        n = ((2 * n) / 3);
      }
    }
  }

  public static int trans(int n) {
    int size = ranges.size();
    int p = 0;

    for (int i = 0; i < size; i++) {
      if (ranges.get(i).size() < n - p)
        p += ranges.get(i).size();
      else
        return (ranges.get(i).start + (n - p - 1));
    }

    return -1;
  }

  public static void rem(int f, int t) {
    int n = ranges.size();

    for (int i = 0; i < n; i++) {
      if (ranges.get(i).end < f)
        continue;
      if (ranges.get(i).start > t)
        break;
      if (ranges.get(i).start >= f) {
        if (ranges.get(i).end <= t) {
          ranges.remove(i);
          i--;
          n--;
        } else
          ranges.get(i).start = t + 1;
      } else {
        if (ranges.get(i).end > t)
          ranges.add(i + 1, new Range(t + 1, ranges.get(i).end));
        ranges.get(i).end = f - 1;
      }
    }
  }

  static class Range {
    int start, end;
    Range(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public int size() {
      return (this.end - this.start + 1);
    }
  }

}

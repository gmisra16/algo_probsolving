package algo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class ParityAgain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();
            for (int i = 0; i < tc; i++) {
                int Q = scanner.nextInt();
                HashSet<Integer> S = new HashSet<>();
                for (int j = 0; j < Q; j++) {
                    final int x = scanner.nextInt();
                    HashSet<Integer> tempS = new HashSet<>();
                    for (Iterator<Integer> iter = S.iterator(); iter.hasNext(); ) {
                        int item = iter.next();
                        if (item != x) tempS.add(item ^ x);
                    }
                    S.addAll(tempS);
                    S.add(x);
                    int size = S.size();
                    System.out.println(S.size());
                    if (size == 1) {
                        int E = 0;
                        int O = 0;
                        if ((countSetBit(x) & 1) == 0) E++;
                        else O++;
                        System.out.println(E + " " + O);
                    } else {
                        System.out.println(size / 2 + " " + (size + 1) / 2);
                    }
                }
            }
        }
    }

    static int countSetBit(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n &= (n - 1);
        }
        return count;

    }
}

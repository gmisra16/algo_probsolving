package algo;

import java.util.Scanner;

public class AntsandAnteaters {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();
            for (int i = 0; i < tc; i++) {
                int R = scanner.nextInt();
                int C = scanner.nextInt();
                scanner.next();
                char[][] grid = new char[R][C];
                for (int j = 0; j < R; j++) {
                    String row = scanner.nextLine();
                    for (int k = 0; k < C; k++) {
                        grid[j][k] = row.charAt(k);
                    }
                }
            }

        }
    }
}

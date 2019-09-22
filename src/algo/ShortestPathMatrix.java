package algo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class ShortestPathMatrix {
    static class Point {
        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int R = scanner.nextInt();
        scanner.nextLine();
        String[][] grid = new String[R][N];
        Point nick = null;
        Point safe = null;
        for (int i = 0; i < R; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = String.valueOf(row.charAt(j));
                if ("M".equalsIgnoreCase(grid[i][j])) {
                    nick = new Point(i, j);
                } else if ("S".equalsIgnoreCase(grid[i][j])) {
                    safe = new Point(i, j);
                }
            }
        }
        for (int time = 0; time < 6400; time++) {
            //nick start moving at time =0
            for (int i = 0; i < S; i++) {
                //bfs()
            }
        }

        scanner.close();
    }

    //shortest path between
    public static boolean bfs(String[][] grid, Point source, Point dest) {
        Deque<Point> queue = new LinkedList<>();
        int[][] visited = new int[grid.length][grid[0].length];
        queue.add(source);
        visited[source.getX()][source.getY()] = 1;

        while (!queue.isEmpty()) {

            Point current = queue.poll();
            if (current.equals(dest)) return true;
            Point east = new Point(source.getX(), source.getY() - 1);
            Point west = new Point(source.getX(), source.getY() + 1);
            Point north = new Point(source.getX() - 1, source.getY());
            Point south = new Point(source.getX() + 1, source.getY());
            if (valid(east, grid.length, grid[0].length) && "O".equalsIgnoreCase(grid[east.getX()][east.getY()]) && visited[east.getX()][east.getY()] != 1) {
                visited[east.getX()][east.getY()] = 1;
                queue.add(east);
            }

            if (valid(west, grid.length, grid[0].length) && "O".equalsIgnoreCase(grid[west.getX()][west.getY()]) && visited[west.getX()][west.getY()] != 1) {
                visited[west.getX()][west.getY()] = 1;
                queue.add(west);
            }

            if (valid(north, grid.length, grid[0].length) && "O".equalsIgnoreCase(grid[north.getX()][north.getY()]) && visited[north.getX()][north.getY()] != 1) {
                visited[north.getX()][north.getY()] = 1;
                queue.add(north);
            }

            if (valid(south, grid.length, grid[0].length) && "O".equalsIgnoreCase(grid[south.getX()][south.getY()]) && visited[south.getX()][south.getY()] != 1) {
                visited[south.getX()][south.getY()] = 1;
                queue.add(south);
            }
        }

        return false;
    }

    public static boolean valid(Point point, int R, int N) {
        if (point.getX() >= 0 && point.getX() < R && point.getY() >= 0 && point.getY() < N) return true;
        return false;
    }

    public static boolean growCommandoAndCatchNick(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Point source = new Point(i, j);
                if ("L".equalsIgnoreCase(grid[i][j])) {
                    Point east = new Point(source.getX(), source.getY() - 1);
                    Point west = new Point(source.getX(), source.getY() + 1);
                    Point north = new Point(source.getX() - 1, source.getY());
                    Point south = new Point(source.getX() + 1, source.getY());
                    if("M".equalsIgnoreCase(grid[east.getX()][east.getY()]) ||
                            "M".equalsIgnoreCase(grid[west.getX()][west.getY()]) ||
                            "M".equalsIgnoreCase(grid[north.getX()][north.getY()]) ||
                            "M".equalsIgnoreCase(grid[south.getX()][south.getY()])
                            )return true;
                    if (valid(east, grid.length, grid[0].length) && "O".equalsIgnoreCase(grid[east.getX()][east.getY()])) {
                        grid[east.getX()][east.getY()] = "L";
                    }
                    if (valid(west, grid.length, grid[0].length) && "O".equalsIgnoreCase(grid[west.getX()][west.getY()])) {
                        grid[west.getX()][west.getY()] = "L";
                    }
                    if (valid(north, grid.length, grid[0].length) && "O".equalsIgnoreCase(grid[north.getX()][north.getY()])) {
                        grid[north.getX()][north.getY()] = "L";
                    }
                    if (valid(south, grid.length, grid[0].length) && "O".equalsIgnoreCase(grid[south.getX()][south.getY()])) {
                        grid[south.getX()][south.getY()] = "L";
                    }
                }
            }
        }
        return false;

    }
}